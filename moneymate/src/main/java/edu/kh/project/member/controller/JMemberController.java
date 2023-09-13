package edu.kh.project.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.member.model.dto.JMember;
import edu.kh.project.member.model.dto.Member;
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
	
	// 마이페이지 상세조회
	@GetMapping(value="/member/mypage/sidemenu", 
			 	produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<JMember> KmyInfo(@SessionAttribute("loginMember") Member loginMember
						, Model model) {
		
		int memberNo = loginMember.getMemberNo();
		
		List<JMember> memberList = service.selectMypage(memberNo);
		
		model.addAttribute("memberList",memberList);
		
		return memberList;
	}

}
