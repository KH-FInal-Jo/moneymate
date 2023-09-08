<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer</title>

    <link rel="stylesheet" href="../css/footer.css">
</head>
<body>
   

    <footer>

        
        <section class="Fmain">
            <section class="Fcontainer">
                <section class="moon"></section>
                <div class="Fcontainer1">
                    <div class="Fcontainer1-1"></div>
                    <div class="Fcontainer1-1"> 
                        <a href="#">제휴문의</a>
                        <a href="#">이용약관</a>
                        <a href="#">개인정보처리방침</a>
                        <a href="#">1:1문의</a>
                    </div>
                    <div class="Fcontainer1-1"></div>
                   
                   
                </div>
                
                <div class="footer">                    
                    <br>
                    머니메이트(주) | 대표자 : 강호연진석 | 주소 : 서울 강남구 테헤란로 낙산공원 정상 | 사업자등록번호 : 214-89-82019 | 
                    <a href="#">이메일 : help@moneymate.com</a> 
                    <br>
                    Copyright © 2023 Muneymate Inc. All right reserved.
                </div>
                
                <section class="moon2">
                    <img src="../images/로고.png">
                </section>
            </section>
            
        </section>
        
        
        <%-- session에 message가 존재할 경우 --%>
        <c:if test="${!empty message}">

            <script>
                // EL/JSTL 구문이 먼저 해석되는데
                // 문자열의 경우 따옴표가 없는 상태이니 붙여줘야한다!!!
                alert("${message}");
            </script>
            
            <%-- message 1회 출력 후 session에서 제거 --%>
        <c:remove var="message" scope="session" />

            
        </c:if>
            
    
    </footer>

</body>


</html>