package edu.kh.project.board.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SBoard {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardCreateDate;
	private String boardUpdateDate;
	private int readCount;
	private int boardCode;
	
	private int likeCount;    // 좋아요 수
	
	// 회원 join
	private String memberNickname; 
	private int memberNo;
	private String profileImage;
	private String thumbNail;
	
	// 이미지 목록
	private List<SBoardImage> imageList;
}
