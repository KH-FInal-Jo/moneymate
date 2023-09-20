package edu.kh.project.member.model.service;

import java.util.Map;

import edu.kh.project.member.model.dto.Member;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public interface CMemberService {

	
	/** 로그인 서비스
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember);

	
	
	/** 회원가입 서비스
	 * @param inputMember
	 * @return result
	 */
	int signUp(Member inputMember);



	int secession(String memberPw, int memberNo);



	int emailDupCheck(String email);



	int signUp(String email, String title);
	
	String createAuthKey();



	int checkAuthKey(Map<String, Object> paramMap);



	Map<String, Object> selectMyBoard(int cp, int myNum);



	Map<String, Object> selectMyBoard(Map<String, Object> paramMap, int cp);



	int nicknameDupCheck(String nickname);



	String memberPhoneCheck(String mTel) throws CoolsmsException;

}
