<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이벤트 목록</title>

    <script src="https://code.createjs.com/easeljs-0.7.1.min.js"></script> 

    <link rel="stylesheet" href="/resources/css/event/eventList.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
</head>
<body onLoad="init()">

    <div id='container'>
    <canvas id="canvas" ></canvas> 
    <div id="main">
        <div>EVENT</div>

        <div id="Hcontainer">
            <div id="event1" onclick="location.href='/event/calendar'">
            <%-- <div id="event1" data-href="/event/calendar"> --%>
                <img src="/resources/images/accountEvent3.png" id="eventImg1">
                <div id="event1-name">출석체크 이벤트</div>
            </div>
            <div id="event2" onclick="location.href='/event/account'">
                <img src="/resources/images/accountEvent2.png" id="eventImg2">
                <div id="event2-name">가계부 자랑하기</div>
            </div>
            
        </div>


    </div>
    </div>
    <script src="/resources/js/eventList.js"></script>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>