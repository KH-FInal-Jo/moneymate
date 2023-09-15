package edu.kh.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.CBoardDAO;
import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CBoardImage;
import edu.kh.project.board.model.dto.CPagination;
import edu.kh.project.board.model.exception.FileUploadException;
import edu.kh.project.common.utility.Util;

@Service
public class CBoardServiceImpl implements CBoardService {
	
	@Autowired
	private CBoardDAO dao;

	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {
		
		
		int listCount = dao.getListCount(boardCode);
		
		CPagination pagination = new CPagination(cp, listCount);
		
		List<CBoard> boardList = dao.selectBoardList(pagination, boardCode);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

	// 검색시 게시글 목록 조회
	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp) {
		// TODO Auto-generated method stub
		return null;
	}

	// 게시글 상세 조회
	@Override
	public CBoard selectBoard(Map<String, Object> map) {
		return dao.selectBoard(map);
	}

	
	// 게시글 작성
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int boardInsert(CBoard board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException {
		
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		
		int boardNo = dao.boardInsert(board);
		
		if(boardNo > 0) {
			List<CBoardImage> uploadList = new ArrayList<CBoardImage>();
			
			for(int i = 0 ; i < images.size() ; i++) {
				if(images.get(i).getSize() > 0) {
					CBoardImage img = new CBoardImage();
					
					img.setImagePath(webPath); // 웹 접근 경로
					img.setBoardNo(boardNo); // 게시글 번호
					img.setImageOrder(i); // 이미지 순서

					String fileName = images.get(i).getOriginalFilename();
					img.setImageOriginal(fileName); // 원본명
					img.setImageReName(Util.fileRename(fileName)); // 변경명

					uploadList.add(img);
				}
			}
			
			if(!uploadList.isEmpty()) {
				int result = dao.insertImageList(uploadList);
				
				if(result == uploadList.size()) {
					for(int i = 0; i<uploadList.size(); i++) {

						int index = uploadList.get(i).getImageOrder();

						// 파일로 변환
						String rename = uploadList.get(i).getImageReName();

						images.get(index).transferTo(new File(filePath + rename));
					}
				} else {
					throw new FileUploadException();
				}
			}
		}
		return boardNo;
	}

	// 좋아요 여부 확인
	@Override
	public int boardLikeCheck(Map<String, Object> map) {
		return dao.boardLikeCheck(map);
	}
	
	
	
	// 좋아요 
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int like(Map<String, Integer> paramMap) {
		
		int result = 0;
		
		if(paramMap.get("check") == 0) { // 좋아요 상태가 X
			// BOARD_LIKE 테이블 INSERT
			result = dao.insertBoardLike(paramMap);
		} else { // 좋아요 상태 
			// BOARD_LIKE 테이블 DELETE
			result = dao.deleteBoardLike(paramMap);
		}
		
		
		if(result == 0) return -1;
		
		// 현재 게시글의 좋아요 개수 조회
		int count = dao.CountBoardLike(paramMap.get("boardNo"));
		
		return count;
	}


}
