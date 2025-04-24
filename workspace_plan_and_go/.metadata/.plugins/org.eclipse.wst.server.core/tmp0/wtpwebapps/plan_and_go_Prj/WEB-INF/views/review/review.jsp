<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loggedInUser" value="${sessionScope.member}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Plan&Go - 여행 리뷰 게시판</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">    
    <link rel="stylesheet" href="${contextPath}/resources/css/board.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body id="review" style="background-image: url('${contextPath}/resources/image/board.jpg'); background-size: cover; background-position: center;">

    <!-- 네비게이션 바 -->
    <nav class="navbar">
    
    <a href="${contextPath}/board/main.do" class="navbar-text">Plan&Go</a>
        <div class="nav-menu">
        
    <a class="nav-btn" href="#" onclick="postToMyPage(); return false;">마이페이지</a>
		<form id="reviewMyPage" action="${contextPath}/board/myPage.do" method="POST">
		    <input type="hidden" name="MEMBER_ID" value="${loggedInUser.MEMBER_ID}">
		</form>
			
    <c:choose>
    
        <c:when test="${empty loggedInUser}">
            <a href="${contextPath}/member/loginForm.do" class="nav-btn">로그인</a>
        </c:when>
        
        <c:otherwise>
            <a href="${contextPath}/member/logout.do" class="nav-btn">로그아웃</a>
        </c:otherwise>
        
    </c:choose>
</div>


        

        
    </nav>

    <!-- 게시판 목록 -->
    <div class="container">
        <h2>여행 리뷰 게시판</h2>

        <!-- 새 글 작성 버튼 -->
        <c:choose>
            <c:when test="${empty loggedInUser}">
                <a href="${contextPath}/member/loginForm.do" class="add-post-btn disabled">새 글 작성</a>
            </c:when>
            <c:otherwise>
            
                <%-- <a href="${contextPath}/review/write.do?MEMBER_ID=${loggedInUser.MEMBER_ID}" class="add-post-btn">새 글 작성</a> --%>
                
                <a class="add-post-btn" href="#" onclick="postToReviewWrite(); return false;">새 글 작성</a>
					<form id="reviewWrite" action="${contextPath}/review/write.do" method="POST">
					    <input type="hidden" name="MEMBER_ID" value="${loggedInUser.MEMBER_ID}">
					</form>
		
		
            </c:otherwise>
        </c:choose>

        <table class="table">
        
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>여행지</th>
                    <th>별점</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="review" items="${reviews}">
                
                    <tr>
                        <td>${review.reviewId}</td>
                        
                        <td>
							<form id="reviewView" action="${contextPath}/review/view.do" method="POST">
							    <input type="hidden" name="MEMBER_ID" value="${loggedInUser.MEMBER_ID}">
							    <input type="hidden" name="id" value="${review.reviewId}">
							    <input type="submit" value="${review.reviewName}">
							</form>
                        </td>
                        
                        <td>${review.memberId}</td>
                        <td><fmt:formatDate value="${review.createdDate}" pattern="yyyy-MM-dd" /></td>
                        <td>${review.activityId}</td>
                        <td>${review.tripRating}</td>
                    </tr>
                    
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <script>
	function postToReviewWrite() {
	    document.getElementById('reviewWrite').submit();
	}
	function postToMyPage() {
	    document.getElementById('reviewMyPage').submit();
	}
    </script>

</body>
</html>
