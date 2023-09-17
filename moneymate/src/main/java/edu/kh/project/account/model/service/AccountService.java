package edu.kh.project.account.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.account.model.dto.SAccount;

public interface AccountService {

	/** 월 변경하기
	 * @param map
	 * @return sumMoney
	 */
	int changeMonth(Map<String, Object> map);
	
	/** 월 수입 변경하기
	 * @param map
	 * @return
	 */
	int changeMonthIncome(Map<String, Object> map);

	/** 지출내역 업데이트
	 *  @param map
	 * @return
	 */
	List<SAccount> changeMonthUpdate(Map<String, Object> map);
	
	/** 수입 내역 업데이트
	 * @param map
	 * @return
	 */
	List<SAccount> changeMonthUpdateIncome(Map<String, Object> map);

	/** 지출 그래프 업데이트
	 * @param map
	 * @return
	 */
	List<SAccount> changeChart(Map<String, Object> map);

	/** 수입 그래프 업데이트
	 * @param map
	 * @return
	 */
	List<SAccount> changeChartIncome(Map<String, Object> map);





}
