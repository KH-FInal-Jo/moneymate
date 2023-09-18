package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.board.model.dto.HBoardImage;
import edu.kh.project.member.model.dto.Member;

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
		
		int result = sqlSession.insert("HBoardMapper.calendarToday", memberNo);
		
		if(result>0) {
			sqlSession.update("HBoardMapper.updateMile", memberNo);
		}
		
		return result;
	}

	/** 가계부 이벤트 댓글 목록 조회
	 * @return
	 */
	public List<CComment> commentList(Member loginMember) {
		return sqlSession.selectList("HBoardMapper.commentList", loginMember);
	}
	
	/** 가계부 이벤트 댓글 목록 조회(비회원)
	 * @return NcommentList
	 */
	public List<CComment> NcommentList() {
		return sqlSession.selectList("HBoardMapper.NcommentList");
	}

	/** 댓글 내용(글자 관련)만 삽입
	 * @param comment
	 * @return commentNo
	 */
	public int commentInsert(CComment comment) {
		
		int result = sqlSession.insert("HBoardMapper.commentInsert", comment);
		
		if(result>0) result = comment.getCommentNo();
		
		return result;
	}

	/** 댓글 이미지 삽입
	 * @param img
	 * @return result
	 */
	public int insertCommentImage(HBoardImage img) {
		return sqlSession.insert("HBoardMapper.insertCommentImage", img);
	}

	// 좋아요 삽입
	public int insertLike(Map<String, Integer> paramMap) {
		return sqlSession.insert("HBoardMapper.insertLike", paramMap);
	}

	// 좋아요 삭제
	public int deleteLike(Map<String, Integer> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.delete("HBoardMapper.deleteLike", paramMap);
	}

	// 좋아요 개수 세기
	public int countLike(Map<String, Integer> paramMap) {
		return sqlSession.selectOne("HBoardMapper.countLike", paramMap);
	}

	/** 댓글 내용 수정
	 * @param comment
	 * @return result
	 */
	public int commentUpdate(CComment comment) {
		return sqlSession.update("HBoardMapper.commentUpdate", comment);
	}

	/** 댓글 이미지 수정
	 * @param img
	 * @return
	 */
	public int updateCommentImage(HBoardImage img) {
		return sqlSession.update("HBoardMapper.updateCommentImage", img);
	}

	/** 댓글 삭제
	 * @param no
	 * @return result
	 */
	public int deleteComment(int no) {
		return sqlSession.update("HBoardMapper.deleteComment", no);
	}

	

	

}
