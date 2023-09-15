package edu.kh.project.member.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JMember {

	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberName;
	private String memberNickname;
	private String memberTel;
	private String memberAddress;
	private String secessionFlag;
	private int authority;
	private String profileImage;
	
	private int subscribeNo;
	private int subscribeStart;
	private int subscribeEnd;
	private int subscribeLevel;
	private int mileage;
	
	private int reportCount;

}
