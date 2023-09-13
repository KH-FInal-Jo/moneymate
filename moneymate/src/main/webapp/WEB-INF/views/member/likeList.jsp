<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="boardList" value="${resMap.boardList}"/>
<c:set var="pagination" value="${resMap.pagination}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>좋아요 목록</title>
    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
  
    <link rel="stylesheet" href="/resources/css/member/myPageSidemenu.css">
    <link rel="stylesheet" href="/resources/css/member/myPageSidemenu.css">
    <link rel="stylesheet" href="/resources/css/member/likeList.css">
    <link rel="stylesheet" href="/resources/css/header.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div id="all">
        <jsp:include page="/WEB-INF/views/member/myPageSideMenu.jsp"/>

        <div id="main">

            <div><i class="fa-solid fa-heart titleName"></i>  &nbsp;&nbsp; &nbsp; 
                좋아요 목록  &nbsp;&nbsp; &nbsp; 
                <i class="fa-solid fa-heart titleName"></i>
            </div>

            <div>
                <!-- <form action="#">
                    <select name="bt" id="bt">
                        <option value="whole">전체</option>
                        <option value="free">자유게시판</option>
                        <option value="column">칼럼게시판</option>
                    </select>
                </form> -->

                <article class="cont-select">
                    <button class="btn-select" id="realBtn">전체</button>
                    <ul class="list-member">
                      <li><button type="button" onclick="location.href='/member/mypage/likeList/0/${loginMember.memberNo}'">전체</button></li>
                      <li><button type="button" onclick="location.href='/member/mypage/likeList/3/${loginMember.memberNo}'">자유게시판</button></li>
                      <li><button type="button" onclick="location.href='/member/mypage/likeList/4/${loginMember.memberNo}'">컬럼게시판</button></li>
                    </ul>
                  </article>
            </div>

            <c:choose>
                <c:when test="${empty boardList}">
                    <div id="none">좋아요한 게시글이 없습니다.</div>
                </c:when>

                <c:otherwise>
                    <c:forEach items="${boardList}" var="board">
        
                        <div class="eachOne">
                            <div>
                                <i class="fa-solid fa-heart boardLike"></i>
                            </div>
                            <div>
                                <c:if test="${!empty board.thumbnail}" >
                                    <img src="${board.thumbnail}" class="thumbnail">
                                </c:if>
                            </div>
                            <div class="likeContent"  onclick="location.href='/'">
                                <div>${board.boardName}</div>
                                <div>
                                    <span>${board.boardTitle}</span>
                                </div>
                            </div>
                        </div>
        
                    </c:forEach>

                </c:otherwise>
            </c:choose>


            <div class="pagination-area">

            <c:set var="url" value=""/>


                <ul class="pagination">
                
                    <!-- 첫 페이지로 이동 -->
                    <li><a href="/member/mypage/likeList/${boardCode}/${loginMember.memberNo}">&lt;&lt;</a></li>
                    <!-- 이전 목록 시작 번호로 이동 -->
                    <li><a href="/member/mypage/likeList/${boardCode}/${loginMember.memberNo}?cp=${pagination.prevPage}">&lt;</a></li>

               
                    <!-- 특정 페이지로 이동 -->

                    <%-- location.pathname.split("/")[4] --%>

                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                        <c:choose>
                           <c:when test="${i == pagination.currentPage}"> 
                                <li><a class="current">${i}</a></li>
                          </c:when>
                        
                           <c:otherwise> 
                                <li><a href="/member/mypage/likeList/${boardCode}/${loginMember.memberNo}?cp=${i}">${i}</a></li> 
                           </c:otherwise>
                        </c:choose>
                        
                    </c:forEach> 
                    
                    
                    
                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="/member/mypage/likeList/${boardCode}/${loginMember.memberNo}?cp=${pagination.nextPage}">&gt;</a></li>

                    <!-- 끝 페이지로 이동 -->
                    <li><a href="/member/mypage/likeList/${boardCode}/${loginMember.memberNo}?cp=${pagination.maxPage}">&gt;&gt;</a></li>

                </ul>
            </div>

        </div>

    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>


    <script src="/resources/js/likeList.js"></script>
</body>
</html>