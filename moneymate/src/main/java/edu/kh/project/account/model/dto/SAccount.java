package edu.kh.project.account.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SAccount {

	private String accountDate;
	private int accountMoney;
	private String accountContent;
	private String category;
	
	private List<SAccount> accountList;
	
}
