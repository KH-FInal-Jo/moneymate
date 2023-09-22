package edu.kh.project.board.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class KBoard {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardCreateDate;
	private String boardUpdateDate;
	private int readCount;
	private int boardCode;
	private String boardName;
	private int commentList;
	
	private int commentCount;
	
	private String memberNickname; 
	private int memberNo;
		

	
}
