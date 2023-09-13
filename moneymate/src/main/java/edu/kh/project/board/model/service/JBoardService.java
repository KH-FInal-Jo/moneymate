package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.JBoard;

public interface JBoardService {

	// 공지사항 목록 조회
	List<JBoard> selectBoardNotice(int boardCode);

	// 공지사항 상세조회
	List<JBoard> boardNoticeDetail(Map<String, Object> map);

	// 공지사항 작성
	int boardNoticeInsert(JBoard board);

	JBoard selectBoardUpdate(int boardNo);

	// 수정하기
	int boardNoticeUpdate(JBoard board);

	int boardDelete(int boardNo);


}
