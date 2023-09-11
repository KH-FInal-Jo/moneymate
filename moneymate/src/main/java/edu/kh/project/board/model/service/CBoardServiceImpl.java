package edu.kh.project.board.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.CBoardDAO;

@Service
public class CBoardServiceImpl implements CBoardService {
	
	@Autowired
	private CBoardDAO dao;

	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {
		
		int listCount = dao.getListCount(boardCode);
		
		
		return null;
	}

}
