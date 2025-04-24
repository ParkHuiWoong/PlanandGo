package com.plan_and_go.plan_and_go_Prj.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MyPageController {

    /**
     * �⺻ ��û ó�� �޼���
     */
    ModelAndView showMyPage(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * ������ ���� ó��
     */
    ModelAndView updateProfile(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * ���� ���� ó��
     */
    ModelAndView deleteSchedule(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
	/* ������Ʈ ������ */
    ModelAndView showPasswordUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/* ��й�ȣ ������Ʈ */
    ModelAndView updatePassword(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView showNicknameUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView updateNickname(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView showEmailUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView updateEmail(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView showPhoneNumberUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView updatePhoneNumber(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
}
