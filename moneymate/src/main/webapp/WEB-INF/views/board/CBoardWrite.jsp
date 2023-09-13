<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <div class="subject">자유게시판 글쓰기</div>

                <form action="/community/3/insert" method="POST" class="board-write" id="boardWriteFrm" enctype="multipart/form-data">
                    <h1 class="board-title">
                        <input type="text" name="boardTitle" placeholder="제목" value="">
                    </h1>

                    <h5>업로드 이미지</h5>
                    <div class="img-box">

                        <div class="boardImg">
                            <label for="img1">
                                <img class="preview" src="">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img1" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img2">
                                <img class="preview" src="">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img2" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img3">
                                <img class="preview" src="">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img3" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img4">
                                <img class="preview" src="">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img4" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img5">
                                <img class="preview" src="">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img5" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>
                    </div>

                    <div class="board-content">
                        <textarea class="boardContent">테스트 게시글 내용입니다.</textarea>
                    </div>

                    <div class="board-btn-area">
                        <button type="submit" id="writebtn">등록</button>
                    </div>

                </form>
    
            </section>
        </section>



    </main>


    <script src="/resources/js/freeBoardWrite.js"></script>
</body>
</html>