package edu.kh.project.account.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.account.model.dao.JAccountBkDAO;

@Service
public class JAccountBkServiceImpl implements JAccountBkService{
	
	@Autowired
	private JAccountBkDAO dao;

}
