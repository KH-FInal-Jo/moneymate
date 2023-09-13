<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/board/boardNoticeDetail.css">
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
				<c:forEach var="board" items="${boardList}">

				${boardList}


					<form action="/community/${boardCode}/insert" method="POST">

						<div class="board-notice-write-container">

							<input type="text" id="board-notice-title" value="${board.boardTitle}"
								name="boardTitle" placeholder="제목을 입력해주세요.">
							<textarea name="boardContent"
								id="board-notice-write-content" placeholder="내용을 입력해주세요.">${board.boardContent}</textarea>

							<div>
								<button type="button">이전으로</button>
								<button type="submit">등록</button>
							</div>
						</div>

					</form>
				</c:forEach>


			</section>

		</section>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</main>

	<script src="../resources/js/boardNotice.js"></script>
	

</body>
</html>