<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/board/boardNoticeDetail.css">
<link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">
<title>공지사항(작성하기)</title>
<script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<main>
		<section>
			<div class="head">
				<div>
					<a href=""><img src="../images/로고.png"></a>
				</div>
				<div class="head-board">
					<!-- 헤더 글 -->
					<div class="nav">
						<a href=""><span>커뮤니티</span></a> <a href=""><span>가계부</span></a> <a
							href=""><span>소비 테스트</span></a> <a href=""><span>이벤트게시판</span></a>
						<a href=""><span>마이페이지</span></a>

					</div>
					<!-- 헤더 프로필 -->
					<div class="login">
						<div>

							<img src="../images/로그인 아이콘.png">
						</div>
						<div>
							<a href=""><span>LOGIN</span></a> <a href=""><span>회원가입</span></a>

						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="board-notice-content">

			<section class="j-board-sidemenu">
				<div class="j-board-community-header">
					<div>커뮤니티</div>
					<div>community</div>
				</div>
				<ul class="j-board-sidemenu-list">

					<li><a href="#">공지사항<i
							class="fa-solid fa-caret-right fa-xl"></i></a></li>

					<li><a href="#">문의게시판<i
							class="fa-solid fa-caret-right fa-xl"></i></a></li>

					<li><a href="#">자유게시판<i
							class="fa-solid fa-caret-right fa-xl"></i></a></li>

					<li><a href="#">컬럼게시판<i
							class="fa-solid fa-caret-right fa-xl"></i></a></li>
				</ul>

			</section>

			<section class="board-notice-main">
				<div class="board-notice-name">공지사항 > 작성하기</div>

				<form action="#">

					<div class="board-notice-write-container">

						<input type="text" id="board-notice-title"
							name="board-notice-title" placeholder="제목을 입력해주세요.">
						<textarea name="board-notice-write-content"
							id="board-notice-write-content" placeholder="내용을 입력해주세요."></textarea>

						<div>
							<button type="button">이전으로</button>
							<button type="button">등록</button>
						</div>
					</div>


				</form>


			</section>

		</section>
	</main>

</body>
</html>