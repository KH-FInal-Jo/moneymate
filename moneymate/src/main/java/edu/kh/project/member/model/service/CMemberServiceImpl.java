package edu.kh.project.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CPagination;
import edu.kh.project.board.model.dto.CPagination2;
import edu.kh.project.member.model.dao.CMemberDAO;
import edu.kh.project.member.model.dto.Member;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class CMemberServiceImpl implements CMemberService {
	
	@Autowired
	private CMemberDAO dao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	
	private String fromEmail = "rjh65395@gmail.com";
	private String fromUsername = "moneymate";
	
	
	// 로그인
	@Override
	public Member login(Member inputMember) {
		
		Member loginMember = dao.login(inputMember);
		
		
		if(loginMember != null) { 
			
			
			
			if(bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) { // 같을 경우
				
				// 비밀번호를 유지하지 않기 위해서 로그인 정보에서 제거
				loginMember.setMemberPw(null);
				
			} else { // 다를 경우
				loginMember = null; // 로그인 실패처럼 만듦
			}
			
		}
		
		return loginMember;
	}

	
	// 회원가입
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int signUp(Member inputMember) {
		
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		
		inputMember.setMemberPw(encPw);
		
		int result = dao.signUp(inputMember);
		
		return result;
	}

	// 회원탈퇴
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int secession(String memberPw, int memberNo) {
		// 회원번호 일치하는 회원의 비밀번호 조회
		String encPw = dao.selectEncPw(memberNo);

		// 비밀번호 일치하면
		if(bcrypt.matches(memberPw, encPw)) {
			return dao.secession(memberNo);
		}

		return 0;	
		
	}

	
	// 이메일 중복 검사
	@Override
	public int emailDupCheck(String email) {
		return dao.emailDupCheck(email);
	}


	
	
	
	@Override
	public String createAuthKey() {
		String key = "";
		for(int i=0 ; i< 6 ; i++) {

			int sel1 = (int)(Math.random() * 3); // 0:숫자 / 1,2:영어

			if(sel1 == 0) {

				int num = (int)(Math.random() * 10); // 0~9
				key += num;

			}else {

				char ch = (char)(Math.random() * 26 + 65); // A~Z

				int sel2 = (int)(Math.random() * 2); // 0:소문자 / 1:대문자

				if(sel2 == 0) {
					ch = (char)(ch + ('a' - 'A')); // 소문자로 변경
				}

				key += ch;
			}

		}
		return key;
	}
	
	
	
	
	
	
	
	// 회원가입 이메일 인증
	@Transactional
	@Override
	public int signUp(String email, String title) {
		String authKey = createAuthKey();
		try {

			MimeMessage mail = mailSender.createMimeMessage();

			String subject = "[moneymate]"+title+" 인증코드";

			String charset = "UTF-8";

			String mailContent 
			= "<p>moneymate" + title + " 인증코드입니다.</p>"
					+ "<h3 style='color:blue'>" + authKey + "</h3>";



			mail.setFrom(new InternetAddress(fromEmail, fromUsername));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			// 수신자(받는사람) 지정

			// 이메일 제목 세팅
			mail.setSubject(subject, charset);

			// 내용 세팅
			mail.setText(mailContent, charset, "html"); //"html" 추가 시 HTML 태그가 해석됨

			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("authKey", authKey);
		map.put("email", email);
		
        System.out.println(map); 


		int result = dao.updateAuthKey(map);

		if(result == 0) {
			result = dao.insertAuthKey(map);
		}



		return result;
	}


	@Override
	public int checkAuthKey(Map<String, Object> paramMap) {
		return dao.checkAuthKey(paramMap);
	}


	// 내가 쓴글 목록 조회 
	@Override
	public Map<String, Object> selectMyBoard(int cp, int myNum) {
		
		int listCount = dao.getListCount(myNum);

		CPagination2 pagination = new CPagination2(cp, listCount);
		
		List<CBoard> boardList = dao.selectMyBoard(pagination, myNum);
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

	// 검색시 내가 쓴 게시글 목록 조회
	@Override
	public Map<String, Object> selectMyBoard(Map<String, Object> paramMap, int cp) {
		
		int listCount = dao.getListCount(paramMap);
		
		CPagination2 pagination = new CPagination2(cp, listCount);
		
		List<CBoard> boardList = dao.selectBoardList(pagination, paramMap);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("boardList", boardList);

		return map;
	}


	@Override
	public int nicknameDupCheck(String nickname) {
		return dao.nicknameDupCheck(nickname);
	}


	@Override
	public String memberPhoneCheck(String mTel) throws CoolsmsException {
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
	    params.put("to", mTel);    // 수신전화번호 (ajax로 view 화면에서 받아온 값으로 넘김)
	    params.put("from", "01032702918");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
	    params.put("type", "sms"); 
	    params.put("text", "[MoneyMate] 회원가입 인증번호는 [" + numStr + "] 입니다.");
	    
        System.out.println(params);
	    
	 
	    coolsms.send(params); // 메시지 전송
			  
			  
		return numStr;
	}


	@Override
	public int dupCheckTestResult(Member member) {
		return dao.dupCheckTestResult(member);
	}


	
	@Override
	public int insertTestResult(Member member) {
		return dao.insertTestResult(member);
	}


	@Override
	public int updateTestResult(Member member) {
		return dao.updateTestResult(member);
	}

}
