package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.CComment;

public interface HBoardService {

	/** 출첵 내역 조회
	 * @param memberNo
	 * @return
	 */
	List<String> calendarList(int memberNo);

	/** 출첵 오늘 날짜 누른 경우
	 * @param memberNo
	 * @return count
	 */
	int calendarToday(int memberNo);

	/** 가계부 이벤트 댓글 목록 조회
	 * @return commentList
	 */
	List<CComment> commentList();

	/** 댓글 삽입
	 * @param comment
	 * @param commentImage
	 * @param webPath
	 * @param filePath
	 * @return commentNo
	 */
	int commentInsert(CComment comment, MultipartFile commentImage, String webPath, String filePath)
			throws IllegalStateException, IOException;

}
