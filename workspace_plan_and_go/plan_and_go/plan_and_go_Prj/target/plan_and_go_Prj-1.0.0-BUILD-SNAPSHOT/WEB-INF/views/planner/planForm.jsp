<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%>     
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>여행 일정 플래너</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <h1>여행 일정 플래너</h1>
    <form action="${contextPath}/planner/planForm2.do" method="get">
	    <!-- 도시 선택 -->
	    <div class="mb-3">
	        <label for="place" class="form-label">여행 도시 선택:</label>
	        <select id="place" name="region" class="form-select" required>
	            <option value="">도시를 선택하세요</option>
	            <c:forEach items="${place}" var="pla">
	                <option value="${pla.region}">${pla.region}</option>
	            </c:forEach>
	        </select>
	    </div>
	    <button type="submit" class="btn btn-primary">다음 단계</button>
	</form>

</div>
</body>
</html>
