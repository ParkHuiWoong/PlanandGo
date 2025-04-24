package com.plan_and_go.plan_and_go_Prj.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;

public interface MemberService {
	public List listMembers() throws DataAccessException;

	public int addMember(MemberVO memberVO) throws DataAccessException;

	public int removeMember(String id) throws DataAccessException;

	public MemberVO login(MemberVO memberVO) throws Exception;

	public boolean checkUserID(String mEMBER_NAME);

	public boolean checkNickname(String nICKNAME);
//
//	public String findPassword(MemberVO memberVO) throws Exception;

	public String generateTempPassword() throws Exception;

	public boolean checkUserIdAndName(MemberVO memberVO) throws Exception;

	public boolean updateTempPassword(MemberVO memberVO) throws Exception ;
	
	public boolean isDuplicatedUser(MemberVO member);
	
	

}
