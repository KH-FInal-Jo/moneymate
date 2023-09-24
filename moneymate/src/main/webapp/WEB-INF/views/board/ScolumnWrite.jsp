<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칼럼 글쓰기</title>

    <link rel="stylesheet" href="/resources/css/columnWrite.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">


    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
</head>
<body>

    <main class="headMain">


        <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    </main>

    <main class="Cwrite-main">

         <jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp"></jsp:include>



            <div class="write-main">
                <h3 id="write-title"> 글 제목 : 
                </h3>
                <input type="text" placeholder="제목을 입력해주세요." id="Wtitle" name="boardTitle">
    
                <div class="img-box">
                    <div class="thumbnail">
                        <label for="img0" class="photo">
                            <i class="fa-regular fa-image fa-lg" style="color: #1476d2;"></i> 사진첨부
                        </label>
                        <input type="file" class="inputImage" id="img0" name="images" accept="image/*">
                    </div>
                </div>
    
                <div id="text" name="boardContent" contentEditable="true">
                    
                </div>  
    
                <div class="btn">
                 <span><button id="finish">등록하기</button></span>
                </div>
    
            </div>



        

    </main>

   

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

     <script src="/resources/js/ScolumnWrite.js"></script>
    
</body>
</html>