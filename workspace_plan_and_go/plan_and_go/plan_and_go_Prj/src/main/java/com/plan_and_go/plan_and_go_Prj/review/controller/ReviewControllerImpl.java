package com.plan_and_go.plan_and_go_Prj.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; // HttpSession 임포트 추가

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.review.service.ReviewService;
import com.plan_and_go.plan_and_go_Prj.review.vo.ReviewVO;

@Controller("reviewController")
public class ReviewControllerImpl implements ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Override
	@RequestMapping(value = "/review/list.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listReviews(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ReviewVO> reviews = reviewService.listReviews();
		String memberId = request.getParameter("MEMBER_ID");
		System.out.println("memberId = " + memberId);
		ModelAndView mav = new ModelAndView("review/review");
		mav.addObject("reviews", reviews);
		return mav;
	}

	@RequestMapping(value = "/review/view.do", method = RequestMethod.POST)
	public ModelAndView viewReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idParam = request.getParameter("id");
		String memberId = request.getParameter("MEMBER_ID");
		
		System.out.println("idParam : " + idParam);
		System.out.println("MEMBER_ID : " + memberId);

		if (idParam == null || idParam.isEmpty()) {
			throw new IllegalArgumentException("리뷰 ID가 없습니다.");
		}

		int reviewId;
		try {
			reviewId = Integer.parseInt(idParam);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("잘못된 리뷰 ID 형식입니다.");
		}

		System.out.println("조회 요청 - 리뷰 ID: " + reviewId + ", 작성자 ID: " + memberId);

		// 🔥 Review 객체 조회
		ReviewVO review = reviewService.getReviewById(reviewId);

		if (review == null) {
			throw new IllegalArgumentException("해당 리뷰를 찾을 수 없습니다.");
		}

		System.out.println("조회된 리뷰: " + review.toString()); // 🔥 디버깅용 로그

		ModelAndView mav = new ModelAndView("review/reviewView");
		mav.addObject("review", review);
		mav.addObject("memberId", memberId);
		return mav;
	}

	@RequestMapping(value = "/review/write.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView writeReview(@RequestParam("MEMBER_ID") String MEMBER_ID, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		// 세션 객체 가져오기
		// 세션 객체가 request에서 가져와야 합니다.
//        String memberId = (String) session.getAttribute("memberId"); // 세션에서 memberId 가져오기

		System.out.println("memberId = " + MEMBER_ID);
		List<ActivityVO> activityList = reviewService.getActivityListByMemberId(MEMBER_ID);

		System.out.println("=============");
		ModelAndView mav = new ModelAndView("review/reviewWrite");
		mav.addObject("activityList", activityList);
		mav.addObject("MEMBER_ID", MEMBER_ID);
		return mav;
	}

	@RequestMapping(value = "/review/insertReview.do", method = RequestMethod.POST)
	public ModelAndView insertReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(); // 세션 객체 가져오기

		ReviewVO review = new ReviewVO();
		review.setReviewName(request.getParameter("reviewName"));
		review.setTripRating(Integer.parseInt(request.getParameter("tripRating")));
		review.setReviewContent(request.getParameter("reviewContent"));
		review.setMemberId(request.getParameter("MEMBER_ID")); // 세션에서 가져온 memberId 사용
		review.setActivityId(Integer.parseInt(request.getParameter("activityId")));

		System.out.println("reviewName = " + request.getParameter("reviewName"));
		System.out.println("tripRating = " + Integer.parseInt(request.getParameter("tripRating")));
		System.out.println("reviewContent = " + request.getParameter("reviewContent"));
		System.out.println("MEMBER_ID = " + request.getParameter("MEMBER_ID"));
		System.out.println("activityId = " + Integer.parseInt(request.getParameter("activityId")));
		System.out.println("review = " + review);

		reviewService.insertReview(review);

		return new ModelAndView("redirect:/review/list.do");
	}

	@Override
	@RequestMapping(value = "/review/delete.do", method = RequestMethod.POST)
	public ModelAndView deleteReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reviewId = Integer.parseInt(request.getParameter("id"));
		reviewService.deleteReview(reviewId);
		return new ModelAndView("redirect:/review/list.do");
	}

	@Override
	@RequestMapping(value = "/review/update.do", method = {RequestMethod.POST })
	public ModelAndView updateReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();

			try {
				int reviewId = Integer.parseInt(request.getParameter("id"));
				String memberId = request.getParameter("memberId");

				// 🔥 Review 객체 조회 (데이터 전달)
				ReviewVO review = reviewService.getReviewById(reviewId);
				if (review == null) {
					throw new IllegalArgumentException("해당 리뷰를 찾을 수 없습니다.");
				}

				System.out.println("수정 페이지 이동 - 리뷰 ID: " + reviewId + ", 작성자 ID: " + memberId);
				System.out.println("조회된 리뷰: " + review.toString());

				mav.setViewName("review/reviewUpdate");
				mav.addObject("review", review); // ✅ Review 객체 그대로 전달

			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("잘못된 리뷰 ID 또는 활동 ID 형식입니다.", e);
			} catch (NullPointerException e) {
				throw new IllegalArgumentException("필수 요청 파라미터가 누락되었습니다.", e);
			}

		return mav;
	}
	
	@RequestMapping(value = "/review/updateReview.do", method = RequestMethod.POST)
	public ModelAndView modReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();

			// POST 요청: 실제 데이터 업데이트 수행
			try {
				int reviewId = Integer.parseInt(request.getParameter("id"));
				String memberId = request.getParameter("memberId");
				int activityId = Integer.parseInt(request.getParameter("activityId"));
				String content = request.getParameter("content");
				String reviewName = request.getParameter("reviewName");
				String RegionName = request.getParameter("RegionName");
				int tripRating = Integer.parseInt(request.getParameter("tripRating"));
				if (reviewName == null || reviewName.trim().isEmpty()) {
					throw new IllegalArgumentException("reviewName 값이 비어 있습니다.");
				}

				ReviewVO review = new ReviewVO();
				review.setReviewId(reviewId);
				review.setMemberId(memberId);
				review.setActivityId(activityId);
				review.setReviewContent(content);
				review.setReviewName(reviewName);
				review.setRegionName(RegionName);
				review.setTripRating(tripRating);

				reviewService.updateReview(review);

				// 수정 후 다시 해당 게시글 보기 페이지로 리디렉션
				mav.setViewName("redirect:/review/view.do?id=" + reviewId + "&memberId=" + memberId);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("잘못된 데이터 형식입니다.", e);
			} catch (NullPointerException e) {
				throw new IllegalArgumentException("필수 요청 파라미터가 누락되었습니다.", e);
			}
		
		return mav;
	}

	@Override
	public ModelAndView writeReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
