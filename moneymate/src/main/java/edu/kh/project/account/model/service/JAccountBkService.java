package edu.kh.project.account.model.service;

import edu.kh.project.account.model.dto.JAccountBook;

public interface JAccountBkService {

	int accountBkInsert(JAccountBook accountBk);

	String accountBkSelect(int memberNo);

}
