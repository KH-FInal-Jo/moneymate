package edu.kh.project.member.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.model.dto.JMember;
import edu.kh.project.member.model.dto.Member;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public interface KMemberService {

	int updateInfo(Member updateMember);
	
	//비밀번호 변경
	int changePw(String Password, String newPassword, int memberNo);

	// 마이페이지 사이드메뉴 조회
	List<JMember> selectMypage(int memberNo);

	
	// 이미지 변경
	int updateProfileImage(MultipartFile profile, String webPath, String filePath, Member loginMember) throws IllegalStateException, IOException;

	
	// 일치 하는 회원의 수
	int memberCheck(Member member);

	//휴대폰 인증
	String memberPhoneCheck(String memberTel) throws CoolsmsException;

	// 로그인x 휴대폰인증 후 비밀번호 바꾸기
	int changePw(String newPw, String memberEmail, String memberTel);

	// 일치 하는 회원의 수 (이멜 인증)
	int memberCheck2(Member member);

	String createAuthKey();
	
	// 이메일 인증 보내기
	int sendEmail(String memberEmail, String string);

	int checkAuthKey(Map<String, Object> paramMap);

	// 이메일 인증 후 비밀번호바꾸기
	int changePw(String newPw, String memberEmail);

		

}
