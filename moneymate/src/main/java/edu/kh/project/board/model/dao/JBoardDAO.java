package edu.kh.project.board.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JBoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;


}
