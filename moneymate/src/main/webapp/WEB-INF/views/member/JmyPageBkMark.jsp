<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="boardList" value="${map.boardList}"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>북마크조회</title>
<link rel="stylesheet" href="/resources/css/member/myPageBookMark.css">

<script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
</head>
<body>

<main>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="myPage-container">
        
        <jsp:include page="/WEB-INF/views/member/myPageSideMenu.jsp" />


            <section class="myPage-main">
                <div class="myPage-list-header-name">북마크 목록</div>
                <div class="myPage-list-container">

                    <c:forEach items="${boardList}" var="board">

                        <div class="myPage-bookmark">
                            <div><i class="fa-solid fa-bookmark fa-xl"></i></div>
                            <div><%-- <a href="#"><img src="../images/dog1.jpg"></a> --%></div>
                            <div>
                                <div><a href="#">${board.boardTitle}</a></div>
                                <div>${board.boardContent}</div>
                            </div>
                        </div>


                    </c:forEach>



                </div>

            <div class="pagination-area">


                <ul class="pagination">
                
                    <!-- 첫 페이지로 이동 -->
                    <li><a href="/member/mypage/bookMark/${boardCode}/${loginMember.memberNo}">&lt;&lt;</a></li>

                    <!-- 이전 목록 시작 번호로 이동 -->
                    <li><a href="/member/mypage/bookMark/${boardCode}/${loginMember.memberNo}?cp=${pagination.prevPage}">&lt;</a></li>

                    <!-- 특정 페이지로 이동 -->

                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                        <!-- 현재 보고있는 페이지 -->
                        <c:choose>
                           <c:when test="${i == pagination.currentPage}">
                                <li><a class="current">${i}</a></li>
                           </c:when>
                        
                           <c:otherwise>
                                <li><a href="/member/mypage/bookMark/${boardCode}/${loginMember.memberNo}?cp=${i}">${i}</a></li>
                           </c:otherwise>
                        </c:choose>
                        
                        <!-- 현재 페이지를 제외한 나머지 -->
                    </c:forEach>
                    
                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="/member/mypage/bookMark/${boardCode}/${loginMember.memberNo}?cp=${pagination.nextPage}">&gt;</a></li>

                    <!-- 끝 페이지로 이동 -->
                    <li><a href="/member/mypage/bookMark/${boardCode}/${loginMember.memberNo}?cp=${pagination.maxPage}">&gt;&gt;</a></li>

                </ul>
            </div>

                

            </section>

        </section>
        <jsp:include page="/WEB-INF/views/common/footer.jsp" />
        
        
        
    </main>

</body>
</html>