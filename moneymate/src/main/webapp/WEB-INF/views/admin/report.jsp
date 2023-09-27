<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/admin/report.css">
<link rel="stylesheet" href="/resources/css/footer.css">

<title>신고하기</title>
</head>
<body>
	<main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>


        <section>
            <div class="main">
                <div class="title"><h1>신고하기</h1></div>
                <form action="/community/report/board" method="POST">
                    <div class="content">
                        <div class="writer">
                            <div class="ecc">글쓴이</div>
                            <div class="bor1">${board.memberNickname}</div>
                            <input type="hidden" name="reportedNo" value="${board.memberNo}">
                            <input type="hidden" name="boardNo" value="${board.boardNo}">
                            <input type="hidden" name="badContent" value="${board.boardContent}">
                            <input type="hidden" name="memberId" value="${board.memberId}">
                            <input type="hidden" name="memberNickname" value="${board.memberNickname}">
                        </div>

                        <div class="writerContent">
                            <div class="ecc">
                                게시글
                                <br>(채팅내용)
                            </div>
                            <div class="bor2"><textarea class="writeContent">${board.boardContent}</textarea></div>
                        </div>
                    </div>

                    <div class="reason">
                        <div class="r-title">
                            <h3>사유내용</h3>
                        </div>
                        <div class="r-reason">
                            <input type="radio" class="radio" name="reportCategory" value="1" id="r1"><label for="r1">욕설이 너무 심해요.</label><br>
                            <input type="radio" class="radio" name="reportCategory" value="2" id="r2"><label for="r2">불법 광고를 해요.</label><br>
                            <input type="radio" class="radio" name="reportCategory" value="3" id="r3"><label for="r3">개인정보 노출 및 사생활 침해</label><br>
                            <input type="radio" class="radio" name="reportCategory" value="4" id="r4"><label for="r4">도배 글이에요.</label><br>
                            <input type="radio" class="radio" name="reportCategory" value="5" id="r5"><label for="r5">기타</label><br>

                            
                            <h5>신고내용</h5>
                            <textarea name="reportContent" class="reportContent"></textarea>
                            <div class="btnArea">
                                <button type="button" id="goBack">뒤로가기</button>
                                <button id="submit">제출하기</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

        
    </main>

    <script></script>

    <script src="/resources/js/report.js"></script>

</body>
</html>