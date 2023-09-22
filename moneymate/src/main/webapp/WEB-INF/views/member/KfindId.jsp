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
                    <p>아이디 찾기</p>
                </div>
            </section>
           
            <!-- 휴대폰으로 아이디 찾기 -->
            <%-- 필요한거 이름, 핸드폰 번호 --%>
                      
            <section class="findContainer4">
                <fieldset>
                    <form action="#">
                        <label style="margin-right: 30px;">
                            <input type="radio" name="contact" value="find" checked />
                            <span class="underline">휴대폰으로 아이디 찾기</span> 
                        </label> <br><br>
                        <input type="text" name="MemberName" id="MemberName" placeholder="이름을 입력해 주세요."> <br>
                        <input type="text" name="MemberTel"  id="MemberTel" placeholder="휴대폰 번호를 입력해 주세요.">
                        <button id="Send" type="button">발송하기</button><br>
                        <input type="text" name="textCertification" id="textCertification" placeholder="인증번호 입력">
                        <button id="check" type="button">인증하기</button><br>
                        <input type="text" name="findId" id="findId" placeholder="찾은 아이디 확인">
                     
                    </form>
                
                    
                </fieldset>
            </section>
           
           
            <!-- 이메일로 아이디 찾기 -->
           
            <%-- <section class="findContainer6">
                <fieldset>
                    <form action="#">
                        <label>
                            <input type="radio" name="contact" value="find" checked />
                            <span class="underline">이메일로 아이디 찾기</span>
                        </label><br><br>

                        <input type="text" name="nm" placeholder="이름을 입력해 주세요."> <br>
                        <input type="text" name="email" placeholder="이메일을 입력해 주세요.">
                        <button id="check">인증하기</button>
                        <input type="text" name="certification" placeholder="인증번호 입력"><br><br>
                        <input type="text" name="findId" placeholder="찾은 아이디 확인">

                    </form>
                    
                </fieldset>

            </section> --%>


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

    <script src="/resources/js/findId.js"></script>
</body>
</html>


