<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결제 진행</title>

    <link rel="stylesheet" href="/resources/css/subscribe/subscribing.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">

    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <form action="/subscribe/end/cash" id="Frm" method="POST">

        <div id="main">

            <!-- 결제 진행 -->
            <div>결제 진행</div>

            <!-- 결제자 정보 -->
            <div id="info">
                <div>결제자 정보</div>
                <div>
                    <span>회원 닉네임</span>
                    <input type="text" readonly name="memberNickname" value="${loginMember.memberNickname}">
                </div>
                <div>
                    <span>회원 이메일</span>
                    <input type="email" readonly name="memberEmail" value="${loginMember.memberEmail}">
                </div>
            </div>

            <!-- 약관 동의 -->
            <div id="agree-area">
                <div>약관 동의</div>
                <div>
                    <textarea disabled>
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관
1. 샘플 약관</textarea>
                </div>
                <span>* 필수동의약관입니다.</span>
                <div>
                    <input type="radio" name="agree" id="yes">
                    <label for="yes">동의합니다.</label>
                    <input type="radio" name="agree" id="no">
                    <label for="no">동의하지 않습니다.</label>
                </div>
            </div>

            <!-- 결제 정보 글씨 -->
            <div>결제 정보</div>

            <!-- 마일리지/결제수단 -->
            <div id="fifth">
                <div>
                    <div>마일리지</div>

                    <div id="haveMileage">
                        <span>보유 마일리지</span>
                        <span>사용할 마일리지</span>
                    </div>

                    <div id="howMileage">
                        <input type="text" name="haveMile" id="haveMile" readonly value="${map.mile}">
                        <input type="text" name="useMile" class="useMile">
                        <input type="checkbox" name="allMile" id="allMile">
                        <label for="allMile">전액 사용</label>
                    </div>

                    <div id="price-area">
                        <div>
                            <span>상품 금액</span>
                            <span>마일리지 사용</span>
                            <span>총 결제금액</span>
                        </div>
                        <div>
                            <input type="text" name="prePrice" id="prePrice" readonly value="${map.prevPrice}">
                            <span> - </span>
                            <input type="text" name="useMile" readonly class="useMile" value="0">
                            <span> = </span>
                            <!-- <span>₩</span> -->
                            <input type="text" name="realPrice" id="realPrice" value="${map.prevPrice}" readonly>
                        </div>
                    </div>
                </div>

                <div id="by-area">
                    <div>결제 수단</div>
                    <div>
                        <%-- <button type="button" id="cashBtn">무통장 입금</button> --%>
                        <button type="button" id="creditBtn">신용 카드</button>
                    </div>
                    <%-- <div class="none-area">*무통장 입금은 익일 자정까지 진행해주세요.</div>
                    <div class="none-area">우리 111-1111-1111 머니메이트</div>
                    <div class="none-area">
                        <span>입금자 명 :</span>
                        <input type="text" id="cashName" name="cashName" placeholder="입금자명을 입력해주세요">
                    </div> --%>

                    <div id="inform-area">
                        <img src="/resources/images/warning.png" id="warning"> <br>
                        <div>
                            기재되어있는 회원정보를 확인해주세요. <br>
                            결제 후 환불은 절대 불가합니다.
                        </div>
                    </div>
                </div>
            </div>

            <!-- 버튼 영역 -->
            <div id="btn-area">
                <button type="button" id="prevBtn" onClick = "location.href = '/subscribe/info'">이전으로</button>
                <%-- <button id="nextBtn">결제 진행</button> --%>
            </div>


        </div>
    </form>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script>
        const memberEmail = "${loginMember.memberEmail}";
        const memberNickname = "${loginMember.memberNickname}";



    </script>

    <script src="/resources/js/subscribing.js"></script>
    
</body>
</html>