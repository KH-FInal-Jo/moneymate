package edu.kh.project.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.service.HBoardService;
import edu.kh.project.member.model.dto.Member;

@SessionAttributes("loginMember")
@Controller
public class HBoardController {
	
	@Autowired
	private HBoardService service;
	
	@GetMapping("/event")
	public String eventList() {
		return "event/eventList";
	}
	
	@GetMapping("/event/calendar")
	public String eventCalendar(@SessionAttribute("loginMember") Member loginMember) {
		
		int memberNo = loginMember.getMemberNo();
								
		// 참여 기록 가져오기
		List<String> calendarList = service.calendarList(memberNo);
		
		
		
		return null;
	}
	
	
	
	

}
