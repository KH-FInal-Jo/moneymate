package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.member.model.service.JMemberService;

@SessionAttributes("loginMember")
@Controller
public class JMemberController {
	
	@Autowired
	private JMemberService service;
	
	@GetMapping("/member/mypage/bookMark")
	public String selectBookMark() {
		return null;
	}

}
