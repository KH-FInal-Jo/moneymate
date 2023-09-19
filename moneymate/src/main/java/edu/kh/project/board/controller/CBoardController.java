package edu.kh.project.board.controller;

import java.io.IOException;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.CReport;
import edu.kh.project.board.model.service.CBoardService;
import edu.kh.project.member.model.dto.Member;

@Controller
@SessionAttributes("loginMember")
@RequestMapping("/community")
public class CBoardController {

	@Autowired
	private CBoardService service;

	// 게시글 목록 조회
	@GetMapping("/3")
	public String selectCBoardList(@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			Model model, @RequestParam Map<String, Object> paramMap) {

		int boardCode = 3;

		if (paramMap.get("sel") == null) {
			Map<String, Object> map = service.selectBoardList(boardCode, cp);

			model.addAttribute("map", map);

		} else { // 검색 O

			paramMap.put("boardCode", 3);

			Map<String, Object> map = service.selectBoardList(paramMap, cp);

			model.addAttribute("map", map);
		}

		return "board/CBoardList";
	}

	// 게시글 상세조회
	@GetMapping("/3/{boardNo}")
	public String boardDetail(@PathVariable("boardNo") int boardNo, Model model, RedirectAttributes ra,
			@SessionAttribute(value = "loginMember", required = false) Member loginMember, HttpServletRequest req,
			HttpServletResponse resp) throws ParseException {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("boardCode", 3);
		map.put("boardNo", boardNo);

		CBoard board = service.selectBoard(map);

		String path = null;

		if (board != null) {
			if (loginMember != null) {
				map.put("memberNo", loginMember.getMemberNo());

				int result = service.boardLikeCheck(map);
				
				if(result>0) model.addAttribute("likeCheck", "on");
			}
			
			
			if(loginMember == null || loginMember.getMemberNo() != board.getMemberNo()) {
				// 비회원 조회수 늘어남 // 작성자가 조회수 늘어나게x

				Cookie c = null;
				
				Cookie[] cookies = req.getCookies();
				
				if(cookies != null) {
					for( Cookie cookie : cookies) {
						if(cookie.getName().equals("readBoardNo")) {
							c = cookie;
							
							break;
						}
					}
				}
				
				
				int result = 0;
				
				if(c == null) {
					
					c = new Cookie("readBoardNo", "|" + boardNo + "|");
					
					result = service.updateReadCount(boardNo);
					
				} else {
					
					if(c.getValue().indexOf("|" + boardNo + "|") == -1) {
						
						
						c.setValue(c.getValue() + "|" + boardNo + "|");
						
						result = service.updateReadCount(boardNo);
						
					}
					
				}
				
				if(result>0) {
					
					board.setReadCount(board.getReadCount() + 1);
					
					c.setPath("/"); 
					
					Calendar cal = Calendar.getInstance();
					cal.add(cal.DATE , 1);
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					
					Date a = new Date();
					
					Date temp = new Date(cal.getTimeInMillis());
					
					Date b = sdf.parse(sdf.format(temp)); 
					
					long diff = (b.getTime() - a.getTime()) / 1000;
					
					c.setMaxAge((int)diff); 
					
					resp.addCookie(c); 
					
				}
			}
			
			
		}
		model.addAttribute("board", board);

		return "board/CboardDetail";
	}

	// 글쓰기 페이지로 이동
	@GetMapping("/3/insert")
	public String boardWrite() {
		return "board/CBoardWrite";
	}

	// 글쓰기
	@PostMapping("/3/insert")
	public String boardWrite(CBoard board, @RequestParam(value = "images", required = false) List<MultipartFile> images,
			@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra, HttpSession session)
			throws IllegalStateException, IOException {

		board.setMemberNo(loginMember.getMemberNo());
		board.setBoardCode(3);

		String webPath = "/resources/images/board/";
		String filePath = session.getServletContext().getRealPath(webPath);

		int boardNo = service.boardInsert(board, images, webPath, filePath);

		String message = null;
		String path = "redirect:";

		if (boardNo > 0) { // 성공 시

			message = "게시글이 등록되었습니다.";
			path += "/community/3/" + boardNo;

		} else { // 실패 시
			message = "게시글 등록 실패";
			path += "insert";
		}

		ra.addFlashAttribute("message", message);

		return path;
	}

