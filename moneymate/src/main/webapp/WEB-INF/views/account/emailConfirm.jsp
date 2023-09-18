<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="/resources/css/account/emailConfirm.css">

    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

</head>
<body>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.js"></script>

    <div id="all">
        <div><img src="/resources/images/로고.png" alt=""></div>
        <div id="main">
            <div>가계부에 초대되었습니다</div>
            <div id="btnArea">
                <button id="no" onclick="goBack()">거절</button>
                <button id="yes" onclick="location.href='/account/accept/${key}'">수락</button>
            </div>
        </div>
    </div>

    

    <input type="hidden" value="${key}"/>

    <div id="confetti"></div>

    <script src="/resources/js/emailConfirm.js"></script>
    
</body>
</html>