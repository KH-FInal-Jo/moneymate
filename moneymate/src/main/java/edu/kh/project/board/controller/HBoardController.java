package edu.kh.project.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import edu.kh.project.board.model.dto.CComment;
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
	public String eventCalendar(@SessionAttribute("loginMember") Member loginMember
								, Model model) {
		
		int memberNo = loginMember.getMemberNo();
								
		// 참여 기록 가져오기
		List<String> calendarList = service.calendarList(memberNo);
		
		if(calendarList != null) {
			
			Gson gson = new Gson(); // gson으로 자바스크립트에서 쓸 수 있게  !!!!!
			
			String calendarListJson = gson.toJson(calendarList);
			
			System.out.println(calendarListJson);
			
			model.addAttribute("calendarListJson",calendarListJson);
		}
		
		return "event/eventCalendar";
	}
	
	@GetMapping("/event/calendar/today")
	@ResponseBody
	public int calendarToday(@SessionAttribute("loginMember") Member loginMember) {
		
		int memberNo = loginMember.getMemberNo();
		
		int result = service.calendarToday(memberNo);
		
		return result;
	}
	
	@GetMapping("/event/account")
	public String eventAccount(Model model) {
		
		List<CComment> commentList = service.commentList();
		
		System.out.println(commentList);
		
		model.addAttribute("commentList",commentList);
		
		return "event/eventAccount";
	}
	
	@PostMapping("/event/account/insert")
	@ResponseBody
	public int result(String commentContent, @RequestParam("commentImage") MultipartFile commentImage
					, @SessionAttribute("loginMember") Member loginMember
					, HttpSession session) {
		
		// boardNo는 0 고정
		
		
		return 0;
	}
	
	
	

}
