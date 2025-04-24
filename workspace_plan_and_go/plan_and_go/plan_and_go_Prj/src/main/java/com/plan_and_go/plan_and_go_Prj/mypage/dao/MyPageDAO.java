package com.plan_and_go.plan_and_go_Prj.mypage.dao;

import java.util.List;

import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;
import com.plan_and_go.plan_and_go_Prj.mypage.vo.MyPageVO;
import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;

public interface MyPageDAO {
    MemberVO selectMemberDetails(String memberId);
    
    MemberVO getMemberById(String memberId);

    List<PlaceVO> selectVisitedPlaces(String memberId);

    List<MyPageVO> selectSchedulesByMemberId(String memberId);

    void updateMemberDetails(MemberVO memberVO);

    void deleteSchedule(int scheduleId);
    
    String shareSchedule(MyPageVO myPageVO);
    
    void updatePassword(String memberId, String newPassword);
    
    void updateNickname(String memberId, String newNickname);
    
    void updateEmail(String memberId, String newEmail);
    
    void updatePhoneNumber(String memberId, String newPhoneNumber);
}
