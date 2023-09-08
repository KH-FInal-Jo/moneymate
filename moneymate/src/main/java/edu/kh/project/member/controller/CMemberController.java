package edu.kh.project.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.CMemberService;

@Controller
@RequestMapping("/member")

@SessionAttributes({"loginMember"})
public class CMemberController {
	
	@Autowired
	private CMemberService service;
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	
	// 로그인
	@PostMapping("/login")
	public String login(Member inputMember, Model model, @RequestHeader(value="referer") String referer, @RequestParam(value = "saveId", required=false) String saveId, HttpServletResponse resp, RedirectAttributes ra) {
		
		
		Member loginMember = service.login(inputMember);
		
		
		
		String path = "redirect:"; 
		String message = "";
		
		if(loginMember != null) {
			path += "/";
			message = loginMember.getMemberNickname() + "님 환영합니다";
			
			model.addAttribute("loginMember", loginMember);
			
		} else {
			path += "/";
			message = "회원정보를 확인해주세요.";
		}
		
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	@GetMapping("/signUp")
	public String signUp() {
		return "member/signUp";
	}
	
	
	// 회원가입
	@PostMapping("/signUp")
	public String signUp(Member inputMember, String[] memberAddress, RedirectAttributes ra) {
		
		if(inputMember.getMemberAddress().equals(",,")) {
			
			inputMember.setMemberAddress(null);
			
		} else {
			
			String address = String.join("^^^", memberAddress);
			
			inputMember.setMemberAddress(address);

		}
		
		int result = service.signUp(inputMember);
		
		String path = "redirect:";
		String message = "";
		
		if(result > 0) {
			path += "/";
			message = "회원가입 성공!!";
		} else {
			path += "/member/signUp";
			message = "회원가입 실패";
		}
		
		ra.addFlashAttribute("message", message);
		
		
		
		return path;
	}
	
	
	
	@GetMapping("/logout")
	public String logout(SessionStatus status, HttpSession session) {
		
		status.setComplete();

		return "redirect:/";
	}
	
	
	
	
	

}
