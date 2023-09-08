package edu.kh.project.member.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.CMemberService;

@Controller
@RequestMapping("/member")

@SessionAttributes({"loginMember"})
public class CMemberController {
	
	@Autowired
	private CMemberService service;
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(Member inputMember, Model model, @RequestHeader(value="referer") String referer, HttpServletResponse resp) {
		
		System.out.println(inputMember);
		
		Member loginMember = service.login(inputMember);
		
		String path = "redirect:"; 
		
		if(loginMember != null) {
			path += "/";
			
			model.addAttribute("loginMember", loginMember);
			
		} else {
			path += referer;
		}
		
		return path;
	}
	
	@GetMapping("/signUp")
	public String signUp() {
		return "member/signUp";
	}
	
	
	
	
	
	

}
