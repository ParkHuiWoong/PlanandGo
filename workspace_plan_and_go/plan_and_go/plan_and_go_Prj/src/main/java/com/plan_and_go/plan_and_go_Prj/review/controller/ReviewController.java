package com.plan_and_go.plan_and_go_Prj.review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface ReviewController {
    ModelAndView listReviews(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView viewReview(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView writeReview(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView insertReview(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView deleteReview(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView updateReview(HttpServletRequest request, HttpServletResponse response) throws Exception;
}