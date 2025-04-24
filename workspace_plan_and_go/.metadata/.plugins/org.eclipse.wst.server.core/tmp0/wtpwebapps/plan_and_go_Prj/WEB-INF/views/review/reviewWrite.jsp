<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- <c:set var="loggedInUser" value="${sessionScope.member}" />
 --%>
<c:set var="loggedInUser" value="${sessionScope.memberId}" />
<%
	String MEMBER_ID = request.getParameter("MEMBER_ID");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plan&Go - 게시글 작성</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
<link rel="stylesheet" href="${contextPath}/resources/css/board.css">
</head>
<body id="reviewWrite" style="background-image: url('${contextPath}/resources/image/board.jpg'); background-size: cover; background-position: center;">

	<!-- 네비게이션 바 -->
	<nav>
		<a href="${contextPath}/board/main.do">Plan&Go</a> <a
			href="${contextPath}/review/list.do" class="btn">목록으로</a>
	</nav>

	<!-- 게시글 작성 폼 -->
	<div class="container">
		<h2>새 게시글 작성</h2>
		<form action="${contextPath}/review/insertReview.do" method="POST">
		
			<label for="activityId">활동 선택</label> <select name="activityId"
				id="activityId">
				<c:forEach var="activity" items="${activityList}">
					<option value="${activity.ACTIVITY_ID}">${activity.ACTIVITY_NAME}</option>
				</c:forEach>

			</select> 
			<input type="hidden" name="MEMBER_ID" value="${MEMBER_ID}">
				<label for="reviewName">리뷰 제목</label> 
			<input type="text" name="reviewName" required> 
				<label for="reviewContent">리뷰내용</label>
			<textarea name="reviewContent" required></textarea>

			<label for="tripRating">별점</label>
			 
			<input type="number" name="tripRating" min="1" max="5" required> 
			
			<input type="submit" value="리뷰 작성">
			
		</form>




	</div>

</body>
</html>
