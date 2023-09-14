package edu.kh.project.board.model.service;

import java.util.Map;

import edu.kh.project.board.model.dto.KBoard;

public interface KBoardService {

	Map<String, Object> selectboardInquiry(int boardCode, int cp);

	// 게시글 작성
	int boardInsert(KBoard board);

	

}
