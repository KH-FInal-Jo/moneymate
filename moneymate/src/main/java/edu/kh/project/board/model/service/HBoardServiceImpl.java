package edu.kh.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.HBoardDAO;
import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.HBoardImage;
import edu.kh.project.board.model.exception.FileUploadException;
import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;

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
	public List<CComment> commentList(Member loginMember) {
		return dao.commentList(loginMember);
	}
	
	// 가계부 이벤트 댓글 목록 조회(비회원)
	@Override
	public List<CComment> NcommentList() {
		return dao.NcommentList();
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
		
		System.out.println(" 1 : " + comment);
		
		if(commentNo>0) { // 글자 관련 삽입 성공 시
			HBoardImage img = new HBoardImage();
			
			img.setImagePath(webPath);
			img.setBrNo(commentNo);
			
			String fileName = commentImage.getOriginalFilename();
			img.setImageOriginal(fileName);
			img.setImageReName(Util.fileRename(fileName));
			
			
			int result = dao.insertCommentImage(img);
			
			System.out.println(" 2 : " + result);
			
			if(result == 1) {
				String rename = img.getImageReName();
				commentImage.transferTo(new File(filePath + rename));
			} else { // insert 실패
				
				throw new FileUploadException();
				
			}
		
		}
		
		return commentNo;
	}

	// 댓글 좋아요
	@Transactional (rollbackFor = {Exception.class})
	@Override
	public int eventLike(Map<String, Integer> paramMap) {
		
		int result = 0;
		
		if(paramMap.get("likeCheck") == 0) { // 좋아요 X -> O
			result = dao.insertLike(paramMap);
		} else { // 좋아요 O -> X
			result = dao.deleteLike(paramMap);
		}
		
		if(result == 0) return -1;
		
		// 좋아요 개수 다시 헤아리기
		int count = dao.countLike(paramMap);
		
		return count;
	}

	

	

}
