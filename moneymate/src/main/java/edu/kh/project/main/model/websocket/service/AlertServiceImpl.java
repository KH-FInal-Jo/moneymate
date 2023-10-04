package edu.kh.project.main.model.websocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.main.model.websocket.dao.AlertDAO;
import edu.kh.project.main.model.websocket.dto.Alert;

@Service
public class AlertServiceImpl implements AlertService{

	@Autowired
	private AlertDAO dao;
	
	// 알람 갯수 받기
	@Override
	public List<Alert> alertNumber(int memberNo) {
		
		
		return dao.alertNumber(memberNo);
	}

	// 글쓴이, 부모댓글 회원번호 
	@Override
	public CBoard memberNo(int commentNo) {
		// TODO Auto-generated method stub
		return dao.memberNo(commentNo);
	}

	// 알람 갯수 조회
	@Override
	public int countAlarm(int memberNo) {
		return dao.countAlarm(memberNo);
	}

	// boardNo 구하기
	@Override
	public int selectBoardNo(int alertNo) {
		// TODO Auto-generated method stub
		return dao.selectBoardNo(alertNo);
	}

	// update 읽음으로 변경
	@Override
	public int updateBoard(int alertNo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(alertNo);
	}
	
	

}
