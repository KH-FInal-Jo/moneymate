package edu.kh.project.subscribe.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.subscribe.model.dao.HSubscribeDAO;
import edu.kh.project.subscribe.model.dto.Subscribe;

@Service
public class HSubscribeServiceImpl implements HSubscribeService{
	
	@Autowired
	private HSubscribeDAO dao;

	// 마일리지 조회
	@Override
	public int mile(int memberNo) {
		return dao.mile(memberNo);
	}

	// kg 결제
	@Transactional (rollbackFor = {Exception.class})
	@Override
	public int kg(Subscribe subscribe) {
		
		// 구독에 insert
		int result = dao.susbscribeKg(subscribe);
		
		if(result>0) {
			result = dao.calculateKg(subscribe);
		}
		
		
		return result;
	}

}
