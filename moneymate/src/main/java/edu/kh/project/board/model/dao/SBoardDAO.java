package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.SBoard;
import edu.kh.project.board.model.dto.SBoardImage;
import edu.kh.project.member.model.dto.Member;

@Repository
public class SBoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	




	/** 칼럼 게시글 삽입
	 * @param board 
	 * @return
	 */
	public int boardInsert(SBoard board) {
		
		int result = sqlSession.insert("SBoardMapper.columnInsert", board);
		// -> SQL 수행 후 매개변수 board 객체에는 boardNo가 존재한다.
		
		if(result > 0) {
			result = board.getBoardNo();
		}
		
		System.out.println("DAO boardNO 값 확인 : " + result);
		
		return result;
	}





	/** 칼럼 게시글 이미지 삽입
	 * @param uploadList
	 * @return
	 */
	public int insertImageList(List<SBoardImage> uploadList) {
		return sqlSession.insert("SBoardMapper.insertImageList", uploadList);
	}





	/** 칼럼 게시글 목록 조회
	 * @param loginMember
	 * @return columnList
	 */
	public List<SBoard> columnList(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SBoardMapper.columnList", memberNo);
	}





	/** 이전 게시글 번호 구하기
	 * @param boardNo
	 * @return
	 */
	public int columnPrevieous(int boardNo) {
		return sqlSession.selectOne("SBoardMapper.columnPrevieous", boardNo);
	}






}
