<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/member/myPageSidemenu.css">
    <link rel="stylesheet" href="/resources/css/member/myPageBookMark.css">
    <link rel="stylesheet" href="/resources/css/member/myPagefindPw.css">
    <script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
    <title>비밀번호 재설정(회원)</title>
</head>
<body>

    <main>
        <!-- 헤더 -->
      <jsp:include page="/WEB-INF/views/common/header.jsp"/>
       
        <section class="myPage-container">

        <!-- 사이드바 -->
           <jsp:include page="/WEB-INF/views/member/myPageSideMenu.jsp"/>

            <!-- 중간영역 -->
            <div class="container">
                <h1>비밀번호 재설정</h1> 
                <br><br>
                <form action="changePw" member="POST" name="myPageFrm" id="changPwFrm">
                    <label for="newPassword">현재 비밀번호</label>
                    <input type="password" id="Password" name="Password" required>
                    <br>

                    <label for="newPassword">새로운 비밀번호</label>
                    <input type="password" id="newPassword" name="newPassword" required>
                    <br>

                    <label for="confirmPassword">비밀번호 확인</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                    <br>
                    
                    <br><br>
                    <button type="submit">그만두기</button>
                    <button type="submit">비밀번호 변경</button>

                </form>
            </div>

        
        
        </section>

        


        <!-- 푸터 -->
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </main>
    
</body>
</html>