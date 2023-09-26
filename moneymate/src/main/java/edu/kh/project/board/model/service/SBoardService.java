package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.SBoard;
import edu.kh.project.member.model.dto.Member;

public interface SBoardService {



	/** 칼럼 게시글 등록
	 * @param board
	 * @param filePath 
	 * @param webPath 
	 * @param images 
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int boardInsert(SBoard board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException;

	/** 칼럼 게시글 목록 조회
	 * @param loginMember
	 * @return columnList
	 */
	List<SBoard> columnList(int memberNo);

	/** 이전 게시글 번호 구하기
	 * @param boardNo
	 * @return
	 */
	int columnPrevieous(int boardNo);

	/** 다음 게시글 번호 구하기
	 * @param boardNo
	 * @return
	 */
	int columnNext(int boardNo);

	/** 게시글 상세조회
	 * @param map
	 * @return
	 */
	SBoard selectBoard(Map<String, Object> map);

	/** 칼럼 좋아요 여부 확인
	 * @param map
	 * @return
	 */
	int columnLikeCheck(Map<String, Object> map);
	

}
