package edu.kh.project.board.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.service.CBoardService;
import edu.kh.project.member.model.dto.Member;

@Controller
@SessionAttributes("loginMember")
@RequestMapping("/community")
public class CBoardController {

	@Autowired
	private CBoardService service;

	// 게시글 목록 조회
	@GetMapping("/3")
	public String selectCBoardList(@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			Model model, @RequestParam Map<String, Object> paramMap) {

		int boardCode = 3;

		if (paramMap.get("key") == null) {
			Map<String, Object> map = service.selectBoardList(boardCode, cp);

			model.addAttribute("map", map);

		} else { // 검색 O

			paramMap.put("boardCode", 3);

			Map<String, Object> map = service.selectBoardList(paramMap, cp);

			model.addAttribute("map", map);
		}

		return "board/CBoardList";
	}

	// 게시글 상세조회
	@GetMapping("/3/{boardNo}")
	public String boardDetail(@PathVariable("boardNo") int boardNo, Model model, RedirectAttributes ra,
			@SessionAttribute(value = "loginMember", required = false) Member loginMember, HttpServletRequest req,
			HttpServletResponse resp) throws ParseException {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("boardCode", 3);
		map.put("boardNo", boardNo);

		CBoard board = service.selectBoard(map);

		String path = null;

		if (board != null) {
			if (loginMember != null) {
				map.put("memberNo", loginMember.getMemberNo());

				int result = service.boardLikeCheck(map);
				
				if(result>0) model.addAttribute("likeCheck", "on");
			}
		}
		model.addAttribute("board", board);

		return "board/CboardDetail";
	}

	// 글쓰기 페이지로 이동
	@GetMapping("/3/insert")
	public String boardWrite() {
		return "board/CBoardWrite";
	}

	// 글쓰기
	@PostMapping("/3/insert")
	public String boardWrite(CBoard board, @RequestParam(value = "images", required = false) List<MultipartFile> images,
			@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra, HttpSession session)
			throws IllegalStateException, IOException {

		board.setMemberNo(loginMember.getMemberNo());
		board.setBoardCode(3);

		String webPath = "/resources/images/board/";
		String filePath = session.getServletContext().getRealPath(webPath);

		int boardNo = service.boardInsert(board, images, webPath, filePath);

		String message = null;
		String path = "redirect:";

		if (boardNo > 0) { // 성공 시

			message = "게시글이 등록되었습니다.";
			path += "/community/3/" + boardNo;

		} else { // 실패 시
			message = "게시글 등록 실패";
			path += "insert";
		}

		ra.addFlashAttribute("message", message);

		return path;
	}

	@PostMapping("/like")
	@ResponseBody // 반환되는 값이 비동기 요청한 곳으로 돌아가게 함
	public int like(@RequestBody Map<String, Integer> paramMap) {


		return service.like(paramMap);
	}

}
