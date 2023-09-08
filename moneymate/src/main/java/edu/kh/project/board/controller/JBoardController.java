package edu.kh.project.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
									,@RequestParam List<JBoard> board) {
		
		
		//List<JBoard> boardList = service.selectBoardNotice(boardCode);
		
		
		return "board/JboardNotice";
		
	}
	
	// 글쓰기 화면가기
	@GetMapping("/{boardCode:[1]}/insert")
	public String selectBoardNoticesdf(@PathVariable("boardCode") int boardCode) {
		
		return "board/JboardWrite";
	}
	

}
