package edu.kh.project.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.JMemberDAO;
import edu.kh.project.member.model.dto.JMember;

@Service
public class JMemberServiceImpl implements JMemberService{

	@Autowired
	private JMemberDAO dao;
	
	// 마이페이지 사이드메뉴 조회
	@Override
	public List<JMember> selectMypage2(int memberNo) {
		return dao.selectMypage2(memberNo);
	}
}
