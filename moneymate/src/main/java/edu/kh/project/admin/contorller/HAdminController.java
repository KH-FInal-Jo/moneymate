package edu.kh.project.admin.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.kh.project.admin.model.service.HAdminService;

@Controller
public class HAdminController {
	
	@Autowired
	private HAdminService service;
	
	@GetMapping("/admin/member")
	public String adminMember() {
		return "admin/adminMember";
	}

}
