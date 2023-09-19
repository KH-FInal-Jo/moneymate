package edu.kh.project.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		
		return sqlSession.selectList("CAdminMapper.selectReportList", rowBounds);
	}

}
