<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="/resources/css/board/boardNoticeDetail.css">
<link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">
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
				<div class="board-notice-name">공지사항</div>

				<div class="board-notice-sel-search">
					<form action="#">

						<select name="sel">
							<option value="1">글제목</option>
							<option value="2">작성자</option>

						</select>
					</form>

					<input type="text" id="board-notice-search"
						placeholder="검색어를 입력해주세요.">

				</div>
				<div class="board-notice-list">
					<table border="1" class="board-notice-table">
						<tr class="board-notice-list-header">
							<th width="50px">번호</th>
							<th width="400px" height="60px">제목</th>
							<td width="100px">작성자</td>
							<th width="100px">작성일</th>
							<th width="50px">조회수</th>
						</tr>
						<tr>
							<th height="60px">0</th>
							<a href="#"><td>공지사항 테스트 글입니다.</td></a>
							<td>관리자</td>
							<td>2023.08.28</td>
							<td>10</td>
						</tr>

						<tr>
							<th height="60px">1</th>
							<a href="#"><td>공지사항 테스트 글입니다.</td></a>
							<td>관리자</td>
							<td>2023.08.28</td>
							<td>10</td>
						</tr>

						<tr>
							<th height="60px">2</th>
							<a href="#"><td>공지사항 테스트 글입니다.</td></a>
							<td>관리자</td>
							<td>2023.08.28</td>
							<td>10</td>
						</tr>

						<tr>
							<th height="60px">3</th>
							<a href="#"><td>공지사항 테스트 글입니다.</td></a>
							<td>관리자</td>
							<td>2023.08.28</td>
							<td>10</td>
						</tr>

						<tr>
							<th height="60px">4</th>
							<a href="#"><td>공지사항 테스트 글입니다.</td></a>
							<td>관리자</td>
							<td>2023.08.28</td>
							<td>10</td>
						</tr>

					</table>

				</div>

				<div class="board-notice-wrtie-btn">
					<button type="button">글쓰기</button>
				</div>

			</section>

		</section>
	</main>

</body>
</html>