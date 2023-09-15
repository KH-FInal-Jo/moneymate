package edu.kh.project.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.JBoard;
import edu.kh.project.board.model.dto.JPagination;
import edu.kh.project.member.model.dto.JMember;

@Repository
public class JMemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<JMember> selectMypage2(int memberNo) {
		return sqlSession.selectList("JMemberMapper.selectMypage", memberNo);
	}

	// 삭제되지 않은 게시글 조회
	public int getListCount(Map<String, Object> map) {
		return sqlSession.selectOne("JMemberMapper.BgetListCount", map);
	}

	// 북마크 관련 목록 조회
	public List<JBoard> selectBookmark(JPagination pagination, Map<String, Object> map) {

		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("JBoardMapper.BselectBookmark", map, rowBounds);
	}


}
