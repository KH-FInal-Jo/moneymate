package edu.kh.project.member.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.CMemberService;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
@RequestMapping("/member")

@SessionAttributes({"loginMember", "authKey"})
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
			
			Cookie cookie = new Cookie("banseoksaveId1", loginMember.getMemberEmail());
			
			if(saveId != null) { 
				cookie.setMaxAge(60 * 60 * 24 * 30); 
				
			} else { 
				cookie.setMaxAge(0);
			}
			
			cookie.setPath("/"); 
			
			resp.addCookie(cookie);
			
		} else {
			path += referer;
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
	
	@GetMapping("mypage/secession")
	public String secession () {
		return "member/secession";
	}
	
	@PostMapping("mypage/secession")
	public String secession (String memberPw, @SessionAttribute("loginMember") Member loginMember
							, SessionStatus status, HttpServletResponse resp, RedirectAttributes ra) {
		
		
		int memberNo = loginMember.getMemberNo();
		
		int result = service.secession(memberPw, memberNo);
		
		String path = "redirect:";
		String message = null;
		
		
		if(result>0) { 
			
			status.setComplete();
			
			Cookie cookie = new Cookie("banseoksaveId1", "");
			
			cookie.setMaxAge(0); 
			
			cookie.setPath("/"); 
			
			resp.addCookie(cookie); 
			
			message = "탈퇴되었습니다.";
			
			path += "/";
			
			
		} else { 
			
			message = "현재 비밀번호가 일치하지 않습니다.";
			
			path += "secession";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	@GetMapping("mypage/myboard")
	public String myBoard (@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			Model model, @RequestParam Map<String, Object> paramMap,  @SessionAttribute("loginMember") Member loginMember) {
		
		
		int myNum = loginMember.getMemberNo();
		
		if (paramMap.get("sel") == null) {
			Map<String, Object> map = service.selectMyBoard(cp, myNum);

			model.addAttribute("map1", map);
			
		} else {
			
			
			paramMap.put("myNum", myNum);
			
			Map<String, Object> map = service.selectMyBoard(paramMap, cp);
			
		 
			model.addAttribute("map1", map);
			 
		}
		
		return "member/myBoard";
	}
	
	
	// 아이디 중복 검사
	@GetMapping("/signUp/emaildupCheck")
	@ResponseBody
	public int emailDupCheck(String email) {
		
		return service.emailDupCheck(email);
	}
	
	// 이메일인증
	@GetMapping("/signUp/sendEmail")
	@ResponseBody
	public int signUp(String email) {
		return service.signUp(email, "회원 가입");
	}
	
	
	@GetMapping("/signUp/checkAuthKey")
	@ResponseBody
	public int checkAuthKey(@RequestParam Map<String, Object> paramMap) {
		
		System.out.println("param : " + paramMap);
		
		return service.checkAuthKey(paramMap);
	}
	
	
	
	@GetMapping("/signUp/dupNicknameCheck")
	@ResponseBody 
	public int nicknameDupCheck(String nickname) {
		
		System.out.println("nickname : " + nickname);
		
		return service.nicknameDupCheck(nickname);
	}
	
	
	
	
	
	 @GetMapping("/signUp/authPhone")
	 @ResponseBody 
	 public String memberPhoneCheck(@RequestParam(value = "mTel") String mTel) throws CoolsmsException {
	  
	  
	 return service.memberPhoneCheck(mTel); 
	 
	 
	 }
	 
	 
	 @GetMapping("dupCheckTestResult")
	 @ResponseBody
	 public int dupCheckTestResult(@SessionAttribute("loginMember") Member loginMember, String testResult) {
		 
		 
		 Member member = new Member();
		 
		 member.setTestResult(testResult);
		 member.setMemberNo(loginMember.getMemberNo());
		 
		 return service.dupCheckTestResult(member);
	 }
	 
	 
	 @GetMapping("insertTestResult")
	 @ResponseBody
	 public int insertTestResult(@SessionAttribute("loginMember") Member loginMember, String testResult) {
		 
		 
		 Member member = new Member();
		 
		 member.setTestResult(testResult);
		 member.setMemberNo(loginMember.getMemberNo());
		 
		 
		 return service.insertTestResult(member);
	 }
	 
	 
	 
	 
	 
	 @GetMapping("updateTestResult")
	 @ResponseBody
	 public int updateTestResult(@SessionAttribute("loginMember") Member loginMember, String testResult) {
		 
		 
		 Member member = new Member();
		 
		 member.setTestResult(testResult);
		 member.setMemberNo(loginMember.getMemberNo());
		 
		 return service.updateTestResult(member);
	 }
	
	
	
	
	
	
	
	

}
