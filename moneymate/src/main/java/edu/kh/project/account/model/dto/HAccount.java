package edu.kh.project.account.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HAccount {
	
	private int accountNo;
	private String memberEmail;
	private String memberEmails;
	private String[] emailArray;

}
