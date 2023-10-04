<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="pList"  value="${map.pList}"/>
<c:set var="gList"  value="${map.gList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>가계부 관리</title>

    <link rel="stylesheet" href="/resources/css/account/accountManage.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
    <!-- 가게부 최대 4개만 만들 ㅁ수 있도록 나중에 c:if문 걸어주기!!! -->
    <div id="main">


        <div id="main-container">

            <div id="modal"> <!-- 모달창 -->
                <div>
                    <img src="/resources/images/add-user.png">
                </div>

                <form action="/account/create" method="POST" id="inviteFrm">
                    <div>가계부 이름</div>
                    <div>
                        <input type="text" id="accountName" name="accountName"/>
                    </div>
                    
                    <div>그룹 초대</div>
                    <div id="input">
                        <input type="text" id="add-group" placeholder="MoneyMate회원 이메일">
                        <img src="/resources/images/check.png" id="check-img">
                        <img src="/resources/images/warning.png" id="warn-img">
                        <button type="button" id="addBtn">추가</button>
                    </div>

                    <div>나의 그룹원</div>
                    <div id="groups">
                        <!-- <div class="each-email">
                            <input type="text" class="input-email" readonly value="user@nad.com">
                            <img src="../images/close.png" class="x-btn">
                        </div> -->
                    </div>

                    <div>
                        <button class="w-btn w-btn-gra1 w-btn-gra-anim" type="submit" id="inviteBtn">
                            생성하기
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <div id="container">

            <c:forEach items="${pList}" var="list">
                <div class="account">
                    <div class="name">${list.accountName}</div>
                    <div class="content">
                        <img src="/resources/images/로고.png" class="logoImg"/>
                        <img src="/resources/images/homework.png" class="logoImg"/>
                    </div>
                    <div class="btn-area">
                        <button class="snip1535" onclick="location.href='/account/${list.accountNo}'">상세</button>
                        <!-- <button type="button" class="moreBtn">상세보기</button> -->
                    </div>
                </div>
            </c:forEach>

            <c:forEach items="${gList}" var="list">
                <div class="account">
                    <div class="name">${list.accountName}</div>
                    <div class="content1">
                        <img src="/resources/images/homework.png" class="logoImg1"/>
                        <c:set var="emails" value="${list.memberEmails}" />
                        <c:set var="emailArray" value="${fn:split(emails, ',,')}" />
                            <c:forEach items="${emailArray}" var="email">
                                <div class="user">
                                    <span class="spans">${email}</span>
                                </div>
                            </c:forEach>
                    </div>
                    <div class="btn-area">
                        <button class="snip1535" onclick="location.href='/account/${list.accountNo}'">상세</button>
                    </div>
                </div>
            </c:forEach>
            <div id="new">
                <img src="/resources/images/plus.png" id="plus-img">
            </div>
        </div>
    </div>

    <script>
        const loginMemberEmail = "${loginMember.memberEmail}";
    </script>

    <script src="/resources/js/accountManage.js"></script>
    
</body>
</html>