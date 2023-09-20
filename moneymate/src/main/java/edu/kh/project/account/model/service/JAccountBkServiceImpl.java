package edu.kh.project.account.model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

	// 목표금액 달성 여부 조회
	/*
	@Override
	public int selectAccountTarget(JAccountBook accountBk) {
		
		
		JAccountBook account = dao.selectAccountTarget(accountBk);
		
		String endDateString = account.getEndDate(); // "2023-09-15"

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate endDate = LocalDate.parse(endDateString, dateFormatter);
		
		LocalDate currentDate = LocalDate.now();
		
		
		// 목표 금액, 시작, 종료 날짜 가져오기
		if (endDate.isEqual(currentDate)) {
			
			
			
			
		}  else {
		    // endDate가 현재 날짜보다 이후인 경우
		    // 여기서 원하는 작업을 수행하세요.
			
		}
		
		
		
		
		return 0;
	}
	*/

	@Override
	public List<JAccountBook> selectAccountBk2() {
		
		List<JAccountBook> account = dao.selectAccountTarget();
		
		
		
		//String endDateString = account.getEndDate(); // "2023-09-15"

		//DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		//LocalDate endDate = LocalDate.parse(endDateString, dateFormatter);
		
		//LocalDate currentDate = LocalDate.now();
		
		
		//System.out.println("endDate" +endDate);
		// 목표 금액, 시작, 종료 날짜 가져오기
		//if (endDate.isEqual(currentDate)) {
			
			
			
			
		//}  else {
		    // endDate가 현재 날짜보다 이후인 경우
		    // 여기서 원하는 작업을 수행하세요.
			
			//System.out.println("endDate" +endDate);
		//}
		
		
		return dao.selectAccountTarget();
	}

	// 마일리지 입력하기
	@Override
	public int insertMileage(int selmemberNo) {
		return dao.insertMileage(selmemberNo);
	}

	// 알림함 insert
	@Override
	public int insertAlert(int selmemberNo) {
		return dao.insertAlert(selmemberNo);
	}

	// 구독 광고 
	@Override
	public String selectSub(int memberNo) {
		return dao.selectSub(memberNo);
	}

}
