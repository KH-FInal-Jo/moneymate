package edu.kh.project.subscribe.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.subscribe.model.dto.Subscribe;

@Repository
public class HSubscribeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 마일리지 조회
	 * @param memberNo
	 * @return mile
	 */
	public int mile(int memberNo) {
		return sqlSession.selectOne("HsubscribeMapper.mile", memberNo);
	}

	/** kg 구독
	 * @param paramMap
	 * @return result
	 */
	public int susbscribeKg(Subscribe subscribe) {
		return sqlSession.insert("HsubscribeMapper.susbscribeKg", subscribe);
	}

	/** kg 결제
	 * @param subscribe
	 * @return result
	 */
	public int calculateKg(Subscribe subscribe) {
		return sqlSession.insert("HsubscribeMapper.calculateKg", subscribe);
	}
	
	/** kg 구독
	 * @param subscribe
	 * @return
	 */
	public int subscribeKg(Subscribe subscribe) {
		return sqlSession.insert("HsubscribeMapper.subscribeKg", subscribe);
	}


	/** 마일리지 차감
	 * @param subscribe
	 * @return result
	 */
	public int mile(Subscribe subscribe) {
		return sqlSession.update("HsubscribeMapper.useMile", subscribe);
	}

	/** 결제 완료 페이지
	 * @param no
	 * @return s
	 */
	public Subscribe subscribeEnd(int no) {
		return sqlSession.selectOne("HsubscribeMapper.subscribeEnd", no);
	}

	


}
