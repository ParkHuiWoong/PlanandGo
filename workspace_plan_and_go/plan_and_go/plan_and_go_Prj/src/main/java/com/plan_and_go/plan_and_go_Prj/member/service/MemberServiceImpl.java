package com.plan_and_go.plan_and_go_Prj.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.plan_and_go.plan_and_go_Prj.member.dao.MemberDAO;
import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}

	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberDAO.loginById(memberVO);
	}

	@Override
	public boolean checkUserID(String MEMBER_ID) throws DataAccessException {
		return memberDAO.checkUserID(MEMBER_ID); // 아이디 중복 확인
	}

	@Override
	public boolean checkNickname(String nickname) throws DataAccessException {
		return memberDAO.checkNickname(nickname); // 닉네임 중복 확인
	}

	@Override
	public boolean isDuplicatedUser(MemberVO member) {
		return checkUserID(member.getMEMBER_ID()) || checkNickname(member.getNICKNAME());
	}

	@Override
	public String generateTempPassword() throws Exception {
		return memberDAO.generateTempPassword();
	}

	@Override
	public boolean checkUserIdAndName(MemberVO memberVO) throws Exception {
		return memberDAO.checkUserIdAndName(memberVO);
	}

	@Override
	public boolean updateTempPassword(MemberVO memberVO) throws Exception {
		return memberDAO.updateTempPassword(memberVO);
	}

}
