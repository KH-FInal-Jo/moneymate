package edu.kh.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.SBoardDAO;
import edu.kh.project.board.model.dto.SBoard;
import edu.kh.project.board.model.dto.SBoardImage;
import edu.kh.project.board.model.exception.FileUploadException;
import edu.kh.project.common.utility.Util;

@Service
public class SBoardServiceImpl implements SBoardService {
	
	@Autowired
	private SBoardDAO dao;




	// 칼럼 게시글 등록
	@Override
	public int boardInsert(SBoard board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException {
		
		// XSS 방지 처리
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		
		// BOARD 테이블 INSERT 하기 (제목, 내용, 작성자, 게시판코드)
		// -> boardNo(시퀀스로 생성한 번호)반환 받기
		int boardNo = dao.boardInsert (board);
		
		if(boardNo > 0) { // 게시글 삽입 성공 시
			
			// 실제로 업로드된 파일의 정보를 기록한 List
			List<SBoardImage> uploadList = new ArrayList<SBoardImage>();
			
			// images에 담겨있는 파일 중 실제 업로드된 파일만 분류
			for(int i=0; i<images.size(); i++) {
				
				// i번째 요소에 업로드한 파일이 있다면
				if(images.get(i).getSize() > 0) {
					
					SBoardImage img = new SBoardImage();
					
					// img에 파일 정보를 담아서 uploadList에 추가
					img.setImagePath(webPath); // 웹 접근 경로
					img.setBoardNo(boardNo); // 게시글 번호
					img.setImageOrder(i); // 이미지 순서
					
					// 파일 원본명
					String fileName = images.get(i).getOriginalFilename();
					
					img.setImageOriginal(fileName); // 원본명
					img.setImageReName(Util.XSSHandling(fileName)); // 파일 변경명
					
					uploadList.add(img);
					
				}
				
			} // 분류 for문 종료
			
			// 분류 작업 후 uploadList가 비어있지 않은 경우
			
			// == 업로드한 파일이 있다
			if(!uploadList.isEmpty()) {
				
				int result = dao.insertImageList(uploadList);
				// result == 삽입된 행의 개수 == uploadList.size()
				
				// 삽입된 행의 개수와 uploadList의 개수가 같다면
				// == 전체 insert 성공
				if(result == uploadList.size()) {
					
					// 서버에 파일을 저장(trasferTo())
					
					for(int i=0; i<uploadList.size(); i++) {
						
						int index = uploadList.get(i).getImageOrder();
						
						// 파일로 변환
						String rename = uploadList.get(i).getImageReName();
						
						images.get(index).transferTo(new File(filePath + rename));
						
					}
					
				} else {
					// 일부 또는 전체 insert 실패
					throw new FileUploadException(); // 예외 강제 발생
				}
				
			}
			
		}
		
		
		
		return boardNo;
	}
	
	

}
