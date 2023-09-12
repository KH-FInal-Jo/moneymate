package edu.kh.project.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.service.CBoardService;

@Controller
@SessionAttributes("loginMember")
@RequestMapping("/community")
public class CBoardController {
	
	@Autowired
	private CBoardService service;
	
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
	
	
	
	

}
