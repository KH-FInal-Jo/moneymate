package edu.kh.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class CMemberController {
	
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	

}
