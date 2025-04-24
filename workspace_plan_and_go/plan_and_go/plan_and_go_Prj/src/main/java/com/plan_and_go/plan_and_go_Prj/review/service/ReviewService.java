package com.plan_and_go.plan_and_go_Prj.review.service;

import java.util.List;

import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.review.vo.ReviewVO;

public interface ReviewService {
    List<ReviewVO> listReviews();
    ReviewVO getReviewById(int reviewId);
    void addReview(ReviewVO review);
    void updateReview(ReviewVO review);
    void deleteReview(int reviewId);
    List<ActivityVO> getActivityListByMemberId(String memberId);
    void insertReview(ReviewVO review);
    
}
