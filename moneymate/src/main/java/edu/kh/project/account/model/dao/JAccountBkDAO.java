package edu.kh.project.account.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.account.model.dto.JAccountBook;

@Repository
public class JAccountBkDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int accountBkInsert(JAccountBook accountBk) {
		
		int result = sqlSession.insert("JBoardMapper.accountBkInsert", accountBk);
		
		if(result > 0) result = accountBk.getAccountNo();
		
		return result;
	}

	// 가계부 다음 번호 얻어오기
	public int nextAccountNo() {
		
		int accountNo = sqlSession.selectOne("nextAccountNo");
		
		return accountNo;
		
	}

	// 가계부 작성하기
	public int insertAccount(JAccountBook accountBk) {
		
		return sqlSession.insert("accountInertInout", accountBk);
	}

	// 가계부 상세 조회
	public int accountBkSelect(int bigAccountNo) {
		return sqlSession.selectOne("accountUse", bigAccountNo);
	}

	public String accountBkTarget(JAccountBook account) {
		return sqlSession.selectOne("accountBkTarget", account);
	}

	// 목표 금액 insert
	public int targetInsert(JAccountBook account) {
		return sqlSession.insert("targetInsert", account);
	}

	// 목표 금액 가져오기
	public int selectTargetM(int memberNo) {
		return sqlSession.selectOne("selectTargetM", memberNo);
	}

	// 목표 금액 insert2
	public int insertTarget(JAccountBook accountBk) {
		return sqlSession.update("targetInsert2", accountBk);
	}

	// 목표금액 , 시작, 종료 날짜 조회
	public JAccountBook selectAccountBk(int bigAccountNo) {
		return sqlSession.selectOne("selectAccountBk", bigAccountNo);
	}

	// 목표금액 전부다 가져ㅇ기
	/*
	 * public JAccountBook selectAccountTarget(JAccountBook account) { return
	 * sqlSession.selectOne("selectAccountBk", account); }
	 */

	public List<JAccountBook> selectAccountTarget() {
		
		return sqlSession.selectList("selectAccountBk2");
	}

	// 마일리지 입력하기
	public int insertMileage(int selmemberNo) {
		return sqlSession.update("insertMileage", selmemberNo);
	}

	// 알림함 insert
	public int insertAlert(int selmemberNo) {
		return sqlSession.insert("insertAlert", selmemberNo);
	}


}
