package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.KMemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service
public class KMemberServiceImpl implements KMemberService{
	
	@Autowired
	private KMemberDAO dao;
	
	private BCryptPasswordEncoder bcrypt;

	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int updateInfo(Member updateMember) {
		
		return dao.updateInfo(updateMember);
	}

}
