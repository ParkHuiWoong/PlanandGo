<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
String result = (String) request.getAttribute("result"); // 로그인 실패 메시지 확인
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
<script>
	window.onload = function() {
		var urlParams = new URLSearchParams(window.location.search);
		var result = urlParams.get("result"); // URL에서 result 값 가져오기

		if (result === "loginFailed") {
			alert("아이디 또는 비밀번호가 잘못되었습니다. 다시 시도해주세요.");
		}
	}
</script>

</head>
<body id="loginForm" style="background-image: url('${contextPath}/resources/image/login.jpeg'); background-size: cover; background-position: center;">
	<c:if test="${not empty success}">
		<script>
			alert("${success}");
		</script>
	</c:if>
	<div class="header">
		<a href="${contextPath}/board/main.do">홈으로</a>
	</div>

	<div class="container">
		<h2>Plan&Go</h2>
		<form action="${contextPath}/member/login.do" method="POST">
			<label for="username">아이디</label> <input type="text" id="username"
				name="MEMBER_ID" placeholder="아이디를 입력하세요" required> <label
				for="password">비밀번호</label> <input type="password" id="password"
				name="PASSWORD" placeholder="비밀번호를 입력하세요" required> <a
				href="${contextPath}/member/findPassword.do" class="forgot-password">비밀번호를
				잊으셨나요?</a>

			<button type="submit">로그인</button>
		</form>
		<div class="signup">
			아직 회원이 아니세요? <a href="${contextPath}/member/signup.do">회원가입</a>
		</div>
	</div>
</body>
</html>
