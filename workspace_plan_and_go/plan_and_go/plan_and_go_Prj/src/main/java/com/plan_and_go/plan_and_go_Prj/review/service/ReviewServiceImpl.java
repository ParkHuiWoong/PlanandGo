package com.plan_and_go.plan_and_go_Prj.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.review.dao.ReviewDAO;
import com.plan_and_go.plan_and_go_Prj.review.vo.ReviewVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDAO reviewDAO;
    
//    public List<ActivityVO> getActivityListByMemberId(String memberId) {
//        return reviewDAO.getActivityListByMemberId(memberId);
//    }

    @Override
    public List<ReviewVO> listReviews() {
        return reviewDAO.getAllReviews();
    }

    @Override
    public ReviewVO getReviewById(int reviewId) {
        return reviewDAO.getReviewById(reviewId);
    }

    @Override
    public void addReview(ReviewVO review) {
        reviewDAO.insertReview(review);
    }

    @Override
    public void updateReview(ReviewVO review) {
        reviewDAO.updateReview(review);
    }

    @Override
    public void deleteReview(int reviewId) {
        reviewDAO.deleteReview(reviewId);
    }
    
    

    @Override
    public List<ActivityVO> getActivityListByMemberId(String memberId) {
    	List<ActivityVO> activityVO = null;
    	activityVO = reviewDAO.getActivityListByMemberId(memberId);
    	System.out.println("activityVO ser =  " + activityVO);
    	return activityVO;
    }

    @Override
    public void insertReview(ReviewVO review) {
        reviewDAO.insertReview(review);
    }
}
