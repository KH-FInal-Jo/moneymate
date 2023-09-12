package edu.kh.project.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.HMemberService;

@SessionAttributes("loginMember")
@Controller
public class HMemberController {
	
	@Autowired
	private HMemberService service;
	
	@GetMapping("/member/mypage/likeList/{boardCode}/{memberNo}")
	public String selectLike(@PathVariable("boardCode") int boardCode,
							@PathVariable("memberNo") int memberNo
							, @RequestParam(value="cp", required = false, defaultValue = "1") int cp
							, Model model) {
		
		System.out.println(boardCode);
		System.out.println(memberNo);
		System.out.println(cp);
		
		// 좋아요 목록 조회
		// 게시판 이름, 게시글 제목, 썸네일, 작성자, 작성일, 조회수 (좋아요한 게시글만)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardCode", boardCode);
		map.put("memberNo", memberNo);
		map.put("cp", cp);
		
		Map<String, Object> resMap = service.selectLike(map);
		
		System.out.println(resMap);
		
		model.addAttribute("resMap", resMap);
		
		return "member/likeList";
	}
	
	@GetMapping(value="/member/mypage/likeList/cancelLike" , produces = "application/text; charset=UTF-8")
	@ResponseBody
	public int cancelLike (int boardNo, @SessionAttribute("loginMember") Member loginMember) {
		
		CBoard board = new CBoard();
		
		board.setMemberNo(loginMember.getMemberNo());
		board.setBoardNo(boardNo);
		
		int result = service.cancelLike(board);
		
		System.out.println("result" + result);
		
		return result;
	}

}
