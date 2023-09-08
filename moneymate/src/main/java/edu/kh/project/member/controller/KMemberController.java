package edu.kh.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class KMemberController {
	
	@PostMapping("/KmyInfo")
	public String myInfo() {
		
		return null;
	}

}
