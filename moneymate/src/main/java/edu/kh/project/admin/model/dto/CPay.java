package edu.kh.project.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CPay {
	
	private int calculateNo;
	private int price;
	private int useMileage;
	
	private int memberNo;
	private String memberNickname;
	private String memberId;
	
	private String subscribeStart;
	private String subscribeEnd;
	
	
	
}
