package edu.kh.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.KMemberService;

@SessionAttributes("loginMember")
@Controller
@RequestMapping("/member")
public class KMemberController {
	
	private KMemberService service;
	
	@PostMapping("/KmyInfo")
	public String myInfo(Member updateMember, String[]memberAddress
							, @SessionAttribute("loginMember")Member loginMember
							, RedirectAttributes ra) {
		
		// 주소 하나로 합치기 (a^^^b^^^c^^^)
				String addr = String.join("^^^", memberAddress);
				updateMember.setMemberAddress(addr);
				
				// 로그인한 회원의 번호를 updateMember에 추가
				updateMember.setMemberNo(loginMember.getMemberNo());
				
				// DB에 회원정보 수정(UPDATE) 서비스 호출
				int result = service.updateInfo(updateMember);
				
				String message = null;
				if(result > 0) {
					// 성공
					message = "회원 정보가 수정되었습니다.";
					
					// Session 에 로그인된 회원 정보도 수정(동기화)
					loginMember.setMemberNickname(updateMember.getMemberNickname());
					loginMember.setMemberTel(updateMember.getMemberTel());
					loginMember.setMemberAddress(updateMember.getMemberAddress());
				}else {
					// 실패
					message = "회원 정보 수정 실패..";
				}
				
				ra.addFlashAttribute("message",message);
		
		return "redirect:KmyInfo";
	}

}
