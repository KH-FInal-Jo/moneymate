package edu.kh.project.member.model.service;

import java.util.Map;

import edu.kh.project.board.model.dto.CBoard;

public interface HMemberService {

	/** 좋아요 글 목록 조회
	 * @param map
	 * @return resMap
	 */
	Map<String, Object> selectLike(Map<String, Object> map);

	/** 좋아요 삭제
	 * @param board
	 * @return result
	 */
	int cancelLike(CBoard board);

}
