<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세</title>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<script src="https://kit.fontawesome.com/d76028de4f.js" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/board/freeBoardDetail.css">
<link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">

</head>
<body>
 <main>
       <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="board-notice-content">

            <jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp" />

            <section class="board-free-main">
                <div class="board-name">자유게시판</div>
                <div>
                    <h1>${board.boardTitle}</h1>
                </div>
    
                <hr class="hr">
    
                <div class="board-head">
                    <div class="board-head1">
                        <c:choose>
                       		<c:when test="${empty board.profileImage}">
                            	<img src="/resources/images/id.png">
                       		</c:when>
                    
                       		<c:otherwise>
                            	<img src="${board.profileImage}">
                       		</c:otherwise>
                    	</c:choose>
                        <span>${board.memberNickname}</span>
                        <span class="like-area">
                        	<c:if test="${!empty likeCheck}" >
                        		<i class="fa-solid fa-heart" style="color: #f50505;"></i>
                        	</c:if>
	                        <c:if test="${empty likeCheck}" >
	                            <i class="fa-regular fa-heart" id="boardLike"></i>
	                        </c:if>
                        </span>
                        <span id="likeCount">${board.likeCount}</span>
                        
                    </div>
        
                    <div class="board-head2">
                        <p><span>작성일 : ${board.boardCreateDate}</span></p>
                        
                        <c:if test="${!empty board.boardUpdateDate}" >
                        	<p> <span>수정일</span>   ${board.boardUpdateDate} </p>   
                    	</c:if>
                        	
                        <p><span>조회수 :  ${board.readCount}</span></p>
                    </div>
                </div>
    
                <c:if test="${fn:length(board.imageList) > 0}" >
                    <div class="img-box">
                        <c:forEach begin="0" end="${fn:length(board.imageList) - 1}" var="i">
                            <div class="boardImg">
                                <c:set var="path" value="${board.imageList[i].imagePath}${board.imageList[i].imageReName}"/>
                                <img src="${path}">
                                <p>
                                <a href="${path}"
                                    download="${board.imageList[i].imageOriginal}">다운로드</a>                
                                </p>
                            </div>
                        </c:forEach>
                    </div>
                 </c:if>
    
                <div class="board-content">${board.boardContent}</div>
    
                <hr class="hr">
    
                <div class="btn-area">
                    <button id="updateBtn">수정</button>
                    <button id="deleteBtn">삭제</button>
                    <button id="goToListBtn">목록으로</button>
                </div>

                
                <div id="commentArea">
                    <div class="comment-list-area">
                        <ul id="commentList">

                            <c:forEach items="${board.commentList}" var="comment">
                            
                                <li class="comment-row <c:if test='${comment.parentNo != 0}'>child-comment</c:if>" >
                                    <p class="comment-writer">

                                    <!-- 프로필 이미지 -->
                                    <c:if test="${empty comment.profileImage}" >
                                        <%-- 프로필 이미지 없는 경우 --%>
                                        <img src="/resources/images/id.png">  
                                    </c:if>
                                    <c:if test="${!empty comment.profileImage}" >
                                        <img src="${comment.profileImage}">  
                                    </c:if>

                                    <!-- 닉네임 -->
                                    <span>${comment.memberNickname}</span>
                                    
                                    <!-- 작성일 -->
                                    <span class="comment-date">${comment.commentCreateDate}</span>
                                    </p>
                                
                                    <!-- 댓글 내용 -->
                                    <p class="comment-content">${comment.commentContent}</p>

                                    
                                    <!-- 버튼 영역 -->
                                    <div class="comment-btn-area">
                                        <button onclick="showInsertComment(${comment.commentNo}, this)">답글</button>   

                                        <c:if test="${loginMember.memberNo == comment.memberNo}" >
                                            <!-- 로그인 회원과 댓글 작성자가 같은 경우 -->  
                                            <button onclick="showUpdateComment(${comment.commentNo}, this)">수정</button>     
                                            <button onclick="deleteComment(${comment.commentNo})">삭제</button>
                                        </c:if>   
                                    </div>
                                </li>

                            </c:forEach>

                        </ul>
                    </div>

                    <div class="comment-write-area">
                        <textarea id="commentContent"></textarea>
                        <button id="addComment">
                            댓글<br>
                            등록
                        </button>
                
                    </div>
                </div>

              
            </section>
        </section>

        <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    </main>

    <script>
        const boardNo = "${board.boardNo}";
        const loginMemberNo = "${loginMember.memberNo}";
    </script>

    <script src="/resources/js/freeBoardDetail.js"></script>
</body>
</html>