<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

            <jsp:include page="/WEB-INF/views/admin/adminSidemenu.jsp" />

            <section class="main">
                <div>11</div>
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
                        <tr>
                            <td>1</td>
                            <td>새우깡</td>
                            <td>rjh10010@naver.com</td>
                            <td>2023/08/01~2023/08/31</td>
                            <td>2800마일리지</td>
                        </tr>
                        
                        
                    </tbody>
                </table>
    
                <div class="page">
                    <a href="#">&lt;&lt;</a>
                    <a href="#">&lt;</a>
                    <a href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">6</a>
                    <a href="#">7</a>
                    <a href="#">8</a>
                    <a href="#">9</a>
                    <a href="#">10</a>
                    <a href="#">&gt;</a>
                    <a href="#">&gt;&gt;</a>
                </div>
            </section>
        </section>
        </section>

    </main>

    <script src="/resources/js/adminSidemenu.js"></script>
    
</body>
</html>