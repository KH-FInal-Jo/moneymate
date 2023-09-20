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
제1조 (목적)
이 약관은 주식회사 머니메이트(이하 "회사"라 한다)가 고객에게 콘텐츠 구독
서비스를 제공함에 있어 고객과 “회사” 간의 “서비스” 이용에 관한 기본적인 사항을
정함을 목적으로 한다
제2조 (용어의 정의)
이 약관에서 사용하는 용어의 정의는 다음과 같다.
1. “서비스”란 “회사”가 이 약관에 따라 서비스 가입 의사를 표시한 고객에게
자체적으로 제작한 “콘텐츠”를 구독하고 열람할 수 있도록 제공하는 행위를
말한다.
2. “콘텐츠”란 글, 그림, 음성, 동영상 등 형태를 불문하고 “회사”가 다음 각 목의
내용을 구성하여 작성 또는 촬영, 이용권한 확보, 수집, 발췌, 편집, 번역 등을 한
결과물을 말한다.
가. 국내∙외 경제 및 금융투자상품 시장의 상황 또는 전망
나. 특정 산업 또는 종목의 상황 및 전망
다. 투자에 관련된 법령정보, 이론 또는 가설 등 지식
라. 투자에 관련된 통계적 기록, 역사적 사건에 관한 서술 또는 논평
마. 투자에 관련된 뉴스, 조사분석자료 등 정보
바. 주식, 펀드 등 금융투자상품에 관련된 투자정보
사. 그 밖에 투자에 관련된 지식 또는 정보
제3조 (서비스 가입 및 해지)
① “서비스” 가입 대상은 다음 각 호를 모두 충족한 고객에 한한다.
1. “회사”가 실명 확인한 계좌를 정상적으로 보유한 고객 또는 “회사”의 「준회원
이용약관」에 따른 준회원
2. 이 약관에 동의하고 “회사”가 “서비스”의 이용을 승낙한 고객
3. “서비스”에 필요한 개인(신용)정보 활용에 동의한 고객
② 제 1 항에도 불구하고 “회사”는 다음 각 호의 경우에 “서비스”의 이용 신청을
승낙하지 않을 수 있다.
1. 관계법규 또는 관계당국의 명령, 권고, 요청 등에 따라 고객의 이용 신청을
승낙하는 것이 곤란한 경우
2. 고객의 실명을 확인할 수 없거나 고객이 타인의 실명을 도용한 경우
3. 이용 신청 시 허위정보를 기재하였거나 잘못된 내용을 기재한 경우
③ 고객은 언제든지 “서비스”를 해지할 수 있다.
④ “회사”는 고객에게 다음 각 호의 어느 하나에 해당하는 사유가 있는 경우 고객에게
7 일의 기간을 부여하여 시정 조치를 요구하고, 고객이 적절한 조치를 취하지 아니한
때에는 ”서비스”를 해지할 수 있다. 다만, 시정이 명백히 불가능하거나 고객의 의무 위반
정도가 중하여 ”서비스”의 목적을 달성할 수 없는 정도에 이른 때에는 즉시 ”서비스”를
해지할 수 있다.
1. 제 2 항 제 2 호 또는 제 3 호에 해당하는 경우
2. “서비스”를 범죄 또는 법령이 금지하는 행위에 이용하는 경우
3. 제 5 조 제 2 항 각 호에 따른 “서비스” 이용 제한 사유가 발생한 경우
⑤ “회사”는 제 4 항에 따라 “서비스”를 해지하는 경우에 그 취지 및 사유를 고객에게
지체없이 통지하여야 한다.
</textarea>
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