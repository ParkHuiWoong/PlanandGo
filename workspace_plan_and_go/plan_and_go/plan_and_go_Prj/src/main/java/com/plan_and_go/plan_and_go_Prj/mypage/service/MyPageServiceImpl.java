package com.plan_and_go.plan_and_go_Prj.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;
import com.plan_and_go.plan_and_go_Prj.mypage.dao.MyPageDAO;
import com.plan_and_go.plan_and_go_Prj.mypage.vo.MyPageVO;
import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

@Service("myPageService")
public class MyPageServiceImpl implements MyPageService {

    @Autowired
    private MyPageDAO myPageDAO;

    @Override
    public MemberVO getMemberDetails(String memberId) {
        return myPageDAO.selectMemberDetails(memberId);
    }

    @Override
    public List<PlaceVO> getVisitedPlaces(String memberId) {
        return myPageDAO.selectVisitedPlaces(memberId);
    }

    @Override
    public List<MyPageVO> getSchedulesByMemberId(String memberId) {
        return myPageDAO.selectSchedulesByMemberId(memberId);
    }

    @Override
    public void updateMemberDetails(MemberVO memberVO) {
        myPageDAO.updateMemberDetails(memberVO);
    }

    
    @Override
    public void deleteSchedule(int scheduleId) {
        myPageDAO.deleteSchedule(scheduleId);
    }
    
    @Override
    public String shareSchedule(MyPageVO myPageVO) {
        return myPageDAO.shareSchedule(myPageVO);
    }
    
    @Override
    public MemberVO getMemberById(String memberId) {
        return myPageDAO.getMemberById(memberId);
    }

    @Override
    public void updatePassword(String memberId, String newPassword) {
    	myPageDAO.updatePassword(memberId, newPassword);
    }
    
    @Override
    public void updateNickname(String memberId, String newNickname) {
        myPageDAO.updateNickname(memberId, newNickname);
    }

    @Override
    public void updateEmail(String memberId, String newEmail) {
        myPageDAO.updateEmail(memberId, newEmail);
    }

    @Override
    public void updatePhoneNumber(String memberId, String newPhoneNumber) {
        myPageDAO.updatePhoneNumber(memberId, newPhoneNumber);
    }


 }
