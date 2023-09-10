package edu.kh.project.subscribe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.subscribe.model.dto.Subscribe;
import edu.kh.project.subscribe.model.service.HSubscribeService;

@SessionAttributes("loginMember")
@Controller
public class HSubscribeController {

	@Autowired
	private HSubscribeService service;
	
	@GetMapping("/subscribe/info")
	public String subscribeInfo() {
		return "subscribe/subscribeInfo";
	}
	
	@GetMapping("subscribe/ing")
	public String subscribing(int type, Model model, @SessionAttribute("loginMember") Member loginMember) {
		
		int memberNo = loginMember.getMemberNo();
		
		int prevPrice = 0;
		
		if(type == 1) {
			prevPrice = 2900;
		} 
		if(type == 2) {
			prevPrice = 31900;
		} 
		if(type == 3) {
			prevPrice = 16530;
		} 
		
		// 마일리지 조회
		int mile = service.mile(memberNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("mile", mile);
		map.put("prevPrice", prevPrice);
		
		model.addAttribute("map", map);
		
		return "subscribe/subscribing";
	}
	
	@PostMapping("/subscribe/calculate/kg")
	@ResponseBody
	public String calcuateKg(@RequestBody Map<String, Object> paramMap
							, @SessionAttribute("loginMember") Member loginMember) {
		
		// 가져온 거 : 실제 가격, 마일리지 전 가격, 사용 마일리지
		
		System.out.println("ㅊ음 : " + paramMap);
		Subscribe subscribe = new Subscribe();
		
		if(Integer.parseInt((String) paramMap.get("prePrice")) == 2900) {
			subscribe.setSubscribeLevel(1);
		}else if((int)paramMap.get("prePrice") == 31900){
			subscribe.setSubscribeLevel(3);
		} else {
			subscribe.setSubscribeLevel(2);
		}
		
		// SUBSCRIBE 객체에 담기
		
		Object amountValue = paramMap.get("amount");
		System.out.println("amountValue class: " + amountValue.getClass().getName());

		
		subscribe.setMemberNo(loginMember.getMemberNo());
		subscribe.setPrice(Integer.valueOf((String) paramMap.get("amount")));
		subscribe.setUseMile(Integer.parseInt((String) paramMap.get("useMile")));
		
		int result = service.kg(subscribe);
		
		String res = null;
		
		if(result>0) {
			System.out.println("성공 !!");
			res = "success";
		} else {
			System.out.println("실패........");
			res = "fail";
		}
		
		return res;
	}
	
}
