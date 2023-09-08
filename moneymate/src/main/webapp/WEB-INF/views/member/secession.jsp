<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
                    ȸ�� Ż��
                </div>

                <div class="sub">
                    <span>Ż��� ���� ����</span>
                </div>

                <div class="textarea1">
<textarea id="textarea">����ϰ� ��� ���̵�(rjh658)�� Ż���� ��� ���� �� ������ �Ұ����մϴ�.
Ż���� ���̵�� ���ΰ� Ÿ�� ��� ���� �� ������ �Ұ��Ͽ��� �����ϰ� �����Ͻñ� �ٶ��ϴ�.
Ż�� �� ȸ������ �� ������ ���� �̿����� ��� �����˴ϴ�.

ȸ������ �� ����, ��α�, �ּҷ� �� ������ ���� �̿����� ��� �����Ǹ�, ������ �����ʹ� �������� �ʽ��ϴ�.
�����Ǵ� ������ Ȯ���Ͻð� �ʿ��� �����ʹ� �̸� ����� ���ּ���.

Ż�� �Ŀ��� �Խ����� ���񽺿� ����� �Խù��� �״�� ���� �ֽ��ϴ�.
����, ī��, ����iN � �ø� �Խñ� �� ����� Ż�� �� �ڵ� �������� �ʰ� �״�� ���� �ֽ��ϴ�.
������ ���ϴ� �Խñ��� �ִٸ� �ݵ�� Ż�� �� ����� ó���ϰų� �����Ͻñ� �ٶ��ϴ�.

Ż�� �Ŀ��� ȸ�������� �����Ǿ� ���� ���θ� Ȯ���� �� �ִ� ����� ����, �Խñ��� ���Ƿ� �����ص帱 �� �����ϴ�.
�Խ����� ���� �� "�׶�������"�� ����� �����˴ϴ�.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
</textarea>
                </div>
                
                <form action="secession" method="POST" name="myPageFrm" id="secessionFrm">
                    <div class="check">
                        <input type="checkbox" id="check">
                        <label for="check">�� ������ ��� Ȯ���Ͽ�����, �̿� �����մϴ�.</label>
                    </div>


                        <div class="inputPw">
                            <label for="memberPw">��й�ȣ</label>
                            <input type="password" name="memberPw" id="memberPw" maxlength="30">              
                        </div>



                    <div class="btn">
                        <button id="quitSecession">�׸��α�</button>
                        <button id="secession">Ż���ϱ�</button>
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
                alert("�� ����� �������ּ���.");
            }
            // ��й�ȣ üũ
                
        })



    </script>
</body>
</html>