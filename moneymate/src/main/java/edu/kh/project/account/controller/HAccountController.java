package edu.kh.project.account.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.account.model.dto.HAccount;
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
		
		model.addAttribute("map", map);
		
		return "account/accountManage";
	}
	
	// 이메일 회원 검사
	@PostMapping(value = "/account/emailCheck")
	@ResponseBody
	public int dupEmail(@RequestBody String memberEmail) {
		
		return service.dupEmail(memberEmail);
	}
	
	// 가계부 생성
	@PostMapping("/account/create")
	public String createAccount(String[] gEmail, String accountName, RedirectAttributes ra, @SessionAttribute("loginMember") Member loginMember) {
		int result = 0;
		HAccount account = new HAccount();
		account.setMemberNo(loginMember.getMemberNo());
		account.setAccountName(accountName);
		account.setMemberEmail(loginMember.getMemberEmail());
		
		
		
		if(gEmail == null) {
			result = service.pAccount(account);
			
		} else {
			// 이메일로 회원 초대하는 로직
			 result = service.gAccount(account, gEmail);
		}
		
		if(result>0) {
			ra.addFlashAttribute("message", "가계부가 생성되었습니다.");
		} else {
			ra.addFlashAttribute("message", "가계부 생성 실패");
		}
		
		return "redirect:/account/list";
	}
	
	// 초대장 들어가기
	@GetMapping("/accounted/invite/{key}")
	public String emailInvite(@PathVariable("key") String key, Model model) {
		
		model.addAttribute("key", key);
		
		return "account/emailConfirm";
	}
	
	// 초대장 수락
	@GetMapping("/accounted/accept/{key}")
	public String inviteAccept(@PathVariable("key") String key, RedirectAttributes ra) {
		
		
		int result = service.inviteAccept(key);
		
		
		//result = 0;
		
		if(result>0) {
			ra.addFlashAttribute("message", "수락완료 ! 로그인 후 이용해주세요");
		} else {
			ra.addFlashAttribute("message", "가계부 초대 수락 실패..");
		}
		
		return "redirect:/member/login";
	}

}
