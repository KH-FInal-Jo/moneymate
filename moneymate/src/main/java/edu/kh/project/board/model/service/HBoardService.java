package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.CComment;
import edu.kh.project.member.model.dto.Member;

public interface HBoardService {

	/** 출첵 내역 조회
	 * @param memberNo
	 * @return
	 */
	List<String> calendarList(int memberNo);

	/** 출첵 오늘 날짜 누른 경우
	 * @param memberNo
	 * @return count
	 */
	int calendarToday(int memberNo);

	/** 가계부 이벤트 댓글 목록 조회
	 * @return commentList
	 */
	List<CComment> commentList(Member loginMember);
	
	/** 가계부 이벤트 댓글 목록 조회(비회원)
	 * @return NcommentList
	 */
	List<CComment> NcommentList();

	/** 댓글 삽입
	 * @param comment
	 * @param commentImage
	 * @param webPath
	 * @param filePath
	 * @return commentNo
	 */
	int commentInsert(CComment comment, MultipartFile commentImage, String webPath, String filePath)
			throws IllegalStateException, IOException;

	/** 댓글 좋아요
	 * @param paramMap
	 * @return
	 */
	int eventLike(Map<String, Integer> paramMap);

	/** 댓글 수정
	 * @param comment
	 * @param updateImage
	 * @param webPath
	 * @param filePath
	 * @return
	 */
	int commentUpdate(CComment comment, MultipartFile updateImage, String webPath, String filePath) throws IllegalStateException, IOException;

	/** 댓글 삭제
	 * @param no
	 * @return result
	 */
	int deleteComment(int no);

	

	

}
