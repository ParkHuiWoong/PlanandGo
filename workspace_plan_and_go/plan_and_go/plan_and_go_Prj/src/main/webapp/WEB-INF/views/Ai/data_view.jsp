<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flask API 데이터 출력</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body id="data_view">
<div class="header">
		<a href="${contextPath}/board/main.do">홈으로</a>
	</div>

	<h2>Plan&Go 키워드 추천</h2>

	<!-- 🔍 검색 폼 -->
	<form action="${contextPath}/Ai/test2.do" method="post"
		style="text-align: center;">
		<input type="text" name="query" value="${query}" size="50"
			placeholder="예: 수영장 바다 조식" /> <input type="submit" value="검색" />
	</form>
	<br />

	<c:if test="${not empty dataList}">
		<table align="center" border="1">
			<tr>
				<th>추천 호텔 이름</th>
				<th>예약 링크</th>
			</tr>
			<c:forEach var="item" items="${dataList}">
				<tr>
					<td>${item.hotel}</td>
					<td><a href="${item.url}" target="_blank">이동하기</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:if test="${empty dataList}">
		<p style="text-align: center;">데이터가 없습니다.</p>
	</c:if>
</body>
</html>
