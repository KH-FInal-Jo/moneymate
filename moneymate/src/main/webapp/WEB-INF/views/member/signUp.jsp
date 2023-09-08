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
<body>

<jsp:include page="/WEB-INF/views/common/header.jsp" />

<section class="signUp-content">

        
        <form action="/member/signUp" method="post" name="signUp-form" id="signUpFrm">
            <div class="name"><span>회원가입</span></div>

            <textarea class="check">약관동의
1.
2.
3.
4.
            </textarea>
            <br>
            <input type="checkbox" id="check">동의합니다.(필수)


            <div class="signUp-input-area">
                <i class="fa-solid fa-id-badge" style="color: #000000;"></i>
                <input type="text" id="memberEmail" name="memberEmail"
                        placeholder="아이디(이메일)" maxlength="30"
                        autocomplete="off" required>

                <button type="button" id="authKey">인증번호 받기</button>
            </div>

            <span class="signUp-message" id="emailMessage">메일을 받을 수 있는 이메일을 입력해 주세요.</span>

            <div class="signUp-input-area">
                <i class="fa-solid fa-keyboard" style="color: #000000;"></i>
                <input type="text" id="emailCheck"
                        placeholder="인증번호 입력" maxlength="6"
                        autocomplete="off">

                <button type="button">인증하기</button>
            </div>

            <span class="signUp-message confirm">인증되었습니다.</span>

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