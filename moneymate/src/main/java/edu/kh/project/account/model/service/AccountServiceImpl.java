package edu.kh.project.account.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.account.model.dao.AccountDAO;
import edu.kh.project.account.model.dto.SAccount;

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

	// 지출 내역 업데이트
	@Override
	public List<SAccount> changeMonthUpdate(Map<String, Object> map) {
		
		
		return dao.changeMonthUpdate(map);
	}

	// 지출 그래프
	@Override
	public List<SAccount> changeChart(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeChart(map);
	}



}
