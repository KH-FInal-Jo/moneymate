package edu.kh.project.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.board.model.service.JBoardService;

@Controller
public class JBoardController {
	
	@Autowired
	private JBoardService service;
	
	
	@GetMapping("/community")
	public String selectBoardNotice(int boardCode) {
		
		System.out.println(boardCode);
		
		return "board/JboardNotice";
	}
	
	

}
