package edu.kh.project.account.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HAccount {
	
	private int accountNo;
	private int memberNo;
	private String accountName;
	private String memberEmail;
	private String memberEmails;
	private String[] emailArray;
	
	private String authKey;

}
