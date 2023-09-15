package edu.kh.project.member.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.member.model.dto.JMember;

public interface JMemberService {

	List<JMember> selectMypage2(int memberNo);

	// 북마크 조회하기
	Map<String, Object> selectBookmark(Map<String, Object> map);

}
