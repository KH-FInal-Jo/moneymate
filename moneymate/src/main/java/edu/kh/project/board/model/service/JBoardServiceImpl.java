package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.JBoardDAO;
import edu.kh.project.board.model.dto.JBoard;
import edu.kh.project.common.utility.Util;

@Service
public class JBoardServiceImpl implements JBoardService{
	
	@Autowired
	private JBoardDAO dao;

	// 공지사항 목록 조회
	@Override
	public List<JBoard> selectBoardNotice(int boardCode) {
		return dao.selectBoardNotice(boardCode);
	}

	// 공지사항 상세조회
	@Override
	public List<JBoard> boardNoticeDetail(Map<String, Object> map) {
		return dao.boardNoticeDetail(map);
	}

	// 공지사항 작성
	@Override
	public int boardNoticeInsert(JBoard board) {
		
		board.setBoardContent(Util.XSSHandling( board.getBoardContent() ));
		board.setBoardTitle(Util.XSSHandling( board.getBoardTitle() ));
		
		int boardNo = dao.nextBoardNo();
		
		board.setBoardNo(boardNo);
		
		int result = dao.insertBoardNotice(board);
		
		return result;
	}


}
