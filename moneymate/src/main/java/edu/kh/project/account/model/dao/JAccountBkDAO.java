package edu.kh.project.account.model.dao;

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
	public String accountBkSelect(int memberNo) {
		return sqlSession.selectOne("accountUse", memberNo);
	}


}
