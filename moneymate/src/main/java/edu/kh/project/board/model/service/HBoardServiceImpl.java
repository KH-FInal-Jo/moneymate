package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dao.HBoardDAO;

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

}
