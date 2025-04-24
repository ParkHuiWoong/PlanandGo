package com.plan_and_go.plan_and_go_Prj.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;
import com.plan_and_go.plan_and_go_Prj.mypage.vo.MyPageVO;
import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

@Repository("myPageDAO")
public class MyPageDAOImpl implements MyPageDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVO selectMemberDetails(String memberId) {
		return sqlSession.selectOne("mapper.mypage.selectMemberDetails", memberId);
	}

	@Override
	public List<PlaceVO> selectVisitedPlaces(String memberId) {
		return sqlSession.selectList("mapper.mypage.selectVisitedPlaces", memberId);
	}

	@Override
	public List<MyPageVO> selectSchedulesByMemberId(String memberId) {
		System.out.println("memberID in DAO : " + memberId);
		return sqlSession.selectList("mapper.mypage.selectSchedulesByMemberId", memberId);
	}

	@Override
	public void updateMemberDetails(MemberVO memberVO) {
		sqlSession.update("mapper.mypage.updateMemberDetails", memberVO);
	}

	@Override
	public void deleteSchedule(int scheduleId) {
		sqlSession.delete("mapper.mypage.deleteReview", scheduleId);
	    sqlSession.delete("mapper.mypage.deleteActivity", scheduleId);
	    sqlSession.delete("mapper.mypage.deleteSchedule", scheduleId);
	}
	
	@Override
	public String shareSchedule(MyPageVO myPageVO) {
		int result1 = sqlSession.selectOne("mapper.mypage.selectMember1", myPageVO);
		
		if(result1 == 0) {
			return "fail";
		}
		else {
			int result2 = sqlSession.selectOne("mapper.mypage.selectMember2", myPageVO);
			
			if(result2 == 1) {
				return "Duplicate";
			}
			else {
				sqlSession.insert("mapper.mypage.shareSchedule", myPageVO);
				
				return "success";
			}
		}
		
	}
	
    @Override
    public MemberVO getMemberById(String memberId) {
        return sqlSession.selectOne("mapper.mypage.getMemberById", memberId);
    }

    @Override
    public void updatePassword(String memberId, String newPassword) {
        MemberVO member = new MemberVO();
        member.setMEMBER_ID(memberId);
        member.setPASSWORD(newPassword);
        sqlSession.update("mapper.mypage.updatePassword", member);
    }
    
    @Override
    public void updateNickname(String memberId, String newNickname) {
        MemberVO member = new MemberVO();
        member.setMEMBER_ID(memberId);
        member.setNICKNAME(newNickname);
        sqlSession.update("mapper.mypage.updateNickname", member);
    }

    @Override
    public void updateEmail(String memberId, String newEmail) {
        MemberVO member = new MemberVO();
        member.setMEMBER_ID(memberId);
        member.setEMAIL(newEmail);
        sqlSession.update("mapper.mypage.updateEmail", member);
    }

    @Override
    public void updatePhoneNumber(String memberId, String newPhoneNumber) {
        MemberVO member = new MemberVO();
        member.setMEMBER_ID(memberId);
        member.setPHONE_NUMBER(newPhoneNumber);
        sqlSession.update("mapper.mypage.updatePhoneNumber", member);
    }

}
