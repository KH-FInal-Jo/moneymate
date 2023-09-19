package edu.kh.project.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.HPagination;
import edu.kh.project.member.model.dao.HMemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service
public class HMemberServiceImpl implements HMemberService {
	
	@Autowired
	private HMemberDAO dao;

	// 좋아요 글 목록 조회
	@Override
	public Map<String, Object> selectLike(Map<String, Object> map) {
		
		// 삭제되지 않는 글 개수 조회
		int listCount = dao.getListCount(map);
		
		// 페이지네이션 객체 생성
		HPagination pagination = new HPagination((int)map.get("cp"), listCount);
		
		// 현재 페이지에 대한 글 조회
		List<CBoard> boardList = dao.selectLikeList(pagination, map);
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("pagination", pagination);
		resMap.put("boardList", boardList);
		
		return resMap;
	}

	// 좋아요 삭제
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int cancelLike(CBoard board) {
		return dao.cancelLike(board);
	}

	// 카카오 로그인
	@Override
	public Member kakao(Map<String, String> paramMap) {
		return dao.kakaoLogin(paramMap);
	}

	// 카카오 회원가입
	@Transactional (rollbackFor = {Exception.class})
	@Override
	public int kakaoSignUp(Map<String, String> paramMap) {
		return dao.kakaoSignUp(paramMap);
	}

}
