package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.JBoardDAO;
import edu.kh.project.board.model.dto.JBoard;

@Service
public class JBoardServiceImpl implements JBoardService{
	
	@Autowired
	private JBoardDAO dao;

	@Override
	public Map<String, Object> selectBoardNotice(int boardCode) {
		// TODO Auto-generated method stub
		return null;
	}


}
