package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.member.model.service.CEmailService;

@Controller
@RequestMapping("sendEmail")
@SessionAttributes("authKey")
public class CEmailController {
	
	@Autowired
	private CEmailService service;
	
	@GetMapping("/signUp")
	@ResponseBody
	public int signUp(String email) {
		return 0; /*service.signUp(email, "회원 가입");*/
	}
	
	

}
