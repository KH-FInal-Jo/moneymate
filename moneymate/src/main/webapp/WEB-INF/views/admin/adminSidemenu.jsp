<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/member/adminSidemenu.css">

<section class="j-admin-sidemenu">
    <div class="j-admin-sidemenu-container">
        <div class="j-admin-sidemenu-title">회원 관리</div>

        <div class="j-admin-sidemenu-content">
            <div id="j-admin-report" onclick="reportBtn()">신고 관리</div>
            <div id="j-admin-report-container">
                <div><a href="#">채팅</a></div>
                <div><a href="#">게시판</a></div>
            </div>
            <div>결제 관리</div>
            <div id="j-admin-community-list" onclick="adminCommunity()">게시판 관리</div>
                <div id="j-admin-com">
                    <div><a href="#">공지사항</a></div>
                    <div><a href="#">문의게시판</a></div>
                    <div><a href="#">자유게시판</a></div>
                    <div><a href="#">컬럼게시판</a></div>
                    <div><a href="#">이벤트게시판</a></div>

                </div>
        </div>
    </div>
</section>


   <script src="/resources/js/adminSidemenu.js"></script>

   <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>


</section>