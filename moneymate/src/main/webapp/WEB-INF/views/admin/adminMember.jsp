<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="memberList" value="${map.memberList}"/>
<c:set var="pagination" value="${map.pagination}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원관리(관리자)</title>

    <link rel="stylesheet" href="/resources/css/admin/adminMember.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">

</head>
<body>

    <!-- 
        JS 만들어서 마일리지 입력 후 확인 누르면 ajax 통해서 마일리지 PUT 할 수 있게
        탈퇴버튼도 동일
     -->

     <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div id="all">

        <div id="sidebar" style="width: 25%; color: pink;"></div>

        <div id="main">

            <div>회원관리</div>

            <form action="/admin/member">
                <input type="search" name="search" id="search" placeholder="닉네임을 입력하세요">
                <button  id="searchBtn">검색</button>
            </form>

            <table border="1">

                <thead>
                    <tr>
                        <th>No</th>
                        <th>이름</th>
                        <th>닉네임</th>
                        <th>이메일</th>
                        <th>신고된 수</th>
                        <th>마일리지</th>
                        <th>탈퇴 여부</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach items="${memberList}" var="member">
                        <tr>
                            <td>${member.memberNo}</td>
                            <td>${member.memberName}</td>
                            <td>${member.memberNickname}</td>
                            <td>${member.memberEmail}</td>
                            <td>${member.reportCount}</td>
                            <td>
                                <input type="number" name="mile" value="${member.mileage}">
                                <button type="button" onclick="mileUpdate(${member.memberNo}, this)">확인</button>
                            </td>
                            <td>
                                <c:if test="${member.secessionFlag == 'N'}" >
                                    <span>N</span>
                                    <button type="button" onclick="secession(${member.memberNo}, this)">탈퇴</button>
                                </c:if>
                                <c:if test="${member.secessionFlag != 'N'}" >
                                    <span>Y</span>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table>

            <div class="pagination-area">


                <ul class="pagination">
                
                    <!-- 첫 페이지로 이동 -->
                    <li><a href="#">&lt;&lt;</a></li>

                    <!-- 이전 목록 시작 번호로 이동 -->
                    <li><a href="#">&lt;</a></li>

               
                    <!-- 특정 페이지로 이동 -->

                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                        <c:choose>
                           <c:when test="${i == pagination.currentPage}">
                                <li><a class="current">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a  href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">6</a></li>
                                <li><a href="#">7</a></li>
                                <li><a href="#">8</a></li>
                                <li><a href="#">9</a></li>
                                <li><a href="#">10</a></li>
                          </c:when>
                        
                           <c:otherwise> 
                                <li><a href="/board/${boardCode}?cp=${i}${sp}">${i}</a></li> 
                          </c:otherwise>
                        </c:choose>
                        
                    </c:forEach> 
                    
                    
                    
                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="#">&gt;</a></li>

                    <!-- 끝 페이지로 이동 -->
                    <li><a href="#">&gt;&gt;</a></li>

                </ul>
            </div>


        </div>


        

    </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

        <script src="/resources/js/adminMember.js"></script>
    
</body>
</html>