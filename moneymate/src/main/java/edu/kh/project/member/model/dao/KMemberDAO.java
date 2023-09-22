package edu.kh.project.member.model.dao;

import java.util.List;
import java.util.Map;

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

	public int changePw(String newPw, String memberEmail, String memberTel) {
		
		Member member = new Member();
		
		member.setMemberPw(newPw);
		member.setMemberEmail(memberEmail);
		member.setMemberTel(memberTel);
		
		return sqlSession.update("KmemberMapper.changePw2", member);
	}


	public int memberCheck2(Member member) {
		return sqlSession.selectOne("KmemberMapper.memberCheck2", member);
	}

	public int updateAuthKey(Map<String, String> map) {
		return sqlSession.update("KmemberMapper.updateAuthKey", map);
	}

	public int insertAuthKey(Map<String, String> map) {
		return sqlSession.update("KmemberMapper.insertAuthKey", map);
	}

	public int checkAuthKey(Map<String, Object> paramMap) {
		return sqlSession.selectOne("KmemberMapper.checkAuthKey", paramMap);
	}

	public int changePw(String newPw, String memberEmail) {
		Member member = new Member();
		
		
		member.setMemberPw(newPw);
		member.setMemberEmail(memberEmail);
		
		return sqlSession.update("KmemberMapper.changePw3", member);
	}
	
	
}
