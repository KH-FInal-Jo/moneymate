<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/member/signUp.css">

<script src="https://kit.fontawesome.com/d76028de4f.js" crossorigin="anonymous"></script>

</head>
<body id="body">

<%-- <jsp:include page="/WEB-INF/views/common/header.jsp" /> --%>

<section class="signUp-content">

        
        <form action="/member/signUp" method="post" name="signUp-form" id="signUpFrm">
            <div class="name"><span>회원가입</span></div>

            <textarea class="check">약관동의
1. 개인정보보호법에 따라 머니메이트에 회원가입 신청하시는 분께 수집하는 개인정보의 항목,
   개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 
   불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.
2. 실명 인증된 아이디로 가입하시면 서비스(가계부 서비스, 게시판, 소비테스트 등)를
    가입 후 바로 이용하실 수 있어요.
3. 회원으로 가입하시면 머니메이트 서비스를 보다 편리하게 이용할 수 있습니다.
   여러분은 본 약관을 읽고 동의하신 후 회원 가입을 신청하실 수 있으며, 머니메이트는
   이에 대한 승낙을 통해 회원 가입 절차를 완료하고 여러분께 서비스 이용 계정
   (이하 ‘계정’)을 부여합니다. 계정이란 회원이 머니메이트 서비스에 로그인한 이후 이용하는 
   각종 서비스 이용 이력을 회원 별로 관리하기 위해 설정한 회원 식별 단위를 말합니다.
   회원은 자신의 계정을 통해 좀더 다양한 머니메이트 서비스를 보다 편리하게 
   이용할 수 있습니다. 이와 관련한 상세한 내용은 계정 운영정책에서 확인해 주세요.
            </textarea>
            <br>
            <input type="checkbox" id="check">동의합니다.(필수)


            <div class="signUp-input-area">
                <i class="fa-solid fa-id-badge" style="color: #000000;"></i>
                <input type="text" id="memberEmail" name="memberEmail"
                        placeholder="아이디(이메일)" maxlength="30"
                        autocomplete="off" required>

                <button type="button" id="sendAuthKeyBtn">인증번호 받기</button>
            </div>

            <span class="signUp-message" id="emailMessage">메일을 받을 수 있는 이메일을 입력해 주세요.</span>

            <div class="signUp-input-area">
                <i class="fa-solid fa-keyboard" style="color: #000000;"></i>
                <input type="text" id="authKey"
                        placeholder="인증번호 입력" maxlength="6"
                        autocomplete="off">

                <button type="button" id="checkAuthKeyBtn">인증하기</button>
            </div>

            <span class="signUp-message" id="authKeyMessage">인증번호를 입력해주세요.</span>

            <button id="open-modal" type="button">→휴대폰 인증으로 대신하기</button>

            <div id="modal1">
                <div class="modal-content">
                    <h2>휴대폰 인증</h2>
                    <p><input type="text" placeholder="휴대폰 번호 입력" id="mTel"> <button type="button" onclick="authPhone()">인증번호 받기</button></p>
                    <p><input type="text" placeholder="인증번호 입력" id="inputNum"> <button type="button" id="confirmNum">인증번호 확인</button></p>
                    <button type="button" id="close-modal">닫기</button>
                </div>
            </div>

            <div class="signUp-input-area">
                <i class="fa-solid fa-lock" style="color: #000000;"></i>
                <input type="password" id="memberPw" name="memberPw"
                        placeholder="비밀번호" maxlength="30">
            </div>

            <div class="signUp-input-area">
                <i class="fa-solid fa-lock" style="color: #000000;"></i>
                <input type="password" id="memberPwConfirm"
                        placeholder="비밀번호 확인" maxlength="30">
            </div>

            <span class="signUp-message error" id="pwMessage"></span>

            <div class="signUp-input-area">
                <i class="fa-solid fa-person" style="color: #000000;"></i>
                <input type="text" id="memberName" name="memberName"
                        placeholder="이름" maxlength="20">
            </div>

            <span class="signUp-message confirm" id="nameMessage"></span>


            <div class="signUp-input-area">
                <i class="fa-solid fa-person" style="color: #000000;"></i>
                <input type="text" id="memberNickname" name="memberNickname"
                        placeholder="닉네임" maxlength="10">
            </div>

            <span class="signUp-message confirm" id="nickMessage"></span>

            <div class="signUp-input-area">
                <i class="fa-solid fa-phone" style="color: #000000;" ></i>
                <input type="text" id="memberTel" name="memberTel"
                        placeholder="(- 없이 숫자만 입력)" maxlength="11">
            </div>

            <span class="signUp-message error" id="telMessage"></span>


            <div class="signUp-input-area">
                <i class="fa-solid fa-house-chimney" style="color: #000000;"></i>
                <input type="text" name="memberAddress" id="sample6_postcode" placeholder="우편번호(선택 사항)" maxlength="6">
               
                <button type="button" onclick="sample6_execDaumPostcode()">검색</button>
            </div>


            <div class="signUp-input-area">
                <input type="text" name="memberAddress" id="sample6_address" placeholder="도로명/지번 주소">
            </div>


            <div class="signUp-input-area">
                <input type="text" name="memberAddress" id="sample6_detailAddress" placeholder="상세 주소">
            </div>


            <button type="submit" id="signUp-btn">가입하기</button>

        </form>

    </section>

</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

    <script>
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {

                    var addr = ''; 

                    if (data.userSelectedType === 'R') {
                        addr = data.roadAddress;
                    } else { 
                        addr = data.jibunAddress;
                    }

                    document.getElementById('sample6_postcode').value = data.zonecode;
                    document.getElementById("sample6_address").value = addr;
                    document.getElementById("sample6_detailAddress").focus();
                }
            }).open();
        }
</script>



<script src="/resources/js/signUp.js"></script>

</html>