package edu.kh.project.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.HBoardImage;

@Repository
public class HBoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 출첵 내역 조회
	 * @param memberNo
	 * @return calendarList
	 */
	public List<String> calendarList(int memberNo) {
		return sqlSession.selectList("HBoardMapper.calendarList", memberNo);
	}

	/** 출첵 오늘 날짜 누른 경우
	 * @param memberNo
	 * @return count
	 */
	public int calendarToday(int memberNo) {
		
		return sqlSession.insert("HBoardMapper.calendarToday", memberNo);
	}

	/** 가계부 이벤트 댓글 목록 조회
	 * @return
	 */
	public List<CComment> commentList() {
		return sqlSession.selectList("HBoardMapper.commentList");
	}

	/** 댓글 내용(글자 관련)만 삽입
	 * @param comment
	 * @return commentNo
	 */
	public int commentInsert(CComment comment) {
		
		int result = sqlSession.insert("HBoardMapper.commentInsert", comment);
		
		return 0;
	}

	/** 댓글 이비지 삽입
	 * @param img
	 * @return result
	 */
	public int insertCommentImage(HBoardImage img) {
		return sqlSession.insert("HBoardMapper.insertCommentImage", img);
	}

}
