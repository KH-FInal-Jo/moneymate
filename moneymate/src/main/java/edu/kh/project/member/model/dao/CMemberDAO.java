package edu.kh.project.member.model.dao;

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

}
