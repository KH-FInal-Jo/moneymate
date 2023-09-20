package edu.kh.project.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
import edu.kh.project.board.model.service.SBoardService;
import edu.kh.project.member.model.dto.Member;

@SessionAttributes({"loginMember"})
@Controller
public class SColumnController {
	
	@Autowired
	private SBoardService service;
	
	@RequestMapping("/community/4")
	public String column() {
	
		
		return "board/Scolumn";
	}
	
	@GetMapping("/community/4/insert")
	public String insert() {
		return "board/ScolumnWrite";
	}
	
	
	// 칼럼게시글 삽입
	@PostMapping(value = "/community/4/insert/register", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int boardInsert(	SBoard board
							, @RequestBody Map<String, Object> paramMap
							, @SessionAttribute("loginMember") Member loginMember
							, @RequestParam(value = "images", required = false) List<MultipartFile> images
							, HttpSession session) {
		
		System.out.println("요청 받음");
		System.out.println("boardTitle : " + paramMap.get("boardContent"));
		
		int boardCode = 4;
		int memberNo = loginMember.getMemberNo();
		
		// 1. 로그인한 회원번호를 얻어와 board에 세팅
		board.setMemberNo(loginMember.getMemberNo());

		// 2. boardCode도 board에 세팅
		board.setBoardCode(boardCode);

		// 3. 업로드된 이미지 서버에 실제로 저장되는 경로
		//		+ 웹에서 요청 시 이미지를 볼 수 있는 경로(웹 접근경로)
		String webPath = "/resources/images/board/";
		String filePath = session.getServletContext().getRealPath(webPath);

		
		paramMap.put("boardCode", boardCode);
		paramMap.put("memberNo", memberNo);
		
		System.out.println(paramMap);
		
		
		return service.boardInsert(paramMap, board, images);
//		int boardCode = 4;
//		System.out.println("요청 받음");
//		System.out.println("board : " + board);
//		System.out.println("boardTitle : " + boardTitle);
//		System.out.println("boardContent : " + boardContent);
//		
//		// 로그인한 회원의 번호 세팅
//		board.setMemberNo(loginMember.getMemberNo());
//		board.setBoardCode(boardCode);
//		
//		// 3. 업로드된 이미지 서버에 실제로 저장되는 경로 + 웹에서 요청 시 이미지를 볼수있는 경로(웹 접근경로)
//		String webPath = "/resources/images/board";
//		String filePath = session.getServletContext().getRealPath(webPath);
//		
//		int registerNo = service.boardInsert(board, images, webPath, filePath);
//		
//		String message = null;
//		String path = "redirect:";
//		
//		if(registerNo > 0) {
//			// 성공
//			message = "게시글이 등록되었습니다.";
//			path += "insert";
//		}else {
//			message = "게시글이 등록실패.";
//			path += "insert";
//		}
//		
//		ra.addFlashAttribute("message", message);
//		
//		return path;
//		
		
	}
	
	

}
