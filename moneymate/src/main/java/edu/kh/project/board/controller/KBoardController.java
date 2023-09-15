package edu.kh.project.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		

		
		
		if(paramMap.get("key") ==null) {
			Map<String, Object> map = service.selectboardInquiry(boardCode, cp);
			model.addAttribute("map", map);
			
			System.out.println(map);
		}


		return "board/boardInquiry";
	}
	// 게시글 작성 화면 전환
	@GetMapping("/2/boardInquiryWrtie")
	public String selectboardInquiryWrtie() {

		return "board/boardInquiryWrtie";
	}
	// 게시글 작성
	@PostMapping("/2/insert")
	public String boardInsert(
			@PathVariable("/community/2") int boardCode // 작성하고 이동할 페이지
			, KBoard board // 커맨드 객체
			, @SessionAttribute("loginMember")Member loginMember // 로그인한 회원 번호
			, RedirectAttributes ra // 리다이렉트시에 데이터 전달
			, HttpSession session // 파일 저장 경로
			)throws IllegalStateException, IOException {
		
		
		// 로그인한 회원번호 얻어와서 board에 세팅
		board.setMemberNo(loginMember.getMemberNo());
		
		// 2도 board에 세팅
		board.setBoardCode(2);
		
		
		int boardNo = service.boardInsert(board);
		
		String message = null;
		String path = "redirect:";

		if(boardNo > 0 ) {
			// 성공 시
			message = "게시글이 등록 되었습니다.";
			path += "/community/2/" + boardNo;
		}else {
			message = "게시글 등록 실패..";
			path += "insert";
		}
		
		ra.addFlashAttribute("message", message);

		return path;
		
	}


}
