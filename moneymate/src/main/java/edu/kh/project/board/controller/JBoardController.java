package edu.kh.project.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.JBoard;
import edu.kh.project.board.model.service.JBoardService;

@RequestMapping("/community")
@Controller
public class JBoardController {
	
	@Autowired
	private JBoardService service;
	
	// 공지사항 목록조회
	@GetMapping("/{boardCode:[1]}")
	public String selectBoardNotice(@PathVariable("boardCode") int boardCode
									,Model model
									) {
		
		
		List<JBoard> boardList = service.selectBoardNotice(boardCode);
		
		model.addAttribute("boardList", boardList);
		
		System.out.println(boardList);
		
		return "board/JboardNotice";
		
	}
	
	// 공지사항 상세조회
	@GetMapping("/{boardCode}/{boardNo}")
	public String boardNoticeDetail(@PathVariable("boardCode") int boardCode
									, @PathVariable("boardNo") int boardNo
									, Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		List<JBoard> boardList = service.boardNoticeDetail(map);
		
		model.addAttribute("boardList", boardList);
		
		return "board/JboardDetail";
		
	}
	
	
	// 공지사항 작성 화면
	@GetMapping("/{boardCode:[1]}/insert")
	public String BoardNoticeInsertView(@PathVariable("boardCode") int boardCode) {
		
		return "board/JboardWrite";
	}
	
	// 공지사항 작성하기
	@PostMapping("/{boardCode:[1]}/insert")
	public String BoardNoticeInsert(@PathVariable("boardCode") int boardCode
									,@ModelAttribute JBoard board
									,RedirectAttributes ra
									, HttpSession session) {
		
		board.setBoardCode(boardCode);
		
		int result = service.boardNoticeInsert(board);
		
		int boardNo = board.getBoardNo();

		System.out.println("boardNo : " +boardNo );
		
		
		String message = null;
		String path = "redirect:";
		
		if(boardNo > 0) { // 성공 시
			
			message = "게시글이 등록되었습니다❤";
			path += "/community/" + boardCode + "/" + boardNo;
			
		}else {
			message = "게시글 등록 실패";
			path += "insert";
		}
		
		ra.addFlashAttribute("message", message);

		return path;
	}
	
	// 공지사항 수정 화면
	@GetMapping("/{boardCode:[1]}/{boardNo}/update")
	public String BoardUpdate(@PathVariable("boardCode") int boardCode
							, @PathVariable("boardNo") int boardNo
							, Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		List<JBoard> boardList = service.boardNoticeDetail(map);
		
		model.addAttribute("boardList", boardList);
		
		System.out.println(boardList);
		
		
		return "board/JboardWrite";
	}
	
	

}
