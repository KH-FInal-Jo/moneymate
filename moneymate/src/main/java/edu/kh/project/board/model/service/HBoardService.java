package edu.kh.project.board.model.service;

import java.util.List;

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

}
