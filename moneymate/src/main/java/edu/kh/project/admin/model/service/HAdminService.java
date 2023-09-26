package edu.kh.project.admin.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.member.model.dto.JMember;


public interface HAdminService {

	/** 회원 리스트 조회
	 * @return memberList
	 */
	Map<String, Object> memberList(int cp);

	/** 마일리지 업데이트
	 * @param member
	 * @return result
	 */
	int mile(Map<String, Object> paramMap);

	/** 회원 탈퇴
	 * @param no
	 * @return result
	 */
	int secession(int no);

	/** 회원 검색
	 * @param cp
	 * @param paramMap
	 * @return
	 */
	Map<String, Object> memberList(int cp, Map<String, Object> paramMap);

	/** 자동완성
	 * @param query
	 * @return mList
	 */
	List<JMember> selectMember(String query);

	/** 채팅 관리자
	 * @param cp
	 * @return
	 */
	Map<String, Object> chattReport(int cp);

	

}
