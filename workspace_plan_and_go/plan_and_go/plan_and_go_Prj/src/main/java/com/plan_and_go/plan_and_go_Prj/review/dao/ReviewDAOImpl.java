package com.plan_and_go.plan_and_go_Prj.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.review.vo.ReviewVO;

@Repository("reviewDAO")
public class ReviewDAOImpl implements ReviewDAO {

    @Autowired
    private SqlSession sqlSession;

//    @Override
//    public List<ActivityVO> getActivityListByMemberId(String memberId) {
//        return sqlSession.selectList("mapper.review.getActivityListByMemberId", memberId);
//    }
//    
    @Override
    public List<ReviewVO> getAllReviews() {
        return sqlSession.selectList("mapper.review.getReviews");
    }

    @Override
    public ReviewVO getReviewById(int id) {
        return sqlSession.selectOne("mapper.review.getReviewById", id);
    }

    @Override
    public void insertReview(ReviewVO review) {
        sqlSession.insert("mapper.review.insertReview", review);
    }

    public void updateReview(ReviewVO review) {
        System.out.println("���� ������Ʈ: " + review.getReviewId());

        sqlSession.update("mapper.review.updateReview", review);
    }

    @Override
    public void deleteReview(int id) {
        sqlSession.delete("mapper.review.deleteReview", id);
    }

    @Override
    public List<ActivityVO> getActivityListByMemberId(String memberId) {
    	List<ActivityVO> activityVO = null;
    	activityVO = sqlSession.selectList("mapper.review.getActivityListByMemberId", memberId);
    	System.out.println("activityVO DAO  = " + activityVO);
        return activityVO;
    }
}