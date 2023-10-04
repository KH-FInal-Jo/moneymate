package edu.kh.project.account.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.account.model.dao.HAccountDAO;
import edu.kh.project.account.model.dto.HAccount;
import edu.kh.project.member.model.dto.Member;

@Service
public class HAccountServiceImpl implements HAccountService{
	
	@Autowired
	private HAccountDAO dao;
	
	@Autowired
	private JavaMailSender mailSender;

	// 가계부 목록 조회
	@Override
	public Map<String, Object> accountList(Member loginMember) {
		
		// 개인 가계부 조회
		List<HAccount> pList = dao.pList(loginMember);
		
		// 그룹 가계부 조회
		List<HAccount> gList = dao.gList(loginMember);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pList", pList);
		map.put("gList", gList);
		
		return map;
	}

	// 이메일 회원 검사
	@Override
	public int dupEmail(String memberEmail) {
		
		return dao.dupCheck(memberEmail);
	}

	// 가계부 생성(개인)
	@Transactional (rollbackFor = {Exception.class})
	@Override
	public int pAccount(HAccount account) {
		return dao.pAccount(account);
	}

	// 가계부 생성(그룹)
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int gAccount(HAccount account, String[] gEmail) {
		
		int result = 0;
		
		try {
			
			result = dao.insertGroup(account); // 가계부 insert(그룹)
			
			for(String email : gEmail) {
				
				String authKey = createAuthKey();
				
				
				//인증메일 보내기
				MimeMessage mail = mailSender.createMimeMessage();
				
				// 제목
				String subject = "[MoneyMate] 가계부 초대";
				
				// 문자 인코딩
				String charset = "UTF-8";
				
				// 메일 내용
				String mailContent 
				= "<h1>[MoneyMate] 가계부 초대 링크입니다.</h1>"
						+ "<button style=\"width: 120px; height: 30px; background-color: lightblue; border: 0; \">" 
						+ "<a href='http://localhost/accounted/invite/" + authKey + "'"
						+ "style='text-decoration: none; color: black; font-weight: bold;'"
						+">" 
						+ "초대장 바로가기</a>" 
						+ "</button>";
				
				// 송신자(보내는 사람) 지정
				mail.setFrom(new InternetAddress("rjh65395@gmail.com", "MoneyMate"));
				mail.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
				
				// 수신자(받는사람) 지정
				
				// 이메일 제목 세팅
				mail.setSubject(subject, charset);
				
				// 내용 세팅
				mail.setText(mailContent, charset, "html"); //"html" 추가 시 HTML 태그가 해석됨
				
				mailSender.send(mail);
				
				// 그룹 초대 테이블에 insert하기
				
				
				account.setMemberEmail(email);
				account.setAuthKey(authKey);
				
				
				
				
				if(result>0) {
					result = dao.group(account);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return 0;
	}

	// 인증키 생성 메소드
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

	// 가계부 초대 수락
	@Override
	public int inviteAccept(String key) {
		return dao.inviteAccept(key);
	}

}
