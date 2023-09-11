package edu.kh.project.account.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.account.model.dto.JAccountBook;
import edu.kh.project.account.model.service.JAccountBkService;
import edu.kh.project.member.model.dto.Member;

@SessionAttributes({"loginMember"})
@Controller
public class JAccountBkController {

	@Autowired
	private JAccountBkService service;

	@GetMapping("/accountBk/inout")
	public String accountBkInout() {

		return "account/JaccountBookInout";
	}
	
	// 가계부 상세조회
	@GetMapping("/account/insert")
	public String accountBkSelect(@SessionAttribute("loginMember") Member loginMember,
								Model model) {
		
		String useMoney = service.accountBkSelect(loginMember.getMemberNo());
		
		model.addAttribute("useMoney", useMoney);
		
		System.out.println(useMoney);
		
		return "account/JaccountBookInout";
		
	}
	

	// 가계부 작성하기
	@PostMapping("/account/insert")
	public String accountBkInsert(JAccountBook accountBk
								, @SessionAttribute("loginMember") Member loginMember
								, RedirectAttributes ra
								, HttpSession session) {

		accountBk.setMemberNo(loginMember.getMemberNo());
		
		int result = service.accountBkInsert(accountBk);

		String message = null;
		String path = "redirect:";

		if(result > 0) { // 성공 시
			
			System.out.println("accountNo : " +accountBk.getAccountNo());

			message = "가계부가 등록되었습니다.";
			path += "/account";

		}else {
			message = "가계부 등록 실패ㅠㅠ";
			path += "/accountBk/inout";
		}

		ra.addFlashAttribute("message", message);


		return path;
	}
	
	// 목표금액
	@PostMapping("/account/target")
	@ResponseBody
	public String accountBkTarget(@RequestParam("accTarget") String accTarget
								, @SessionAttribute("loginMember") Member loginMember) {
		
		
		JAccountBook account = new JAccountBook();
		account.setMemberNo(loginMember.getMemberNo());
		account.setTargetMoney(accTarget);
		
		
		
		return service.accountBkTarget(account);
	}

}
