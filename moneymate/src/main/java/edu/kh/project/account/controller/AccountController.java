package edu.kh.project.account.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.account.model.service.AccountService;
import edu.kh.project.account.model.service.AccountServiceImpl;
import edu.kh.project.member.model.dto.Member;
@SessionAttributes({"loginMember"})
@Controller
public class AccountController {

	
	@Autowired
	private AccountService service;
	
	@RequestMapping("/account")
	public String accountBook() {
		return "account/SaccountBookDetail";
	}
	
	@GetMapping(value = "/account/changeMonth", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int changeMonth(@RequestParam("month") String month, @SessionAttribute("loginMember") Member loginMember) {
	    System.out.println("달 : " + month);
	    System.out.println("멤버번호 : " + loginMember.getMemberNo());
	    int memberNo = loginMember.getMemberNo();
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    
	    map.put("month", month);
	    map.put("memberNo", memberNo);
	    
	    
	    
	    System.out.println("건너오나?" + map);
	    return service.changeMonth(map); // 예시 JSON 응답
	}
	
	

}
