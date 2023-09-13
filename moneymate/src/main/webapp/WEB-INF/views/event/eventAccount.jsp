<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>가계부 이벤트</title>

    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/resources/css/event/eventAccount.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">

    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>

    <!-- 
        한 사람당 하나만 댓글 쓸 수 있음
        페이지 조회할 떄 조회한 사람이 댓글 썼는지 안 썼는지 조회 필수 !! 제발 제발
     -->

     <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div id="main">
        <div>가계부 자랑하기(임시 제목)</div>
        <div>
            <span>조회수</span>
            <span>5</span>
        </div>

        <div id="event">
            <img src="/resources/images/accountEvent1.png"> <!-- 본문 이미지 -->   
        </div>

        <div id="commentArea">

            <ul id="commentList">

                <c:forEach items="${commentList}" var="comment">
                    <li class="comment-li">
                        <p class="writer">
                        <c:if test="${empty comment.profileImage}" >
                            <img src="/resources/images/id.png">
                        </c:if>
                        <c:if test="${!empty comment.profileImage}" >
                            <img src="${comment.profileImage}">
                        </c:if>
                            <span>${comment.memberNickname}</span>
                            <span class="writeDate">${comment.commentCreateDate}</span>
                        </p>

                        <div class="comment-area">
                            <img src="${comment.commentImage}" class="contentImg">
                            <p class="contentArea">${comment.commentContent}</p>

                            <div class="likeArea">
                                <%-- <i class="fa-regular fa-heart" id="commentLike"></i>
                                <i class="fa-solid fa-heart" id="commentLike"></i> --%>
                            </div>
                        </div>

                        <div class="btn-area">
                            <button type="button" onclick="updateBtn(${comment.commentNo},this)">수정</button>
                            <button type="button" onclick="deleteBtn(${comment.commentNo})">삭제</button>
                        </div>
                    </li>
                </c:forEach>
                
            </ul>

        </div>


        <!-- 댓글 작성 -->
        <form action="#" id="commentFrm">
            <div class="writeArea">
                <input type="file" class="imgInput" id="imgInput" name="commentImage">
                <label for="imgInput">
                    <img src="/resources/images/camera1.png" alt="카메라 사진" class="camera">
                </label>
                <img class="preview">
                <!-- <img src="../images/dog1.jpg" class="preview"> -->
                <button id="insertBtn">등록</button>
                <span class="delete-image">&times;</span>
                <textarea id="commentWrite" name="commentContent"></textarea>
            </div>
        </form>

    </div>

    <script>
        const loginMemberNo = "${loginMember.memberNo}";
    </script>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="/resources/js/eventAccount.js"></script>
    
</body>
</html>