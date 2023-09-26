<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%-- <c:set var="pagination" value="${map.pagination}"/>
<c:set var="reportList" value="${map.reportList}"/> --%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>신고 관리</title>

<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/member/adminSidemenu.css">
<link rel="stylesheet" href="/resources/css/footer.css">
<link rel="stylesheet" href="/resources/css/admin/chattReport.css">

</head>
<body>
<main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="admin-container">

           <jsp:include page="/WEB-INF/views/admin/chattReport.jsp"/>
           

            <section class="admin-main">
            <div><h1>신고관리</h1></div>
                <div class="admin-report-list">
                    <table border="1" class="admin-report-table">
                        <tr class="admin-report-list-header">
                            <th width="28px">신고자</th>
                            <th width="30px" height="60px">피신고자</th>
                            <th width="20px">이메일</th>
                            <th width="50px">신고이유</th>
                            <th width="50px">신고날짜</th>
                        </tr>
                        <%-- <h1>sdklfsdsd ${reportList}</h1> --%>


                        <%-- <c:choose>
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
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose> --%>

                    </table>

                </div>

                <%-- <div class="pagination-area">


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
                </div> --%>

            </section>

        </section>
        
         <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
        
    </main>

</body>
</html>