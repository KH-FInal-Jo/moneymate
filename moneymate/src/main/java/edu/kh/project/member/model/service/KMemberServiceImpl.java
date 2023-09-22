package edu.kh.project.member.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dao.KMemberDAO;
import edu.kh.project.member.model.dto.JMember;
import edu.kh.project.member.model.dto.Member;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class KMemberServiceImpl implements KMemberService{
	
	@Autowired
	private KMemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int updateInfo(Member updateMember) {
		
		return dao.updateInfo(updateMember);
	}

	//비밀번호 변경
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int changePw(String Password, String newPassword, int memberNo) {
		
		String encPw = dao.selectEncPw(memberNo);
		
		if(bcrypt.matches(Password, encPw)) {
			
			return dao.changePw(bcrypt.encode(newPassword), memberNo);
		}
		return 0;
	}

	// 마이페이지 사이드메뉴 조회
	@Override
	public List<JMember> selectMypage(int memberNo) {
		return dao.selectMypage(memberNo);
	}

	@Override
	public int updateProfileImage(MultipartFile profile, String webPath, String filePath, Member loginMember)  throws IllegalStateException, IOException {
		
		// 프로필 이미지 변경 실패 대비
				String temp = loginMember.getProfileImage(); // 이전 이미지 저장 
				
				String rename = null; // 변경 이름 저장 변수
				
				if(profile.getSize() > 0) {
					// 업로드된 이미지가 있을 경우  
					
					// 1) 파일 이름 변경 
					rename = Util.fileRename(profile.getOriginalFilename());
					
					// 2) 바뀐 이름 loginMember에 세팅
					loginMember.setProfileImage(webPath + rename);
												
				}else {
					//없는 경우(x버튼)
					loginMember.setProfileImage(null);
					// 세션 이미지를 null로 변경해서 삭제 
					
				}
				
				// 프로필 이미지 수정 DAO 메소드 호출
				int result = dao.updateProfileImage(loginMember);
				
				if(result > 0) {
					// 성공
					// 새 이미지가 업로드 된 경우
					if(rename != null) {
						profile.transferTo(new File(filePath + rename));
					}
				}else {
					// 실패
					// 이전 이미지로 프로필 다시 세팅
					loginMember.setProfileImage(temp);
				}
				
				return result;
			}

	// 일치하는 회원의 수
	@Override
	public int memberCheck(Member member) {
	
		return dao.memberCheck(member);
	}

	// 휴대폰 인증
	@Override
	public String memberPhoneCheck(String memberTel) throws CoolsmsException {
		String api_key = "NCSDPAWVSKNIKY0W";
		String api_secret = "RJDCDQVB6H6E0HEURDJ8OVOE9SZW54OV";
		net.nurigo.java_sdk.api.Message coolsms = new net.nurigo.java_sdk.api.Message(api_key, api_secret);
			
		
		Random rand = new Random(); 
		String numStr = "";
		for(int i=0; i<6; i++) {
			String ran = Integer.toString(rand.nextInt(10)); 
			numStr += ran;
		}
		  
		HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", memberTel);    // 수신전화번호 (ajax로 view 화면에서 받아온 값으로 넘김)
	    params.put("from", "01026233745");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
	    params.put("type", "sms"); 
	    params.put("text", "[MoneyMate] 비밀번호 찾기 인증번호는 [" + numStr + "] 입니다.");
	    
	    System.out.println(params);
	 
	    coolsms.send(params); // 메시지 전송
			  
			  
		return numStr;
	}

	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int changePw(String newPw, String memberEmail, String memberTel) {
		return dao.changePw(bcrypt.encode(newPw), memberEmail, memberTel);
	}
		
		

}


