package edu.kh.project.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.service.CBoardService;
import edu.kh.project.main.model.websocket.dto.Alert;
import edu.kh.project.main.model.websocket.service.AlertService;
import edu.kh.project.member.model.dto.Member;
@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/alert")
public class SAlertController {
	
	@Autowired
	private AlertService service;

	// 알람 갯수 조회
	@GetMapping("/alertNumber")
	@ResponseBody
	public List<Alert> alertNumber(@SessionAttribute("loginMember") Member loginMember) {
		
//		System.out.println("알람 요청 받음");
		
		int memberNo = loginMember.getMemberNo();
		
		List<Alert> alertList = service.alertNumber(memberNo);
		
		return alertList;
	}
	
	
	
}
