<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loggedInUser" value="${sessionScope.member}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
<meta charset="UTF-8">
<title>Plan&Go - 게시글 보기</title>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/style.css">
<link rel="stylesheet" href="${contextPath}/resources/css/board.css">
</head>
<body id="reviewView" style="background-image: url('${contextPath}/resources/image/board.jpg'); background-size: cover; background-position: center;">

	<!-- 네비게이션 바 -->
	<nav>
		<a href="${contextPath}/board/main.do">Plan&Go</a>
		<div>
			<a class="btn btn-outline-primary"
				href="${contextPath}/board/main.do">메인</a> <a
				class="btn btn-outline-primary" href="${contextPath}/review/list.do">리뷰게시판</a>
			<c:choose>
				<c:when test="${empty loggedInUser}">
					<a class="btn btn-outline-primary"
						href="${contextPath}/member/loginForm.do">로그인</a>
				</c:when>
				<c:otherwise>
					<a class="btn btn-outline-primary"
						href="${contextPath}/member/logout.do">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>

	<!-- 게시글 상세 내용 -->
	<div class="container">
		<a href="${contextPath}/review/list.do" class="btn btn-list">목록으로</a>
		<h2>${review.reviewName}</h2>

		<p>
			<strong>작성자</strong> ${review.memberId}
		</p>
		<p>
			<strong>작성일</strong> <span><fmt:formatDate
					value="${review.createdDate}" pattern="yyyy-MM-dd" /></span>
		</p>

		<p>

			<strong>여행지</strong> ${review.regionName}
		</p>
		<p>

			<strong>별점</strong> ${review.tripRating}
		</p>


		<hr>
		<p>${review.reviewContent}</p>

		<!-- 삭제 버튼 (URL로 받은 memberId와 작성한 memberId가 같을 때만 표시) -->
		<c:if test="${loggedInUser.MEMBER_ID eq review.memberId}">
			<div class="action-buttons">
				<form action="${contextPath}/review/delete.do" method="post">
					<input type="hidden" name="id" value="${review.reviewId}">
					<button type="submit" class="btn btn-edit" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</button>
				
				</form>
				
		</c:if>

		<!-- 수정 버튼 (URL에서 받은 memberId와 작성자의 memberId가 같을 때만 표시) -->

		<c:if test="${loggedInUser.MEMBER_ID eq review.memberId}">

			<a href="#" class="btn btn-edit"
				onclick="checkPermission('${loggedInUser.MEMBER_ID ne null ? loggedInUser.MEMBER_ID : ''}', '${review.memberId ne null ? review.memberId : ''}')">
				수정 </a>
				
			<form id="updateReview" action="${contextPath}/review/update.do" method="POST">
			    <input type="hidden" name="id" value="${review.reviewId}">
			    <input type="hidden" name="memberId" value="${review.memberId}">
			    <input type="hidden" name="activityId" value="${review.activityId}">
			    <input type="hidden" name="content" value="${review.reviewContent}">
			</form>
	</div>
	</c:if>

</body>
<script>
    function checkPermission(paramMemberId, reviewMemberId) {
        if (paramMemberId !== reviewMemberId) {
            alert("수정 권한이 없습니다.");
        } else {
        	document.getElementById('updateReview').submit();
        }
    }
</script>
</html>
