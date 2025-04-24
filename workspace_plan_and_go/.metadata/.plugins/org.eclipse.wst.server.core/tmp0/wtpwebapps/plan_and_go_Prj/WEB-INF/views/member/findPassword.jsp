<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 찾기</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function resetPassword() {
		var userId = $("#userId").val();
		var userName = $("#userName").val();

		if (userId.trim() === '' || userName.trim() === '') {
			alert("아이디와 이름을 입력하세요");
			return;
		}

		console.log("전송할 데이터: MEMBER_ID=" + userId + ", MEMBER_NAME="
				+ userName);

		$.ajax({
			type : "post",
			async : true,
			url : "${contextPath}/member/resetPassword.do",
			dataType : "text",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : {
				MEMBER_ID : userId,
				MEMBER_NAME : userName
			},
			success : function(response, textStatus) {
				console.log("서버 응답:", response);

				if (response.trim() === "invalid") {
					alert("아이디나 이름이 일치하지 않습니다.");
				} else if (response.trim() === "error") {
					alert("비밀번호 변경 중 오류가 발생했습니다.");
				} else {
					alert("임시 비밀번호는 " + response + "입니다. 이 패스워드로 로그인해주세요.");
					 window.location.href = "${contextPath}/member/loginForm.do";
				}
			},
			error : function(xhr, textStatus, errorThrown) {
				console.log("AJAX 오류:", xhr.status, errorThrown);
				alert("에러가 발생했습니다. 잠시 후 다시 시도해주세요.");
			}
		});
	}
</script>
</head>
<body id="findPassword" style="background-image: url('${contextPath}/resources/image/login.jpeg'); background-size: cover; background-position: center;">
	<div class="header">
		<a href="${contextPath}/board/main.do">홈으로</a>
	</div>
	<div class="container">
		<h2>비밀번호 찾기</h2>
		<form id="passwordResetForm"
			onsubmit="event.preventDefault(); resetPassword();">
			<label for="userId">아이디</label> <input type="text" id="userId"
				name="MEMBER_ID" placeholder="아이디를 입력하세요" required><br>

			<label for="userName">이름</label> <input type="text" id="userName"
				name="MEMBER_NAME" placeholder="이름을 입력하세요" required><br>

			<br>
			<button type="submit">비밀번호 찾기</button>
		</form>
	</div>
</body>
</html>
