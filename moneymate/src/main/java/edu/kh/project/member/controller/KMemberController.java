package edu.kh.project.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.JMember;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.KMemberService;

@SessionAttributes("loginMember")
@Controller
@RequestMapping("/member")
public class KMemberController {
	
	@Autowired
	private KMemberService service;
	
	// 마이페이지 상세조회
	@GetMapping("/mypage")
	public String KmyInfo(@SessionAttribute("loginMember") Member loginMember
						, Model model) {
		
		int memberNo = loginMember.getMemberNo();
		
		List<JMember> memberList = service.selectMypage(memberNo);
		
		model.addAttribute("memberList",memberList);
		
		return "/member/KmyInfo";
	}
	
	@PostMapping("/mypage")
	public String myInfo(Member updateMember, String[]memberAddress
							, @SessionAttribute("loginMember")Member loginMember
							, RedirectAttributes ra) {
		
				String addr = String.join("^^^", memberAddress);
				updateMember.setMemberAddress(addr);
				
				updateMember.setMemberNo(loginMember.getMemberNo());
				
				int result = service.updateInfo(updateMember);
				
				String message = null;
				if(result > 0) {
					message = "회원 정보가 수정되었습니다.";					
					loginMember.setMemberNickname(updateMember.getMemberNickname());
					loginMember.setMemberTel(updateMember.getMemberTel());
					loginMember.setMemberAddress(updateMember.getMemberAddress());
				}else {
					message = "회원 정보 수정 실패..";
				}
				
				ra.addFlashAttribute("message",message);
		
		return "/member/KmyInfo";
	}
	
	@PostMapping("/changePw")
	public String ChangePw( String currentPw, String newPw
							, @SessionAttribute("loginMember")Member loginMember
							, RedirectAttributes ra) {
		
		int memberNo = loginMember.getMemberNo();
		
		int result = service.changePw(currentPw, newPw, memberNo);
		
		String path = "rediret:";
		String message = null;
		
		if(result>0) {
			message="비밀번호가 변경 되었습니다.";
			path += "myPage";
		
		}else {
			message="비밀번호가 틀립니다.";
			path += "changePw";
		}
		ra.addFlashAttribute("message", message);
		
		return path;
		
		
	}

}



