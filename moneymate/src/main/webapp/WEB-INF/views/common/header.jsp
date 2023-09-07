<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/header.css">

</head>
<body>
	<main class="headMain">


        <div class="head">
            <div><a href=""><img src="/resources/images/로고.png"></a></div>
            <div class="head-board">
                <!-- 헤더 글 -->
                <div class="nav">
                    <a href=""><span>커뮤니티</span></a>
                    <a href=""><span>가계부</span></a>
                    <a href=""><span>소비 테스트</span></a>
                    <a href=""><span>이벤트게시판</span></a>
                    <a href=""><span>마이페이지</span></a>
                    <span><i class="fa-solid fa-bell fa-2x" id="alarm-btn" style="color: #efe834;"></i></span>
                    <div class="alarm-area">
                        
                        <span id="alarm-number">1</span>
                        <div id="alarm-page">
                            <div class="alarm-check">
                                <span><i class="fa-solid fa-right-to-bracket"></i></span>
                                <a href="#"><span>작성하신 댓글에 답글이 달렸습니다.11</span></a>
                            </div>
                            <div class="alarm-check">
                                <span><i class="fa-solid fa-right-to-bracket"></i></span>
                                <a href="#"><span>작성하신 댓글에 답글이 달렸습니다.22</span></a>
                            </div>
                            <div class="alarm-check">
                                <span><i class="fa-solid fa-right-to-bracket"></i></span>
                                <a href="#"><span>작성하신 댓글에 답글이 달렸습니다.33</span></a>
                            </div>
                            <button id="close-btn">닫기</button>
    

                        </div>
                    </div>
    
                </div>
                <!-- 헤더 프로필 -->
                <div class="login">
                    <div>
                        
                        <img src="/resources/images/로그인 아이콘.png">
                    </div>
                    <div>
                        <a href="/member/login"><span>LOGIN</span></a>
                        <a href=""><span>회원가입</span></a>

                    </div>
                    <div>
                        
                    </div>
                </div>
            </div>
        </div>


    </main>

    <script src="/resources/js/header.js"></script>
</body>
</html>