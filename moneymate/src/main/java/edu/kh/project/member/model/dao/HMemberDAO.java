package edu.kh.project.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
