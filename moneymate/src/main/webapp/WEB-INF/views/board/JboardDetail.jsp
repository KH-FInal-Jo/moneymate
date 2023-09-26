<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>공지사항(상세)</title>
<link rel="stylesheet" href="/resources/css/board/boardNoticeDetail.css">

<script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<main>
		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<section class="board-notice-content">

			<jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp" />

			<section class="board-notice-main">
				<div class="board-notice-name">공지사항</div>

				<div class="board-notice-detail-container">

				<c:forEach var="board" items="${boardList}">


					<div>${board.boardTitle}</div>

					<div>작성자 : 관리자</div>
					<div>작성일 : ${board.boardCreateDate}</div>
					<div>조회수 : ${board.readCount}</div>

				
					<textarea name="board-notice-content" id="board-notice-content" disabled>${board.boardContent}
                    </textarea>


					<div class="noticeBtnCon">

						<div>
							<c:if test="${loginMember.authority == 1}" >

								<button type="button" id="updateBtn" onclick="location.href='/community/1/${board.boardNo}/update'">수정</button>
								<button type="button" id="deleteBtn">삭제</button>

							</c:if>
						</div>

						<button type="button" id="goToBtn">목록으로</button>
					</div>
				</c:forEach>

				</div>


			</section>

		</section>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />

		<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
		
	</main>


	<script src="/resources/js/boardNotice.js"></script>
	
	

</body>
</html>