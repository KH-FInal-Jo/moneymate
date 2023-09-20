package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.SBoard;

@Repository
public class SBoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	


	/** 칼럼 게시글 등록
	 * @param paramMap
	 * @param images 
	 * @param board 
	 * @return
	 */
	public int boardInsert(Map<String, Object> paramMap, SBoard board, List<MultipartFile> images) {
		// TODO Auto-generated method stub
		return sqlSession.insert("SBoardMapper.columnInsert", paramMap);
	}

}
