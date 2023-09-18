package edu.kh.project.member.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.common.utility.Util;
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
	public int updateProfile(MultipartFile profileImage, String webPath, String filePath, Member loginMember) throws IllegalStateException {
		
		// 프로필 이미지 변경 실패 대비
		String temp = loginMember.getProfileImage(); // 이전 이미지 저장 
		
		String rename = null; // 변경 이름 저장 변수
		
		if(profileImage.getSize() > 0) {
			// 업로드된 이미지가 있을 경우  
			
			// 1) 파일 이름 변경 
			rename = Util.fileRename(profileImage.getOriginalFilename());
			
			// 2) 바뀐 이름 loginMember에 세팅
			loginMember.setProfileImage(webPath + rename);
										
		}else {
			//없는 경우(x버튼)
			loginMember.setProfileImage(null);
			// 세션 이미지를 null로 변경해서 삭제 
			
		}
		
		// 프로필 이미지 수정 DAO 메소드 호출
		int result = dao.updateProfileImage(loginMember);
		
		
		return result;
		
	}

}


