package edu.kh.project.member.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.model.dto.JMember;
import edu.kh.project.member.model.dto.Member;

public interface KMemberService {

	int updateInfo(Member updateMember);

	int changePw(String currentPw, String newPw, int memberNo);

	// 마이페이지 사이드메뉴 조회
	List<JMember> selectMypage(int memberNo);

	
	
	
	int updateProfile(MultipartFile profileImage, String webPath, String filePath, Member loginMember);
	

}
