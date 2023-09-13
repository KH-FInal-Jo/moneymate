package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CPagination;

@Repository
public class CBoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getListCount(int boardCode) {
		return sqlSession.selectOne("CboardMapper.getListCount", boardCode);
	}

	public List<CBoard> selectBoardList(CPagination pagination, int boardCode) {
		
		int offset
		= (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("CboardMapper.selectBoardList", boardCode, rowBounds);
	}

	public CBoard selectBoard(Map<String, Object> map) {
		return sqlSession.selectOne("CboardMapper.selectBoard", map);
	}

	
	
	// 게시글 삽입
	public int boardInsert(CBoard board) {
		
		int result = sqlSession.insert("CboardMapper.boardInsert", board);
		
		return 0;
	}

}
