package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.KBoard;

/**
 * @author user1
 *
 */
/**
 * @author user1
 *
 */
public interface KBoardService {

	Map<String, Object> selectboardInquiry(int boardCode, int cp);

	
	/** 게시글 작성
	 * @param board
	 * @return boardNo
	 */
	int boardInsert(KBoard board)
			throws IllegalStateException, IOException;


	

	/**게시글 상세 조회
	 * @param map
	 * @return
	 */
	KBoard selectboardInquiryDetail(Map<String, Object> map);


	/** 게시글 수정
	 * @param board
	 * @return
	 */
	int boardUpdate(KBoard board);

	
	
	/** 게시글 삭제
	 * @param boardNo
	 * @return
	 */
	int boardDelete(int boardNo);


	/** 댓글 조회
	 * @param boardNo
	 * @return
	 */
	List<CComment> select(int boardNo);


	/** 댓글 등록
	 * @param paramMap
	 * @return
	 */
	int insertComment(CComment comment);


	/** 댓글 수정
	 * @param comment
	 * @return
	 */
	int boardUpdate(CComment comment);


	/** 댓글 삭제
	 * @param commentNo
	 * @return
	 */
	int boardDeleteComment(int commentNo);
	
	


	

	

}
