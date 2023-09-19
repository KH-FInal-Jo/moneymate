package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.SBoardDAO;
import edu.kh.project.board.model.dto.SBoard;
import edu.kh.project.common.utility.Util;

@Service
public class SBoardServiceImpl implements SBoardService {
	
	@Autowired
	private SBoardDAO dao;

	// 칼럼 게시글 등록
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int boardInsert(SBoard board, List<MultipartFile> images, String webPath, String filePath) {
		
		// 0. XSS 방지 처리
		board.setBoardContent(Util.XSSHandling( board.getBoardContent() ));
		board.setBoardTitle(Util.XSSHandling( board.getBoardTitle() ));

		int registerNo = dao.boardInsert(board);
		
		return registerNo;
	}
	
	

}
