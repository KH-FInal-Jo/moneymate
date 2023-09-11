package edu.kh.project.account.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JAccountBook {
	
	private int accountNo;
	private String relevantDate;
	private String registrationDate;
	private String account;
	private String accountMoney;
	private String memo;
	private String paymentMethod;
	private int categoryCode;
	private int memberNo;
	private String accountSt;
	
	private String categoryName;
	private String inoutCode;
	private String inoutName;
	
	private String targetMoney;
	
}
