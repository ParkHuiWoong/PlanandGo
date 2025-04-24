package com.plan_and_go.plan_and_go_Prj.review.vo;

import java.util.Date;

public class ReviewVO {

    private int reviewId;        // REVIEW_ID
    private String reviewName;   // REVIEW_NAME
    private Integer tripRating;  // TRIP_RATING
    private String reviewContent; // REVIEW_CONTENT
    private Date createdDate;    // CREATED_DATE
    private Date updatedDate;    // UPDATED_DATE
    private String memberId;     // MEMBER_ID
    private int activityId;      // ACTIVITY_ID
    private String regionName; // �߰� (������ �̸�)


    // �⺻ ������
    public ReviewVO() {}

    // ������
    public ReviewVO(int reviewId, String reviewName, Integer tripRating, String reviewContent, 
                    Date createdDate, Date updatedDate, String memberId, int activityId, String regionName) {
        this.reviewId = reviewId;
        this.reviewName = reviewName;
        this.tripRating = tripRating;
        this.reviewContent = reviewContent;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.memberId = memberId;
        this.activityId = activityId;
        this.regionName = regionName;
    }

    // Getter and Setter Methods

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public Integer getTripRating() {
        return tripRating;
    }

    public void setTripRating(Integer tripRating) {
        this.tripRating = tripRating;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
}
