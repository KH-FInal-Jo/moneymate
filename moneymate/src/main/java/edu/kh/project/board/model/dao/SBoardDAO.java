package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.SBoard;
import edu.kh.project.board.model.dto.SBoardImage;

@Repository
public class SBoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	




	/** 칼럼 게시글 삽입
	 * @param board 
	 * @param paramMap 
	 * @return
	 */
	public int boardInsert(SBoard board, Map<String, Object> paramMap) {
		
		int result = sqlSession.insert("SBoardMapper.columnInsert", paramMap);
		// -> SQL 수행 후 매개변수 board 객체에는 boardNo가 존재한다.
		
		if(result > 0) {
			result = (int)paramMap.get("boardNo");
		}
		
		System.out.println("DAO boardNO 값 확인 : " + result);
		
		return result;
	}





	/** 이미지 리스트 삽입
	 * @param uploadList
	 * @return
	 */
	public int insertImageList(List<SBoardImage> uploadList) {
		
		return sqlSession.insert("SBoardMapper.insertImageList", uploadList);
	}

}
