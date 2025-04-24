package com.plan_and_go.plan_and_go_Prj.mypage.service;

import java.util.List;

import com.plan_and_go.plan_and_go_Prj.mypage.vo.MyPageVO;
import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;
import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

public interface MyPageService {
    MemberVO getMemberDetails(String memberId);
    
    MemberVO getMemberById(String memberId);
    
    List<PlaceVO> getVisitedPlaces(String memberId);

    List<MyPageVO> getSchedulesByMemberId(String memberId);

    void updateMemberDetails(MemberVO memberVO);

    void deleteSchedule(int scheduleId);
    
    String shareSchedule(MyPageVO myPageVO);
    
    void updatePassword(String memberId, String newPassword);
    
    void updateNickname(String memberId, String newNickname);
    
    void updateEmail(String memberId, String newEmail);
    
    void updatePhoneNumber(String memberId, String newPhoneNumber);
}
