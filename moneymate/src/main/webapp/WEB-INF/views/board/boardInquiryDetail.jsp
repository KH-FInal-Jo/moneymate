<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${boardTypeList}" var="boardType">
    <c:if test="${boardType.BOARD_CODE == 2}" >
        <c:set var="boardName" value="${boardType.BOARD_NAME}"/>
    </c:if>
</c:forEach>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문의게시판 상세</title>

    <script src="https://kit.fontawesome.com/d76028de4f.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/board/InquiryBulletinBoardDetail.css">
    <link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">
</head>
<body>
    <main>
         <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="board-notice-content">

            <jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp"/>

            <section class="board-free-main">
                <div class="board-name"> 문의게시판</div>
                <div class="boardTitle">
                <%-- 제목 --%>
                    <h1 class="board-title">${board.boardTitle}<span> - ${boardName} </span> </h1>
                </div>
    
                
    <%-- 프로필, 닉네임, 작성일, 조회수 --%>
                <div class="board-head">
                    <div class="board-head1">
                    <%-- 프로필 이미지 --%>
                    <c:choose>
                        <c:when test="${empty member.profile}">
                            <%-- 프로필 이미지 없을때 기본이미지 출력 --%>
                            <img src="/resources/images/몽자.jpg">
                        
                        </c:when>

                        <c:otherwise>
                        <%-- 프로필 이미지 있을때 출력 --%>
                            <img src="${member.profile}">                        

                        </c:otherwise>

                    
                    </c:choose>
                        <span>${board.memberNickname}</span>
                    </div>
        
                    <div class="board-head2">
                        <p><span>작성일 : ${board.boardCreateDate}</span></p>
                        <c:if test="${!empty board.boardUpdateDate}" >
                            <p><span>수정일 : ${board.boardUpdateDate}</span></p>
                        </c:if>
                        <p><span>조회수 : ${board.readCount}</span></p>
                    </div>
                    
                </div>
    
    
                
    
                <div class="board-content">${board.boardContent}</div>
    
                
    
                <div class="btn-area">
                    <button id="updateBtn">수정</button>
                    <button id="deleteBtn">삭제</button>
                    <button id="goToList">목록으로</button>
                </div>
    
            </section>
        </section>

     <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    </main>

    <script src="/resources/js/boardInquiryDetail.js"></script>


    
</body>
</html>