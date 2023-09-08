<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>공지사항(상세)</title>
<link rel="stylesheet" href="/resources/css/board/boardNoticeDetail.css">
<link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">
<script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
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
				<div class="board-notice-name">공지사항</div>

				<div class="board-notice-detail-container">
					<div>게시글 제목입니다.</div>

					<div>작성자 : 관리자</div>
					<div>작성일 : 2023.08.28</div>
					<div>조회수 : 10</div>

					<textarea name="board-notice-content" id="board-notice-content">게시글 내용입니다.
                    </textarea>

					<div>
						<button type="button">목록으로</button>
					</div>

				</div>



			</section>

		</section>
	</main>

</body>
</html>