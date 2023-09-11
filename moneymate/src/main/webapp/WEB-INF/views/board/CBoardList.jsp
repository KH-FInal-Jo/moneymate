<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="boardList" value="${map.boardList}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">
<link rel="stylesheet" href="/resources/css/board/freeBoard.css">
<link rel="stylesheet" href="/resources/css/header.css">

</head>
<body>

	<c:if test="${!empty param.key}" >
            <c:set var="sp" value="&key=${param.key}&query=${param.query}"/>
    </c:if>

    <main>
        <section>
            <div class="head">
                <div><a href=""><img src="/resources/images/로고.png"></a></div>
                <div class="head-board">
                    <!-- 헤더 글 -->
                    <div class="nav">
                        <a href=""><span>커뮤니티</span></a>
                        <a href=""><span>가계부</span></a>
                        <a href=""><span>소비 테스트</span></a>
                        <a href=""><span>이벤트게시판</span></a>
                        <a href=""><span>마이페이지</span></a>
        
                    </div>
                    <!-- 헤더 프로필 -->
                    <div class="login">
                        <div>
                            
                            <img src="/resources/images/로그인 아이콘.png">
                        </div>
                        <div>
                            <a href=""><span>LOGIN</span></a>
                            <a href=""><span>회원가입</span></a>
    
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="board-notice-content">

            <section class="j-board-sidemenu">
                <div class="j-board-community-header">
                    <div>커뮤니티</div>
                    <div>community</div>
                </div>
                <ul class="j-board-sidemenu-list">

                    <li><a href="#">공지사항<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                    
                    <li><a href="#">문의게시판<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                    
                    <li><a href="#">자유게시판<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                    
                    <li><a href="#">컬럼게시판<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                </ul>

            </section>


            <section class="board-notice-main">
                <div class="board-notice-name">자유 게시판</div>

                

                <div class="freeBoard-area">
                    <table border="1" class="freeBoard">
                        <thead>
                            <tr class="board-head">
                                <th class="no">번호</th>
                                <th class="title">제목</th>
                                <th class="writer">작성자</th>
                                <th class="date">작성일</th>
                                <th class="view">조회수</th>
                                <th class="good">좋아요</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr class="board-body">
                                <td>1</td>
                                <td><a href="#">1번 게시글 입니다.</a></td>
                                <td><a href="#">유저일</a></td>
                                <td>2023.08.31</td>
                                <td>1</td>
                                <td>1</td>
                            </tr>
                            
                       <c:choose>
	                       <c:when test="${empty boardList}">
	                            <%-- 조회된 게시글 목록이 비어있거나 null인 경우 --%>
	                            <tr>
	                                <th colspan="6">게시글이 존재하지 않습니다.</th>
	                            </tr>
	                       </c:when>
	                    
	                       <c:otherwise>
	                        <!-- 게시글 목록 조회 결과가 있다면 -->
		                        <c:forEach items="${boardList}" var="board">
		                            <tr class="board-head">
		                                <td>${board.boardNo}</td>
		                                <td> 
			                                <c:if test="${!empty board.thumbnail}" >
			                                    <img class="list-thumbnail" src="${board.thumbnail}">
			                                </c:if>
		                                    <a href="/board/${boardCode}/${board.boardNo}?cp=${pagination.currentPage}${sp}">${board.boardTitle}</a>   
		                                    [${board.commentCount}]                        
		                                </td>
		                                <td>${board.memberNickname}</td>
		                                <td>${board.boardCreateDate}</td>
		                                <td>${board.readCount}</td>
		                                <td>${board.likeCount}</td>
		                            </tr>
		                        </c:forEach>
	                       </c:otherwise>
                    </c:choose>
                         
                           
                        </tbody>
                    </table>
                </div>

                <div class="search-area">
                    <div class="search">
                        <form>
                            <div>
                                <select id="sel" name="sel">
                                    <option value="1" selected>제목</option>
                                    <option value="2" >내용</option>
                                    <option value="3">제목+내용</option>
                                    <option value="4">작성자</option>
                                </select>
                                <input type="text" id="query">
                                <button id="btn1">검색</button>
                            </div>
                        </form>
                    </div>

                    <div class="btn-area">
                        <button id="btn2">글쓰기</button>
                    </div>
                </div>

                <div class="pagination-area">


                <ul class="pagination">
                
                    <li><a href="/board/${boardCode}?cp=1${sp}">&lt;&lt;</a></li>

                    <li><a href="/board/${boardCode}?cp=${pagination.prevPage}${sp}">&lt;</a></li>

               
                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                        <c:choose>
                           <c:when test="${i == pagination.currentPage}">
                                <li><a class="current">${i}</a></li>
                           </c:when>
                        
                           <c:otherwise>
                                <li><a href="/board/${boardCode}?cp=${i}${sp}">${i}</a></li>
                           </c:otherwise>
                        </c:choose>
                        
                    </c:forEach>
                    
                    
                    
                    <li><a href="/board/${boardCode}?cp=${pagination.nextPage}${sp}">&gt;</a></li>

                    <li><a href="/board/${boardCode}?cp=${pagination.maxPage}${sp}">&gt;&gt;</a></li>

                </ul>
            </div>


                

            </section>

        </section>
    </main>
    
</body>
</html>