package edu.kh.project.main.model.websocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	

}
