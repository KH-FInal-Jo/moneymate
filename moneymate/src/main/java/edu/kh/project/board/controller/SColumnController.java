package edu.kh.project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class SColumnController {
	
	@GetMapping("/4")
	public String column() {
		
		
		
		
		
		
		
		return "board/Scolumn";
	}
	
	

}
