package edu.kh.project.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.HPagination;
import edu.kh.project.board.model.dto.JBoard;
import edu.kh.project.board.model.dto.JPagination;
import edu.kh.project.member.model.dao.JMemberDAO;
import edu.kh.project.member.model.dto.JMember;

@Service
public class JMemberServiceImpl implements JMemberService{

	@Autowired
	private JMemberDAO dao;

	// 마이페이지 사이드메뉴 조회
	@Override
	public List<JMember> selectMypage2(int memberNo) {
		return dao.selectMypage2(memberNo);
	}

	// 북마크 조회
	@Override
	public Map<String, Object> selectBookmark(Map<String, Object> map) {

		// 삭제되지 않는 글 개수 조회
		int listCount = dao.getListCount(map);

		// 페이지네이션 객체 생성
		JPagination pagination = new JPagination((int)map.get("cp"), listCount);

		// 현재 페이지에 대한 글 조회
		List<JBoard> boardList = dao.selectBookmark(pagination, map);

		Map<String, Object> bkmap = new HashMap<String, Object>();

		bkmap.put("pagination", pagination);
		bkmap.put("boardList", boardList);

		return bkmap;

	}
}
