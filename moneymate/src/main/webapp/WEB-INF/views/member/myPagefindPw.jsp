<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
    <script src="https://kit.fontawesome.com/98acdabf0d.js" crossorigin="anonymous"></script>
    <title>비밀번호 재설정(회원)</title>
</head>
<body>

    <main>
        <!-- 헤더 -->
        <section>
            <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        </section>
        <!-- 사이드바 -->
        <section class="myPage-container">

            <jsp:include page="/WEB-INF/views/member/myPageSideMenu.jsp"/>
            <!-- 중간영역 -->
            <div class="container">
                <h1>비밀번호 재설정</h1> <br><br>
                <span>현재 비밀번호가 일치하는 경우 새 비밀번호로 변경할 수 있습니다.</span>
                <form action="/member/mypage/findPw" method="POST" name="myPageFrm" id="changePwFrm">
                    <label for="newPassword">현재 비밀번호</label>
                    <input type="password" id="Password" name="Password" maxlength="30" required>
                    <br>

                    <label for="newPassword">새로운 비밀번호</label>
                    <input type="password" id="newPassword" name="newPassword" maxlength="30" required>
                    <br>

                    <label for="confirmPassword">비밀번호 확인</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" maxlength="30" required>
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

    <script src="/resources/js/myPage.js"></script>
    
</body>
</html>