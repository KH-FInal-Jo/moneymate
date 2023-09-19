package edu.kh.project.board.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CReport {
	
	private int reportNo;
	private int reportedNo;
	private String reportContent;
	private int boardNo;
	private int reportCode;
	private int reportCategory;
	private String memberId;
	
	private String badContent;
	private String memberNickname;
	private String reportDate;
	private String reportState;
	
}
