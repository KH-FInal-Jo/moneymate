<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/member/myPageBookMark.css">
<script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
<title>마이페이지 사이드메뉴</title>
</head>
<body>

    <main>
    
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="myPage-container">

            <jsp:include page="/WEB-INF/views/member/myPageSideMenu.jsp" />

            <section class="myPage-main">
                <div class="myPage-list-header-name">북마크 목록</div>
                <div class="myPage-list-container">
                    <div class="myPage-bookmark">
                        <div><i class="fa-solid fa-bookmark fa-xl"></i></div>
                        <div><a href="#"><img src="../images/dog1.jpg"></a></div>
                        <div>
                            <div>게시글 제목~</div>
                            <div>게시글내용용용</div>
                        </div>
                    </div>

                    <div class="myPage-bookmark">
                        <div><i class="fa-solid fa-bookmark fa-xl"></i></div>
                        <div><a href="#"><img src="../images/금융칼럼.jpg"></a></div>
                        <div>
                            <div>게시글 제목~</div>
                            <div>게시글내용용용</div>
                        </div>
                    </div>

                    <div class="myPage-bookmark">
                        <div><i class="fa-solid fa-bookmark fa-xl"></i></div>
                        <div><a href="#"><img src="../images/dog1.jpg"></a></div>
                        <div>
                            <div>게시글 제목~</div>
                            <div>게시글내용용용</div>
                        </div>
                    </div>

                    <div class="myPage-bookmark">
                        <div><i class="fa-solid fa-bookmark fa-xl"></i></div>
                        <div><a href="#"><img src="../images/dog1.jpg"></a></div>
                        <div>
                            <div>게시글 제목~</div>
                            <div>게시글내용용용</div>
                        </div>
                    </div>

                    <div class="page">
                        <a href="#">&lt;&lt;</a>
                        <a href="#">&lt;</a>
                        <a href="#">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                        <a href="#">5</a>
                        <a href="#">6</a>
                        <a href="#">7</a>
                        <a href="#">8</a>
                        <a href="#">9</a>
                        <a href="#">10</a>
                        <a href="#">&gt;</a>
                        <a href="#">&gt;&gt;</a>
                    </div>
                    
                </div>

            </section>

        </section>
    </main>
    
</body>
</html>