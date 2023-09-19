<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="reportList" value="${map.reportList}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 관리</title>

<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/member/adminSidemenu.css">
<link rel="stylesheet" href="/resources/css/footer.css">


</head>
<body>
<main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="admin-container">

           <section class="j-admin-sidemenu">
                <div class="j-admin-sidemenu-container">
                    <div class="j-admin-sidemenu-title">회원 관리</div>

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
           

            <section class="admin-main">
                <div class="admin-report-list">
                    <table border="1" class="admin-report-table">
                        <tr class="admin-report-list-header">
                            <th width="28px">회원번호</th>
                            <th width="30px" height="60px">닉네임</th>
                            <th width="20px">이메일</th>
                            <th width="80px">게시글내용</th>
                            <th width="50px">신고이유</th>
                            <th width="50px">신고날짜</th>
                            <th width="40px">승인여부</th>
                        </tr>

                        <c:choose>
                            <c:when test="${empty reportList}">
                                <tr>
	                                <th colspan="7">확인하지 않은 신고가 없습니다.</th>
	                            </tr>
                            </c:when>
                        
                            <c:otherwise>
                                <c:forEach items="${reportList}" var="report">
                                    <tr>
                                        <th>${report.reportedNo}</th>
                                        <a href="#"><th width="30px" height="50px">유저일</th></a>
                                        <td width="40px">user01@naver.com</td>
                                        <a href="#"><td width="120px">${report}</td></a>
                                        <a href="#"><td width="50px">${report.reportContent}</td></a>
                                        <td width="50px">2023.08.30</td>
                                        <td width="40px"><button type="button">승인</button></td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>

                    </table>

                </div>

                

            </section>

        </section>
        
         <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
        
    </main>

    <script src="/resources/js/adminSidemenu.js"></script>
    <script src="/resources/js/reportManage.js"></script>
</body>
</html>