<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
                    회원 탈퇴
                </div>

                <div class="sub">
                    <span>탈퇴시 유의 사항</span>
                </div>

                <div class="textarea1">
<textarea id="textarea">사용하고 계신 아이디(rjh658)는 탈퇴할 경우 재사용 및 복구가 불가능합니다.
탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가하오니 신중하게 선택하시기 바랍니다.
탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.

회원정보 및 메일, 블로그, 주소록 등 개인형 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.
삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.

탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로 남아 있습니다.
뉴스, 카페, 지식iN 등에 올린 게시글 및 댓글은 탈퇴 시 자동 삭제되지 않고 그대로 남아 있습니다.
삭제를 원하는 게시글이 있다면 반드시 탈퇴 전 비공개 처리하거나 삭제하시기 바랍니다.

탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다.
게시판형 서비스 중 "그라폴리오"의 댓글은 삭제됩니다.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
</textarea>
                </div>
                
                <form action="secession" method="POST" name="myPageFrm" id="secessionFrm">
                    <div class="check">
                        <input type="checkbox" id="check">
                        <label for="check">위 사항을 모두 확인하였으며, 이에 동의합니다.</label>
                    </div>


                        <div class="inputPw">
                            <label for="memberPw">비밀번호</label>
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
                alert("위 약관을 동의해주세요.");
            }
            // 비밀번호 체크
                
        })



    </script>
</body>
</html>