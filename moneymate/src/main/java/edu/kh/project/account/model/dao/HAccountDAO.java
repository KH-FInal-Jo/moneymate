package edu.kh.project.account.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.account.model.dto.HAccount;
import edu.kh.project.member.model.dto.Member;

@Repository
public class HAccountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 개인 가계부 조회
	 * @param loginMember
	 * @return pList
	 */
	public List<HAccount> pList(Member loginMember) {
		return sqlSession.selectList("HAccountMapper.pList", loginMember);
	}

	/** 그룹 가계부 조회
	 * @param loginMember
	 * @return gList
	 */
	public List<HAccount> gList(Member loginMember) {
		return sqlSession.selectList("HAccountMapper.gList", loginMember);
	}

}
