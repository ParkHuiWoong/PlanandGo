package com.plan_and_go.plan_and_go_Prj.review.dao;

import java.util.List;

import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.review.vo.ReviewVO;

public interface ReviewDAO {
    List<ReviewVO> getAllReviews();
    ReviewVO getReviewById(int id);
    void insertReview(ReviewVO review);
    void updateReview(ReviewVO review);
    void deleteReview(int id);
    List<ActivityVO> getActivityListByMemberId(String memberId);
    
}