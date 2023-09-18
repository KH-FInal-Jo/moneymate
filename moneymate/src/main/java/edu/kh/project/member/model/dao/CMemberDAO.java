package edu.kh.project.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.CBoard;
import edu.kh.project.board.model.dto.CPagination;
import edu.kh.project.board.model.dto.CPagination2;
import edu.kh.project.member.model.dto.Member;

@Repository
public class CMemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	// 로그인
	public Member login(Member inputMember) {
		
		return sqlSession.selectOne("CmemberMapper.login", inputMember);
	}


	// 회원가입
	public int signUp(Member inputMember) {
		return sqlSession.insert("CmemberMapper.signUp", inputMember);
	}

	// 회원 비밀번호 조회
	public String selectEncPw(int memberNo) {
		return sqlSession.selectOne("CmemberMapper.selectEncPw", memberNo);
	}

	// 회원탈퇴
	public int secession(int memberNo) {
		return sqlSession.update("CmemberMapper.secession", memberNo);
	}


	public int emailDupCheck(String email) {
		return sqlSession.selectOne("CmemberMapper.emailDupCheck", email);
	}


	public int updateAuthKey(Map<String, String> map) {
		return sqlSession.update("CmemberMapper.updateAuthKey", map);
	}


	public int insertAuthKey(Map<String, String> map) {
		return sqlSession.update("CmemberMapper.insertAuthKey", map);
	}


	public int checkAuthKey(Map<String, Object> paramMap) {
		return sqlSession.selectOne("CmemberMapper.checkAuthKey", paramMap);
	}


	// 내가 쓴글 갯수 조회
	public int getListCount(int myNum) {
		return sqlSession.selectOne("CmemberMapper.getListCount", myNum);
	}


	// 내가 쓴 글 목록 조회
	public List<CBoard> selectMyBoard(CPagination2 pagination, int myNum) {
		
		int offset
		= (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("CmemberMapper.selectMyBoard",  myNum, rowBounds);
	}

	// 검색 시 게시글 수 조회
	public int getListCount(Map<String, Object> paramMap) {
		
		
		return sqlSession.selectOne("CmemberMapper.getListCount_search", paramMap);
	}

	
	// 검색 시 게시글 목록 조회
	public List<CBoard> selectBoardList(CPagination2 pagination, Map<String, Object> paramMap) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("CmemberMapper.selectBoardList_search", paramMap, rowBounds);
	}

}
