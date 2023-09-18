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
                <form action="/member/mypage" method="POST" name="myPageFrm" id="UpdateProfile" enctype="multipart/form-data">

                    <div class="profile">

                        <div class="image-section">

                            <c:if test="${empty loginMember.profileImage}" >
                                <img src="/resources/images/dog1.jpg" class="myInfoImg" id ="profileImage" alt="프로필 이미지">
                            </c:if>

                            <c:if test="${!empty loginMember.profileImage}" >
                                <img src="${loginMember.profileImage}" id="profileImage">
                            </c:if>


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
                                    <td  class="borderno">
                                        <input type="text" name="memberName" maxlength="8"
                                            value="${loginMember.memberName}" id="memberName">
                                            
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>닉네임</th>
                                    <td>
                                        <input type="text" name="memberNickname" maxlength="10"
                                            value="${loginMember.memberNickname}" id="memberNickname">
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>이메일</th>
                                    <td>
                                        <input type="text" name="memberEmail" maxlength="20"
                                            value="${loginMember.memberEmail}" id="memberEmail">
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>전화번호</th>
                                    <td>
                                        <input type="text" name="memberTel" maxlength="11"
                                            value="${loginMember.memberTel}" id="memberTel">
                                    </td>
                                    <td></td>
                                </tr>
                                <c:set var="addr" value="${fn:split(loginMember.memberAddress, '^^^')}"/>
                                <tr>
                                    <th><button id="searchButton" type="button" onclick="sample6_execDaumPostcode()">주소검색</th>
                                    <td><input type="text" name="memberPostcode" id="sample6_postcode" placeholder="우편번호" maxlength="6"></td>
                                    <td></td>                                                                   
                                </tr>
                                <tr>
                                    <th></th>
                                    <td>
                                        <input type="text" name="memberRoadAddress" id="sample6_address" placeholder="도로명/지번 주소">
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <td> <input type="text" name="memberJibunAddress" id="sample6_detailAddress" placeholder="상세 주소"></td>
                                    <td></td>
                                </tr>
<%-- <input type="text" name="memberPostcode" id="sample6_postcode" placeholder="우편번호" maxlength="6">
<input type="text" name="memberRoadAddress" id="sample6_address" placeholder="도로명/지번 주소">
<input type="text" name="memberJibunAddress" id="sample6_detailAddress" placeholder="상세 주소"> --%>


                            </table>
                           
                        </div>
                    </div>
                </form>

            </div>


</body>

</html>


</section>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

    <script>
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {

                    var addr = ''; 

                    if (data.userSelectedType === 'R') {
                        addr = data.roadAddress;
                    } else { 
                        addr = data.jibunAddress;
                    }

                    document.getElementById('sample6_postcode').value = data.zonecode;
                    document.getElementById("sample6_address").value = addr;
                    document.getElementById("sample6_detailAddress").focus();
                }
            }).open();
        }
</script>


<!-- 푸터 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</main>

</body>
<script src="/resources/js/myInfo.js"></script>

</html>