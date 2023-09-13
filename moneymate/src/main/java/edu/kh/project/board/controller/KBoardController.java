package edu.kh.project.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.board.model.service.KBoardService;

@RequestMapping("/community")
@Controller
public class KBoardController {

	@Autowired
	private KBoardService service;

	@GetMapping("/2")
	public String selectboardInquiry(@RequestParam(value="cp", required=false, defaultValue = "1") int cp
											, Model model, @RequestParam Map<String, Object> paramMap) {
		
		int boardCode = 2;
		
		
		if(paramMap.get("key") == null) {
			Map<String, Object> map = service.selectboardInquiry(boardCode, cp);
			
			model.addAttribute("map", map);
			
			
		} else { // 검색 O
			
			paramMap.put("boardCode", 2);
			
			Map<String, Object> map = service.selectboardInquiry(paramMap, cp);
			
			model.addAttribute("map", map);
		}
			

		return "board/boardInquiry";
	}


}
