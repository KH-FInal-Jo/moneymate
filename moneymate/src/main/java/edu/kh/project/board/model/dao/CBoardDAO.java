package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CBoardImage;
import edu.kh.project.board.model.dto.CComment;
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

	// 조회수 처리
	public int updateReadCount(int boardNo) {
		return sqlSession.update("CboardMapper.updateReadCount", boardNo);
	}

	// 게시글 수정
	public int boardUpdate(CBoard board) {
		return sqlSession.update("CboardMapper.boardUpdate", board);
	}

	// 이미지 삭제
	public int imageDelete(Map<String, Object> deleteMap) {
		return sqlSession.delete("CboardMapper.imageDelete", deleteMap);
	}

	// 이미지 수정
	public int imageUpdate(CBoardImage img) {
		return sqlSession.update("CboardMapper.imageUpdate", img);
	}

	// 이미지 삽입
	public int imageInsert(CBoardImage img) {
		return sqlSession.insert("CboardMapper.imageInsert", img);
	}

	// 게시글 삭제
	public int boardDelete(int boardNo) {
		return sqlSession.update("CboardMapper.boardDelete", boardNo);
	}
	
	// 검색시 게시글 수 조회
	public int getListCount(Map<String, Object> paramMap) {
		return sqlSession.selectOne("CboardMapper.getListCount_search", paramMap);
	}

	// 검색 시 게시글 목록 조회
	public List<CBoard> selectBoardList(CPagination pagination, Map<String, Object> paramMap) {
				// 1) offset 계산
				int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

				// 2) Rowbounds 객체 생성
				RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

				// 3) selectList("namespace.id", 파라미터, Rowbounds) 호출
				return sqlSession.selectList("CboardMapper.selectBoardList_search", paramMap, rowBounds);
	}

	// 댓글 목록 조회
	public List<CComment> selectComment(int boardNo) {
		return sqlSession.selectList("CboardMapper.selectCommentList", boardNo);
	}
	
	
	// 댓글 작성
	public int insertComment(CComment comment) {
		return sqlSession.insert("CboardMapper.insertComment", comment);
	}

	
	// 댓글 삭제
	public int deleteComment(int commentNo) {
		return sqlSession.delete("CboardMapper.deleteComment", commentNo);
	}

	public int updateComment(CComment comment) {
		return sqlSession.update("CboardMapper.updateComment", comment);
	}


}
