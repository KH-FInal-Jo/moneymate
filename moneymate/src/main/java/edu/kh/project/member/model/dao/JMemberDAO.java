package edu.kh.project.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.JMember;

@Repository
public class JMemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<JMember> selectMypage2(int memberNo) {
		return sqlSession.selectList("JMemberMapper.selectMypage", memberNo);
	}

}
