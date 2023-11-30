<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칼럼 상세보기</title>

    <link rel="stylesheet" href="/resources/css/columnDetail.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">

    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
</head>
<body>

    <main class="headMain">


        <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>


    </main>



    <main class="detailMain">
           <jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp"></jsp:include>



        <div class="detail">

            <div class="writer">
                작성자 : ${board.memberNickname}
            </div>
            <div class="createDate">
                작성일 : ${board.boardCreateDate}
            </div>
            <div class="readCount">   
                조회수 : ${board.readCount}
            </div>
            <div class="title">
                ${board.boardTitle}
            </div>

            <%-- 썸네일 --%>
            <div class="article">
                



    
                <div id="text" name="boardContent">


               
                    <%-- 현재 게시글 내용의 전체길이를 ('^^^') 기준으로 잘라서 contents 배열에 대입 --%>
                    <c:set var="contents" value="${fn:split(board.boardContent, '^^^')}" />

                    <%-- 게시글의 이미지 개수를 for문 돌려서 인덱스 번호 생성 --%>
                    <c:forEach items="${board.imageList}" var="img" varStatus="imgLoop">
                        <img class="preview" src="${img.imagePath}${img.imageRename}">
                        
                        <%-- contents 배열에 인덱스 번호 주어서 0번째, 1번째... 순서대로 요소 출력 --%>
                        <div class="content">${contents[imgLoop.index]}</div>
                        <%-- 0번째 요소 출력하고 다시 위로 올라가서 다음번째 이미지 출력 --%>

                    </c:forEach>



                    <%-- ${board.boardContent} --%>
                </div> 


            </div>
            <div>
                
                    <span><button id="previous">이전글</button></span>

                    <div>
                        <%-- 좋아요 안눌렀을때 --%>
                        <c:if test="${empty likeCheck}" >
                        <i class="fa-regular fa-thumbs-up fa-2x" style="color: #0c40ca;" id="boardLike"></i></i>
                        <span id="likeBtn">${board.likeCount}</span>

                        </c:if>

                        <%-- 좋아요 눌렀을 때 --%>
                        <c:if test="${!empty likeCheck}" >
                        <i class="fa-solid fa-thumbs-up fa-2x" style="color: #2c4cce;" id="boardLike"></i></i>
                        <span id="likeBtn">${board.likeCount}</span>
                            
                        </c:if>
                    
                    </div>


                    <span><button id="next">다음글</button></span>
            </div>
            
            <a href="/community/4"><span><button id="list">목록으로</button></span></a>

            <%-- 관리자만 보이게 --%>
            <c:if test="${loginMember.memberNo == 1}" >
                <div id="update-area">

                    <button id="delete-btn">삭제하기</button>
                    <button id="update-btn">수정하기</button>
                </div>

            </c:if>


            
            <div class="other-title">다른 칼럼 보러가기</div>
            <div class="other">
                <c:forEach items="${randomList}" var="random">

                    <div class="otherView">

                        <div><a href="/community/4/${random.boardNo}"><img src="${random.thumbNail}"></a></div>
                        <div><a href="/community/4/${random.boardNo}">${random.boardTitle}</a></div>

                    </div>
                   

                </c:forEach>
            </div>
        </div>
    </main>

    <footer>
         <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

    </footer>


    <script>

        const boardNo = ${board.boardNo};

        const memberNo = ${loginMember.memberNo}
    </script>

    <script src="/resources/js/ScolumnDetail.js"></script>
    
</body>
</html>