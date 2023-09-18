package edu.kh.project.account.model.dao;

import java.util.List;
import java.util.Map;

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

	/** 이메일 유효 검사
	 * @param memberEmail
	 * @return
	 */
	public int dupCheck(String memberEmail) {
		return sqlSession.selectOne("HAccountMapper.dupEmail", (memberEmail));
	}

	/** 가계부 생성(개인)
	 * @param loginMember
	 * @return result
	 */
	public int pAccount(Member loginMember) {
		return sqlSession.insert("HAccountMapper.pAccount", loginMember);
	}

	/** 가계부 (그룹) 테이블 insert
	 * @param map
	 * @return result
	 */
	public int insertGroup(HAccount account) {
		return sqlSession.insert("HAccountMapper.insertGroup", account);
	}

	/** 그룹테이블 insert
	 * @param account
	 * @return result
	 */
	public int group(HAccount account) {
		return sqlSession.insert("HAccountMapper.group", account);
	}

	/** 가계부 초대 수락
	 * @param key
	 * @return result
	 */
	public int inviteAccept(String key) {
		return sqlSession.update("HAccountMapper.inviteAccept", key);
	}
	
	

}
