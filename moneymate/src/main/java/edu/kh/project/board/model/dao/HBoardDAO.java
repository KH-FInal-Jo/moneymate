package edu.kh.project.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
