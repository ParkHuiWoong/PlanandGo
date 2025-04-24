package com.plan_and_go.plan_and_go_Prj.group.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.plan_and_go.plan_and_go_Prj.group.service.GroupService;
import com.plan_and_go.plan_and_go_Prj.group.vo.GroupTBVO;

@Controller("groupController")
@RequestMapping("/group")
public class GroupControllerImpl implements GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value="/addGroup.do" ,method = RequestMethod.POST)
	public ModelAndView addGroup(@RequestParam("group_name") String group_name, @RequestParam("region") String region, @RequestParam("MEMBER_ID") String MEMBER_ID,
			                  HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		int result = groupService.addGroup(group_name, MEMBER_ID);
		System.out.println("group ID : " + result);
		
		model.addAttribute("region", region);
		model.addAttribute("group_id", result);
		model.addAttribute("MEMBER_ID", MEMBER_ID);
		
		ModelAndView mav = new ModelAndView("redirect:/planner/planForm.do");
		return mav;
	}
	
	@RequestMapping(value="/groupForm.do" , method = RequestMethod.GET)
	public String groupForm (@RequestParam("region") String region, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("groupForm.do");
		
		model.addAttribute("region", region);

		return "/group/groupForm"; // planForm.jsp∑Œ ¿Ãµø
	}
	
}
