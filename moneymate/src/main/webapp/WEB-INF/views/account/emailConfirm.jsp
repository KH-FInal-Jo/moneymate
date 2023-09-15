<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이메일 초대</title>

    <link rel="stylesheet" href="/resources/css/account/emailConfirm.css">

   

    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

</head>
<body>


<canvas id="birthday"></canvas>

    <div id="all">
        <div id="main">
            <div>가계부에 초대되었습니다.</div>
            <div>
                <button>거절</button>
                <button>수락</button>
            </div>
        </div>

    </div>

    <div class="pyro">
  <div class="before"></div>
  <div class="after"></div>
</div>


    <script src="/resources/js/emailConfirm.js"></script>

    
    
</body>
</html>