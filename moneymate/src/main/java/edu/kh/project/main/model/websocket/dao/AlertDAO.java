package edu.kh.project.main.model.websocket.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.main.model.websocket.dto.Alert;

@Repository
public class AlertDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 알람 갯수 받기
	 * @param memberNo
	 * @return
	 */
	public List<Alert> alertNumber(int memberNo) {
		return sqlSession.selectList("SBoardMapper.alertNumber", memberNo);
	}

	/** 글쓴이, 부모댓글 회원번호
	 * @param commentNo
	 * @return
	 */
	public CBoard memberNo(int commentNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("SBoardMapper.memberNo", commentNo);
	}


}
