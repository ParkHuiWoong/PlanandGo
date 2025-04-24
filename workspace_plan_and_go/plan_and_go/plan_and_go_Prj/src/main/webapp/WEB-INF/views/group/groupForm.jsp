<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loggedInUser" value="${sessionScope.member}" />

<%
	request.setCharacterEncoding("UTF-8");
String region = request.getParameter("region"); // 전달된 region 값
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 만들기</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script>
	console.log("로그인한 사용자 ID:" + `${loggedInUser.MEMBER_ID}`);
</script>
</head>
<body id="groupForm" style="background-image: url('${contextPath}/resources/image/plan.jpeg'); background-size: cover; background-position: center;">
		<nav class="navbar navbar-expand-lg navbar-light">
		<a class="navbar-brand" href="${contextPath}/board/main.do"> 
		<img src="${contextPath}/resources/image/plan_and_go_logo.jpg" alt="Plan&Go 로고" class="logo">
		</a> 
		<span class="navbar-text">Plan&Go</span>
		<div class="ml-auto">
			<a class="btn btn-outline-primary"
						href="${contextPath}/member/logout.do">로그아웃</a>
			<!-- 로그아웃 링크 -->
			<a class="btn btn-outline-secondary"
			href="${contextPath}/review/list.do">리뷰 게시판</a>
						
			<a class="btn btn-outline-success" href="#" onclick="postToMyPage(); return false;">마이페이지</a>
			<!-- myPage POST 요청으로 수정 -->
			<form id="planFormMyPage" action="${contextPath}/board/myPage.do" method="POST">
				<input type="hidden" name="MEMBER_ID" value="${loggedInUser.MEMBER_ID}">
			</form>
		</div>
	</nav>
	<div id="groupFormContainer">
		<!-- 여행 그룹 생성 폼 -->
		<form id="groupForm"
			action="${contextPath}/group/addGroup.do?region=${region}&MEMBER_ID=${loggedInUser.MEMBER_ID}"
			method="POST">
			<!-- 여행 이름 입력 -->
			<div class="mb-3">
				<label for="group_name" class="form-label">여행 이름</label> <input
					type="text" id="group_name" name="group_name" class="form-control"
					placeholder="여행 이름을 입력하세요" required>
			</div>

			<button type="submit" class="btn btn-primary">다음 단계</button>
		</form>
	</div>
</body>
</html>
