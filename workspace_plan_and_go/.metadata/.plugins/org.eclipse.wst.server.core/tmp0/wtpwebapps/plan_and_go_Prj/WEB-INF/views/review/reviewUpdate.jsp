<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loggedInUser" value="${sessionScope.member}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Plan&Go - 게시글 수정</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/board.css">
</head>
<body id="reviewUpdate" style="background-image: url('${contextPath}/resources/image/board.jpg'); background-size: cover; background-position: center;">

    <!-- 네비게이션 바 -->
    <nav>
        <a href="${contextPath}/board/main.do">Plan&Go</a>
        <a href="${contextPath}/review/list.do" class="btn">목록으로</a>
    </nav>

    <!-- 게시글 수정 폼 -->
<div class="container">
    <h2>게시글 수정</h2>
    <form action="${contextPath}/review/updateReview.do?id=${review.reviewId}&memberId=${loggedInUser.MEMBER_ID}" method="post">
    
        <input type="hidden" name="id" value="${review.reviewId}">
        <input type="hidden" name="author" value="${review.memberId}">
        <input type="hidden" name="activityId" value="${review.activityId}">


        <label>제목</label>
		<input type="text" name="reviewName" value="${review.reviewName}" required>

        <label>여행지</label>
        <input type="text" name="location" value="${review.regionName}" required>

        <label>내용</label>
        <textarea name="content" required>${review.reviewContent}</textarea>
        
        <label>별점</label>
        <%-- <input type="number" name="tripRating" min="1" max="5" value = "${review.tripRating}" required> --%>
        
		<input type="number" name="tripRating" id="tripRating"  min="1" max="5" value="${review.tripRating ne null ? review.tripRating : ''}" required>
		
        <input type="submit" value="수정 완료">
        
    </form>
</div>
<script>
function validateForm() {
    const tripRating = document.getElementById("tripRating").value;
    if (!tripRating) { 
        alert("별점을 입력해주세요.");
        document.getElementById("tripRating").focus();
        return false; // 제출 중단
    }
    return true; // 정상 제출
}
</script>
</body>
</html>
