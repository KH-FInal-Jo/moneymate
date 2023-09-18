package edu.kh.project.account.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.account.model.dao.HAccountDAO;
import edu.kh.project.account.model.dto.HAccount;
import edu.kh.project.member.model.dto.Member;

@Service
public class HAccountServiceImpl implements HAccountService{
	
	@Autowired
	private HAccountDAO dao;

	// 가계부 목록 조회
	@Override
	public Map<String, Object> accountList(Member loginMember) {
		
		// 개인 가계부 조회
		List<HAccount> pList = dao.pList(loginMember);
		
		// 그룹 가계부 조회
		List<HAccount> gList = dao.gList(loginMember);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pList", pList);
		map.put("gList", gList);
		
		return map;
	}

	// 이메일 회원 검사
	@Override
	public int dupEmail(String memberEmail) {
		
		return dao.dupCheck(memberEmail);
	}

	// 가계부 생성(개인)
	@Override
	public int pAccount(Member loginMember) {
		return dao.pAccount(loginMember);
	}

}
