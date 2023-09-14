package edu.kh.project.account.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.account.model.dao.JAccountBkDAO;
import edu.kh.project.account.model.dto.JAccountBook;

@Service
public class JAccountBkServiceImpl implements JAccountBkService{
	
	@Autowired
	private JAccountBkDAO dao;

	@Override
	public int accountBkInsert(JAccountBook accountBk) {
		
		// 가계부 다음 번호 얻기
		int accountNo = dao.nextAccountNo();
		
		accountBk.setAccountNo(accountNo);
		
		int result = dao.insertAccount(accountBk);
		
		return result;
	}

	// 가계부 상세 조회
	@Override
	public int accountBkSelect(int bigAccountNo) {
		return dao.accountBkSelect(bigAccountNo);
	}

	// 목표금액 설정
	@Override
	public int accountBkTarget(JAccountBook account) {
		
		int targetMoney = 0;
		
		int result = dao.targetInsert(account);
		
		if(result > 0) {
			
			targetMoney = dao.selectTargetM(account.getMemberNo());
			
		}
		
		
		return targetMoney;
	}

	// 목표 금액 insert
	@Override
	public int insertTarget(JAccountBook accountBk) {
		
		
		return dao.insertTarget(accountBk);
	}

	// 목표금액, 시작,종료 날짜 가져오기
	@Override
	public JAccountBook selectAccountBk(int bigAccountNo) {
		return dao.selectAccountBk(bigAccountNo);
	}

}
