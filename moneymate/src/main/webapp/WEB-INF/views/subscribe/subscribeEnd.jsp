<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결제 확인</title>

    <link rel="stylesheet" href="/resources/css/subscribe/subscribeEnd.css">
    <link rel="stylesheet" href="/resources/css/subscribe/subscribeInform.css">
    <link rel="stylesheet" href="/resources/css/header.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div id="main">

        <div>결제 확인</div>

        <table>
            <tr>
                <td id="td-time">구독 기간</td>
                <td><input type="text" id="time" value="${s.subscribeStart} ~ ${s.subscribeEnd}" readonly></td>
            </tr>
            <tr>
                <td id="td-by">결제 정보</td>
                <td id="by">
                    <c:if test="${s.calculateWay == 1}" >
                        무통장
                    </c:if>
                    <c:if test="${s.calculateWay == 2}" >
                        카드
                    </c:if>
                
                </td>
            </tr>
            <tr>
                <td id="td-price">결제 금액</td>
                <td id="price"><input type="text" id="time" value="${s.price}" readonly></td>
            </tr>
            <tr>
                <td colspan="2" id="td-inform">결제 정보는 이메일에서도 확인하실 수 있습니다.</td>
            </tr>
        </table>

        <div>
            <button type="button" id="btn" onclick="location.href='/'">확인</button>
        </div>

    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    
</body>
</html>