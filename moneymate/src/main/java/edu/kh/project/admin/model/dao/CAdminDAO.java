package edu.kh.project.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.admin.model.dto.CPay;
import edu.kh.project.board.model.dto.CPagination;
import edu.kh.project.board.model.dto.CReport;

@Repository
public class CAdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getListCount() {
		return sqlSession.selectOne("CAdminMapper.getListCount");
	}

	public List<CReport> selectReportList(CPagination pagination) {
		
		int offset
		= (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("CAdminMapper.selectReportList", null,rowBounds);
	}

	public int reportConfirm(Map<String, Object> paramMap) {
		return sqlSession.update("CAdminMapper.reportConfirm", paramMap);
	}

	public int reportDupCheck(Map<String, Object> paramMap) {
		return sqlSession.selectOne("CAdminMapper.reportDupCheck", paramMap);
	}

	public int getPayCount() {
		
		return sqlSession.selectOne("CAdminMapper.getPayCount");
	}

	public List<CPay> selectPayList(CPagination pagination) {

		int offset
		= (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("CAdminMapper.selectPayList", null, rowBounds);
	}

	public int getPayCount(Map<String, Object> paramMap) {
		return sqlSession.selectOne("CAdminMapper.getPayCount_search", paramMap);
	}

	public List<CPay> selectPayList(CPagination pagination, Map<String, Object> paramMap) {
		
		int offset
		= (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("CAdminMapper.selectPayList_search", paramMap, rowBounds);
	}

}
