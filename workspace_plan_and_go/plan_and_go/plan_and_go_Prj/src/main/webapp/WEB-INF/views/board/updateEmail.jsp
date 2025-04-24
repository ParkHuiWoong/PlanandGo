<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>이메일 변경</title>
        <link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/style.css">
</head>
<body id = "updateEmail" style="background-image: url('${contextPath}/resources/image/myPage.jpg'); background-size: cover; background-position: center;">
    <div class="container">
        <h2>이메일 변경</h2>
        <form action="${contextPath}/board/updateEmailDone.do" method="post">
            <input type="hidden" name="memberId" value="${memberId}">
            <label>새 이메일</label>
            <input type="email" name="newEmail" required>
            <button type="submit">변경</button>
        </form>
        <p><a href="${contextPath}/board/myPage.do?MEMBER_ID=${memberId}">돌아가기</a></p>
    </div>
</body>
</html>
