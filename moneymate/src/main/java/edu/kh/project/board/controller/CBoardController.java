package edu.kh.project.board.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.service.CBoardService;
import edu.kh.project.member.model.dto.Member;

@Controller
@SessionAttributes("loginMember")
@RequestMapping("/community")
public class CBoardController {
	
	@Autowired
	private CBoardService service;
	
	// 게시글 목록 조회
	@GetMapping("/3")
	public String selectCBoardList(@RequestParam(value="cp", required=false, defaultValue = "1") int cp
			, Model model, @RequestParam Map<String, Object> paramMap) {
		
		
		int boardCode = 3;
		
		
		if(paramMap.get("key") == null) {
			Map<String, Object> map = service.selectBoardList(boardCode, cp);
			
			model.addAttribute("map", map);
			
			
		} else { // 검색 O
			
			paramMap.put("boardCode", 3);
			
			Map<String, Object> map = service.selectBoardList(paramMap, cp);
			
			model.addAttribute("map", map);
		}
		
		return "board/CBoardList";
	}
	
	
	// 게시글 상세조회
	@GetMapping("/3/{boardNo}")
	public String boardDetail(@PathVariable("boardNo") int boardNo, Model model,  RedirectAttributes ra, @SessionAttribute(value="loginMember", required=false) Member loginMember
								, HttpServletRequest req, HttpServletResponse resp) throws ParseException {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardCode", 3);
		map.put("boardNo", boardNo);
		
		CBoard board = service.selectBoard(map);
		
		String path = null;
		
		if(board != null) {
			if(loginMember != null) {
				map.put("memberNo", loginMember.getMemberNo());
				
				/* int result = service.boardLikeCheck(map); */
			}
		}
		model.addAttribute("board",board);
		
		return "board/CboardDetail";
	}
	
	
	
	
	
	

}
