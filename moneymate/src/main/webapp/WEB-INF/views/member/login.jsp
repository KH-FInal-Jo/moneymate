<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">


<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인 페이지</title>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>



<script src="https://kit.fontawesome.com/d76028de4f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/member/login.css">
    <link rel="stylesheet" href="/resources/css/header.css">


</head>


<body>
	 <section>
    </section>

    <div class="container">
        <div class="logo">
            <a href="/"><img src="/resources/images/로고.png" alt=""></a>
        </div>

        <div class="input">
            <form action="/member/login" method="post" id="loginFrm">

                <div class="inputs">
                    <i class="fa-regular fa-id-badge"></i><input type="text" id="inputId" class="inputId" name="memberEmail" value="${cookie.saveId.value}">
                </div>
    
                <div class="inputs">
                    <i class="fa-solid fa-lock"></i><input type="password" id="inputPwd" name="memberPw">
                </div>
                
                <c:if test="${ !empty cookie.saveId.value}">
					<c:set var="chk" value="checked" />
				</c:if>
                
                <div class="saveId">
                    <input type="checkbox" name="saveId" ${chk} id="saveId1" value="1">
                    <label for="saveId1">아이디 저장</label>
                </div>

                <div>
                    <button id="btn1" class="btn1">로그인</button>
                </div>
                <div>
                        <div class="btn-area">
                            <div id="custom-login-btn">
                                <img src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg" width="200"  onclick="loginWithKakao()"/>
                            </div>
                        </div>
                    </button>
                </div>

            </form>

        </div>

        <div class="spans">    
            <span><a href="/member/signUp">회원가입</a></span>
            <span> | </span> 
            <span><a href="#">ID/PW 찾기</a></span>
        </div>
    </div>

    <script src="/resources/js/kakaoLogin.js"></script>
    <!-- <script src="/resources/js/kakao2.js"></script> -->
    
    
    <c:if test="${!empty message}">

            <script>
                // EL/JSTL 구문이 먼저 해석되는데
                // 문자열의 경우 따옴표가 없는 상태이니 붙여줘야한다!!!
                alert("${message}");
            </script>
            
            <%-- message 1회 출력 후 session에서 제거 --%>
        	<c:remove var="message" scope="session" />

            
    </c:if>
</body>
</html>