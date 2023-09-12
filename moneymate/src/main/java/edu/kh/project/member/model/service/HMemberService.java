package edu.kh.project.member.model.service;

import java.util.Map;

public interface HMemberService {

	/** 좋아요 글 목록 조회
	 * @param map
	 * @return resMap
	 */
	Map<String, Object> selectLike(Map<String, Object> map);

}
