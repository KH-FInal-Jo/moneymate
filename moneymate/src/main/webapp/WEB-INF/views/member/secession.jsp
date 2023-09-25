<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ��Ż��</title>

<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/member/myPageSidemenu.css">
    <link rel="stylesheet" href="/resources/css/member/secession.css">
    <script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>

</head>
<body>

<jsp:include page="/WEB-INF/views/common/header.jsp"/>
       
<section class="myPage-container">    
<jsp:include page="/WEB-INF/views/member/myPageSideMenu.jsp"/>

				<section class="myPage-notice-main">
                <div class="myPage-notice-name">
                    <h1>회원탈퇴</h1>
                </div>

                <div class="sub">
                    <span>탈퇴 시 주의사항</span>
                </div>

                <div class="textarea1">
<textarea id="textarea">
약관1.
약관2.
약관3.
약관4.
약관5.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
</textarea>
                </div>
                
                <form action="secession" method="POST" name="myPageFrm" id="secessionFrm">
                    <div class="check">
                        <input type="checkbox" id="check">
                        <label for="check">위 약관을 모두 읽었으며, 이에 동의합니다.</label>
                    </div>


                        <div class="inputPw">
                            <label for="memberPw">현재 비밀번호 : </label>
                            <input type="password" name="memberPw" id="memberPw" maxlength="30">              
                        </div>



                    <div class="btn">
                        <button id="quitSecession">그만두기</button>
                        <button id="secession">탈퇴하기</button>
                    </div>
                </form>
            </section>
        </section>
    </main>
    

    <script>
        const secession = document.getElementById("secession");
        const secessionFrm = document.getElementById("secessionFrm");
        const memberPw = document.getElementById("memberPw");
        const check = document.getElementById("check");

        secessionFrm.addEventListener("submit", e => {
            if(check.checked == false){
                e.preventDefault();
                alert("약관을 읽고 동의해주세요.");
            }

            if(memberPw.value.trim().length == 0){
                e.preventDefault();
                alert("비밀번호를 입력해주세요.");
            }
                
        })





    </script>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>