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

	<c:if test="${!empty param.sel}" >
            <c:set var="sp" value="&sel=${param.sel}&query=${param.query}"/>
    </c:if>

    <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="board-notice-content">

        <jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp" />


            <section class="board-notice-main">
                <div class="board-notice-name">자유 게시판</div>

                <c:if test="${!empty param.query}" >
                <h3 class="searchResult">'${param.query}' 검색 결과</h3>
                </c:if>

                <div class="freeBoard-area">
                    <table border="1" class="freeBoard">
                        <thead>
                            <tr class="board-header">
                                <th class="no">번호</th>
                                <th class="title">제목</th>
                                <th class="writer">작성자</th>
                                <th class="date">작성일</th>
                                <th class="view">조회수</th>
                                <th class="good">좋아요</th>
                            </tr>
                        </thead>

                        <tbody>
                            
                            
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
		                            <tr class="board-body">
		                                <td>${board.boardNo}</td>
		                                <td class="title"> 
			                                <c:if test="${!empty board.thumbnail}" >
			                                    <img class="list-thumbnail" src="${board.thumbnail}">
			                                </c:if>
		                                    <a href="/community/3/${board.boardNo}?cp=${pagination.currentPage}${sp}">${board.boardTitle}</a>   
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
                        <form action="${boardCode}" method="get" id="boardSearch">
                            <div>
                                <select id="sel" name="sel">
                                    <option value="t" selected>제목</option>
                                    <option value="c" >내용</option>
                                    <option value="tc">제목+내용</option>
                                    <option value="w">작성자</option>
                                </select>
                                <input type="text" id="query" name="query" value="${param.query}">
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
                
                    <li><a href="/board/3?cp=1${sp}">&lt;&lt;</a></li>

                    <li><a href="/board/3?cp=${pagination.prevPage}${sp}">&lt;</a></li>

               
                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                        <c:choose>
                           <c:when test="${i == pagination.currentPage}">
                                <li><a class="current">${i}</a></li>
                           </c:when>
                        
                           <c:otherwise>
                                <li><a href="/community/3?cp=${i}${sp}">${i}</a></li>
                           </c:otherwise>
                        </c:choose>
                        
                    </c:forEach>
                    
                    
                    
                    <li><a href="/community/3?cp=${pagination.nextPage}${sp}">&gt;</a></li>

                    <li><a href="/community/3?cp=${pagination.maxPage}${sp}">&gt;&gt;</a></li>

                </ul>
            </div>


                

            </section>

        </section>

        <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    </main>

    <script src="/resources/js/freeBoard.js" ></script>
    
</body>
</html>