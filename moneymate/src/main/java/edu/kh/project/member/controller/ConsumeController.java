package edu.kh.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"loginMember"})
public class ConsumeController {
	
	@GetMapping("/consumetest")
	public String consumeTest() {
		return "member/consumeTestStart";
	}
	
	@GetMapping("/consumeteststart")
	public String consumeTestStart() {
		return "member/consumeTest";
	}
	
	
	
	
	
	
	
}
