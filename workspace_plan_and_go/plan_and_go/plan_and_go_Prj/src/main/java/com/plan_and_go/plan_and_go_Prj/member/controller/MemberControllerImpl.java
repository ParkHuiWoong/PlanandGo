package com.plan_and_go.plan_and_go_Prj.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.plan_and_go.plan_and_go_Prj.member.service.MemberService;
import com.plan_and_go.plan_and_go_Prj.member.vo.MemberVO;

@Controller("memberController")
//@EnableAspectJAutoProxy
public class MemberControllerImpl implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;

	@RequestMapping(value = { "/", "/main.do" }, method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String) request.getAttribute("viewName");
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/addMember.do", method = RequestMethod.GET)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");

		// 아이디 및 닉네임 중복 확인
		if (memberService.checkUserID(member.getMEMBER_ID())) {
			redirectAttributes.addFlashAttribute("error", "이미 사용 중인 아이디입니다.");
			return new ModelAndView("redirect:/member/signup.do");
		}

		if (memberService.checkNickname(member.getNICKNAME())) {
			redirectAttributes.addFlashAttribute("error", "이미 사용 중인 닉네임입니다.");
			return new ModelAndView("redirect:/member/signup.do");
		}

		// 회원가입 진행
		int result = memberService.addMember(member);

		if (result > 0) {
			redirectAttributes.addFlashAttribute("success", "회원가입이 완료되었습니다! 로그인 페이지로 이동합니다.");
			return new ModelAndView("redirect:/member/loginForm.do"); // 가입 성공 → 로그인 페이지로 이동
		} else {
			redirectAttributes.addFlashAttribute("error", "회원가입에 실패했습니다. 다시 시도해주세요.");
			return new ModelAndView("redirect:/member/signup.do"); // 가입 실패 → 다시 회원가입 페이지로 이동
		}
	}

	@Override
	@RequestMapping(value = "/member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@RequestMapping(value = "/member/signup.do", method = RequestMethod.GET)
	private ModelAndView signup(@RequestParam(value = "result", required = false) String result,
			@RequestParam(value = "action", required = false) String action, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/checkUserID.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity checkUserID(@RequestParam("MEMBER_ID") String MEMBER_ID) {
		ResponseEntity resEntity = null;

		try {
			System.out.println("id = " + MEMBER_ID);
			boolean overlappedID = memberService.checkUserID(MEMBER_ID);

			if (overlappedID == true) {
				resEntity = new ResponseEntity("not_usable", HttpStatus.OK);
			} else {
				resEntity = new ResponseEntity("usable", HttpStatus.OK);
			}

		} catch (Exception e) {
			resEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return resEntity;
	}

	@Override
	@RequestMapping(value = "/member/checkNickname.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity checkNickname(@RequestParam("NICKNAME") String Nickname) {
		ResponseEntity resEntity = null;

		try {
			System.out.println("nickname = " + Nickname);
			boolean overlappedID = memberService.checkNickname(Nickname);

			if (overlappedID == true) {
				resEntity = new ResponseEntity("not_usable", HttpStatus.OK);
			} else {
				resEntity = new ResponseEntity("usable", HttpStatus.OK);
			}

		} catch (Exception e) {
			resEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return resEntity;
	}

	@Override
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();

		memberVO = memberService.login(member);
		System.out.println("memberVO : " + memberVO);
		if (memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/board/main.do");
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");
			if (action != null) {
				mav.setViewName("redirect:" + action);
			}

		} else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}

	@RequestMapping(value = "/member/findPassword.do", method = { RequestMethod.GET, RequestMethod.POST })
	private ModelAndView findPassword(@RequestParam(value = "result", required = false) String result,
			@RequestParam(value = "action", required = false) String action, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName); 
		return mav;
	}

	@RequestMapping(value = "/member/resetPassword.do", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String resetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String MEMBER_ID = request.getParameter("MEMBER_ID");
		String MEMBER_NAME = request.getParameter("MEMBER_NAME");
		MemberVO memberVO = new MemberVO();

		System.out.println("입력된 MEMBER_ID: " + MEMBER_ID);
		System.out.println("입력된 MEMBER_NAME: " + MEMBER_NAME);
		
		memberVO.setMEMBER_ID(MEMBER_ID);
		memberVO.setMEMBER_NAME(MEMBER_NAME);

		if (MEMBER_ID == null || MEMBER_NAME == null) {
			return "invalid";
		}

		boolean isValidUser = memberService.checkUserIdAndName(memberVO);
		if (!isValidUser) {
			return "invalid";
		}

		String tempPassword = memberService.generateTempPassword();
		System.out.println("생성된 임시 비밀번호: " + tempPassword);
		
		
		memberVO.setTempPassword(tempPassword);

		boolean updateSuccess = memberService.updateTempPassword(memberVO);
		if (updateSuccess) {
			return tempPassword;
		} else {
			return "error";
		}
	}

	@Override
	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/loginForm.do");
		return mav;
	}

	@RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(@RequestParam(value = "result", required = false) String result,
			@RequestParam(value = "action", required = false) String action, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}

	@Override
	public int updatePassword(String memberId, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResponseEntity<Map<String, Object>> findPassword(String mEMBER_ID, String mEMBER_NAME) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView addMember(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
