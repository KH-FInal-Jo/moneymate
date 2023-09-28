package edu.kh.project.admin.contorller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.project.admin.model.service.CAdminService;

@Controller
public class CAdminController {

	@Autowired
	private CAdminService service;
	
	@GetMapping("/admin/payment")
	public String paymentManage (@RequestParam(value="cp", required=false, defaultValue = "1") int cp, Model model) {
		
		Map<String, Object> map = service.selectPayList(cp);
		
		
		model.addAttribute("map", map);
		
		
		return "admin/payManagement";
	}
	
	
	@GetMapping("/admin/reportManage/board")
	public String reportManage(@RequestParam(value="cp", required=false, defaultValue = "1") int cp
			, Model model) {
		
		Map<String, Object> map = service.selectReportList(cp);
		
		model.addAttribute("map", map);
		
		
		return "admin/reportManage";
	}
	
	
	
	@PostMapping("/admin/reportManage/confirm")
	@ResponseBody
	public int reportConfirm(@RequestBody Map<String, Object> paramMap) {
		
		
		int result = service.reportConfirm(paramMap);
		
		return result;
	}
	
	@PostMapping(value="/admin/reportManage/dupCheck", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int reportDupCheck(@RequestBody Map<String, Object> paramMap) {
		
		System.out.println("1111111111"+paramMap);
		return service.reportDupCheck(paramMap);
	}
	
}
