<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/member/adminSidemenu.css">

<section class="j-admin-sidemenu">
    <div class="j-admin-sidemenu-container">
        <div class="j-admin-sidemenu-title"><a href="/admin/member">회원 관리</a></div>

        <div class="j-admin-sidemenu-content">
            <div id="j-admin-report" onclick="reportBtn()">신고 관리</div>
            <div id="j-admin-report-container">
                <div><a href="/admin/reportManage/chatt">채팅</a></div>
                <div><a href="/admin/reportManage/board">게시판</a></div>
            </div>
            <div><a href="/admin/payment">결제 관리</a></div>
    </div>
</section>


   <script src="/resources/js/adminSidemenu.js"></script>

   <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>


</section>