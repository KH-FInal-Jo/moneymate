<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원탈퇴</title>

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
회원탈퇴 약관

제1조: 목적
    
본 약관은 머니메이트 회원이 회원탈퇴를 원할 경우 회원과 회사 간의 권리와 의무를 규정합니다.
    
제2조: 회원탈퇴 절차
    
회원은 회원탈퇴를 원할 경우, [탈퇴 절차 설명]을 따라야 합니다.
[탈퇴 절차 설명]을 완료한 후, 회사는 해당 요청을 검토하고 회원탈퇴를 처리할 것입니다.
제3조: 회원탈퇴의 효과
    
회원탈퇴가 승인된 경우, 해당 회원은 회사의 서비스 및 기능에 대한 접근 권한을 상실하게 됩니다.
회원탈퇴로 인한 정보 삭제 및 회원정보 보유에 관한 사항은 [정보 보호 정책 또는 개인정보 처리 방침]을 따릅니다.
제4조: 책임과 의무
    
회원은 회원탈퇴 시 회사에게 손해를 입히지 않아야 하며, 탈퇴와 관련된 모든 비용과 책임을 부담하여야 합니다.
회원탈퇴 후에도 회원이 게시한 콘텐츠와 정보의 법적 책임은 해당 회원에게 있습니다.
제5조: 약관 변경
    
회사는 필요한 경우 본 약관을 변경할 수 있으며, 변경된 약관은 회원에게 통지 후 적용됩니다.
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
                        <button id="quitSecession" type="button">그만두기</button>
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
        const quitSecession = document.getElementById("quitSecession");

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

        quitSecession.addEventListener("click", function(){
            location.href = "/member/mypage";
        })





    </script>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>