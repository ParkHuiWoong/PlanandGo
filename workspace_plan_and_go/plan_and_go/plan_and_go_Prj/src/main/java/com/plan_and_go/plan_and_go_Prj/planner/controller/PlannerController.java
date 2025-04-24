package com.plan_and_go.plan_and_go_Prj.planner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ScheduleVO;

public interface PlannerController {

	public String planForm (@RequestParam("region") String region, @RequestParam("group_id") String group_id, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;

	
}
