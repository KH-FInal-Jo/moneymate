package edu.kh.project.account.model.service;

import edu.kh.project.account.model.dto.JAccountBook;

public interface JAccountBkService {

	int accountBkInsert(JAccountBook accountBk);

	int accountBkSelect(int bigAccountNo);

	int accountBkTarget(JAccountBook account);

	// 목표 금액 inserts
	int insertTarget(JAccountBook accountBk);

	// 목표금액, 날짜 가져오기
	JAccountBook selectAccountBk(int bigAccountNo);

}
