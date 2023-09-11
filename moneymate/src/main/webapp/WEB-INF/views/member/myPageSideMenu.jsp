<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/member/myPageSidemenu.css">

<section class="j-myPage-sidemenu">
	<div class="j-myPage-content-header">
		<div>MY PAGE</div>
		<div class="j-myPage-sub-content">
			<div>
				<span>나의 구독 현황 >></span><span> 플래티넘</span>
			</div>
			<div>
				<div>베이직</div>
				<div>스탠다드</div>
				<div>프리미엄</div>
			</div>
			<div>
				<i class="fa-solid fa-coins fa-xl"></i></i>마일리지 : 1500점
			</div>

		</div>
	</div>
	<div class="j-myPage-member-list">
		<ul class="j-myPage-sidemenu-list">

			<li><a href="#">내 정보 조회</i></a></li>

			<li><a href="#">내 정보 수정</i></a></li>

			<li><a href="#">비밀번호 재설정</i></a></li>

			<li><a href="/member/mypage/myboard">내가 쓴 글</i></a></li>

			<li><a href="/member/mypage/likeList/1/{loginMember.memberNo}">좋아요 목록</a></li>

			<li><a href="#">북마크 조회</a></li>

			<li><a href="/member/mypage/secession">회원 탈퇴</a></li>
		</ul>

	</div>

	<script>
		const memberNo = "${loginMember.memberNo}";
	</script>

</section>