package edu.kh.project.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.member.model.service.HMemberService;

@Controller
public class HMemberController {
	
	@Autowired
	private HMemberService service;
	
	@GetMapping("/member/mypage/likeList/{boardCode}/{memberNo}")
	public String selectLike(@PathVariable("boardCode") int boardCode,
							@PathVariable("memberNo") int memberNo
							, @RequestParam(value="cp", required = false, defaultValue = "1") int cp
							, Model model) {
		
		// 좋아요 목록 조회
		// 게시판 이름, 게시글 제목, 썸네일, 작성자, 작성일, 조회수 (좋아요한 게시글만)
		
		
		
		
		return null;
	}

}
