package edu.kh.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.CBoardDAO;
import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CBoardImage;
import edu.kh.project.board.model.dto.CPagination;
import edu.kh.project.board.model.exception.FileUploadException;
import edu.kh.project.board.model.exception.ImageDeleteException;
import edu.kh.project.common.utility.Util;

@Service
public class CBoardServiceImpl implements CBoardService {

	@Autowired
	private CBoardDAO dao;

	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {


		int listCount = dao.getListCount(boardCode);

		CPagination pagination = new CPagination(cp, listCount);

		List<CBoard> boardList = dao.selectBoardList(pagination, boardCode);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("pagination", pagination);
		map.put("boardList", boardList);

		return map;
	}

	// 검색시 게시글 목록 조회
	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp) {
		
				// 1. 특정 게시판의 삭제되지 않고 검색 조건이 일치하는 게시글 수 조회
				int listCount = dao.getListCount(paramMap);

				// 2. 1번의 조회 결과 + cp를 이용해서 페이지네이션 객체 생성
				// -> 내부 필드가 계산되어서 모두 초기화 됨
				CPagination pagination = new CPagination(cp, listCount);
				
				// 3. 특정 게시판에서 
				// 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
				// + 단, 검색 조건이 일치하는 글만
				List<CBoard> boardList = dao.selectBoardList(pagination, paramMap);

				// 4. pagination, boardList를  Map에 담아서 반환
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("pagination", pagination);
				map.put("boardList", boardList);

				return map;
	}

	// 게시글 상세 조회
	@Override
	public CBoard selectBoard(Map<String, Object> map) {
		return dao.selectBoard(map);
	}


	// 게시글 작성
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int boardInsert(CBoard board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException {

		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));

		int boardNo = dao.boardInsert(board);

		if(boardNo > 0) {
			List<CBoardImage> uploadList = new ArrayList<CBoardImage>();

			for(int i = 0 ; i < images.size() ; i++) {
				if(images.get(i).getSize() > 0) {
					CBoardImage img = new CBoardImage();

					img.setImagePath(webPath); // 웹 접근 경로
					img.setBoardNo(boardNo); // 게시글 번호
					img.setImageOrder(i); // 이미지 순서

					String fileName = images.get(i).getOriginalFilename();
					img.setImageOriginal(fileName); // 원본명
					img.setImageReName(Util.fileRename(fileName)); // 변경명

					uploadList.add(img);
				}
			}

			if(!uploadList.isEmpty()) {
				int result = dao.insertImageList(uploadList);

				if(result == uploadList.size()) {
					for(int i = 0; i<uploadList.size(); i++) {

						int index = uploadList.get(i).getImageOrder();

						// 파일로 변환
						String rename = uploadList.get(i).getImageReName();

						images.get(index).transferTo(new File(filePath + rename));
					}
				} else {
					throw new FileUploadException();
				}
			}
		}
		return boardNo;
	}

	// 좋아요 여부 확인
	@Override
	public int boardLikeCheck(Map<String, Object> map) {
		return dao.boardLikeCheck(map);
	}



	// 좋아요 
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int like(Map<String, Integer> paramMap) {

		int result = 0;

		if(paramMap.get("check") == 0) { // 좋아요 상태가 X
			// BOARD_LIKE 테이블 INSERT
			result = dao.insertBoardLike(paramMap);
		} else { // 좋아요 상태 
			// BOARD_LIKE 테이블 DELETE
			result = dao.deleteBoardLike(paramMap);
		}


		if(result == 0) return -1;

		// 현재 게시글의 좋아요 개수 조회
		int count = dao.CountBoardLike(paramMap.get("boardNo"));

		return count;
	}

	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int updateReadCount(int boardNo) {
		return dao.updateReadCount(boardNo);
	}

	
	// 게시글 수정
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int boardUpdate(CBoard board, List<MultipartFile> images, String webPath, String filePath,
			String deleteList) throws IllegalStateException, IOException {

		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));

		int rowCount = dao.boardUpdate(board);

		// 게시글 부분 수정 성공 시
		if(rowCount > 0) {

			// 삭제할 이미지가 있다면
			if(!deleteList.equals("")) { // 미친 String equals 쓰라고 젭ㅂㅏㄹ ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ

				// 3. deleteList에 작성된 이미지 모두 삭제
				Map<String, Object> deleteMap = new HashMap<String, Object>();

				deleteMap.put("boardNo", board.getBoardNo());
				deleteMap.put("deleteList", deleteList);

				rowCount = dao.imageDelete(deleteMap);

			}

			if(rowCount == 0) { // 이미지 삭제 실패 시 전체 롤백

				// 예외 강제 발생
				throw new ImageDeleteException();
			}

		}

		// 4. 새로 업로드된 이미지 분류 작업

		// images : 실제 파일이 담긴 List
		// 		-> input type = "file" 개수만큼 요소가 존재
		// 		-> 제출된 파일이 없어도 MultipartFile 객체 존재

		List<CBoardImage> uploadList = new ArrayList<CBoardImage>();

		// images에 담겨 있는 파일 중 실제 업로드된 파일만을 분류
		for(int i = 0; i<images.size(); i++) {

			// i번째 요소에 업로드한 파일이 있다면
			if(images.get(i).getSize() > 0) {
				CBoardImage img = new CBoardImage();

				// img에 파일 정보를 담아서 uploadList 추가
				img.setImagePath(webPath); // 웹 접근 경로
				img.setBoardNo(board.getBoardNo()); // 게시글 번호
				img.setImageOrder(i); // 이미지 순서

				// 파일 원본명
				String fileName = images.get(i).getOriginalFilename();
				img.setImageOriginal(fileName); // 원본명
				img.setImageReName(Util.fileRename(fileName)); // 변경명

				uploadList.add(img);


				// 오라클은 다중 UPDATE 지원하지 않기 때문에 하나씩 UPDATE 수행
				rowCount = dao.imageUpdate(img);

				if(rowCount == 0) {
					// 수정 실패 == DB에 이미지가 없었다 == INSERT
					rowCount = dao.imageInsert(img); // insert 실패 시에는 예외 처리 안 해주나?

				}
			}

		} // 분류 for문 종료

		// 5. uploadList에 있는 이미지들만 서버에 저장(transferTo)
		if(!uploadList.isEmpty()) {

			for(int i = 0;  i<uploadList.size(); i++) {
				int index = uploadList.get(i).getImageOrder();

				String rename = uploadList.get(i).getImageReName();

				images.get(index).transferTo(new File(filePath + rename));
			}
		}


		return rowCount;
	}

	// 게시글 삭제
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int boardDelete(int boardNo) {
		int result = dao.boardDelete(boardNo);
		return result;
	}


}
