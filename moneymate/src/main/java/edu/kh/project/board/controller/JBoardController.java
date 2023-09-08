package edu.kh.project.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.board.model.service.JBoardService;

@RequestMapping("/board")
@Controller
public class JBoardController {
	
	@Autowired
	private JBoardService service;
	
	

}
