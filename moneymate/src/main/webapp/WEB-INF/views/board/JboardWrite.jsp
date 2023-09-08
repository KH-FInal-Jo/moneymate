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
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		

		<section class="board-notice-content">

			<jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp" />

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