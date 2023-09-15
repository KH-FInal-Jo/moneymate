package edu.kh.project.admin.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CAdminController {

	
	@GetMapping("/admin/payment")
	public String paymentManage () {
		
		return "admin/payManagement";
	}
}
