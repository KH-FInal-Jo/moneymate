package edu.kh.project.account.model.service;

import java.util.List;

import edu.kh.project.account.model.dto.JAccountBook;

public interface JAccountBkService {

	int accountBkInsert(JAccountBook accountBk);

	int accountBkSelect(int bigAccountNo);

	int accountBkTarget(JAccountBook account);

	// 목표 금액 inserts
	int insertTarget(JAccountBook accountBk);

	// 목표금액, 날짜 가져오기
	JAccountBook selectAccountBk(int bigAccountNo);

	// 목표 금액, 날짜 비교하기
	//int selectAccountTarget(JAccountBook accountBk);

	List<JAccountBook> selectAccountBk2();

	// 마일리지 입력하기
	int insertMileage(int selmemberNo);

	// 알림함 insert
	int insertAlert(int selmemberNo);

	// 구독 광고 ㅋ
	String selectSub(int memberNo);

}
