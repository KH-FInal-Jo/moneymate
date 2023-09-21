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


	public int changePw(String newPw, int memberNo) {
		Member member = new Member();
		member.setMemberNo(memberNo);
		member.setMemberPw(newPw);
		
		return sqlSession.update("kmemberMapper.changePw", member);
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
		return sqlSession.update("kmemberMapper.updateProfileImage", loginMember);
	}
	
	
}
