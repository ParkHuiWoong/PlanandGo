package com.plan_and_go.plan_and_go_Prj.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.plan_and_go.plan_and_go_Prj.board.service.BoardService;
import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {

    @Autowired
    private BoardService boardService;

    @Override
    @RequestMapping(value = "/board/main.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
    	
    	String viewName = (String) request.getAttribute("viewName");
        System.out.println("viewName : " + viewName);
        
        
        List boardsList = boardService.listBoards();
        System.out.println("boardsList : " + boardsList);
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("boardsList", boardsList);

        return mav;
    }
}
