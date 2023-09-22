package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.CPagination;
import edu.kh.project.board.model.dto.KBoard;

@Repository
public class KBoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getListCount(int boardCode) {
		return sqlSession.selectOne("KboardMapper.getListCount", boardCode);
	}

	public List<KBoard> selectboardInquiry(CPagination pagination, int boardCode) {
		
		int offset
	      = (pagination.getCurrentPage() - 1) * pagination.getLimit();
	      
	      RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
	      
	      return sqlSession.selectList("KboardMapper.selectboardInquiry", boardCode, rowBounds);
		
		
	}
	
	
	/** 게시글 삽입
	 * @param board
	 * @return boardNo
	 */
	public int boardInsert(KBoard board) {
		int result = sqlSession.insert("KboardMapper.boardInsert", board);
		
		if(result>0) {
			result = board.getBoardNo();
		}
		
		return result;
	}

	/**게시글 상세조회
	 * @param map
	 * @return
	 */
	public KBoard selectboardInquiryDetail(Map<String, Object> map) {
		return sqlSession.selectOne("KboardMapper.boardInquiryDetail", map);
	}

	public int boardUpdate(KBoard board) {
		
		return sqlSession.update("KboardMapper.boardUpdate", board);
	}

	public int boardDelete(int boardNo) {
		return sqlSession.update("KboardMapper.boardDelete", boardNo);
	}

	public List<CComment> select(int boardNo) {
		return sqlSession.selectList("KboardMapper.boardComment", boardNo);
	}

	public int insertComment(CComment comment) {
	
		return sqlSession.insert("KboardMapper.boardinsertComment", comment);
	}

	/**댓글 수정
	 * @param comment
	 * @return result
	 */
	public int update(CComment comment) {
	
		return sqlSession.update("KboardMapper.boardupdateComment", comment);
	}

	/** 댓글 삭제
	 * @param commentNo
	 * @return
	 */
	public int boardDeleteComment(int commentNo) {
		
		return sqlSession.delete("KboardMapper.boardDeleteComment", commentNo);
	}

	public int updateReadCount(int boardNo) {
		return sqlSession.update("KboardMapper.updateReadCount", boardNo);
	}

	/** 검색 게시글 수
	 * @param paramMap
	 * @return listCount
	 */
	public int getListCount(Map<String, Object> paramMap) {
		
		return sqlSession.selectOne("KboardMapper.searchCount", paramMap);
	}

	/** 검색 게시글 목록
	 * @param pagination
	 * @param paramMap
	 * @return
	 */
	public List<KBoard> selectBoardList(CPagination pagination, Map<String, Object> paramMap) {
		
		
		int offset = (pagination.getCurrentPage() - 1)*pagination.getLimit(); // off셋 계산
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("KboardMapper.selectSearchBoardList", paramMap, rowBounds);
	}



	

}
