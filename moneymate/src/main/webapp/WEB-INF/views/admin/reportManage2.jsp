<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="reportList" value="${map.reportList}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/member/adminSidemenu.css">
<link rel="stylesheet" href="/resources/css/admin/reportManage2.css">

</head>
<body>
	<main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="admin-container">

            <section class="j-admin-sidemenu">
                <div class="j-admin-sidemenu-container">
                    <div class="j-admin-sidemenu-title"><a href="/admin/member">회원 관리</a></div>
            
                    <div class="j-admin-sidemenu-content">
                        <div id="j-admin-report" onclick="reportBtn()">신고 관리</div>
                        <div id="j-admin-report-container">
                            <div><a href="/admin/reportManage/chatt">채팅</a></div>
                            <div><a href="/admin/reportManage/board">게시판</a></div>
                        </div>
                        <div><a href="/admin/payment">결제 관리</a></div>
                </div>
            </section>
           

            <section class="admin-main">
            <div><h1>채팅 신고관리</h1></div>
                <div class="admin-report-list">
                    <table border="1" class="admin-report-table">
                        <tr class="admin-report-list-header">
                            <th width="28px">신고자</th>
                            <th width="30px" height="60px">피신고자</th>
                            <th width="20px">이메일</th>
                            <th width="50px">신고이유</th>
                            <th width="50px">신고날짜</th>
                            <th width="20px">처리</th>
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
                                        <td>${report.reportNickname}</td>  
                                        <a href="#"><th width="30px" height="50px">${report.reportedNickname}</th></a>
                                        <td width="40px">${report.memberId}</td>
                                        <td width="40px">${report.reportContent}</td>
                                        <td width="50px">${report.reportDate}</td>
                                        <td width="20px"><button type="button" id="confirm" onclick="confirm(${report.reportNo}, ${report.reportedNo})">확인</button></td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>

                    </table>

                </div>

                <div class="pagination-area">


                    <ul class="pagination">
                    
                        <li><a href="/admin/reportManage/chatt?cp=1">&lt;&lt;</a></li>

                        <li><a href="/admin/reportManage/chatt?cp=${pagination.prevPage}">&lt;</a></li>

                
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                            <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                    <li><a class="current">${i}</a></li>
                            </c:when>
                            
                            <c:otherwise>
                                    <li><a href="/admin/reportManage/chatt?cp=${i}">${i}</a></li>
                            </c:otherwise>
                            </c:choose>
                            
                        </c:forEach>
                        
                        
                        
                        <li><a href="/admin/reportManage/chatt?cp=${pagination.nextPage}">&gt;</a></li>

                        <li><a href="/admin/reportManage/chatt?cp=${pagination.maxPage}">&gt;&gt;</a></li>

                    </ul>
                </div>


            </section>

        </section>
        
         <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
        
    </main>

    <script src="/resources/js/reportManage2.js"></script>
    <script src="/resources/js/adminSidemenu.js"></script>
</body>
</html>