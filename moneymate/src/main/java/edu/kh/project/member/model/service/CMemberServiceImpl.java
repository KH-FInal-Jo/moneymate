package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.CMemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service
public class CMemberServiceImpl implements CMemberService {
	
	@Autowired
	private CMemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	
	// 로그인
	@Override
	public Member login(Member inputMember) {
		
		Member loginMember = dao.login(inputMember);
		
		
		if(loginMember != null) { 
			
			
			
			if(bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) { // 같을 경우
				
				// 비밀번호를 유지하지 않기 위해서 로그인 정보에서 제거
				loginMember.setMemberPw(null);
				
			} else { // 다를 경우
				loginMember = null; // 로그인 실패처럼 만듦
			}
			
		}
		
		return loginMember;
	}

	
	// 회원가입
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int signUp(Member inputMember) {
		
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		
		inputMember.setMemberPw(encPw);
		
		int result = dao.signUp(inputMember);
		
		return result;
	}

	// 회원탈퇴
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int secession(String memberPw, int memberNo) {
		// 회원번호 일치하는 회원의 비밀번호 조회
		String encPw = dao.selectEncPw(memberNo);

		// 비밀번호 일치하면
		if(bcrypt.matches(memberPw, encPw)) {
			return dao.secession(memberNo);
		}

		return 0;	
		
	}

	
	// 이메일 중복 검사
	@Override
	public int emailDupCheck(String email) {
		return dao.emailDupCheck(email);
	}

}
