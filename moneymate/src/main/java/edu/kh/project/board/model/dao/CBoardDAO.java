package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CBoardImage;
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
		
		if(result>0) result = board.getBoardNo();
		
		return result;
	}

	
	// 이미지 삽입
	public int insertImageList(List<CBoardImage> uploadList) {
		return sqlSession.insert("CboardMapper.insertImageList", uploadList);
	}

	// 좋아요 여부
	public int boardLikeCheck(Map<String, Object> map) {
		return sqlSession.selectOne("CboardMapper.boardLikeCheck", map);
	}
	
	
	// 좋아요 추가
	public int insertBoardLike(Map<String, Integer> paramMap) {
		return sqlSession.insert("CboardMapper.insertBoardLike", paramMap);
	}

	// 좋아요 삭제
	public int deleteBoardLike(Map<String, Integer> paramMap) {
		return sqlSession.delete("CboardMapper.deleteBoardLike", paramMap);
	}
	

	// 좋아요 갯수 조회
	public int CountBoardLike(Integer boardNo) {
		return sqlSession.selectOne("CboardMapper.CountBoardLike", boardNo);
	}


}
