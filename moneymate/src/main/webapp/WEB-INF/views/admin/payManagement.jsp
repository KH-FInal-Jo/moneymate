<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="payList" value="${map.payList}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/member/adminSidemenu.css">
    <link rel="stylesheet" href="/resources/css/admin/paymentManage.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <title>관리자 페이지</title>
</head>
<body>
	<main>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="admin-container">

            <section class="j-admin-sidemenu">
                <div class="j-admin-sidemenu-container">
                    <div class="j-admin-sidemenu-title"><a href="/admin/member">회원 관리</a></div>

                    <div class="j-admin-sidemenu-content">
                        <div id="j-admin-report" onclick="reportBtn()">신고 관리</div>
                        <div id="j-admin-report-container">
                            <div><a href="#">채팅</a></div>
                            <div><a href="/admin/reportManage/board">게시판</a></div>
                        </div>
                        <div><a href="/admin/payment">결제 관리</a></div>
                        <div id="j-admin-community-list" onclick="adminCommunity()">게시판 관리</div>
                            <div id="j-admin-com">
                                <div><a href="#">공지사항</a></div>
                                <div><a href="#">문의게시판</a></div>
                                <div><a href="#">자유게시판</a></div>
                                <div><a href="#">컬럼게시판</a></div>
                                <div><a href="#">이벤트게시판</a></div>
    
                            </div>
                    </div>
                </div>
            </section>

            <section class="main">
                <div><h1>결제관리</h1></div>
                <table border="1" class="result">
                    <thead class="thead">
                        <tr>
                            <th>회원번호</th>
                            <th>닉네임</th>
                            <th>이메일</th>
                            <th>구독 기간</th>
                            <th>사용 마일리지</th>
                        </tr>
                    </thead>
    
                    <tbody class="tbody">

                    <c:choose>
                        <c:when test="${empty payList}">
                            <tr>
	                            <th colspan="5">결제 내역이 없습니다.</th>
	                        </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${payList}" var="pay">
                                <tr>
                                    <td>${pay.memberNo}</td>
                                    <td>${pay.memberNickname}</td>
                                    <td>${pay.memberId}</td>
                                    <td>${pay.subscribeStart}~${pay.subscribeEnd}</td>
                                    <td>${pay.useMileage}마일리지</td>
                                </tr>
                            </c:forEach>

                        </c:otherwise>
                    </c:choose>

                    </tbody>
                </table>
    
                <div class="pagination-area">


                    <ul class="pagination">
                    
                        <li><a href="/community/3?cp=1">&lt;&lt;</a></li>

                        <li><a href="/community/3?cp=${pagination.prevPage}">&lt;</a></li>

                
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                            <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                    <li><a class="current">${i}</a></li>
                            </c:when>
                            
                            <c:otherwise>
                                    <li><a href="/community/3?cp=${i}">${i}</a></li>
                            </c:otherwise>
                            </c:choose>
                            
                        </c:forEach>
                        
                        
                        
                        <li><a href="/community/3?cp=${pagination.nextPage}">&gt;</a></li>

                        <li><a href="/community/3?cp=${pagination.maxPage}">&gt;&gt;</a></li>

                    </ul>
                </div>
            </section>
        </section>
        </section>

    </main>

    <script src="/resources/js/adminSidemenu.js"></script>
    
</body>
</html>