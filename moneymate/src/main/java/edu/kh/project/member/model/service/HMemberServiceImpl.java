package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.HMemberDAO;

@Service
public class HMemberServiceImpl implements HMemberService {
	
	@Autowired
	private HMemberDAO dao;

}
