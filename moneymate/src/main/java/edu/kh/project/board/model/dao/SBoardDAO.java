package edu.kh.project.board.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.SBoard;

@Repository
public class SBoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/** 칼럼 게시글 등록
	 * @param board
	 * @return
	 */
	public int boardInsert(SBoard board) {
		return sqlSession.insert("SBoardMapper.columnInsert", board);
		
	}

}
