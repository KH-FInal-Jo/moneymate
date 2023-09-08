package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
