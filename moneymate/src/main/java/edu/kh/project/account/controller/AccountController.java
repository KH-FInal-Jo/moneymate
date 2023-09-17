package edu.kh.project.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.account.model.dto.SAccount;
import edu.kh.project.account.model.service.AccountService;
import edu.kh.project.account.model.service.AccountServiceImpl;
import edu.kh.project.member.model.dto.Member;
@SessionAttributes({"loginMember"})
@Controller
public class AccountController {

	
	@Autowired
	private AccountService service;
	
	@RequestMapping("/account/1")
	public String accountBook() {
		return "account/SaccountBookDetail";
	}
	
	
	// 월 지출금액
	@GetMapping(value = "/account/changeMonth", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int changeMonth(@RequestParam("month") String month, 
							@RequestParam("accountNo") String accountNo,
						@SessionAttribute("loginMember") Member loginMember) {
					   
	    System.out.println("달 : " + month);
	    System.out.println("가계부번호 : " + accountNo);
	    System.out.println("멤버번호 : " + loginMember.getMemberNo());
	    int memberNo = loginMember.getMemberNo();
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    
	    map.put("month", month);
	    map.put("accountNo", accountNo);
	    map.put("memberNo", memberNo);
	    
	    
	    
	    System.out.println("건너오나?" + map);
	    return service.changeMonth(map); // 예시 JSON 응답
	}
	
	
	
	// 월 수입금액
	@GetMapping(value = "/account/changeMonthIncome", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int changeMonthIncome(@RequestParam("month") String month, 
			@RequestParam("accountNo") String accountNo,
			@SessionAttribute("loginMember") Member loginMember) {
		
		int memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("month", month);
		map.put("accountNo", accountNo);
		map.put("memberNo", memberNo);
		
		
		
		return service.changeMonthIncome(map); // 예시 JSON 응답
	}
	
	
	// 월 지출내역 업데이트
	@GetMapping(value = "/account/changeMonthUpdate", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<SAccount> changeMonthUpdate(@RequestParam("month") String month, 
											@RequestParam("accountNo") String accountNo,
											@SessionAttribute("loginMember") Member loginMember) {
	    int memberNo = loginMember.getMemberNo();
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    
	    map.put("month", month);
	    map.put("accountNo", accountNo);
	    map.put("memberNo", memberNo);
	    
	    System.out.println("업데이트 : " + map);
	    
	    return service.changeMonthUpdate(map); // 예시 JSON 응답
	}
	
	
	// 월 수입내역 업데이트
	@GetMapping(value = "/account/changeMonthUpdateIncome", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<SAccount> changeMonthUpdateIncome(@RequestParam("month") String month, 
			@RequestParam("accountNo") String accountNo,
			@SessionAttribute("loginMember") Member loginMember) {
		int memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("month", month);
		map.put("accountNo", accountNo);
		map.put("memberNo", memberNo);
		
		
		return service.changeMonthUpdateIncome(map); // 예시 JSON 응답
	}
	
	
	// 월 지출 그래프
	@GetMapping(value = "/account/changeChart", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<SAccount> changeChart(@RequestParam("month") String month, 
											@RequestParam("accountNo") String accountNo,
											@SessionAttribute("loginMember") Member loginMember) {
	    int memberNo = loginMember.getMemberNo();
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    
	    map.put("month", month);
	    map.put("accountNo", accountNo);
	    map.put("memberNo", memberNo);
	    
	    System.out.println("업데이트 : " + map);
	    
	    return service.changeChart(map); // 예시 JSON 응답
	}
	
	
	
	// 월 수입 그래프
	@GetMapping(value = "/account/changeChartIncome", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<SAccount> changeChartIncome(@RequestParam("month") String month, 
			@RequestParam("accountNo") String accountNo,
			@SessionAttribute("loginMember") Member loginMember) {
		int memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("month", month);
		map.put("accountNo", accountNo);
		map.put("memberNo", memberNo);
		
		System.out.println("업데이트 : " + map);
		
		return service.changeChartIncome(map); // 예시 JSON 응답
	}
	
	

}
