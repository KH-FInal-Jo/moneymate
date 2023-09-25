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

        <section class="board-sidemenu">
            <div class="board-community-header">
                <div>커뮤니티 </div>
                <div>community</div>
            </div>
            <ul class="board-sidemenu-list">

                <li><a href="#">공지사항<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                
                <li><a href="#">문의게시판<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                
                <li><a href="#">자유게시판<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                
                <li><a href="#">컬럼게시판<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
            </ul>

        </section>

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
                <div class="img-box">
                    <div class="boardImg thumbnail">
                        <label for="img0">
                            <img class="preview" src="${board.imageList[0].imagePath}${board.imageList[0].imageRename}">
                        </label>
                    </div>
                </div>

                <!-- 업로드 이미지 영역 -->
                <h5>업로드 이미지</h5>
                <div class="img-box">

                    <div class="boardImg">
                        <label for="img1">
                            <img class="preview" src="">
                        </label>
                    </div>

                    <div class="boardImg">
                        <label for="img2">
                            <img class="preview" src="">
                        </label>
                    </div>

                    <div class="boardImg">
                        <label for="img3">
                            <img class="preview" src="">
                        </label>
                    </div>

                    <div class="boardImg">
                        <label for="img4">
                            <img class="preview" src="">
                        </label>
                    </div>
                </div>



    
                <div id="text" name="boardContent">
                    ${board.boardContent}
                </div> 


            </div>
            <div>
                
                    <span><button id="previous">이전글</button></span>
                    <span id="likeBtn"><i class="fa-regular fa-thumbs-up fa-2x" style="color: #0c40ca;"></i></i> 10</span>
                    <span><button id="next">다음글</button></span>
            </div>

            
            <div class="other-title">다른 칼럼 보러가기</div>
            <div class="other">
                <div class="otherView">

                    <div><a href="#"><img src="/resources/images/dog1.jpg"></a></div>
                    <div><a href="#">다른 칼럼 제목</a></div>

                </div>
                <div class="otherView">
                    <div><a href=""><img src="/resources/images/금융칼럼.jpg"></a></div>
                    <div><a href="">다른 칼럼 제목다른 칼럼 제목다른 칼럼 제목다른 칼럼 제목다른 칼럼 제목</a></div>

                </div>
                <div class="otherView">
                    <div><a href=""><img src="/resources/images/dog1.jpg"></a></div>
                    <div><a href="#">다른 칼럼 제목</a></div>

                </div>
            </div>
        </div>
    </main>

    <footer>
         <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    </footer>

    <script src="/resources/js/ScolumnDetail.js"></script>
    
</body>
</html>