package com.plan_and_go.plan_and_go_Prj.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;

public interface MemberDAO {
	public List selectAllMemberList() throws DataAccessException;

	public int insertMember(MemberVO memberVO) throws DataAccessException;

	public int deleteMember(String id) throws DataAccessException;

	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;

	public boolean checkUserID(String MEMBER_ID) throws DataAccessException;

	public boolean checkNickname(String nickname) throws DataAccessException;

//	public String findPassword(String memberId, String email) throws Exception;

	public String generateTempPassword() throws Exception;

	public boolean checkUserIdAndName(MemberVO memberVO) throws Exception;

	public boolean updateTempPassword(MemberVO memberVO);
    
}
