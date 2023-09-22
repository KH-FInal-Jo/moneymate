<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/member/findId.css">
    
    <title>아이디 찾기</title>
</head>
<body>

    <main>
        <section>
         <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        </section>

        <!-- 중간영역 -->
          <middle>
            <section class="findContainer1">
                <div id="imgTop">
                    <img src="/resources/images/로고.png">
                </div>
            </section>
            <section class="findContainer2">
                <div id="findFont">
                    <p>비밀번호 찾기</p>
                </div>
            </section>
           
            <!-- 휴대폰으로 비밀번호 찾기 -->
            <section class="findContainer4">
                <fieldset>
                    <form action="#">
                        <label style="margin-right: 30px;">
                            <input type="radio" name="contact" value="find" checked />
                            <span class="underline">휴대폰인증으로 재설정</span> 
                        </label> <br><br>
                        <input type="text" name="memberName" id="memberName" placeholder="이름을 입력해 주세요."> <br>
                        <input type="text" name="memberEmail" id="memberEmail" placeholder="아이디를 입력해 주세요."> <br>
                        <input type="text" name="memberTel" id="memberTel" placeholder="휴대폰 번호를 입력해 주세요.">
                        <button id="sendmessage" type="button">발송하기</button><br>
                        <input type="text" name="certification" id="certification" placeholder="인증번호 입력">
                        <button id="check" type="button">인증하기</button><br><br>
                        <input type="password" name="newPw" id="newPw" placeholder="새 비밀번호">
                        <input type="password" name="newPwConfirm" id="newPwConfirm" placeholder="새 비밀번호 확인">
                        <button type="button" id="changePw">변경</button>
                     
                    </form>
                
                    
                </fieldset>
            </section>
           
           
            <!-- 이메일로 비밀번호 찾기 -->
           
           <section class="findContainer6">
                <fieldset>
                    <form action="#">
                        <label>
                            <input type="radio" name="contact" value="find" checked />
                            <span class="underline">이메일로 재설정</span>
                        </label><br><br>

                        <input type="text" name="memberName2" id="memberName2" placeholder="이름을 입력해 주세요."> <br>
                        <input type="text" name="memberEmail2" id="memberEmail2" placeholder="이메일을 입력해 주세요.">
                        <button id="sendmessage2" type="button">발송하기</button><br>
                        <span id="authKeyMessage"></span> <br>
                        <input type="text" name="certification2" id="certification2" placeholder="인증번호 입력">
                        <button id="check2" type="button">인증하기</button><br><br>
                        <input type="password" name="newPw2" id="newPw2" placeholder="새 비밀번호">
                        <input type="password" name="newPwConfirm2" id="newPwConfirm2" placeholder="새 비밀번호 확인">
                        <button type="button" id="changePw2">변경</button>

                    </form>
                    
                </fieldset>

            </section>


        </middle>
       
       


       <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </main>
    
    <script>
    
        function search_check(num) {
            if (num == '1') {
                document.getElementById("searchP").style.display = "none";
                document.getElementById("searchI").style.display = "";	
            } else {
                document.getElementById("searchI").style.display = "none";
                document.getElementById("searchP").style.display = "";
            }
        }


    </script>
    <script src="/resources/js/findPw.js"></script>
</body>
</html>


