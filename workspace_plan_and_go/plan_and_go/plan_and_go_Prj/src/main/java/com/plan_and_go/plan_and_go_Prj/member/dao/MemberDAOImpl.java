package com.plan_and_go.plan_and_go_Prj.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.loginById", memberVO);
		return vo;
	}

	@Override
	public boolean checkUserID(String MEMBER_ID) throws DataAccessException {
		boolean result = sqlSession.selectOne("mapper.member.checkUserID", MEMBER_ID);
		return result;
	}

	@Override
	public boolean checkNickname(String nickname) throws DataAccessException {
		boolean result = sqlSession.selectOne("mapper.member.checkNickname", nickname);
		return result;
	}

	@Override
	public boolean updateTempPassword(MemberVO memberVO) {

		sqlSession.update("mapper.member.updatePassword", memberVO);

	    return true;
	}


	@Override
	public boolean checkUserIdAndName(MemberVO memberVO) {

		int count = sqlSession.selectOne("mapper.member.checkUserIdAndName", memberVO);

		// SQL 실행 결과 로그 추가
		System.out.println("쿼리 실행 결과 count: " + count);

		boolean check = false;
		if (count == 1)
			check = true;

		return check;
	}

	public String generateTempPassword() {
		return UUID.randomUUID().toString().substring(0, 8); // 8자리 랜덤 비밀번호 생성
	}
	
	

}