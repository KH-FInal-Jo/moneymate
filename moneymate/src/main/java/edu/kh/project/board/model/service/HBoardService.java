package edu.kh.project.board.model.service;

import java.util.List;

public interface HBoardService {

	/** 출첵 내역 조회
	 * @param memberNo
	 * @return
	 */
	List<String> calendarList(int memberNo);

}
