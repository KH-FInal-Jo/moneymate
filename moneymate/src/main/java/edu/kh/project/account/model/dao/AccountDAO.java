package edu.kh.project.account.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	/** 월 변경하기 dao
	 * @param map
	 * @return sumMoney
	 */
	public int changeMonth(Map<String, Object> map) {
		System.out.println("dao 확인 : " + map.get("month"));
		return sqlSession.selectOne("SmemberMapper.changeMonth",map);
	}


	
	

}
