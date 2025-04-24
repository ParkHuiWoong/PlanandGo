<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loggedInUser" value="${sessionScope.member}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>닉네임 변경</title>
    <link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/style.css">
</head>
<body id = "updateNickname" style="background-image: url('${contextPath}/resources/image/myPage.jpg'); background-size: cover; background-position: center;">
    <div class="container">
        <h2>닉네임 변경</h2>
        <form action="${contextPath}/board/updateNicknameDone.do" method="post">
            <input type="hidden" name="memberId" value="${memberId}">
            <label>새 닉네임</label>
            <input type="text" name="newNickname" required>
            <button type="submit">변경하기</button>
        </form>
        <p><a href="${contextPath}/board/myPage.do?MEMBER_ID=${memberId}">돌아가기</a></p>
    </div>
</body>
</html>
