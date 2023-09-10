<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구독 안내</title>

    <link rel="stylesheet" href="/resources/css/subscribe/subscribeInform.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <main>
        <!-- 광고없는 ~ -->
        <div id="first-div">
            <div>광고 없는</div>
            <img src="/resources/images/로고.png" alt="logo">
            <div>를 이용해보세요 !</div>
        </div>
    
    
        <!-- 선택창 -->
        <div id="second-div">
            <div id="oneMonth" onclick="location.href='/subscribe/ing?type=1'"> <!-- #second-div>div:nth-child(1) -->
                <div>한 달</div>
                <div><span>₩</span>2,900</div>
                <div>
                    <!-- <button type="button" id="monthBtn">선택</button> -->
                    <button class="w-btn-neon2" type="button" id="monthBtn">
                        구매
                    </button>
                </div>
            </div>

            <div id="year" onclick="location.href='/subscribe/ing?type=2'">
                <div >일 년</div>
                <div id="popular">
                    <div><img src="/resources/images/crown.png"></div>
                    <div>가장 인기 많은</div>
                </div>
                <div>10% 할인</div>
                <div><span>₩</span>31,900</div>
                <div><!-- <button type="button" id="yearBtn">선택</button> -->
                    <button class="w-btn-neon2" type="button" id="yearBtn">
                        구매
                    </button>
                </div>
            </div>

            <div id="sixMonth" onclick="location.href='/subscribe/ing?type=3'">
                <div>육 개월</div>
                <div>5% 할인</div>
                <div><span>₩</span>16,530</div>
                <div><!-- <button type="button" id="sixBtn">선택</button> -->
                    <button class="w-btn-neon2" type="button" id="sixBtn">
                        구매
                    </button>
                </div>
            </div>
        </div>
    
        <!-- 안내 -->
        <div id="third-div">
            <div><img src="/resources/images/information (1).png"></div>
            <div>귀하의 모든 기기에서 광고 없는 플랫폼을 경험할 수 있습니다.</div>
            <div>구독 취소는 불가하니 신중히 결제해주세요.</div>
            <div>자동결제는 불가합니다. 장기 구독을 원한다면 장기 구독 플랜을 이용해주세요 !</div>
        </div>

    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    
</body>
</html>