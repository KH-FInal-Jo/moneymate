package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.SBoard;

public interface SBoardService {

	/** 칼럼 게시글 등록
	 * @param board
	 * @param images
	 * @param webPath
	 * @param filePath
	 * @return
	 */
	int boardInsert(SBoard board, List<MultipartFile> images, String webPath, String filePath);

}
