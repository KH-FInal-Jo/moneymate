package edu.kh.project.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.model.dao.HAdminDAO;

@Service
public class HAdminServiceImpl implements HAdminService {
	
	@Autowired
	private HAdminDAO dao;

}
