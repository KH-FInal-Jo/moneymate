package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.KBoardDAO;
import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CPagination;

@Service
public class KBoardServiceImpl implements KBoardService{
	
	private KBoardDAO dao;

	@Override
	public Map<String, Object> selectboardInquiry(int boardCode, int cp) {
		
		int listCount = dao.getListCount(boardCode);
		
		CPagination pagination = new CPagination(cp, listCount);
		
		List<CBoard> boardList = dao.selectBoardList(pagination, boardCode);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

}
