package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dao.KBoardDAO;
import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.CPagination;
import edu.kh.project.board.model.dto.KBoard;
import edu.kh.project.board.model.exception.FileUploadException;
import edu.kh.project.common.utility.Util;

@Service
public class KBoardServiceImpl implements KBoardService{


	@Autowired
	private KBoardDAO dao;



	@Override
	public Map<String, Object> selectboardInquiry(int boardCode, int cp) {

		int listCount = dao.getListCount(boardCode);

		CPagination pagination = new CPagination(cp, listCount);

		List<KBoard> boardList = dao.selectboardInquiry(pagination, boardCode);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("pagination", pagination);
		map.put("boardList", boardList);

		return map;
	}



	// 게시글 작성
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int boardInsert(KBoard board){

		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));

		int boardNo = dao.boardInsert(board);

		return boardNo;
	}


	// 게시글 상세조회
	@Override
	public KBoard selectboardInquiryDetail(Map<String, Object> map) {

		return dao.selectboardInquiryDetail(map);
	}


	// 게시글 수정
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int boardUpdate(KBoard board) {

		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));

		int rowCount = dao.boardUpdate(board);

		return rowCount;
	}



	/**게시글 삭제
	 *
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int boardDelete(int boardNo) {


		return dao.boardDelete(boardNo);
	}



	/**
	 * 댓글 조회
	 */
	@Override
	public List<CComment> select(int boardNo) {
		return dao.select(boardNo);
	}



	/**
	 *댓글 삽입
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertComment(CComment comment) {
		//		CComment comment= new CComment();
		//		comment.setMemberNo((int)paramMap.get("memberNo"));
		//		comment.setcommentContent((String.valueOf(paramMap.get("commentContent"))));

		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));

		return dao.insertComment(comment);
	}



	/**
	 *댓글 수정
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int boardUpdate(CComment comment) {

		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));
		return dao.update(comment);
	}



	/**
	 *댓글 삭제
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int boardDeleteComment(int commentNo) {

		return dao.boardDeleteComment(commentNo);
	}



	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateReadCount(int boardNo) {


		return dao.updateReadCount(boardNo);
	}



	/**
	 *게시글 검색
	 */
	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp) {
		// 1. 특정 게시판의 삭제되지 않은 검색 조건이 일치하는 게시글 수 조회
		int listCount = dao.getListCount(paramMap);
			System.out.println("숫자다"+listCount);
		// 2. 1번의 조회 결과 + cp를 이용해서 Pagination 객체 생성
		// -> 내부 필드가 모두 계산되어 초기화 됨
		CPagination pagination = new CPagination(cp, listCount);

		// 3. 특정 게시판에서
		// 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회

		List<KBoard>boardList = dao.selectBoardList(pagination, paramMap);


		// 4. pagination, boardList를 Map에 담아서 반환
		Map<String, Object> map = new HashMap<>();

		// 조회 결과를 request scope에 세팅 후 forward

		map.put("pagination", pagination);
		map.put("boardList", boardList);

		return map;
	}










}
