package edu.kh.project.account.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	private HttpSession httpSession;

	@GetMapping("/accountBk/inout")
	public String accountBkInout() {

		return "account/JaccountBookInout";
	}
	
	// 가계부 상세조회
	@GetMapping("/account/{bigAccountNo}/insert")
	public String accountBkSelect(@SessionAttribute("loginMember") Member loginMember
								, @PathVariable("bigAccountNo") int bigAccountNo
								, Model model) {
		
		int useMoney = service.accountBkSelect(bigAccountNo);
		
		JAccountBook account = service.selectAccountBk(bigAccountNo);
		
		
		model.addAttribute("useMoney", useMoney);
		model.addAttribute("account", account);
		
		
		return "account/JaccountBookInout";
		
	}
	

	// 가계부 작성하기
	@PostMapping("/account/insert/{bigAccountNo}")
	public String accountBkInsert(JAccountBook accountBk
								, @SessionAttribute("loginMember") Member loginMember
								, @PathVariable("bigAccountNo") int bigAccountNo
								, RedirectAttributes ra
								, HttpSession session) {

		accountBk.setAccountNo(bigAccountNo);
		
		if(accountBk.getPaymentMethod() == null) {
			
			accountBk.setPaymentMethod("무통장입금");
		}
		
		int result = service.accountBkInsert(accountBk);

		String message = null;
		String path = "redirect:";

		if(result > 0) { // 성공 시
			
			message = "가계부가 등록되었습니다.";
			path += "/account/insert/1";

		}else {
			message = "가계부 등록 실패ㅠㅠ";
			path += "/accountBk/inout";
		}

		ra.addFlashAttribute("message", message);


		return path;
	}
	
	// 목표금액
	@PostMapping(value="/account/target", 
			 produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int accountBkTarget(@RequestBody JAccountBook accountBk
								, HttpSession session) {
		
		return service.insertTarget(accountBk);
	}

}
