package edu.kh.project.subscribe.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Subscribe {
	
	private int subscribeNo;
	private String subscribeStart;
	private String subscribeEnd;
	private int subscribeLevel;
	private int memberNo;
	
	private int calculateNo;
	private int calculateWay;
	private String calculateFl;
	private int price;
	
	private int useMile;

}
