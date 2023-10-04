package edu.kh.project.main.model.websocket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.main.model.websocket.dto.Alert;

public interface AlertService {

	/** 알람 갯수 받기
	 * @param memberNo
	 * @return
	 */
	List<Alert> alertNumber(int memberNo);

	/** 글쓴이, 부모댓글 회원번호
	 * @param commentNo
	 * @return
	 */
	CBoard memberNo(int commentNo);

}
