package edu.kh.project.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.model.dao.HAdminDAO;
import edu.kh.project.admin.model.dto.HHPagination;
import edu.kh.project.member.model.dto.JMember;

@Service
public class HAdminServiceImpl implements HAdminService {
	
	@Autowired
	private HAdminDAO dao;

	// 회원 목록 조회
	@Override
	public Map<String, Object> memberList(int cp) {
		
		// 회원 수 조회
		int memberCount = dao.getMemberCount();
		
		// 페이지네이션 객체 생성
		HHPagination pagination = new HHPagination(cp, memberCount);
		
		// 회원 목록 조회
		List<JMember> memberList = dao.memberList(pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("memberList", memberList);
		
		return map;
	}

	// 회원 검색
	@Override
	public Map<String, Object> memberList(int cp, Map<String, Object> paramMap) {
		
		int memberCount = dao.getmemberCount(paramMap);
		
		HHPagination pagination = new HHPagination(cp, memberCount);
		
		List<JMember> memberList = dao.selectMemberList(pagination, paramMap);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberList", memberList);
		map.put("pagination", pagination);
		
		return map;
	}
	
	// 마일리지 업뎃
	@Override
	public int mile(Map<String, Object> paramMap) {
		return dao.mile(paramMap);
	}

	// 회원 탈퇴
	@Override
	public int secession(int no) {
		return dao.secession(no);
	}

	// 자동완성
	@Override
	public List<JMember> selectMember(String query) {
		return dao.selectMember(query);
	}


	

}
