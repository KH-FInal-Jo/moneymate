<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%-- map에 저장된 값들을 각각 변수에 저장 --%>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="boardList" value="${map.boardList}"/>

<%-- <c:set var="boardName" value="${boardTypeList[boardCode-1].BOARD_NAME}"/> --%>

<c:forEach items="${boardTypeList}" var="boardType">
    <c:if test="${boardType.BOARD_CODE == boardCode}" >
        <c:set var="boardName" value="${boardType.BOARD_NAME}"/>
    </c:if>
</c:forEach>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/board/boardSidemenu-style.css">
    <link rel="stylesheet" href="../css/board/InquiryBulletinBoard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/footer.css">
    <title>문의게시판</title>
    <script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
</head>
<body>

    <main>
    <%-- 헤더 --%>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
      

        <section class="board-notice-content">

        <%-- 사이드바 --%>
           <jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp" />

            <section class="InquiryBulletinBoardmain">
                
                <div class="Bcontainer1">문의게시판</div>
                
                <div class="Bcontainer2"></div>
                
                <div class="Bcontainer3">
                    <select name="open" id="open">
                        <option value="">게시글</option>
                        <option value="">#</option>
                        <option value="">#</option>
                        <option value="">#</option>
                        <option value="">#</option>
                    </select>
                    <form action="/search" method="get">
                        <div class="search-container">
                            <label for="search-input" class="sr-only">검색어 입력:</label>
                            <input type="text" id="search-input" name="q" placeholder="검색어를 입력하세요..." required>
                            <button type="submit" class="search-button"><i class="fas fa-search"></i></button>
                        </div>
                    </form>
                </div>
                
                <div class="Bcontainer4">
                    <table>
                        <thead>
                            <tr>
                                <th class="center">번호</th>
                                <th>제목</th>
                                <th class="center">작성자</th>
                                <th class="center">작성일</th>
                                <th class="center">조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="center">5</td>
                                <td>문의게시판 게시글 제목입니다.</td>
                                <td>유저일</td>
                                <td class="center">2023.08.23</td>
                                <td class="center">10</td>
                            </tr>
                           
                            <tr>
                                <td class="center">4</td>
                                <td>문의게시판 게시글 제목입니다.</td>
                                <td>유저이</td>
                                <td class="center">2023.08.23</td>
                                <td class="center">10</td>
                            </tr>

                            <tr>
                                <td class="center">3</td>
                                <td>문의게시판 게시글 제목입니다.</td>
                                <td>유저삼</td>
                                <td class="center">2023.08.23</td>
                                <td class="center">10</td>
                            </tr>

                            <tr>
                                <td class="center">2</td>
                                <td>문의게시판 게시글 제목입니다.</td>
                                <td>유저사</td>
                                <td class="center">2023.08.23</td>
                                <td class="center">10</td>
                            </tr>

                            <tr>
                                <td class="center">1</td>
                                <td>문의게시판 게시글 제목입니다.</td>
                                <td>유저오</td>
                                <td class="center">2023.08.23</td>
                                <td class="center">10</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="Bcontainer5">

                    <div class="Bcontainer5-1"></div>

                    <div class="Bcontainer5-1">
                        <div class="pagination-container">
                            <ul class="pagination">
                                <li><a href="#">&laquo;</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </div>
                    
                    </div>
                    <div class="Bcontainer5-1">
                        <a href="#" class="write-button">글쓰기</a>
                    </div>
                </div>


            </section>

        </section>

<%-- 푸터 --%>
     <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    </main>
    
</body>
</html>