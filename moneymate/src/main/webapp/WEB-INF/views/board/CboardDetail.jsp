<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세</title>

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
                    <button>목록으로</button>
                </div>

                

                <div class="comment-area">
                    <ul>
                        <li id="comment-list">
                            <p class="commentWriter">
                                <img src="../images/몽자.jpg">
                                <span>닉네임</span>
                            </p>

                            <p id="comment-content">댓글 내용</p>

                            <div>
                                <div class="btn-area2">
                                    <button>답글</button>
                                    <button>수정</button>
                                    <button>삭제</button>
                                </div>

                                <div class="createDate">
                                    작성일 : 2023-09-05
                                </div>
                            </div>
                        </li>
                    </ul>
                    <hr>
                </div>


                <div class="comment-area">
                    <ul>
                        <li id="comment-list">
                            <p class="commentWriter">
                                <img src="../images/몽자.jpg">
                                <span>닉네임</span>
                            </p>

                            <p id="comment-content">댓글 내용</p>

                            <div>
                                <div class="btn-area2">
                                    <button>답글</button>
                                    <button>수정</button>
                                    <button>삭제</button>
                                </div>

                                <div class="createDate">
                                    작성일 : 2023-09-05
                                </div>
                            </div>

                        </li>
                    </ul>
                    <hr>
                    
                </div>

                <div class="comment-write-area">
                    <textarea id="commentContent"></textarea>
                    <button id="addComment">
                        댓글<br>
                        등록
                    </button>
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