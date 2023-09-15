<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">
    <link rel="stylesheet" href="/resources/css/board/InquiryBulletinBoardWrtie.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <title>문의게시판</title>
    <script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
</head>
<body>

    <main>
    <%-- 헤더 --%>${board}
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
      <section class="board-notice-content">
        <%-- 사이드바 --%>
           <jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp" />

            <section class="board-free-main">
                <div class="subject">문의게시판 수정</div>

                <form action="update" method="POST" 
                class="board-write" id="boardWriteFrm" enctype="multipart/form-data">
                    <h1 class="board-title">
                        <input type="text" class="boardTitle"  name="boardTitle" placeholder="제목" value="${board.boardTitle}">
                    </h1>

                   
                    <div class="board-content">
                        <textarea class="boardContent" name="boardContent">${board.boardContent}</textarea>
                    </div>

                    <div class="board-btn-area">
                        <button type="submit" id="updateBtn">수정하기</button>
                    </div>

                </form>
    
            </section>
      </section>


            

<%-- 푸터 --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    
    </main>

    <script src="/resources/js/boardInquiryUpdate.js"></script>
    
</body>
</html>