package edu.kh.project.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.HMemberDAO;

@Service
public class HMemberServiceImpl implements HMemberService {
	
	@Autowired
	private HMemberDAO dao;

	// 좋아요 글 목록 조회
	@Override
	public Map<String, Object> selectLike(Map<String, Object> map) {
		
		// 삭제되지 않는 글 개수 조회
		// 페이지네이션 객체 생성
		// 현재 페이지에 대한 글 조회
		int listCount = dao.getListCount(map);
		
		System.out.println("listCOunt : " + listCount);
		
		
		return null;
	}

}
