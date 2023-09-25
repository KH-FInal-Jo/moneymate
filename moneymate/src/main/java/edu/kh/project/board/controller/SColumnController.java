package edu.kh.project.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
		int memberNo = loginMember.getMemberNo();
		
		List<SBoard> columnList = service.columnList(memberNo);
		
		System.out.println("columnList : " + columnList);
		
		model.addAttribute("columnList",columnList);
		
		return "board/Scolumn";
	}
	
	@GetMapping("/insert")
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
		
		System.out.println("요청 받음");
		System.out.println("boardTitle : " + boardTitle);
		System.out.println("boardContent : " + boardContent);
		System.out.println("file : " + images);
		
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
							, HttpServletResponse resp) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int boardCode = 4;
		
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		// 게시글 상세조회 서비스 호출
		SBoard board = service.selectBoard(map);
		
		model.addAttribute("board" , board);
		
		
		
		
		
		
		
		return "board/ScolumnDetail";
	}
	
	
	// 이전글
	@GetMapping("/previous")
	@ResponseBody
	public int columnPrevieous(@RequestParam("boardNo")int boardNo) {
		
		System.out.println("이전글 boardNo : " + boardNo);
		
		
		
		return service.columnPrevieous(boardNo);
	}
	
	// 다음글
	@GetMapping("/next")
	@ResponseBody
	public int columnNext(@RequestParam("boardNo")int boardNo) {
		
		System.out.println("다음글 boardNo : " + boardNo);
		
		
		
		return service.columnNext(boardNo);
	}
	
	
	
	
	
	
	

}
