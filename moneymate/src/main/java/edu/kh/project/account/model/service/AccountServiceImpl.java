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
	
	// 월 지출 금액 합계 10-12월
		@Override
		public int changeMonthUpdateBigger(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return dao.changeMonthUpdateBigger(map);
	}

	
	// 월 수입 변경하기
	@Override
	public int changeMonthIncome(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeMonthIncome(map);
	}

	// 지출 내역 업데이트
	@Override
	public List<SAccount> changeMonthUpdate(Map<String, Object> map) {
		
		
		return dao.changeMonthUpdate(map);
	}
	
	// 월 지출 내역 10-12월
	@Override
	public List<SAccount> changeMonthBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeMonthBigger(map);
	}

	
	// 수입 내역 업데이트
	@Override
	public List<SAccount> changeMonthUpdateIncome(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeMonthUpdateIncome(map);
	}
	
	// 월 수입 내역 10-12월
	@Override
	public List<SAccount> changeMonthUpdateIncomeBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeMonthUpdateIncomeBigger(map);
	}


	// 지출 그래프
	@Override
	public List<SAccount> changeChart(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeChart(map);
	}
	
	// 월 지출 그래프 10-12월
	@Override
	public List<SAccount> changeChartBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeChartBigger(map);
	}

	// 수입 그래프
	@Override
	public List<SAccount> changeChartIncome(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeChartIncome(map);
	}
	
	// 월 수입 그래프 10-12월
	@Override
	public List<SAccount> changeChartIncomeBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeChartIncomeBigger(map);
	}

	// 월 수입 합계금액 10-12월
	@Override
	public int changeMonthIncomeBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeMonthIncomeBigger(map);
	}

	// 카테고리명 조회 내역
	@Override
	public List<SAccount> categoryName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.categoryName(map);
	}

	// 카테고리명 조회 내역 수입
	@Override
	public List<SAccount> categoryNameIncome(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.categoryNameIncome(map);
	}

	// 카테고리 조회 내역 10-12월
	@Override
	public List<SAccount> categoryNameBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.categoryNameBigger(map);
	}

	// 카테고리 조회 내역 수입 10-12월
	@Override
	public List<SAccount> categoryNameIncomeBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.categoryNameIncomeBigger(map);
	}

	

	

	
	
	




}
