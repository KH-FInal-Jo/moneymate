package edu.kh.project.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.kh.project.account.model.service.JAccountBkService;

@Controller
public class JAccountBkController {
	
	@Autowired
	private JAccountBkService service;
	
	@GetMapping("/get")
	public String get() {
		
		return "account/JaccountBookInout";
	}
	
	

}
