package edu.kh.project.board.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thoughtworks.qdox.parser.ParseException;

import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.KBoard;
import edu.kh.project.board.model.dto.KBoard;
import edu.kh.project.board.model.dto.KBoard;
import edu.kh.project.board.model.service.KBoardService;
import edu.kh.project.member.model.dto.Member;

@SessionAttributes({"loginMember"})
@RequestMapping("/community")
@Controller
public class KBoardController {

	@Autowired
	private KBoardService service;

	@GetMapping("/{boardCode:[2]}")
	public String selectboardInquiry(@PathVariable("boardCode")int boardCode, @RequestParam(value="cp", required = false, defaultValue = "1")int cp
			, Model model
			, @RequestParam Map<String, Object> paramMap // 전달받은 파라미터가 전부다 담겨있다.
			) {




		if(paramMap.get("open") ==null) {
			Map<String, Object> map = service.selectboardInquiry(boardCode, cp);
			model.addAttribute("map", map);

		}else {
			paramMap.put("boardCode", boardCode);
			Map<String,Object>map = service.selectBoardList(paramMap, cp);
			model.addAttribute("map", map);
		}


		return "board/boardInquiry";
	}
	
	// 상세 화면 전환
	@GetMapping("/2/{boardNo}")
	public String selectboardInquiryDetail(@PathVariable("boardNo")int boardNo
										,Model model, RedirectAttributes ra
										,@SessionAttribute(value="loginMember", required = false)Member loginMember
										,HttpServletRequest reqs
										,HttpServletResponse resps
										)throws ParseException, java.text.ParseException {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardCode",2);
		map.put("boardNo",boardNo);
				
		KBoard board = service.selectboardInquiryDetail(map);
		
		// 쿠키 조회수 증가
		
		// 1) 비회원 또는 로그인한 회원의 글이 아닌 경우
		if(loginMember == null ||	// 비회원 
			loginMember.getMemberNo() != board.getMemberNo()) {
			
			// 2) 쿠키 얻어오기
			Cookie c = null;
			
			// 요청에 담겨있는 모든 쿠키 얻어오기
			Cookie[] cookies = reqs.getCookies();
			
			if(cookies != null) { // 쿠키가 존재할 경우
				// 쿠키 중 "readBoardNo"라는 쿠키를 찾아서 c에 대입
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("readBoardNo")) {
						c = cookie;
						break;
					}
				}
			}
			
			// 3) 기존 쿠키가 없거나(c == null)
			// 	  존재는 하나 현재 게시글 번호가
			//    쿠키에 저장되지 않은 경우(오늘 해당 게시글 본 적 없음)
			
			int result = 0;
			if(c==null) {
				// 쿠키가 존재 X -> 하나 새로 생성
				c = new Cookie("readBoardNo", "|" + boardNo + "|");
				
				// 조회수 증가 서비스 호출
				result = service.updateReadCount(boardNo);
			}else {
				// 현재 게시글 번호가 쿠키에 있는지
				
				// Cookie.getValue() : 쿠키에 저장된 모든 값을 읽어옴
				//							-> String으로 반환
				
				// String.indexOf("문자열")
				// : 찾는 문자열이 몇번 인덱스에 존재하는지를 반환 
				// 단, 없으면 -1 반환 
				if(c.getValue().indexOf("|" + boardNo + "|") == -1) {
					// 쿠키에 현재 게시글 번호가 없다면 
					// 기존 값에 게시글 번호 추가해서 다시 세팅
					c.setValue(c.getValue() + "|" + boardNo + "|");
					
					// 조회수 증가 서비스 호출
					result = service.updateReadCount(boardNo);
				}
			} // 3) 종료
			
