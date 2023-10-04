<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/member/myPageSidemenu.css">

<section class="j-myPage-sidemenu">
   <div class="j-myPage-content-header">
      <div>My page</div>
      <div class="result">소비성향 > ${loginMember.testResult}</div>
	   <div class="JmemberPro">
	  	<%-- 프사 들어갈 예정 --%>
      <c:if test="${empty loginMember.profileImage}" >
         <img src="/resources/images/id.png" class="myPageSideImg">
      </c:if>

      <c:if test="${!empty loginMember.profileImage}" >
         <img src="${loginMember.profileImage}" class="myPageSideImg">
      </c:if>
	  	<%-- <img src="/resources/images/mongja2.jpg" class="myPageSideImg"> --%>
	   </div>
      <div class="j-myPage-sub-content" id="memberList">
         <div>
            <span><span class="j-memberNicknameIn">${loginMember.memberNickname}</span>님의 구독현황 >></span>
			   <span id="sub"></span>
         </div>
		 <div>
            <i class="fa-solid fa-coins fa-xl"></i></i>마일리지 : <span id="mig"></span>
		 </div>

      </div>
   </div>
   <div class="j-myPage-member-list">
      <ul class="j-myPage-sidemenu-list">

         <li><a href="/member/mypage">내 정보 조회</a></li>

         <li><a href="/member/mypage/findPw">비밀번호 재설정</a></li>

         <li><a href="/member/mypage/myboard">내가 쓴 글</a></li>

         <li><a href="/member/mypage/likeList/0/${loginMember.memberNo}">좋아요 목록</a></li>

         <%-- <li><a href="/member/mypage/bookMark/4/${loginMember.memberNo }">북마크 조회</a></li> --%>

         <li><a href="/member/mypage/secession">회원 탈퇴</a></li>
      </ul>
   </div>

   <script>
      const memberNo = "${loginMember.memberNo}";
   </script>

   <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

   <script src="/resources/js/myPageSide.js"></script>

</section>