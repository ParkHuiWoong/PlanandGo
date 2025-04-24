package com.plan_and_go.plan_and_go_Prj.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface BoardController {
    public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
