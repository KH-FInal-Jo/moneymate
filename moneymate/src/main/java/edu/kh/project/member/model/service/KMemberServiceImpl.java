package edu.kh.project.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.model.dao.KMemberDAO;
import edu.kh.project.member.model.dto.JMember;
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

	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		return dao.changePw(newPw, memberNo);
	}

	// 마이페이지 사이드메뉴 조회
	@Override
	public List<JMember> selectMypage(int memberNo) {
		return dao.selectMypage(memberNo);
	}

	@Override
	public int updateProfile(MultipartFile profileImage, String webPath, String filePath, Member loginMember) {
		return dao.updateInfo();
	}

}
