package edu.kh.project.account.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.account.model.dto.SAccount;

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


	/** 지출 내역 업데이트
	 * @param map
	 * @return
	 */
	public List<SAccount> changeMonthUpdate(Map<String, Object> map) {
		return sqlSession.selectList("SmemberMapper.selectAccount" , map);
	}


	/** 지출 그래프
	 * @param map
	 * @return
	 */
	public List<SAccount> changeChart(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SmemberMapper.selectChart", map);
	}


	
	

}
