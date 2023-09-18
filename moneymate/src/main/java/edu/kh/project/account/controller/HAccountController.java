package edu.kh.project.account.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.kh.project.account.model.service.HAccountService;
import edu.kh.project.member.model.dto.Member;

@Controller
public class HAccountController {
	
	@Autowired
	private HAccountService service;
	
	// 목록 조회
	@GetMapping("/account/list")
	public String confirm(@SessionAttribute("loginMember") Member loginMember, Model model) {
		
		// 개인 + 그룹 둘 다 조회.. 각각 조회해서 따로 출력하는 방법이 더 좋을 듯
		Map<String, Object> map = service.accountList(loginMember);
		
		// System.out.println(map);
		
		model.addAttribute("map", map);
		
		return "account/accountManage";
	}

}
