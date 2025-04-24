<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
    request.setCharacterEncoding("UTF-8");
    String region = request.getParameter("region"); // 전달된 region 값
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
    <form action="/submitPlan" method="post">
        <!-- 도시 선택 -->
        <div class="mb-3">
            <label for="place" class="form-label">여행 도시 선택:</label>
            <select id="place" name="place" class="form-select" required>
                <option value="">${region}</option>
            </select>
        </div>

        <!-- 날짜 선택 모달 -->
        <div class="mb-3">
            <label for="startDate" class="form-label">여행 날짜:</label>
            <div class="d-flex">
                <input type="text" id="startDate" name="startDate" class="form-control me-2" placeholder="시작 날짜 선택" readonly required>
                <input type="text" id="endDate" name="endDate" class="form-control" placeholder="종료 날짜 선택" readonly required>
                <button type="button" class="btn btn-secondary ms-2" data-bs-toggle="modal" data-bs-target="#dateModal">날짜 선택</button>
            </div>
        </div>

        <!-- 방문 장소 선택 모달 -->
        <div class="mb-3">
            <label for="place" class="form-label">방문 장소 선택:</label>
            <div class="d-flex">
                <input type="text" id="pla_name" name="place" class="form-control" placeholder="선택된 장소" readonly required>
                <button type="button" class="btn btn-secondary ms-2" data-bs-toggle="modal" data-bs-target="#placeModal">장소 선택</button>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">일정 생성</button>
    </form>
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

<!-- 장소 모달 -->
<div class="modal fade" id="placeModal" tabindex="-1" aria-labelledby="placeModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="placeModalLabel">장소 선택</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:forEach items="${place}" var="place_name">
                    <div class="mb-3">
                        <img src="${place_name.image}" alt="${place_name.name}" class="img-fluid">
                        <h6>${place_name.name}</h6>
                        <p>${place_name.info}</p>
                        <button type="button" class="btn btn-outline-primary" onclick="selectPlace('${place_name.name}')">선택</button>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<script>
    function applyDates() {
        const startDate = document.getElementById('modalStartDate').value;
        const endDate = document.getElementById('modalEndDate').value;
        document.getElementById('startDate').value = startDate;
        document.getElementById('endDate').value = endDate;
        document.querySelector('#dateModal .btn-close').click();
    }

    function selectPlace(placeName) {
        document.getElementById('pla_name').value = placeName;
        document.querySelector('#placeModal .btn-close').click();
    }
</script>
</body>
</html>
