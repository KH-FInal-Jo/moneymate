package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.JMemberDAO;

@Service
public class JMemberServiceImpl implements JMemberService{

	@Autowired
	private JMemberDAO dao;
}
