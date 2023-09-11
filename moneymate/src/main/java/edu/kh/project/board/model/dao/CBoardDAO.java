package edu.kh.project.board.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CBoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getListCount(int boardCode) {
		return sqlSession.selectOne("CboardMapper.getListCount", boardCode);
	}

}
