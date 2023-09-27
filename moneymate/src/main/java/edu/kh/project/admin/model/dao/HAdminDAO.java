package edu.kh.project.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.admin.model.dto.HHPagination;
import edu.kh.project.member.model.dto.JMember;

@Repository
public class HAdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 회원 수 조회
	 * @return memberCount
	 */
	public int getMemberCount() {
		return sqlSession.selectOne("HAdminMapper.memberCount");
	}
	
	/** 검색 조건에 맞는 회원 수 
	 * @param paramMap
	 * @return memberCount
	 */
	public int getmemberCount(Map<String, Object> paramMap) {
		return sqlSession.selectOne("HAdminMapper.getmemberCount", paramMap);
	}


	/** 회원 목록 조회
	 * @param pagination
	 * @return
	 */
	public List<JMember> memberList(HHPagination pagination) {
		
		int offset
		= (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("HAdminMapper.memberList" , null, rowBounds);
	}
	
	/** 검색 조건에 맞는 회원 목록 조회
	 * @param pagination
	 * @param paramMap
	 * @return memberList
	 */
	public List<JMember> selectMemberList(HHPagination pagination, Map<String, Object> paramMap) {
		
		int offset
		= (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		// 3) selectList("namespace.id", 파라미터, Rowbounds) 호출
		return sqlSession.selectList("HAdminMapper.selectMemberList", paramMap, rowBounds);
	}

	/** 마일리지 업데이트
	 * @param member
	 * @return result
	 */
	public int mile(Map<String, Object> paramMap) {
		return sqlSession.update("HAdminMapper.mile", paramMap);
	}

	/** 회원 탈퇴
	 * @param no
	 * @return result
	 */
	public int secession(int no) {
		return sqlSession.update("HAdminMapper.secession", no);
	}

	/** 자동완성
	 * @param query
	 * @return mList
	 */
	public List<JMember> selectMember(String query) {
		return sqlSession.selectList("HAdminMapper.selectMember", query);
	}

	/** 채팅 신고 수 조회
	 * @return
	 */
	public int reportCount() {
		return sqlSession.selectOne("HAdminMapper.reportCount");
	}

	/** 채팅 신고 목록 조회
	 * @param pagination
	 * @return
	 */
	public List<JMember> selectReportList(HHPagination pagination) {
		int offset
		= (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("HAdminMapper.reportList" , null, rowBounds);
	}

	public int reportConfirm(Map<String, Object> paramMap) {
		return sqlSession.update("HAdminMapper.reportConfirm", paramMap);
	}

	
}
