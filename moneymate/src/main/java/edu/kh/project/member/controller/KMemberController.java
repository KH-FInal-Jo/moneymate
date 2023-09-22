package edu.kh.project.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.JMember;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.KMemberService;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@SessionAttributes("loginMember")
@Controller
@RequestMapping("/member")
public class KMemberController {

	@Autowired
	private KMemberService service;

	// 내 정보 페이지로 이동
	@GetMapping("/info")
	public String info() {

		// ViewResolver 설정 -> servlet-context.xml
		return "myPage/myPage-info";
	}

	// 프로필 이동
	@GetMapping("/member/mypage")
	public String profile() {

		return "member/KmyInfo";
	}


	// 비밀번호 변경 페이지 이동
	@GetMapping("/mypage/findPw")
	public String myPagefindPw() {

		return "member/myPagefindPw";
	}


	// 마이페이지 상세조회
	@GetMapping("/mypage")
	public String KmyInfo(@SessionAttribute("loginMember") Member loginMember
			, Model model) {

		int memberNo = loginMember.getMemberNo();

		List<JMember> memberList = service.selectMypage(memberNo);

		model.addAttribute("memberList",memberList);

		return "/member/KmyInfo";
	}

	@PostMapping("/mypage")
	public String myInfo(Member updateMember, String[]memberAddress
			, @SessionAttribute("loginMember")Member loginMember
			, RedirectAttributes ra 
			, @RequestParam("profile")MultipartFile profile // 업로드한 파일
			, HttpSession session )  throws IllegalStateException, IOException {

		updateMember.setMemberNo(loginMember.getMemberNo());
		String webPath = "/resources/images/member/";
		

		// 실제로 이미지 파일이 저장되어야 하는 서버 컴퓨터 경로
		String filePath = session.getServletContext().getRealPath(webPath);
		// 프로필 이미지 수정 서비스 호출
		int result = service.updateProfileImage(profile,webPath, filePath,loginMember);
		
		if(result > 0) {
			
			
			
			String addr = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(addr);
			int result1 = service.updateInfo(updateMember);
			System.out.println("loginMember");
			
			String message = null;
			if(result1 > 0) {
				message = "회원 정보가 수정되었습니다.";					
				loginMember.setMemberNickname(updateMember.getMemberNickname());
				loginMember.setMemberTel(updateMember.getMemberTel());
				loginMember.setMemberAddress(updateMember.getMemberAddress());
			}else {
				message = "회원 정보 수정 실패..";
			}
			
			ra.addFlashAttribute("message",message);
		}
		return "/member/KmyInfo";



	}

// 비밀	
	@PostMapping("/mypage/findPw")
	public String ChangePw( String Password, String newPassword
			, @SessionAttribute("loginMember")Member loginMember
			, RedirectAttributes ra) {

		int memberNo = loginMember.getMemberNo();

		int result = service.changePw(Password, newPassword, memberNo);

		String path = "redirect:";
		String message = null;

		if(result>0) {
			message="비밀번호가 변경 되었습니다.";
			path += "/";

		}else {
			message="비밀번호가 틀립니다.";
			path += "/member/mypage/findPw";
		}
		ra.addFlashAttribute("message", message);

		return path;


	}

	// 프로필 이미지 수정
	@PostMapping("/member/KmyInfo")
	public String updateProfileImage(
			@RequestParam("profile")MultipartFile profile // 업로드한 파일
			,@SessionAttribute("loginMember") Member loginMember // 로그인한 회원
			,RedirectAttributes ra // 리다이렉트 시 메세지 전달
			,HttpSession session // 세션 객체
			) throws IllegalStateException, IOException {

		System.out.println("profile" + profile);
		// 웹 접근 경로
		String webPath = "/resources/images/member/";

		// 실제로 이미지 파일이 저장되어야 하는 서버 컴퓨터 경로
		String filePath = session.getServletContext().getRealPath(webPath);

		// 프로필 이미지 수정 서비스 호출
		int result = service.updateProfileImage(profile,webPath, filePath,loginMember);

		String message = null;
		if(result > 0) message = "프로필 이미지가 변경되었습니다.";
		else		   message = "프로필 변경 실패";

		ra.addFlashAttribute("message",message);

		return "redirect:/member/KmyInfo";
	}
	
	@GetMapping("/findId")
	public String findId() {
		return "/member/KfindId";
	}
	@GetMapping("/findPw")
	public String findPw() {
		return "/member/KfindPw";
	}

	@GetMapping("/findPw1")
	@ResponseBody
	public String findPw(Member member, String memberTel) throws CoolsmsException {
		
		int count = service.memberCheck(member);
		System.out.println(count);
		
		String numStr = "";
		
		System.out.println(memberTel);
		
		if(count > 0) {
			
			
			numStr = service.memberPhoneCheck(memberTel); 
			
		}
		
		System.out.println("numStr : " + numStr);
		
		
		
		
		
		return numStr;
	}
	
	

}



