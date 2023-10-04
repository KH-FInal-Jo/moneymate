<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/header.css">

<script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
<script src="resources/js/jquery-3.7.0.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

</head>
<body>
   <main class="headMain">


        <div class="head">
            <div><a href="/"><img src="/resources/images/로고.png"></a></div>
            <div class="head-board">
                <!-- 헤더 글 -->
                <div class="nav">


                    <div class="headback color-5">
                        <div class="row columns">
                        <h3 class="headH3"></h3>
                        <ul class="menu align-center expanded text-center SMN_effect-25">
                            <li class="headLi"><a href="/community/1" class="headA">커뮤니티</a></li>

                            <c:if test="${!empty loginMember}" >
                                <li class="headLi"><a href="/account/list" class="headA">가계부</a></li>
                            </c:if>

                            <li class="headLi"><a href="/consumetest" class="headA">소비 테스트</a></li>

                            <li class="headLi"><a href="/event" class="headA">이벤트</a></li>

                            <c:if test="${!empty loginMember}" >
                                <li class="headLi"><a href="/member/mypage" class="headA">마이페이지</a></li>
                            </c:if>
                            
                            <c:if test="${!empty loginMember}" >
                                <li class="headLi"><a href="/chatting" class="headA">채팅</a></li>
                            </c:if>

                            <c:if test="${loginMember.authority == 1}">
                                <li class="headLi"><a href="/admin/member" class="headA">관리자</a></li>
                            </c:if>
                        </ul>
                        </div>
                    </div>


                    <%-- <a href="/community/1"><span>커뮤니티</span></a>
                    <c:if test="${!empty loginMember}" >
                    <a href="/account/list"><span>가계부</span></a>
                    </c:if>
                    <a href="/consumetest"><span>소비 테스트</span></a>
                    <a href="/event"><span>이벤트게시판</span></a>
                    <c:if test="${!empty loginMember}" >
                        <a href="/member/mypage"><span>마이페이지</span></a>
                    </c:if>
                    <c:if test="${!empty loginMember}" >
                        <a href="/chatting"><span>채팅</span></a>
                    </c:if>
                    
                    <c:if test="${loginMember.authority == 1}">
                       <a href="/admin/member"><span>관리자</span></a>
                    </c:if> --%>
                    <c:if test="${!empty loginMember}" >

                        <span><i class="fa-solid fa-bell fa-2x" id="alarm-btn" style="color: #efe834;"></i></span>
                        <div class="alarm-area">
                            <span id="alarm-number">0</span>
                            <div id="alarm-page">
                                <div id="modal">

                                    <div id="alarmImg-area"><img src="/resources/images/로고.png" class="alarm-img"></div>

                                    <div id="alarm-head">알림</div>

                                    <div id="content-container">
                                    
                                        <a href="#">
                                            <div class="alarm-check">
                                                <img src=""><div class="alarm-content"></div>
                                            </div>
                                        </a>
                                        

                                        <div id="alarm-date"></div>
                                    </div>

                                    
                                    
                                    <button id="close-btn">닫기</button>

                                </div>
        

                            </div>
                        </div>

                    </c:if>
    
                </div>
                <!-- 헤더 프로필 -->
                <div class="login">
                    <div>
                        
                        <img src="/resources/images/로그인 아이콘.png">
                    </div>
                    <div>
                        <c:choose>
                            <c:when test="${empty loginMember}">
                                <a href="/member/login"><span>LOGIN</span></a>
                                <a href="/member/signUp"><span>회원가입</span></a>
                            </c:when>
                        
                            <c:otherwise>
                                <a href="/member/logout"><span>로그아웃</span></a>
                            </c:otherwise>
                        </c:choose>
                        
                    </div>
                    <div>
                        
                    </div>
                </div>
            </div>
        </div>


    </main>

    <script>

        const member = ${loginMember.memberNo}
        const memberName = "${loginMember.memberNickname}"
    </script>

    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="/resources/js/header.js"></script>
</body>
</html>