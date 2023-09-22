package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.SBoard;

public interface SBoardService {



	/** 칼럼 게시글 등록
	 * @param board
	 * @param images
	 * @param webPath
	 * @param filePath
	 * @param paramMap 
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int boardInsert(SBoard board, List<MultipartFile> images, String webPath, String filePath, Map<String, Object> paramMap) throws IllegalStateException, IOException;

}
