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
	
	/**  월 지출 내역 10-12월
	 * @param map
	 * @return
	 */
	List<SAccount> changeMonthBigger(Map<String, Object> map);
	
	/** 수입 내역 업데이트
	 * @param map
	 * @return
	 */
	List<SAccount> changeMonthUpdateIncome(Map<String, Object> map);
	
	/** 월 수입내역 10-12월
	 * @param map
	 * @return
	 */
	List<SAccount> changeMonthUpdateIncomeBigger(Map<String, Object> map);

	/** 지출 그래프 업데이트
	 * @param map
	 * @return
	 */
	List<SAccount> changeChart(Map<String, Object> map);
	
	/** 월 지출 그래프 10-12월
	 * @param map
	 * @return
	 */
	List<SAccount> changeChartBigger(Map<String, Object> map);

	/** 수입 그래프 업데이트
	 * @param map
	 * @return
	 */
	List<SAccount> changeChartIncome(Map<String, Object> map);
	
	/** 월 수입 그래프 10-12월
	 * @param map
	 * @return
	 */
	List<SAccount> changeChartIncomeBigger(Map<String, Object> map);

	/** 월 지출 합계금액 10-12월
	 * @param map
	 * @return
	 */
	int changeMonthUpdateBigger(Map<String, Object> map);

	/** 월 수입 합계금액 10-12월
	 * @param map
	 * @return
	 */
	int changeMonthIncomeBigger(Map<String, Object> map);

	/** 카테고리명 조회 내역
	 * @param map
	 * @return
	 */
	List<SAccount> categoryName(Map<String, Object> map);

	/** 카테고리명 조회 내역 수입
	 * @param map
	 * @return
	 */
	List<SAccount> categoryNameIncome(Map<String, Object> map);

	/** 카테고리 조회 내역 10-12월
	 * @param map
	 * @return
	 */
	List<SAccount> categoryNameBigger(Map<String, Object> map);

	/** 카테고리 조회 내역 수입 10-12월
	 * @param map
	 * @return
	 */
	List<SAccount> categoryNameIncomeBigger(Map<String, Object> map);













}
