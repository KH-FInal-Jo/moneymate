<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pagination" value="${map1.pagination}"/>
<c:set var="boardList" value="${map1.boardList}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/d76028de4f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/member/myPageSidemenu.css">
    <link rel="stylesheet" href="/resources/css/myBoardList.css">
    <script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>

<title>내가 쓴 글</title>
</head>
<body>
    <c:if test="${!empty param.sel}" >
            <c:set var="sp" value="&sel=${param.sel}&query=${param.query}"/>
    </c:if>

    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        
        <section class="myPage-container">

            <jsp:include page="/WEB-INF/views/member/myPageSideMenu.jsp"/>

            <section class="myPage-notice-main">
                <div class="myPage-notice-name"><h1>내가 쓴 글</h1>
                </div>
                <div class="list">
                    
                    <div class="search">
                        <form action="/member/mypage/myboard">
                            <select name="sel">
                                <option value="t" selected>제목</option>
                                <option value="c" >내용</option>
                                <option value="tc">제목+내용</option>
                            </select>
                            <input type="text" id="query" name="query" value="${param.query}"> <button>검색</button>
                        </form>
                    </div>

                    <c:choose>
                        <c:when test="${empty boardList}">
                            <h3>게시글이 존재하지 않습니다.</h3>
                        </c:when>
                    
                        <c:otherwise>
                            <c:forEach items="${boardList}" var="board">
                                <div class="listOne">
                                    <div class="thumbnail">
                                        <c:if test="${!empty board.thumbnail}" >
                                            <img src="${board.thumbnail}">
                                        </c:if>
                                        <c:if test="${empty board.thumbnail}" >
                                            <img src="/resources/images/mongja2.jpg">
                                        </c:if>
                                    </div>
                                    <div class="board">
                                        <div class="title">
                                            <c:if test="${board.boardCode == 1}" >
                                                [공지]
                                            </c:if>
                                            <c:if test="${board.boardCode == 2}" >
                                                [문의]
                                            </c:if>
                                            <c:if test="${board.boardCode == 3}" >
                                                [자유]
                                            </c:if>
                                            <a href="/community/${board.boardCode}/${board.boardNo}?cp=${pagination.currentPage}${sp}">${board.boardTitle}</a> [${board.commentCount}]
                                        </div>
                                        <div class="content"><a href="/community/${board.boardCode}/${board.boardNo}?cp=${pagination.currentPage}${sp}">${board.boardContent}</a></div>
                                        <div class="etc">
                                            <div>
                                                <i class="fa-solid fa-heart" style="color: #f50505;"></i>: ${board.likeCount}
                                            </div>
                                            <div>
                                                조회수 : ${board.readCount}
                                            </div>

                                            <div>
                                                <span>${board.boardCreateDate}</span>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>

                                

                    
                <div class="pagination-area">


                    <ul class="pagination">
                    
                        <li><a href="/member/mypage/myboard?cp=1${sp}">&lt;&lt;</a></li>

                        <li><a href="/member/mypage/myboard?cp=${pagination.prevPage}${sp}">&lt;</a></li>

                
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                            <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                    <li><a class="current">${i}</a></li>
                            </c:when>
                            
                            <c:otherwise>
                                    <li><a href="/member/mypage/myboard?cp=${i}${sp}">${i}</a></li>
                            </c:otherwise>
                            </c:choose>
                            
                        </c:forEach>
                        
                        
                        
                        <li><a href="/member/mypage/myboard?cp=${pagination.nextPage}${sp}">&gt;</a></li>

                        <li><a href="/member/mypage/myboard?cp=${pagination.maxPage}${sp}">&gt;&gt;</a></li>

                    </ul>
                </div>
           

            </section>

        </section>
        
    </main>
    
</body>
</html>