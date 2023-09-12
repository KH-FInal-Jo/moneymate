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
		
		// 결제에 insert 
		int result = dao.calculateKg(subscribe);
		
		// 구독 테이블에 insert
		if(result>0) {
			result = dao.subscribeKg(subscribe);
		}
		
		// 사용한 마일리지 차감
		if(result > 0) {
			result = dao.mile(subscribe);
		}
		
		return result;
	}

	// 결제 완료 페이지
	@Override
	public Subscribe subscribeEnd(int no) {
		
		Subscribe s = dao.subscribeEnd(no); // 구독 기간 조회
		
		return s;
	}

}
