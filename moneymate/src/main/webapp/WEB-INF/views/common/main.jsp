<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/footer.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	
	 <section class="container">

        <div class="container1">
            <div id="container2">
                <div id="item1">
                    
                    <p style=" margin-top: 250px;">
                        내 돈 관리 똑똑하게</p>                    
                    <p>데이터 기반 자동</p>
                    
                </div>
                <div id="item2">
                    <form action=""></form>
                    <button class="button">로그인</button>
                    <button class="button">회원가입</button>
                </div>
                <div id="item3">
                    
                </div>
            </div>
            <div class="container3-1">
                <div class="box">
                    <div class="front"><img src="/resources/images/img_point4.png"></div>
                    <div class="front"><img src="/resources/images/img_point2.png"></div>
                </div>
                <div class="box">
                    <div class="front1"><img src="/resources/images/img_point6.png"></div>
                    <div class="front1"><img src="/resources/images/img_point5.png"></div>
        
                </div>
        
            </div>

        </div><hr>        


        <!-- 2쪽 -->
        <div class="container1-1" >
            <div class="top">데이터 기반 자동 가계부</div>
            <div class="middle" >
                <div id="left" class="animate__animated animate__flipInY"><img src="/resources/images/img_sreen_light5.png" alt=""></div>
                <div id="middle" class="animate__animated animate__flipInY"><img src="/resources/images/img_point1.png" alt=""></div>
                <div id="right" class="animate__animated animate__flipInY"><img src="/resources/images/img_sreen_light3.png" alt=""></div>

            </div>
            
        </div><hr>

        <div class="container1-2">
            <div class="middle1">
                <div id="left1"><img src="/resources/images/img_point7.png"> </div>
                <div id="font1">
                    <h1>캘린더에 눈에 보기 쉽게</h1>
                    <b>수입과 지출을 한눈에</b>
                        <br>                    
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                    
                </div>
            </div>
            <div class="middle1">
                <div id="font2">
                    <h1>캘린더에 눈에 보기 쉽게</h1>
                    <b>수입과 지출을 한눈에</b>
                        <br>                    
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                    

                </div>
                <div id="right1"> <img src="/resources/images/img_point8.png"> </div>
            </div>

        </div>
        <hr>

        
        <div class="container1">#</div><hr>
        <div class="container1-5">
            <div class="middle5">
               
                <div id="font5-1">
                    <h1>함께 해서 더 즐거운</h1>
                        
                    <b>가족과 함께</b>
                        <br>                    
                    <b>친구들과 함께</b>
                        <br>                                     
                </div>
                
                <div id="right5"><img src="/resources/images/sample1.png"> </div>
            </div>
            <div class="middle5">
                <div id="font5">
                    <h1>캘린더에 눈에 보기 쉽게</h1>
                    <b>수입과 지출을 한눈에</b>
                        <br>                    
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                        <br>
                    <b>내 지갑을 지킬 수 있는 가계부</b>
                </div>
                
                <div id="right5"> <img src="/resources/images/sample1.png"> </div>
            </div>

        </div>
        <hr>
        <div class="container1">#</div><hr>

    </section>
    

	
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
	<script>document.documentElement.style.setProperty('--animate-duration', '2s');</script>

	
</body>
</html>