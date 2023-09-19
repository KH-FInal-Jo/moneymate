package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.CReport;

public interface CBoardService {

	Map<String, Object> selectBoardList(int boardCode, int cp);

	Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp);

	CBoard selectBoard(Map<String, Object> map);

	int boardInsert(CBoard board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException;

	int boardLikeCheck(Map<String, Object> map);
	
	int like(Map<String, Integer> paramMap);

	int updateReadCount(int boardNo);

	int boardUpdate(CBoard board, List<MultipartFile> images, String webPath, String filePath, String deleteList) throws IllegalStateException, IOException;

	int boardDelete(int boardNo);

	// 댓글 조회
	List<CComment> selectComment(int boardNo);

	// 댓글 삽입
	int insertComment(CComment comment);

	// 댓글 삭제
	int deleteComment(int commentNo);

	// 댓글 수정
	int updateComment(CComment comment);

	int insertReport(CReport report);


	
}
