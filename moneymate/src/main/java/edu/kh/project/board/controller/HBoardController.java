package edu.kh.project.board.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	// 댓글 조회(가계부 이벤트 조회........)
	@GetMapping("/event/account")
	public String eventAccount(Model model 
			,@SessionAttribute(value="loginMember", required=false) Member loginMember
			, HttpServletRequest req , HttpServletResponse resp
			) throws ParseException {
		
		List<CComment> commentList = null;
		
		if(loginMember != null) { // 회원용
			commentList = service.commentList(loginMember);
		} else { // 비회원용
			commentList = service.NcommentList();
		}
		
		int readCount = service.eventReadCount();
		
		// 이벤트 게시글 조회수(쿠키..사용..)
		// 조회수 -> 비회원 올리기 O, 관리자(글쓴이) 올리기 O -> 조건 없이 누구나 접속하면 한 번씩 다 오르게!
		Cookie cook = null; // 쿠키 얻어오기
		
		Cookie[] cookies = req.getCookies(); // 요청에 있는 모든 쿠키 얻어오기
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				// eventReadCount라는 쿠키가 있다면 cook에 넣겠다.
				if(c.getName().equals("eventReadCount")) {
					cook = c;
					break;
				}
			}
		}
		
		int result = 0;
		
		// eventReadCount라는 쿠키가 없다면 만들고, 조회수 늘리겠다.
		if(cook == null) {
			cook = new Cookie("eventReadCount", "0"); // 이벤트 게시글은 하나라서 boardNo 0 고정
			result = service.updateEventRead(); // 조회수 증가
		} 
		
		// 조회수가 증가된 경우, 쿠키 수명 당일 자정 직전으로 설정
		if(result > 0) {
			readCount += 1; // 동기화
			cook.setPath("/");
			Calendar cal = Calendar.getInstance(); 
			cal.add(cal.DATE , 1);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Date a = new Date(); // 현재 시간
			
			Date temp = new Date(cal.getTimeInMillis()); // 24시간 후
			
			Date b = sdf.parse(sdf.format(temp)); // 내일 0시 0분 0초
			
			long diff = (b.getTime() - a.getTime()) / 1000;
			
			cook.setMaxAge((int)diff); 
			
			resp.addCookie(cook); 
			
		}
		
		
		// 댓글 목록, 조회수
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentList", commentList);
		map.put("readCount", readCount);
		model.addAttribute("map",map);
		
		return "event/eventAccount";
	}
	
	// 댓글 삽입
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
	
	// 댓글 수정
	@PostMapping("/event/account/update")
	@ResponseBody
	public int updateComment(@RequestParam("updateContent") String updateContent
							, @RequestParam("updateFile") MultipartFile updateImage
							, @RequestParam("commentNo") int commentNo
							, @SessionAttribute(value="loginMember", required=false) Member loginMember
							, HttpSession session) throws IllegalStateException, IOException {
		
		CComment comment = new CComment();
		
		
		comment.setCommentNo(commentNo);
		
		comment.setCommentContent(updateContent);
		
		comment.setMemberNo(loginMember.getMemberNo());
		String webPath = "/resources/images/event/";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		int result = service.commentUpdate(comment, updateImage, webPath, filePath);
		
		
		return result;
	}
	
	// 댓글 삭제
	@GetMapping("/event/account/delete")
	@ResponseBody
	public int deleteComment(int no) {
		return service.deleteComment(no);
	}
	
	
	
	

}
