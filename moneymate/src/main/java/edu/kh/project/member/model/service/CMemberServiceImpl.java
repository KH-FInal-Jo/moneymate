package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.CMemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service
public class CMemberServiceImpl implements CMemberService {
	
	@Autowired
	private CMemberDAO dao;

	@Override
	public Member login(Member inputMember) {
		
		Member loginMember = dao.login(inputMember);
		
		if(loginMember != null) {
			loginMember.setMemberPw(null);
		} else {
			loginMember = null;
		}
		
		return loginMember;
	}

}
