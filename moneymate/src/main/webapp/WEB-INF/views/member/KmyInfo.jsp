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
    <link rel="stylesheet" href="/resources/css/member/myInfo.css">
    <script src="https://kit.fontawesome.com/98acdabf0d.js" crossorigin="anonymous"></script>
    <title>회원정보 조회</title>
</head>

<body>

    <main>
        <!-- 헤더 -->
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
       
        <!-- 사이드바 -->
        <section class="myPage-container">
 		<jsp:include page="/WEB-INF/views/member/myPageSideMenu.jsp"/>

            <div class="container">
                <h1>내 정보 수정</h1>
                <form action="/member/KmyInfo" method="POST" name="myPageFrm" id="updateInfo">
                    <div class="profile">

                        <div class="image-section">
                            <img src="/resources/images/dog1.jpg" class="myInfoImg" alt="프로필 이미지">

                            <div>
                                <input type="file" name="imageInput" id="imageInput" accept="image/*">
                                <label for="imageInput" id="chooseButton">
                                    이미지 선택
                                </label>
                                <button type="submit" id="changeButton">변경하기</button>
                            </div>
                        </div>

                        <div class="info-section">

                            <table>
                                <tr>
                                    <th>이름</th>
                                    <td  class="borderno"><input></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>아이디</th>
                                    <td><input></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>이메일</th>
                                    <td><input></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>전화번호</th>
                                    <td><input></td>
                                    <td></td>
                                </tr>
                                <c:set var="addr" value="${fn:split(loginMember.memberAddress, '^^^')}"/>
                                <tr>
                                    <th><button id="searchButton">주소검색</th>
                                    <td><input></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <td><input></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <td><input></td>
                                    <td></td>
                                </tr>


                            </table>
                           
                        </div>
                    </div>
                </form>

            </div>


</body>

</html>


</section>

<!-- 푸터 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</main>

</body>
<script src="/resources/js/myInfo.js"></script>

</html>