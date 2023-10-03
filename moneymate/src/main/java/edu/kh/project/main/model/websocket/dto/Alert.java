package edu.kh.project.main.model.websocket.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Alert {
	
	private int alertNo;
	private int boardNo;
	private int commentNo;
	private String alertSt;
	private String alertTarget;
	private int memberNo;
	
	
	
	

}
