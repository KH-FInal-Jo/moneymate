package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.kh.project.member.model.service.HMemberService;

@Controller
public class HMemberController {
	
	@Autowired
	private HMemberService service;
	
	//@GetMapping("")

}
