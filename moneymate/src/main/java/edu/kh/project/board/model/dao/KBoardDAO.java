package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CPagination;
import edu.kh.project.board.model.dto.KBoard;

@Repository
public class KBoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Map<String, Object> getListCount(int boardCode) {
		return sqlSession.selectOne("KboardMapper.getListCount", boardCode);
	}

	public List<KBoard> selectBoardList(CPagination pagination, int boardCode) {
		return null;
	}


	

}
