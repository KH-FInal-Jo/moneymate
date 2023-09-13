<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이벤트 목록</title>

    <link rel="stylesheet" href="/resources/css/event/eventList.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
</head>
<body>

   <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <!-- a태그 안 걸고 js로 해결하기!!! -->
    <!-- css 추가하고 싶은데.. 리액트 배운 후에 마우스 따라다니는 선 같은 효과 추가하기... -->
    <!-- 출석체크 이벤트 같은 경우는, 스케줄러 사용해서 하루에 한 번만 참여할 수 있게 !!! -->

    <div id="main">
        <div>EVENT</div>

        <div id="container">
            <div id="event1" onclick="location.href='/event/calendar'">
                <img src="/resources/images/accountEvent3.png" id="eventImg1">
                <div id="event1-name">출석체크 이벤트</div>
            </div>
            <div id="event2" onclick="location.href='/event/account'">
                <img src="/resources/images/accountEvent2.png" id="eventImg2">
                <div id="event2-name">가계부 자랑하기</div>
            </div>
            
        </div>


    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>