package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.JBoard;

@Repository
public class JBoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 공지사항 목록 조회
	public List<JBoard> selectBoardNotice(int boardCode) {
		
		
		System.out.println(boardCode);
		
		return sqlSession.selectList("selectBoardNotice", boardCode);
	}

	// 공지사항 상세 조회
	public List<JBoard> boardNoticeDetail(Map<String, Object> map) {
		return sqlSession.selectList("boardNoticeDetail", map);
	}

	// 공지사항 다음 글 얻어오기
	public int nextBoardNo() {
		
		int boardNo = sqlSession.selectOne("nextBoardNo");
		
		return boardNo;
	}

	// 공지사항 작성하기
	public int insertBoardNotice(JBoard board) {
		return sqlSession.insert("insertBoardNotice", board);
	}


}
