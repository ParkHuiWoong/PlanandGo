package com.plan_and_go.plan_and_go_Prj.Ai.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AiController {
	
	public ModelAndView fetchData2(String query) throws Exception;


}
