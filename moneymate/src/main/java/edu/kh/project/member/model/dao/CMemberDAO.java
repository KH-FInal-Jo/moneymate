package edu.kh.project.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository
public class CMemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	// 로그인
	public Member login(Member inputMember) {
		
		return sqlSession.selectOne("CmemberMapper.login", inputMember);
	}


	// 회원가입
	public int signUp(Member inputMember) {
		return sqlSession.insert("CmemberMapper.signUp", inputMember);
	}

	// 회원 비밀번호 조회
	public String selectEncPw(int memberNo) {
		return sqlSession.selectOne("CmemberMapper.selectEncPw", memberNo);
	}

	// 회원탈퇴
	public int secession(int memberNo) {
		return sqlSession.update("CmemberMapper.secession", memberNo);
	}


	public int emailDupCheck(String email) {
		return sqlSession.selectOne("CmemberMapper.emailDupCheck", email);
	}


	public int updateAuthKey(Map<String, String> map) {
		return sqlSession.update("CmemberMapper.updateAuthKey", map);
	}


	public int insertAuthKey(Map<String, String> map) {
		return sqlSession.update("CmemberMapper.insertAuthKey", map);
	}

}
