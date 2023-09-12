package edu.kh.project.board.model.service;

import java.util.Map;

import edu.kh.project.board.model.dto.CBoard;

public interface CBoardService {

	Map<String, Object> selectBoardList(int boardCode, int cp);

	Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp);

	CBoard selectBoard(Map<String, Object> map);

	
}
