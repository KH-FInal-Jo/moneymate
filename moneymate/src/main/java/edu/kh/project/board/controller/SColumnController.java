package edu.kh.project.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.SBoard;
import edu.kh.project.board.model.service.SBoardService;
import edu.kh.project.member.model.dto.Member;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/community")
public class SColumnController {
	
	@Autowired
	private SBoardService service;
	
	@GetMapping("/4")
	public String column() {
	
		
		return "board/Scolumn";
	}
	
	@GetMapping("/4/insert")
	public String insert() {
		return "board/ScolumnWrite";
	}
	
	@PostMapping("/4/register")
	public String boardInsert(SBoard board,
								@SessionAttribute("loginMember") Member loginMember,
								@RequestParam(value="images", required = false) List<MultipartFile> images,
								@RequestParam("title") String boardTitle,
								@RequestParam("content") String boardContent,
								RedirectAttributes ra
								, HttpSession session) {
		int boardCode = 4;
		System.out.println("요청 받음");
		System.out.println("board : " + board);
		System.out.println("boardTitle : " + boardTitle);
		System.out.println("boardContent : " + boardContent);
		
		// 로그인한 회원의 번호 세팅
		board.setMemberNo(loginMember.getMemberNo());
		board.setBoardCode(boardCode);
		
		// 3. 업로드된 이미지 서버에 실제로 저장되는 경로 + 웹에서 요청 시 이미지를 볼수있는 경로(웹 접근경로)
		String webPath = "/resources/images/board";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		int registerNo = service.boardInsert(board, images, webPath, filePath);
		
		String message = null;
		String path = "redirect:";
		
		if(registerNo > 0) {
			// 성공
			message = "게시글이 등록되었습니다.";
			path += "insert";
		}else {
			message = "게시글이 등록실패.";
			path += "insert";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
		
		
	}
	
	

}
