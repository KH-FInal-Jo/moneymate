package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

public interface KMemberService {

	int updateInfo(Member updateMember);

	int changePw(String currentPw, String newPw, int memberNo);
	

}
