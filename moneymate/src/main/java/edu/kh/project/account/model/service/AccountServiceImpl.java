package edu.kh.project.account.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.account.model.dao.AccountDAO;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDAO dao;

	// 월 변경하기
	@Override
	public int changeMonth(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeMonth(map);
	}



}
