package edu.kh.project.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.JMember;
import edu.kh.project.member.model.dto.Member;

@Repository
public class KMemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int updateInfo(Member updateMember) {
		
		return sqlSession.update("KmemberMapper.updateInfo", updateMember);
	}

	// 비밀번호 변경DAO
	public int changePw(String newPassword, int memberNo) {
		Member member = new Member();
		member.setMemberNo(memberNo);
		member.setMemberPw(newPassword);
		
		return sqlSession.update("KmemberMapper.changePw", member);
	}


	// 마이페이지 조회
	public List<JMember> selectMypage(int memberNo) {
		return sqlSession.selectList("JMemberMapper.selectMypage", memberNo);
	}


	/**이미지 변경
	 * @param loginMember
	 * @return result
	 */
	public int updateProfileImage(Member loginMember) {
		return sqlSession.update("KmemberMapper.updateProfileImage", loginMember);
	}


	public int memberCheck(Member member) {
		return sqlSession.selectOne("KmemberMapper.memberCheck", member);
	}

	
	/** 회원 비밀번호 조회
	 * @param memberNo
	 * @return
	 */
	public String selectEncPw(int memberNo) {
		
		return sqlSession.selectOne("KmemberMapper.selectEncPw", memberNo);
	}
	
	
}
