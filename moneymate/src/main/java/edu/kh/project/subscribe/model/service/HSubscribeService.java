package edu.kh.project.subscribe.model.service;

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

	/** 결제 완료 페이지
	 * @param no
	 * @return s
	 */
	Subscribe subscribeEnd(int no);

}
