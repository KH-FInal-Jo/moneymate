package edu.kh.project.main.model.websocket.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


}
