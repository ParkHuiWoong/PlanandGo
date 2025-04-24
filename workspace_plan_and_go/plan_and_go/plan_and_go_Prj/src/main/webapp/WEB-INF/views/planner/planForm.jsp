<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
	String region = request.getParameter("region"); // 전달된 region 값
	String MEMBER_ID = request.getParameter("MEMBER_ID");
	String group_id = request.getParameter("group_id");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>여행 일정 플래너</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</head>

<body id="planForm" style="background-image: url('${contextPath}/resources/image/plan.jpeg'); background-size: cover; background-position: center;">
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
    <div class="container mt-5">
        <h1>여행 일정 플래너</h1>
        <form action="${contextPath}/planner/saveSchedule.do" method="POST">
        	<input type="hidden" id="group_id" name="group_id" value="${group_id}">
        	
            <!-- 도시 선택 -->
            <div class="mb-3">
                <label for="region" class="form-label">여행 도시 선택</label>
                <select id="region" name="region" class="form-select">
                    <option value="${region}">${region}</option>
                </select>
            </div>
            
            <!-- 여행 이름 -->
            <div class="mb-3">
                <label for="startDate" class="form-label">여행 이름</label>
                <div class="d-flex">
                    <input type="text" id="schedule_name" name="schedule_name" placeholder="여행 이름 입력" required>
                </div>
            </div>
            
            <!-- 날짜 선택 -->
            <div class="mb-3">
                <label for="startDate" class="form-label">여행 날짜</label>
                <div class="d-flex">
                    <input type="text" id="start_date" name="start_date" class="form-control me-2" placeholder="시작 날짜 선택" readonly required>
                    <input type="text" id="end_date" name="end_date" class="form-control" placeholder="종료 날짜 선택" readonly required>
                    <button type="button" class="btn btn-secondary ms-2" data-bs-toggle="modal" data-bs-target="#dateModal">날짜 선택</button>
                </div>
            </div>

            <!-- 날짜 모달 -->
            <div class="modal fade" id="dateModal" tabindex="-1" aria-labelledby="dateModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="dateModalLabel">날짜 선택</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="date" id="modalStartDate" class="form-control mb-3">
                            <input type="date" id="modalEndDate" class="form-control">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" onclick="applyDates()">적용</button>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                function applyDates() {
                    const startDate = document.getElementById('modalStartDate').value;
                    const endDate = document.getElementById('modalEndDate').value;
                    document.getElementById('start_date').value = startDate;
                    document.getElementById('end_date').value = endDate;
                    document.querySelector('#dateModal .btn-close').click();
                }
                function postToMyPage() {
        		    document.getElementById('planFormMyPage').submit();
        		}
            </script>

            <button type="submit" class="btn btn-primary">다음 단계</button>

        </form>
    </div>
</body>
</html>
