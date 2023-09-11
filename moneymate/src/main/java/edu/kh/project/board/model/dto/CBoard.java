package edu.kh.project.board.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CBoard {

	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardCreateDate;
	private String boardUpdateDate;
	private int readCount;
	private int boardCode;
	
	private int commentCount;
	private int likeCount; 
	
	
	private String memberNickname; 
	private int memberNo;
	private String profileImage;
	private String thumbnail;
	
	private List<CBoardImage> imageList;
	private List<CComment> commentList;

}
