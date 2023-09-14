package edu.kh.project.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.service.KBoardService;

@SessionAttributes({"loginMember"})
@RequestMapping("/community")
@Controller
public class KBoardController {

	@Autowired
	private KBoardService service;

	@GetMapping("/{boardCode:[2]}")
	public String selectboardInquiry(@PathVariable("boardCode")int boardCode, @RequestParam(value="cp", required = false, defaultValue = "1")int cp
			, Model model
			, @RequestParam Map<String, Object> paramMap // 전달받은 파라미터가 전부다 담겨있다.
			) {
		

		
		
		if(paramMap.get("key") ==null) {
			Map<String, Object> map = service.selectboardInquiry(boardCode, cp);
			model.addAttribute("map", map);
			
			System.out.println(map);
		}


		return "board/boardInquiry";
	}

	@GetMapping("/2/boardInquiryWrtie")
	public String selectboardInquiryWrtie() {

		return "board/boardInquiryWrtie";
	}


}