			// 4) 조회 수 증가 성공 시 쿠키가 적용되는 경로
			//, 수명(당일 23:59분59초) 지정
			if(result > 0) {
				// 조회된 board 조회 수와 DB 조회 수 동기화
				board.setReadCount(board.getReadCount() + 1);
				
				// 적용 경로 설정
				c.setPath("/"); // "/" 이하 경로 요청 시 쿠키 서버로 전달
				
				// 수명 지정
				Calendar cal = Calendar.getInstance();	// 싱글톤 패턴
				cal.add(cal.DATE, 1);
				
				// 날짜 표기법 변경 객체(DB의 TO_CHAR()와 비슷)
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				// java.util.Date
				Date a = new Date(); // 현재 시간
				
				Date temp = new Date(cal.getTimeInMillis()); // 내일 (24시간 후)
				// 2023-08-24 12:17:40
				
				Date b = sdf.parse(sdf.format(temp)); // 내일 0시0분0초
				
				// 내일 0시0분0초 - 현재시간
				long diff = (b.getTime() - a.getTime()) / 1000;
				// -> 내일 0시0분0초 까지 남은 시간을 초단위로 반환 
				
				c.setMaxAge((int)diff);	// 수명 설정
				
				resps.addCookie(c); // 응답 객체를 이용해서
								  // 클라이언트에게 전달
				
			}
			
			
		}
		
		String path = null;
		
		if(board != null) { // 조회 결과가 있을 경우
			//-------------------------------------------
			// 현재 로그인 상태인 경우
			// 로그인한 회원이 해당 게시글에 좋아요 눌렀는지 확인
			
			// 댓글 조회
			List<CComment> cList= service.select(boardNo);
			model.addAttribute("cList",cList);			
			// forward할 jsp 경로
			path = "board/boardInquiryDetail";
			model.addAttribute("board",board);
		}else { // 조회 결과가 없을 경우
			path =  "redirect:/community/2";
			
			ra.addFlashAttribute("message","해당 게시글이 존재하지 않습니다.");
		}
		
		return path;
	}
	
	
	
	
	
	// 게시글 작성 화면 전환
	@GetMapping("/2/boardInquiryWrtie")
	public String selectboardInquiryWrtie() {

		return "board/boardInquiryWrtie";
	}
	// 게시글 작성
	@PostMapping("/2/insert/boardInsert")
	public String boardInsert(
			KBoard board // 커맨드 객체
			, @SessionAttribute("loginMember")Member loginMember // 로그인한 회원 번호
			, RedirectAttributes ra // 리다이렉트시에 데이터 전달
			, HttpSession session // 파일 저장 경로
			, @RequestParam(value="cp", required = false, defaultValue = "1")int cp
			)throws IllegalStateException, IOException {


		// 로그인한 회원번호 얻어와서 board에 세팅
		board.setMemberNo(loginMember.getMemberNo());

		// 2도 board에 세팅
		board.setBoardCode(2);


		int boardNo = service.boardInsert(board); // 서비스로 연결

		String message = null;
		String path = "redirect:";

		if(boardNo > 0 ) {
			// 성공 시
			message = "게시글이 등록 되었습니다.";
			path += "/community/2/" + boardNo +"?cp=" + cp;
		}else {
			message = "게시글 등록 실패..";
			path += "insert";
		}

		ra.addFlashAttribute("message", message);

		return path;

	}


	// 게시글 수정 화면 전환
	@GetMapping("/2/{boardNo}/update")
	public String boardUpdate(@PathVariable("boardNo") int boardNo
			, Model model // 데이터 전달용 객체
			) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("boardNo", boardNo);
		map.put("boardCode", 2);


		
		KBoard board = service.selectboardInquiryDetail(map);

		model.addAttribute("board",board);

		return "board/boardInquiryUpdate";

	}

	@PostMapping("/2/{boardNo}/update")
	public String boardUpdate(
			  KBoard board // 커맨드 객체(name == 필드 경우 필드에 파라미터 세팅)
			, @RequestParam(value="cp", required=false, defaultValue="1")int cp // 쿼리스트링 유지하기 위해서
			, @PathVariable("boardNo") int boardNo
			, RedirectAttributes ra // 리다이렉트 시 값 전달용
			)throws IllegalStateException, IOException {
		
		
		String message = null;
		String path = "redirect:";
		
		board.setBoardCode(2);
		board.setBoardNo(boardNo);
		
		int rowCount = service.boardUpdate(board);
		
		
		if(rowCount > 0) {
			message = "게시글이 수정되었습니다.";
			path += "/community/2/"  + boardNo + "?cp=" + cp; // 상세조회 페이지
			
		}else {
			message = "게시글 수정 실패";
			path += "update";
		}
		
		ra.addFlashAttribute("message", message);

		
		return path;
		
	}
	
	@GetMapping("/2/{boardNo}/delete")
	public String boardDelete(
			@PathVariable("boardNo") int boardNo
		   ,RedirectAttributes ra
		   ,@RequestHeader("referer") String referer) { 
		
		int result = service.boardDelete(boardNo);
		String message="";
		String path = "redirect:";
		if(result>0) {
			message="게시글이 삭제되었습니다.";
			path += "/community/2";
			
		}else {
			message="게시글이 삭제에 실패 했습니다.";
			path += "/community/2/" + boardNo;
		}
		
		ra.addFlashAttribute("message",message);
		
		return path;
		
		
	}
	
	
	@PostMapping("/inquiry/comment")
	@ResponseBody
	public int insertComment(@RequestBody CComment comment) {
		
		
		return service.insertComment(comment);
	}
	
	
	@PutMapping("/inquiry/comment")
	@ResponseBody
	public int update(@RequestBody CComment comment) {
		
		return service.boardUpdate(comment);
	}
	
	@DeleteMapping("/inquiry/comment")
	@ResponseBody
	public int delete(@RequestBody int commentNo) {
		
		return service.boardDeleteComment(commentNo);
	}
	
	 

}
