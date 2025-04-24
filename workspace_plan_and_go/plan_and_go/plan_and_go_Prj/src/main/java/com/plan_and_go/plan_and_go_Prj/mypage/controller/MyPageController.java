package com.plan_and_go.plan_and_go_Prj.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MyPageController {

    /**
     * 기본 요청 처리 메서드
     */
    ModelAndView showMyPage(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 프로필 수정 처리
     */
    ModelAndView updateProfile(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 일정 삭제 처리
     */
    ModelAndView deleteSchedule(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
	/* 업데이트 페이지 */
    ModelAndView showPasswordUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/* 비밀번호 업데이트 */
    ModelAndView updatePassword(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView showNicknameUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView updateNickname(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView showEmailUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView updateEmail(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView showPhoneNumberUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView updatePhoneNumber(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
}
