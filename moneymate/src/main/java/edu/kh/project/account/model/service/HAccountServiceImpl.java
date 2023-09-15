package edu.kh.project.account.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.account.model.dao.HAccountDAO;

@Service
public class HAccountServiceImpl implements HAccountService{
	
	@Autowired
	private HAccountDAO dao;

}
