<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
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


						<c:forEach var="board" items="${boardList}">
							<tr>
								<th height="60px">${board.boardNo}</th>
								<td><a href="/community/${boardCode}/${board.boardNo}">${board.boardTitle}</a></td>
								<td>${board.memberNickname}</td>
								<td>${board.boardCreateDate}</td>
								<td>${board.readCount}</td>
							</tr>
						</c:forEach>


					</table>

				</div>
				<c:if test="${loginMember.authority == 1}">

					<div class="board-notice-wrtie-btn">
						<button type="button" id="NoticeWriteBtn">글쓰기</button>
					</div>
				</c:if>

			</section>

		</section>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
		
		
		
	</main>

	<script src="../resources/js/boardNotice.js"></script>
</body>
</html>