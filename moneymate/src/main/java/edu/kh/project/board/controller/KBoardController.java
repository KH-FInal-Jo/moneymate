package edu.kh.project.board.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.KBoard;
import edu.kh.project.board.model.dto.KBoard;
import edu.kh.project.board.model.dto.KBoard;
import edu.kh.project.board.model.service.KBoardService;
import edu.kh.project.member.model.dto.Member;

@SessionAttributes({"loginMember"})
@RequestMapping("/community")
@Controller
public class KBoardController {

	@Autowired
	private KBoardService service;

	@GetMapping("/{boardCode:[2]}")
	public String selectboardInquiry(@PathVariable("boardCode")int boardCode, @RequestParam(value="cp", required = false, defaultValue = "1")int cp
			, Model model
			, @RequestParam Map<String, Object> paramMap // 전달받은 파라미터가 전부다 담겨있다.
			) {




		if(paramMap.get("key") ==null) {
			Map<String, Object> map = service.selectboardInquiry(boardCode, cp);
			model.addAttribute("map", map);

			System.out.println(map);
		}


		return "board/boardInquiry";
	}
	
	// 상세 화면 전환
	@GetMapping("/2/{boardNo}")
	public String selectboardInquiryDetail(@PathVariable("boardNo")int boardNo
										,Model model, RedirectAttributes ra) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardCode",2);
		map.put("boardNo",boardNo);
				
		KBoard board = service.selectboardInquiryDetail(map);
		
		String path = null;
		
		if(board != null) { // 조회 결과가 있을 경우
			//-------------------------------------------
			// 현재 로그인 상태인 경우
			// 로그인한 회원이 해당 게시글에 좋아요 눌렀는지 확인
			
						
			// forward할 jsp 경로
			path = "board/boardInquiryDetail";
			model.addAttribute("board",board);
		}else { // 조회 결과가 없을 경우
			path =  "redirect:/community/2";
			
			ra.addFlashAttribute("message","해당 게시글이 존재하지 않습니다.");
		}
		
		return path;
	}
	
	
	
	
	
	// 게시글 작성 화면 전환
	@GetMapping("/2/boardInquiryWrtie")
	public String selectboardInquiryWrtie() {

		return "board/boardInquiryWrtie";
	}
	// 게시글 작성
	@PostMapping("/2/insert/boardInsert")
	public String boardInsert(
			KBoard board // 커맨드 객체
			, @SessionAttribute("loginMember")Member loginMember // 로그인한 회원 번호
			, RedirectAttributes ra // 리다이렉트시에 데이터 전달
			, HttpSession session // 파일 저장 경로
			, @RequestParam(value="cp", required = false, defaultValue = "1")int cp
			)throws IllegalStateException, IOException {


		// 로그인한 회원번호 얻어와서 board에 세팅
		board.setMemberNo(loginMember.getMemberNo());

		// 2도 board에 세팅
		board.setBoardCode(2);


		int boardNo = service.boardInsert(board); // 서비스로 연결

		String message = null;
		String path = "redirect:";

		if(boardNo > 0 ) {
			// 성공 시
			System.out.println("ㅎ::" + boardNo);
			System.out.println("ㅎ::" + cp);
			message = "게시글이 등록 되었습니다.";
			path += "/community/2/" + boardNo +"?cp=" + cp;
		}else {
			message = "게시글 등록 실패..";
			path += "insert";
		}

		ra.addFlashAttribute("message", message);

		return path;

	}


	// 게시글 수정 화면 전환
	@GetMapping("/2/{boardNo}/update")
	public String boardUpdate(@PathVariable("boardNo") int boardNo
			, Model model // 데이터 전달용 객체
			) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("boardNo", boardNo);
		map.put("boardCode", 2);


		
		KBoard board = service.selectboardInquiryDetail(map);

		model.addAttribute("board",board);

		return "board/boardInquiryUpdate";

	}

	@PostMapping("/2/{boardNo}/update")
	public String boardUpdate(
			  KBoard board // 커맨드 객체(name == 필드 경우 필드에 파라미터 세팅)
			, @RequestParam(value="cp", required=false, defaultValue="1")int cp // 쿼리스트링 유지하기 위해서
			, @PathVariable("boardNo") int boardNo
			, RedirectAttributes ra // 리다이렉트 시 값 전달용
			)throws IllegalStateException, IOException {
		
		
		String message = null;
		String path = "redirect:";
		
		board.setBoardCode(2);
		board.setBoardNo(boardNo);
		
		int rowCount = service.boardUpdate(board);
		
		
		if(rowCount > 0) {
			message = "게시글이 수정되었습니다.";
			path += "/community/2/"  + boardNo + "?cp=" + cp; // 상세조회 페이지
			
		}else {
			message = "게시글 수정 실패";
			path += "update";
		}
		
		ra.addFlashAttribute("message", message);

		
		return path;
		
	}


}
