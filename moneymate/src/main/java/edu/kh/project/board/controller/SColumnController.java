package edu.kh.project.board.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.SBoard;
import edu.kh.project.board.model.dto.SBoardImage;
import edu.kh.project.board.model.dto.SColumnRandom;
import edu.kh.project.board.model.service.SBoardService;
import edu.kh.project.member.model.dto.Member;

@SessionAttributes({"loginMember"})
@Controller
@RequestMapping("/community")
public class SColumnController {
	
	@Autowired
	private SBoardService service;
	
	// 게시글 목록 조회
	@GetMapping("/4")
	public String column(@SessionAttribute("loginMember") Member loginMember
						 , Model model) {
	
		
		List<SBoard> columnList = service.columnList();
		
		
		model.addAttribute("columnList",columnList);
		model.addAttribute("loginMember",loginMember);
		
			
		return "board/Scolumn";
		
		
	}
	
	@GetMapping("/4/insert")
	public String insert() {
		return "board/ScolumnWrite";
	}
	
	
	// 칼럼게시글 삽입
	@PostMapping(value = "/register", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int boardInsert(	SBoard board
							, @RequestParam("images") List<MultipartFile> images
							, @RequestParam(value = "boardTitle") String boardTitle
							, @RequestParam(value = "boardContent") String boardContent
							, @SessionAttribute("loginMember") Member loginMember
							, HttpSession session
							, RedirectAttributes ra)throws IllegalStateException, IOException {
		
		
		int boardCode = 4;
		int boardNo = 0;
		int memberNo = loginMember.getMemberNo();
		
		// 1. 로그인한 회원번호를 얻어와 board에 세팅
		board.setMemberNo(memberNo);

		// 2. boardCode도 board에 세팅
		board.setBoardCode(boardCode);
		
		
		// form형식으로 받은게 아니기 때문에 커맨드 객체 활용 불가능
		// 직접 값 필드에 넣어주기
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		// 업로드된 이미지 서버에 실제로 저장되는 경로
		//		+ 웹에서 요청 시 이미지를 볼 수 있는 경로(웹 접근경로)
		String webPath = "/resources/images/column/";
		String filePath = session.getServletContext().getRealPath(webPath);



		
		
		// 게시글 삽입 서비스 호출 후 삽입된 게시글 번호 반환 받기
		return service.boardInsert(board, images, webPath, filePath);
		

		
		
		
	}
	
	// 게시글 상세조회
	@GetMapping("/4/{boardNo}")
	public String columnDetail(@PathVariable("boardNo") int boardNo
							, Model model
							, @SessionAttribute("loginMember")Member loginMember
							, RedirectAttributes ra
							, HttpServletRequest req
							, HttpServletResponse resp) throws ParseException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int boardCode = 4;
		
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		// 게시글 상세조회 서비스 호출
		SBoard board = service.selectBoard(map);
		
		List<SBoard> randomList = service.selectRandom(map);
		
		model.addAttribute("board", board);
		model.addAttribute("randomList", randomList);
		
		if(board != null) {
			// 조회 결과가 있을 경우
			if(loginMember != null) {
				// 로그인 상태인 경우
				map.put("memberNo", loginMember.getMemberNo());
				
				// 좋아요 여부 서비스 호출
				int result = service.columnLikeCheck(map);
				
				if(result > 0) {
					model.addAttribute("likeCheck" , "on");
				}
			}
		}
		
		// 비회원 또는 로그인한 회원의 글이 아닌 경우
		if(loginMember == null || loginMember.getMemberNo() != board.getMemberNo()) {
			
			// 쿠키 얻어오기
			Cookie c = null;
			
			// 요청에 담겨있는 모든 쿠키 얻어오기
			Cookie[] cookies = req.getCookies();
			
			if(cookies != null) {
				// 쿠키가 존재할 경우
				// 쿠키 중 "readBoardNo"라는 쿠키를 찾아서 c에 대입
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("readBoardNo")) {
						c = cookie;
						break;
					}
				}
			}
			
			// 기존 쿠키가 없거나 (c == null)
			// 존재는 하나 현재 게시글 번호가
			// 쿠키에 저장되지 않은 경우(오늘 해당 게시글 본 적 없음)
			int result = 0;
			
			if(c == null) {
				// 쿠키가 존재 X -> 하나 새로 생성
				c = new Cookie("readBoardNo", "|" + boardNo + "|");
				
				result = service.readCount(boardNo);
			}else {
				// 현재 게시글 번호가 쿠키에 있는지
				
				// Cookie.getValue() : 쿠키에 저장된 모든 값을 읽어옴
				// -> String 으로 반환
				
				if(c.getValue().indexOf("|" + boardNo + "|") == -1) {
					
					// 찾는 문자열이 몇번 인덱스에 존재하는지 반환, 단 없으면 -1 반환
					// 쿠키에 게시글 번호가 없다면 기존 값에 게시글 번호 추가해서 다시 세팅
					c.setValue(c.getValue() + "|" + boardNo + "|");
					
					
					result = service.readCount(boardNo);
				}
				
			}
			
			// 조회 수 증가 성공 시 쿠키가 적용되는 경로
			// 수명 지정
			if(result > 0) {
				
				board.setReadCount(board.getReadCount() + 1);
				
				c.setPath("/");
				// "/" 이하 경로 요청 시 쿠키 서버로 전달
				
				// 수명 지정
				Calendar cal = Calendar.getInstance();
				
				cal.add(cal.DATE, 1);
				
				// 날짜 표기법 변경 객체
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				Date a = new Date();
				
				Date temp = new Date(cal.getTimeInMillis()); // 내일 24시간 후
				
				Date b = sdf.parse(sdf.format(temp)); // 내일 0시 0분
				
				long diff = (b.getTime() - a.getTime()) / 1000;
				// -> 내일 0시0분0초 까지 남은 시간을 초단위로 반환
				
				c.setMaxAge((int)diff);
				
				resp.addCookie(c);
				// 응답 객체를 이용해서 클라이언트에게 전달
			}
			
		}
		
		
		
		
		
		
		return "board/ScolumnDetail";
	}
	
	
	// 이전글
	@GetMapping("/previous")
	@ResponseBody
	public int columnPrevieous(@RequestParam("boardNo")int boardNo) {
		
		
		
		
		return service.columnPrevieous(boardNo);
	}
	
	// 다음글
	@GetMapping("/next")
	@ResponseBody
	public int columnNext(@RequestParam("boardNo")int boardNo) {
		
		
		
		
		return service.columnNext(boardNo);
	}
	
	// 삭제하기
	@GetMapping("/columnDelete")
	@ResponseBody
	public int columnDelete(@RequestParam("boardNo")int boardNo) {
		
		return service.columnDelete(boardNo);
	}
	
	// 좋아요 처리
	@PostMapping("/4/like")
	@ResponseBody
	public int likeCount(@RequestBody Map<String, Integer> paramMap) {
		
		
		return service.likeCount(paramMap);
	}
	
	
	
	

}
