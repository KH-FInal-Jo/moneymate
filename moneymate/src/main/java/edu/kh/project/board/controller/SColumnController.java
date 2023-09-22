package edu.kh.project.board.controller;

import java.io.IOException;
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
	public String boardInsert(	SBoard board
							, @RequestBody Map<String, Object> paramMap
							, @SessionAttribute("loginMember") Member loginMember
							, @RequestParam(value = "images", required = false) List<MultipartFile> images
							, HttpSession session
							, RedirectAttributes ra)throws IllegalStateException, IOException {
		
		System.out.println("요청 받음");
		System.out.println("boardTitle : " + paramMap.get("boardContent"));
		
		int boardCode = 4;
		int boardNo = 0;
		int memberNo = loginMember.getMemberNo();
		
		// 1. 로그인한 회원번호를 얻어와 board에 세팅
		board.setMemberNo(memberNo);

		// 2. boardCode도 board에 세팅
		board.setBoardCode(boardCode);
		
		// map형식으로 얻어온 값들을 String 변수에 담아주기
		String boardTitle = (String)paramMap.get("boardTitle");
		String boardContent = (String)paramMap.get("boardContent");
		
		// form형식으로 받은게 아니기 때문에 커맨드 객체 활용 불가능
		// 직접 값 필드에 넣어주기
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		

		// 3. 업로드된 이미지 서버에 실제로 저장되는 경로
		//		+ 웹에서 요청 시 이미지를 볼 수 있는 경로(웹 접근경로)
		String webPath = "/resources/images/board/";
		String filePath = session.getServletContext().getRealPath(webPath);

		
		paramMap.put("boardCode", boardCode);
		paramMap.put("memberNo", memberNo);
		paramMap.put("boardNo", boardNo);
		
		System.out.println(paramMap);
		
		// 게시글 삽입 서비스 호출 후 삽입된 게시글 번호 반환 받기
		boardNo = service.boardInsert(board, images, webPath, filePath, paramMap);
		
		// 게시글 삽입 성공 시
		// -> 방금 삽입한 게시글의 상세조회 페이지 리다이렉트
		
		String message = null;
		String path = "redirect:";
		
		if(boardNo > 0) {
			message = "게시글이 등록 되었습니다.";
			path += "/board/" + boardCode + "/" + boardNo;
		}else {
			message = "게시글 등록 실패";
			path += "insert";
		}
		
		ra.addFlashAttribute("message" + message);
		
		return path;
		
		
		
		
	}
	
	
	@PostMapping(value = "/community/4/insert/imageList", produces = "application/json; charset=UTF-8")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		
		System.out.println("file : " + file);
		
		return null;
		
    }
	
	

}
