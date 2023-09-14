package edu.kh.project.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HAdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

}
