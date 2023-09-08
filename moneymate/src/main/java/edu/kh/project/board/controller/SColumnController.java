package edu.kh.project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SColumnController {
	
	@RequestMapping("/columns")
	public String column() {
		return "board/Scolumn";
	}
	
	@GetMapping("/columns/detail")
	public String detail() {
		return "board/ScolumnDetail";
	}

}
