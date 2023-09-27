<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
                    <c:if test="${loginMember.memberNo == board.memberNo || loginMember.authority == 1 }" >

                     <button id="updateBtn">수정</button>
                     <button id="deleteBtn">삭제</button>
                    </c:if>                   
                    <button id="goToList">목록으로</button>
                </div>
    

                 <div class="comment-area">
                    <h4>댓글</h4>
                    <ul id=commentList>
                    
                        <c:forEach items="${cList}" var="comment">
                        <li class="comment-list">

                            <div>
                                <c:if test="${empty comment.profileImage}">
                                    <img class="img50" src="/resources/images/몽자.jpg">
                                </c:if>

                                 <c:if test="${!empty comment.profileImage}">
                                    <img class="img50" src="${comment.profileImage}">
                                </c:if>

                                <span>${comment.memberNickname}</span>
                            </div>
                            
                                
                            <div class="comment-content">${comment.commentContent}</div>
                            <div>
                           
                                <div class="btn-area2">
                                    <c:if test="${loginMember.memberNo == comment.memberNo}">
                                    <button id="updateBtn" onclick="showUpdateComment(${comment.commentNo}, this)">수정</button>
                                    <button id="deleteBtn" onclick="deleteComment(${comment.commentNo})">삭제</button>                                    
                                    </c:if>
                                </div>

                                <div class="createDate">
                                    작성일 : ${comment.commentCreateDate}
                                </div>
                            </div>

                        </li>
                        </c:forEach>
                    </ul>
                </div>
                <c:if test="${loginMember.memberNo == comment.memberNo || loginMember.authority == 1}">
                        <div class="comment-write-area">
                            <textarea id="commentContent"></textarea>
                            <button id="addComment">
                                댓글<br>
                                등록
                            </button>
                        </div>
    
                </c:if>
            </section>
        </section>
        <script>
            const loginMemberNo="${loginMember.memberNo}" // 전역변수로 선언해서 자바스크립트도 사용할수 있게 해줌
            const boardNo="${board.boardNo}"
        </script>

     <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    </main>

    <script src="/resources/js/boardInquiryDetail.js"></script>


    
</body>
</html>