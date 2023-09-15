<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글쓰기</title>

<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">
<link rel="stylesheet" href="/resources/css/board/freeBoardWrtie.css">

</head>
<body>
<main>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="board-notice-content">

           <jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp" />
           
            <section class="board-free-main">
                <div class="subject">자유게시판 글 수정하기</div>

                <form action="update" method="POST" class="board-write" id="boardUpdateFrm" enctype="multipart/form-data">
                    <h1 class="board-title">
                        <input type="text" name="boardTitle" placeholder="제목" value="${board.boardTitle}">
                    </h1>

                    <c:forEach items="${board.imageList}" var="img">
                        <c:choose>
                            <c:when test="${img.imageOrder == 0}">
                                <c:set var="img0" value="${img.imagePath}${img.imageReName}"/>
                            </c:when>
                            <c:when test="${img.imageOrder == 1}">
                                <c:set var="img1" value="${img.imagePath}${img.imageReName}"/>
                            </c:when>
                            <c:when test="${img.imageOrder == 2}">
                                <c:set var="img2" value="${img.imagePath}${img.imageReName}"/>
                            </c:when>
                            <c:when test="${img.imageOrder == 3}">
                                <c:set var="img3" value="${img.imagePath}${img.imageReName}"/>
                            </c:when>
                            <c:when test="${img.imageOrder == 4}">
                                <c:set var="img4" value="${img.imagePath}${img.imageReName}"/>
                            </c:when>
                        </c:choose>
                    </c:forEach>

                    <h5>업로드 이미지</h5>
                    <div class="img-box">

                        <div class="boardImg">
                            <label for="img1">
                                <img class="preview" src="${img0}">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img1" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img2">
                                <img class="preview" src="${img1}">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img2" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img3">
                                <img class="preview" src="${img2}">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img3" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img4">
                                <img class="preview" src="${img3}">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img4" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img5">
                                <img class="preview" src="${img4}">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img5" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>
                    </div>

                    <div class="board-content">
                        <textarea class="boardContent" name="boardContent">${board.boardContent}</textarea>
                    </div>

                    <div class="board-btn-area">
                        <button type="submit" id="writebtn">등록</button>
                    </div>

                    <%-- 기존 이미지가 있다가 삭제된 이미지의 순서를 기록 --%>
                    <input type="hidden" name="deleteList" value="">

                    <%-- 수정 성공 시 주소(쿼리스트링) 유지 용도 --%>
                    <input type="hidden" name="cp" value="${param.cp}">

                </form>
    
            </section>
        </section>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />

    </main>


    <script src="/resources/js/freeBoardUpdate.js"></script>
</body>
</html>