package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.CBoardDAO;
import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CPagination;

@Service
public class CBoardServiceImpl implements CBoardService {
	
	@Autowired
	private CBoardDAO dao;

	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {
		
		
		int listCount = dao.getListCount(boardCode);
		
		CPagination pagination = new CPagination(cp, listCount);
		
		List<CBoard> boardList = dao.selectBoardList(pagination, boardCode);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

	// 검색시 게시글 목록 조회
	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp) {
		// TODO Auto-generated method stub
		return null;
	}

	// 게시글 상세 조회
	@Override
	public CBoard selectBoard(Map<String, Object> map) {
		return dao.selectBoard(map);
	}

}
