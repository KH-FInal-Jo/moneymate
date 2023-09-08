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
		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<section class="board-notice-content">

			<jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp" />

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