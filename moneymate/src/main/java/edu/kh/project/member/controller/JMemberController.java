package edu.kh.project.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.utils.Punycode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/member/mypage/bookMark/{boardCode}/{memberNo}")
	public String selectBookMark(@PathVariable("boardCode") int boardCode,
								@PathVariable("memberNo") int memberNo
								, @RequestParam(value="cp", required = false, defaultValue = "1") int cp
								, Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardCode", boardCode);
		map.put("memberNo", memberNo);
		map.put("cp", cp);
		
		Map<String, Object> bkmap = service.selectBookmark(map);
		
		
		model.addAttribute("map", bkmap);
		
		return "member/JmyPageBkMark";
	}
	
	// 마이페이지 상세조회
	@GetMapping(value="/member/mypage/sidemenu")
	@ResponseBody
	public List<JMember> selectMypage2(@SessionAttribute("loginMember") Member loginMember
						, Model model) {
		
		int memberNo = loginMember.getMemberNo();
		
		List<JMember> memberList = service.selectMypage2(memberNo);
		
		model.addAttribute("memberList",memberList);
		
		return memberList;
	}
	
	
	@GetMapping(value="/member/mypage/sidemenu2", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String selectMypage3(@SessionAttribute("loginMember") Member loginMember
			, Model model) {
		
		int memberNo = loginMember.getMemberNo();
		
		System.out.println("memberNo : " + memberNo);
		
		String testResult = service.selectMypage3(memberNo);
		
		System.out.println("testResult : " + testResult);
		
		return testResult;
	}

}
