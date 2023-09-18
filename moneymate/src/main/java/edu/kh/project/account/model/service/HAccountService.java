package edu.kh.project.account.model.service;

import java.util.Map;

import edu.kh.project.member.model.dto.Member;

public interface HAccountService {

	/** 가계부 목록 조회
	 * @param loginMember
	 * @return map
	 */
	Map<String, Object> accountList(Member loginMember);

	/** 이메일 회원 검사
	 * @param memberEmail
	 * @return result
	 */
	int dupEmail(String memberEmail);

	/** 가계부 생성(개인)
	 * @param loginMember
	 * @return
	 */
	int pAccount(Member loginMember);

}