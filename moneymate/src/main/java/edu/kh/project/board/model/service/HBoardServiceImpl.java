package edu.kh.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.HBoardDAO;
import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.HBoardImage;
import edu.kh.project.board.model.exception.FileUploadException;
import edu.kh.project.common.utility.Util;

@Service
public class HBoardServiceImpl implements HBoardService {
	
	@Autowired
	private HBoardDAO dao;

	// 출첵 내역 조회
	@Override
	public List<String> calendarList(int memberNo) {
		return dao.calendarList(memberNo);
	}

	// 출첵 오늘 날짜 누른 경우
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int calendarToday(int memberNo) {
		return dao.calendarToday(memberNo);
	}

	// 가계부 이벤트 댓글 목록 조회
	@Override
	public List<CComment> commentList() {
		return dao.commentList();
	}

	// 댓글 삽입
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int commentInsert(CComment comment, MultipartFile commentImage, String webPath, String filePath) 
														throws IllegalStateException, IOException {
		
		// XSS
		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));
		
		// 내용, 작성자.. insert
		int commentNo = dao.commentInsert(comment);
		
		if(commentNo>0) { // 글자 관련 삽입 성공 시
			HBoardImage img = new HBoardImage();
			
			img.setImagePath(webPath);
			img.setBrNo(commentNo);
			
			String fileName = commentImage.getOriginalFilename();
			img.setImageOriginal(fileName);
			img.setImageReName(Util.fileRename(fileName));
			
			
			int result = dao.insertCommentImage(img);
			
			if(result == 1) {
				String rename = img.getImageReName();
				commentImage.transferTo(new File(filePath + rename));
			} else { // insert 실패
				
				throw new FileUploadException();
				
			}
		
		}
		
		return commentNo;
	}

}
