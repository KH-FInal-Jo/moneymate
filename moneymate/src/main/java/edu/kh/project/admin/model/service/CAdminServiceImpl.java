package edu.kh.project.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.model.dao.CAdminDAO;
import edu.kh.project.admin.model.dto.CPay;
import edu.kh.project.board.model.dto.CPagination;
import edu.kh.project.board.model.dto.CReport;

@Service
public class CAdminServiceImpl implements CAdminService {
	
	@Autowired
	private CAdminDAO dao;

	@Override
	public Map<String, Object> selectReportList(int cp) {
		
		int listCount = dao.getListCount();
		
		CPagination pagination = new CPagination(cp, listCount);
		
		List<CReport> reportList = dao.selectReportList(pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("reportList", reportList);
		
		return map;
	}

	@Override
	public int reportConfirm(Map<String, Object> paramMap) {
		return dao.reportConfirm(paramMap);
	}

	@Override
	public int reportDupCheck(Map<String, Object> paramMap) {
		
		return dao.reportDupCheck(paramMap);
	}

	@Override
	public Map<String, Object> selectPayList(int cp) {
		
		int payCount = dao.getPayCount();
		
		CPagination pagination = new CPagination(cp, payCount);
		
		List<CPay> payList = dao.selectPayList(pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("payList", payList);
		
		return map;
	}

}
