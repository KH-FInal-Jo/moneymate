package edu.kh.project.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.kh.project.account.model.service.HAccountService;

@Controller
public class HAccountController {
	
	@Autowired
	private HAccountService service;
	
	// 임시
	@GetMapping("/email/confirm")
	public String confirm() {
		return "account/emailConfirm";
	}

}
