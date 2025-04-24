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
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function checkUsername() {
		var userid = $("#userid").val();
		if (userid == '') {
			alert("ID를 입력하세요");
			return;
		}
		$.ajax({
			type : "post",
			async : true,
			url : "${contextPath}/member/checkUserID.do",
			dataType : "text",
			data : {
				MEMBER_ID : userid
			},
			success : function(data, textStatus) {
				//alert(data);

				if (data == 'usable') {
					alert("사용할 수 있는 ID입니다.");
					$('#btnDuplicate').prop("disabled", true);
				} else {
					alert("사용할 수 없는 ID입니다.");
				}
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다.");
				ㅣ
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
			}
		}); //end ajax    
	}

	function checkNickname() {
		var nickname = $("#nickname").val();
		if (nickname == '') {
			alert("닉네임을 입력하세요");
			return;
		}
		$.ajax({
			type : "post",
			async : true,
			url : "${contextPath}/member/checkNickname.do",
			dataType : "text",
			data : {
				NICKNAME : nickname
			},
			success : function(data, textStatus) {
				//alert(data);

				if (data == 'usable') {
					alert("사용할 수 있는 닉네임입니다.");
					$('#btnDuplicate').prop("disabled", true);
				} else {
					alert("사용할 수 없는 닉네임입니다.");
				}
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다.");
				ㅣ
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
			}
		}); //end ajax    
	}
</script>
</head>
<body id="signup" style="background-image: url('${contextPath}/resources/image/login.jpeg'); background-size: cover; background-position: center;">
	<!-- Header for Home Button -->
	<div class="header">
		<a href="${contextPath}/board/main.do">홈으로</a>
	</div>

	<!-- Signup Container -->
	<div class="container">
		<h2>Plan&go 회원가입</h2>
		<form action="${contextPath}/member/addMember.do" method="GET">
			<!-- 아이디 입력 -->
			<div class="input-group">
				<label for="userid">아이디</label> <input type="text" id="userid"
					name="MEMBER_ID" placeholder="아이디를 입력하세요" required>
				<button type="button" class="check-btn" onclick="checkUsername()">중복
					확인</button>
			</div>
			<div class="input-group">
				<label for="username">이름</label> <input type="text" id="username"
					name="MEMBER_NAME" placeholder="이름을 입력하세요" required>
			</div>

			<!-- 비밀번호 입력 -->
			<div class="input-group">
			<label for="password">비밀번호</label> <input type="password"
				id="PASSWORD" name="PASSWORD" placeholder="비밀번호를 입력하세요" required>
</div>
			<!-- 닉네임 입력 -->
			<div class="input-group">
				<label for="nickname">닉네임</label> <input type="text" id="nickname"
					name="NICKNAME" maxlength="50" placeholder="닉네임을 입력하세요" required>
				<button type="button" class="check-btn2" onclick="checkNickname()">중복
					확인</button>
			</div>

			<!-- 이메일 입력 -->
			<div class="input-group">
			<label for="email">이메일</label> <input type="email" id="email"
				name="EMAIL" maxlength="50" placeholder="이메일을 입력하세요" required>
</div>
			<!-- 전화번호 입력 -->
			<div class="input-group">
			<label for="phone">전화번호</label> <input type="tel" id="phone"
				name="PHONE_NUMBER" maxlength="11" pattern="[0-9]{10,11}"
				oninput="this.value = this.value.replace(/[^0-9]/g, '')"
				placeholder="전화번호를 입력하세요" required> <br>
			<c:if test="${not empty error}">
				<p style="color: red; font-size: 14px; text-align: center;">${error}</p>
			</c:if>
			</div>
			<div class="input-group">
			<button type="submit">회원가입</button>
			</div>
		</form>

		<div class="signup-message" id="signup-message"></div>
		<br>
		<div class="signup">
			이미 회원이신가요? <a href="${contextPath}/member/loginForm.do">로그인</a>
		</div>
	</div>
</body>
</html>
