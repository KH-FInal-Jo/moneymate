package edu.kh.project.board.model.service;

import java.util.Map;

public interface CBoardService {

	Map<String, Object> selectBoardList(int boardCode, int cp);

	Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp);

	
}