	@PostMapping("/like")
	@ResponseBody // 반환되는 값이 비동기 요청한 곳으로 돌아가게 함
	public int like(@RequestBody Map<String, Integer> paramMap) {


		return service.like(paramMap);
	}
	
	
	// 게시글 수정 페이지 전환
	@GetMapping("/3/{boardNo}/update")
	public String boardUpdate(@PathVariable("boardNo") int boardNo
							, Model model
							) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardCode", 3);
		map.put("boardNo", boardNo);
		
		CBoard board = service.selectBoard(map);
		
		model.addAttribute("board", board);
		
		return "board/CBoardUpdate";
	}
	

	// 게시글 수정
	@PostMapping("/3/{boardNo}/update")
	public String boardUpdate(CBoard board // 커맨드 객체 (name == 필드 경우 필드에 파라미터 세팅)
			, @RequestParam(value="cp", required = false, defaultValue = "1") int cp // 쿼리스트링 유지
			, @RequestParam(value="deleteList", required = false) String deleteList // 삭제할 이미지 순서
			, @RequestParam(value="images", required =  false) List<MultipartFile> images // 업로드된 파일 리스트
			, @PathVariable("boardNo") int boardNo
			, HttpSession session // 서버 파일 저장 경로를 얻어오는 용도
			, RedirectAttributes ra // 리다이렉트 시 값 전달용
			) throws IllegalStateException, IOException {
		
		// 1) boardCode, boardNo를 커맨드 객체(board)에 세팅
		board.setBoardCode(3);
		board.setBoardNo(boardNo);
		
		// board(boardCode, boardNo, boardTitle, boardContent)
		
		// 2) 이미지 서버 저장 경로, 웹 접근 경로
		String webPath = "/resources/images/board/";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		// 3) 게시글 수정 서비스 호출
		int rowCount = service.boardUpdate(board, images, webPath, filePath, deleteList);
		
		// 4) 수행 결과에 따라 message, path 설정
		String message = null;
		String path = "redirect:";
		
		if(rowCount > 0) {
			message = "게시글이 수정되었습니다.";
			path += "/community/3/"  + boardNo + "?cp=" + cp; // 상세 조회 페이지
		} else {
			message = "게시글 수정 실패";
			path += "update";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	
	
	@GetMapping("/3/{boardNo}/delete")
	public String boardDelete(@PathVariable("boardNo") int boardNo,
								RedirectAttributes ra) {
		
		int boardCode = 3;
		
		int result = service.boardDelete(boardNo);
		
		String path = "redirect:";
		String message = "";
		
		
		if (result > 0) {
			message = "삭제 되었습니다";
			path += ("/community/" + boardCode );
		} else {
			message = "삭제 실패";
			path += ("/community/" + boardCode + "/" + boardNo );
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	
	@GetMapping(value = "/comment", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<CComment> select(int boardNo){
		return service.selectComment(boardNo);
	}
	
	@PostMapping(value = "/comment")
	@ResponseBody
	public int insertComment (@RequestBody CComment comment) {
		return service.insertComment(comment);
	}
	
	@DeleteMapping("/comment")
	@ResponseBody
	public int deleteComment(@RequestBody int commentNo) {
		return service.deleteComment(commentNo);
	}
	
	@PutMapping("/comment")
	@ResponseBody
	public int updateComment(@RequestBody CComment comment) {
		return service.updateComment(comment);
	}
	
	
	@GetMapping("/report")
	public String report(int boardNo, Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardCode", 3);
		map.put("boardNo", boardNo);
		
		CBoard board = service.selectBoard(map);
		
		
		model.addAttribute("board", board);
		
		return "admin/report";
	}
	
	
	@PostMapping("/report/board")
	public String report(CReport report ,@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra, HttpSession session) {
		
		report.setReportNo(loginMember.getMemberNo());
		report.setReportCode(1);
		
		int result = service.insertReport(report);
		
		String message = null;
		String path = "redirect:";		

		if(result > 0) {
			message = "신고 접수가 완료 되었습니다.";
			path += "/community/3/" + report.getBoardNo();
		} else {
			message = "신고 접수 중 오류가 발생했습니다.";
			path += "/community/3/" + report.getBoardNo();
		}
		
		ra.addFlashAttribute("message" ,message);
		
		return path;
	}
	
	

}
