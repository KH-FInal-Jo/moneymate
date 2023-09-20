package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.SBoard;

public interface SBoardService {


	/** 칼럼 게시글 등록
	 * @param images 
	 * @param board 
	 * @param board
	 * @param images
	 * @param webPath
	 * @param filePath
	 * @return
	 */
	int boardInsert(Map<String, Object> paramMap, SBoard board, List<MultipartFile> images );

}
