package edu.kh.project.subscribe.model.service;

import java.util.Map;

import edu.kh.project.subscribe.model.dto.Subscribe;

public interface HSubscribeService {

	/** 마일리지 조회
	 * @return
	 */
	int mile(int memberNo);

	/** kg 결제
	 * @param paramMap
	 * @return
	 */
	int kg(Subscribe subscribe);

}
