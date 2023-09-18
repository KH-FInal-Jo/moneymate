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
	
	/** 월 지출 금액 합계 10-12월
	 * @param map
	 * @return
	 */
	public int changeMonthUpdateBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("SmemberMapper.changeMonthBigger",map);
	}
	
	/** 월 수입 변경하기
	 * @param map
	 * @return
	 */
	public int changeMonthIncome(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("SmemberMapper.changeMonthIncome",map);
	}
	
	/** 월 수입 합계 금액 10-12월
	 * @param map
	 * @return
	 */
	public int changeMonthIncomeBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("SmemberMapper.changeMonthIncomeBigger", map);
	}



	/** 지출 내역 업데이트
	 * @param map
	 * @return
	 */
	public List<SAccount> changeMonthUpdate(Map<String, Object> map) {
		return sqlSession.selectList("SmemberMapper.selectAccount" , map);
	}
	
	/** 월 지출 내역 10-12월
	 * @param map
	 * @return
	 */
	public List<SAccount> changeMonthBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SmemberMapper.selectAccountBigger", map);
	}
	
	/** 수입 내역 업데이트
	 * @param map
	 * @return
	 */
	public List<SAccount> changeMonthUpdateIncome(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SmemberMapper.selectAccountIncome" , map);
	}
	
	/** 월 수입 내역 10-12월
	 * @param map
	 * @return
	 */
	public List<SAccount> changeMonthUpdateIncomeBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SmemberMapper.selectAccountIncomeBigger", map);
	}


	/** 지출 그래프
	 * @param map
	 * @return
	 */
	public List<SAccount> changeChart(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SmemberMapper.selectChart", map);
	}
	
	/** 월 지출 그래프 10-12월
	 * @param map
	 * @return
	 */
	public List<SAccount> changeChartBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SmemberMapper.selectChartBigger", map);
	}



	/** 수입 그래프
	 * @param map
	 * @return
	 */
	public List<SAccount> changeChartIncome(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SmemberMapper.selectChartIncome",map);
	}

	/** 월 수입 그래프 10-12월
	 * @param map
	 * @return
	 */
	public List<SAccount> changeChartIncomeBigger(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SmemberMapper.selectChartIncomeBigger", map);
	}

	/** 카테고리명 조회 내역
	 * @param map
	 * @return
	 */
	public List<SAccount> categoryName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SmemberMapper.categoryName", map);
	}

	
	

	

	
	



	


	
	

}
