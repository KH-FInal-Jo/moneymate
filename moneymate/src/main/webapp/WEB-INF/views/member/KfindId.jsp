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
        <%@ include file="/WEB-INF/views/modal/userIdSearchModal.jsp" %> 
            <section class="findContainer1">
                            <div id="imgTop">
                                <img src="/resources/images/로고.png">
                            </div>
                        </section>
                    <div class="full">
                    <div class="container">
                        <div class="area_inputs wow fadeIn">
                            <div class="sub_title font-weight-bold text-white">
                                <h3>아이디/비밀번호 찾기</h3>
                                <p>인증된 이메일만 정보 찾기가 가능합니다 :)</p>
                            </div>
                            <div style="margin-bottom: 10px;"
                                class="custom-control custom-radio custom-control-inline">
                                <input type="radio" class="custom-control-input" id="search_1" name="search_total" onclick="search_check(1)" checked="checked">
                                <label class="custom-control-label font-weight-bold text-white"	for="search_1">아이디 찾기</label>
                            </div>
                            <div class="custom-control custom-radio custom-control-inline">
                                <input type="radio" class="custom-control-input" id="search_2" name="search_total" onclick="search_check(2)"> 
                                <label class="custom-control-label font-weight-bold text-white" for="search_2">비밀번호 찾기</label>
                            </div>
                            <div id="searchI">
                                <div class="form-group">
                                    <label class="font-weight-bold text-white" for="inputName_1">이름</label>
                                    <div>
                                        <input type="text" class="form-control" id="inputName_1" name="inputName_1" placeholder="ex) 갓민수">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="font-weight-bold text-white" for="inputPhone_1">휴대폰번호</label>
                                    <div>
                                        <input type="text" class="form-control" id="inputPhone_1" name="inputPhone_1" placeholder="ex) 01077779999">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button id="searchBtn" type="button" onclick="idSearch_click()" class="btn btn-primary btn-block">확인</button>
                                <a class="btn btn-danger btn-block"	href="${pageContext.request.contextPath}">취소</a>
                                </div>
                            </div>
                            <div id="searchP" style="display: none;">
                                <div class="form-group">
                                    <label class="font-weight-bold text-white" for="inputId">아이디</label>
                                    <div>
                                        <input type="text" class="form-control" id="inputId" name="inputId_2" placeholder="ex) godmisu">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="font-weight-bold text-white" for="inputEmail_2">이메일</label>
                                    <div>
                                        <input type="email" class="form-control" id="inputEmail_2"	name="inputEmail_2" placeholder="ex) E-mail@gmail.com">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button id="searchBtn2" type="button" class="btn btn-primary btn-block">확인</button>
                                <a class="btn btn-danger btn-block"	href="${pageContext.request.contextPath}">취소</a>
                            </div>
                            </div>
                        </div>
                    </div>
            </div>



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
</body>
</html>


