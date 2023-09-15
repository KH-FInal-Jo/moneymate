package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dao.KBoardDAO;
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



	@Override
	public KBoard selectBoard(Map<String, Object> map) {
		return null;
	}







}
