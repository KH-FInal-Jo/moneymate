package edu.kh.project.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// 댓글 조회
	@GetMapping("/event/account")
	public String eventAccount(Model model ,@SessionAttribute(value="loginMember", required=false) Member loginMember) {
		
		List<CComment> commentList = null;
		
		if(loginMember != null) { // 회원용
			commentList = service.commentList(loginMember);
		} else { // 비회원용
			commentList = service.NcommentList();
		}
		
		
		model.addAttribute("commentList",commentList);
		
		return "event/eventAccount";
	}
	
	@PostMapping("/event/account/insert")
	@ResponseBody
	public int result(@RequestParam("commentContent") String commentContent, @RequestParam("commentImage") MultipartFile commentImage
					, @SessionAttribute(value="loginMember", required=false) Member loginMember
					, HttpSession session) throws IllegalStateException, IOException {
		
		// boardNo는 0 고정
		
		CComment comment = new CComment();
		
		comment.setCommentContent(commentContent);
		
		comment.setMemberNo(loginMember.getMemberNo());
		String webPath = "/resources/images/event/";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		int commentNo = service.commentInsert(comment, commentImage, webPath, filePath);
		
		return commentNo;
	}
	
	// 좋아요 상태 변화
	@PostMapping("/event/account/like")
	@ResponseBody
	public int eventLike(@RequestBody Map<String, Integer> paramMap) {
		return service.eventLike(paramMap);
	}
	
	// 댓글 조회(비동기)
	@GetMapping(value = "/event/account/comment", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<CComment> commentList(@SessionAttribute("loginMember") Member loginMember){
		return service.commentList(loginMember);
	}
	
	

}
