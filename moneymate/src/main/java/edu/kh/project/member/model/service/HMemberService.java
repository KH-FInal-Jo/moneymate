package edu.kh.project.member.model.service;

import java.util.Map;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.member.model.dto.Member;

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

	/** 카카오 로그인
	 * @param paramMap
	 * @return
	 */
	Member kakao(Map<String, String> paramMap);

	/** 카카오 회원가입
	 * @param paramMap
	 * @return
	 */
	int kakaoSignUp(Map<String, String> paramMap);

}
