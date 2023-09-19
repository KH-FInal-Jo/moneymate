package edu.kh.project.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.model.dao.CAdminDAO;
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

}