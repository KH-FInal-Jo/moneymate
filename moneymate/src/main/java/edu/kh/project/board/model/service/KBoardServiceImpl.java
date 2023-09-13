package edu.kh.project.board.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.KBoardDAO;

@Service
public class KBoardServiceImpl implements KBoardService{
	
	private KBoardDAO dao;

	@Override
	public Map<String, Object> selectboardInquiry(int boardCode, int cp) {
		
		Map<String, Object> listCount = (Map<String, Object>) dao.getListCount(boardCode);
		
		return listCount;
	}

	@Override
	public Map<String, Object> selectboardInquiry(Map<String, Object> paramMap, int cp) {
		
		
		return null;
	}

}
