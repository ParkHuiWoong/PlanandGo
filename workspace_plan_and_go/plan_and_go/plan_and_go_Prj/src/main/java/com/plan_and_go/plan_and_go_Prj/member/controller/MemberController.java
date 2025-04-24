package com.plan_and_go.plan_and_go_Prj.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView addMember(@ModelAttribute("info") MemberVO memberVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity checkNickname(@RequestParam("nickname") String nickname) throws Exception;

	public ResponseEntity checkUserID(@RequestParam("userid") String username) throws Exception;

	public ResponseEntity<Map<String, Object>> findPassword(@RequestParam("MEMBER_ID") String mEMBER_ID,
			@RequestParam("MEMBER_NAME") String mEMBER_NAME) throws Exception;

	public int updatePassword(@Param("memberId") String memberId, @Param("password") String password) throws Exception;

	public ModelAndView addMember(MemberVO member, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception;;

}