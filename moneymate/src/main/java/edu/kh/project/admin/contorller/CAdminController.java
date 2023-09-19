package edu.kh.project.admin.contorller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.admin.model.service.CAdminService;

@Controller
public class CAdminController {

	@Autowired
	private CAdminService service;
	
	@GetMapping("/admin/payment")
	public String paymentManage () {
		
		return "admin/payManagement";
	}
	
	
	@GetMapping("/admin/reportManage/board")
	public String reportManage(@RequestParam(value="cp", required=false, defaultValue = "1") int cp
			, Model model) {
		
		Map<String, Object> map = service.selectReportList(cp);
		
		model.addAttribute("map", map);
		
		System.out.println(map);
		
		
		return "admin/reportManage";
	}
}
