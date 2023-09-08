package edu.kh.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("loginMember")
@Controller
@RequestMapping("/member")
public class KMemberController {
	
	@PostMapping("/KmyInfo")
	public String myInfo() {
		
		String addr = String.join("^^^", memberAddress);
		updateMember.setMemberAddress(addr);
		
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		
		return "member/KmyInfo";
	}

}
