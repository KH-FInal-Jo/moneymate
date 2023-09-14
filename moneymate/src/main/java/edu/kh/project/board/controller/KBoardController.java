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

	@GetMapping("/2/boardInquiryWrtie")
	public String selectboardInquiryWrtie() {

		return "board/boardInquiryWrtie";
	}
	
	@PostMapping("/{boardCode:[0-9]+}/insert")
	public String boardInsert(
			@PathVariable("boardCode") int boardCode
			, KBoard board
			, @SessionAttribute("loginMember")Member loginMember
			, RedirectAttributes ra
			, HttpSession session
			)throws IllegalStateException, IOException {
		
		board.setMemberNo(loginMember.getMemberNo());
		board.setBoardCode(boardCode);
		
		int boardNo = service.boardInsert(board);
		
		String message = null;
		String path = "redirect:";

		if(boardNo > 0 ) {
			// 성공 시
			message = "게시글이 등록 되었습니다.";
			path += "/board/" + boardCode + "/" + boardNo;
		}else {
			message = "게시글 등록 실패..";
			path += "insert";
		}
		
		ra.addFlashAttribute("message", message);

		return path;
		
	}


}
