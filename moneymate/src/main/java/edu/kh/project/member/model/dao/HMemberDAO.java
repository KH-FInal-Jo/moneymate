package edu.kh.project.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.HPagination;

@Repository
public class HMemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 좋아요 한 글 중 삭제되지 않은 게시글 수 조회
	 * @param map
	 * @return listCount
	 */
	public int getListCount(Map<String, Object> map) {
		return sqlSession.selectOne("HMemberMapper.getListCount", map);
	}

	/** 좋아요 목록- 현재 페이지에 해당하는 게시글 목록 조회
	 * @param pagination
	 * @param map
	 * @return boardList
	 */
	public List<CBoard> selectLikeList(HPagination pagination, Map<String, Object> map) {
		
		// RowBounds 객체 사용
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("HMemberMapper.selectLikeList", map, rowBounds);
	}

}
