package edu.kh.project.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JReport {
	
	private int reportNo;
	private int reportedNo;
	private String reportContent;
	private int bcNo;
	private int reportCode;

}
