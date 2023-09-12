<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <h1>게시글 1번 제목</h1>
                </div>
    
                <hr class="hr">
    
                <div class="board-head">
                    <div class="board-head1">
                        <img src="../images/몽자.jpg" >
                        <span>닉네임</span>
                        <span class="like-area"><i class="fa-solid fa-heart" style="color: #f50505;"></i>1</span>
                    </div>
        
                    <div class="board-head2">
                        <p><span>작성일 : 2023-09-04 15:08:44</span></p>
                        <p><span>수정일 : 2023-09-04 15:08:44</span></p>
                        <p><span>조회수 : 10</span></p>
                    </div>
                    
                </div>
    
    
                <div class="img-box">
                    <div class="boardImg">
                        <img src="../images/몽자.jpg">
                        <p><a href="#" download="#">다운로드</a></p>         
                    </div>
                    <div class="boardImg">
                        <img src="../images/몽자.jpg">
                        <p><a href="#" download="#">다운로드</a></p>         
                    </div>
                    <div class="boardImg">
                        <img src="../images/몽자.jpg">
                        <p><a href="#" download="#">다운로드</a></p>         
                    </div>
                    <div class="boardImg">
                        <img src="../images/몽자.jpg">
                        <p><a href="#" download="#">다운로드</a></p>         
                    </div>
                    <div class="boardImg">
                        <img src="../images/몽자.jpg">
                        <p><a href="#" download="#">다운로드</a></p>         
                    </div>
                </div>
    
                <div class="board-content">게시글 내용</div>
    
                <hr class="hr">
    
                <div class="btn-area">
                    <button>수정</button>
                    <button>삭제</button>
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



    </main>


    <script src="/resources/js/freeBoardDetail.js"></script>
</body>
</html>