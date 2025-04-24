<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loggedInUser" value="${sessionScope.member}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<script>
	function validatePasswordForm() {
		var currentPassword = document.getElementById("currentPassword").value
				.trim();
		var newPassword = document.getElementById("newPassword").value.trim();
		var confirmPassword = document.getElementById("confirmPassword").value
				.trim();

		if (currentPassword === "") {
			alert("현재 비밀번호를 입력하세요.");
			return false;
		}

		if (newPassword === "" || confirmPassword === "") {
			alert("새 비밀번호를 입력하세요.");
			return false;
		}

		if (newPassword !== confirmPassword) {
			alert("새 비밀번호가 일치하지 않습니다.");
			return false;
		}

		return true;
	}
</script>
</head>
<body id="passwordUpdate" style="background-image: url('${contextPath}/resources/image/myPage.jpg'); background-size: cover; background-position: center;">

	<div class="container">
		<h1>비밀번호 변경</h1>
		<form action="${contextPath}/board/updatePasswordDone.do"
			method="post" onsubmit="return validatePasswordForm();">
			<input type="hidden" name="memberId" value="${memberId}">

			<div class="form-group">
				<label for="currentPassword">현재 비밀번호</label> <input type="password"
					id="currentPassword" name="currentPassword" required>
			</div>
			<div class="form-group">
				<label for="newPassword">새 비밀번호</label> <input type="password"
					id="newPassword" name="newPassword" required>
			</div>
			<div class="form-group">
				<label for="confirmPassword">새 비밀번호 확인</label>
			</div>
			<input type="password" id="confirmPassword" name="confirmPassword"
				required>
				<button type="submit">비밀번호 변경</button>
			<p>
				<a href="${contextPath}/board/myPage.do">돌아가기</a>
			</p>
			
		</form>
	</div>

</body>
</html>
