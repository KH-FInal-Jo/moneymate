package edu.kh.project.admin.contorller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.project.admin.model.service.HAdminService;
import edu.kh.project.member.model.dto.JMember;

@Controller
public class HAdminController {
	
	@Autowired
	private HAdminService service;
	
	// 회원 목록 조회 -> 페이지네이션 고쳐라ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
	@GetMapping("/admin/member")
	public String adminMember(Model model, @RequestParam Map<String, Object> paramMap,
							@RequestParam(value="cp", required=false, defaultValue = "1") int cp) {
		
		
		if(paramMap.get("search") == null) { // 검색 없이 그냥 조회
			Map<String, Object> map = service.memberList(cp);
			model.addAttribute("map", map);
		} else { // 검색어 있을 때
			Map<String, Object> map = service.memberList(cp, paramMap);
			model.addAttribute("map", map);
		}
		
		return "admin/adminMember";
	}
	
	// 마일리지 업뎃
	@PostMapping("/admin/member/mile")
	@ResponseBody
	public int mile(@RequestBody Map<String, Object> paramMap) {
		
		int result = service.mile(paramMap);
		
		return result;
	}
	
	// 회원 탈퇴
	@GetMapping("/admin/member/secession")
	@ResponseBody
	public int secession(int no) {
		return service.secession(no);
	}
	
	// 자동완성
	@GetMapping("/admin/member/selectMember")
	@ResponseBody
	public List<JMember> selectMember(String query){
		return service.selectMember(query);
	}
	
	// 채팅 관리자 
	@GetMapping("/admin/reportManage/chatt")
	public String chattReport(Model model, @RequestParam(value="cp", required=false, defaultValue = "1") int cp) {
		
		Map<String, Object> map = service.chattReport(cp);
		
		model.addAttribute(map);
		
		System.out.println("is it correct? " + map);
		
		return "admin/chattingReport";
	}
	
}
