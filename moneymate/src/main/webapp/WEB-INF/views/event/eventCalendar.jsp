<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=\, initial-scale=1.0">
    <title>출석체크 이벤트</title>

    <link rel="stylesheet" href="/resources/css/event/eventCalendar.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div id="main">
    

        <div id="title">
            출석체크 이벤트
        </div>

        <div  id="img1">
            <img src="../images/stamp.png" id="stampImg">
        </div>
        <div  id="img2">
            <img src="../images/calendarEvent.png" id="calendarImg">
        </div>
        <div  id="img3">
            <img src="../images/coin1.png" id="coin1">
        </div>
        <div  id="img4">
            <img src="../images/coin1.png" id="coin2">
        </div>
        <div  id="img5">
            <img src="../images/coin2.png" id="coin3">
        </div>

        <div id="container">
            <table class="Calendar">
                <thead>
                    <tr>
                        <td onClick="prevCalendar();" style="cursor:pointer;">&#60;</td>
                        <td colspan="5">
                            <span id="calYear"></span>년
                            <span id="calMonth"></span>월
                        </td>
                        <td onClick="nextCalendar();" style="cursor:pointer;">&#62;</td>
                    </tr>
                    <tr>
                        <td>일</td>
                        <td>월</td>
                        <td>화</td>
                        <td>수</td>
                        <td>목</td>
                        <td>금</td>
                        <td>토</td>
                    </tr>
                </thead>

                <tbody>
                </tbody>
            </table>
        </div>


        <!-- 모달 -->
        <div id="modal-container">
            <div id="modal">
                <div>5 마일리지가 적립되었습니다.</div>
                <div>
                    <button type="button" id="mileBtn" class="w-btn w-btn-gra1 w-btn-gra-anim" onclick="gotoEventList()">확인</button>
                </div>
            </div>
        </div>

    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script>
        // var calendarList = <c:out value="${calendarList}" />;
        var calendarList = ${calendarListJson};
        // JavaScript 코드에서 calendarList를 사용할 수 있습니다.
        console.log(calendarList); // 확인을 위해 콘솔에 출력
    </script>

    <script src="/resources/js/eventCalendar.js"></script>
</body>
</html>