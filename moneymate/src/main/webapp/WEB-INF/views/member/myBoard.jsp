<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/member/myPageSidemenu.css">
    <link rel="stylesheet" href="/resources/css/myBoardList.css">
    <script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>

<title>내가 쓴 글</title>
</head>
<body>

    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        
        <section class="myPage-container">

            <jsp:include page="/WEB-INF/views/member/myPageSideMenu.jsp"/>

            <section class="myPage-notice-main">
                <div class="myPage-notice-name"><h1>내가 쓴 글</h1>
                </div>
                <div class="list">
                    
                    <div class="search">
                        <form>
                            <select name="sel">
                                <option value="1" selected>제목</option>
                                <option value="2" >내용</option>
                                <option value="3">제목+내용</option>
                            </select>
                            <input type="text" id="query"> <button>검색</button>
                        </form>
                    </div>
                    <div class="listOne">
                        <div class="thumbnail"><img src="/resources/images/mongja2.jpg"></div>
                        <div class="board">
                            <div class="title"><a>1번 게시글 내용입니다 [5]</a></div>
                            <div class="content"><a>1번 게시글 내용 입니다!!</a></div>
                            <div class="etc">2023-09-11</div>
                        </div>
                    </div>
                    <div class="listOne">
                        <div class="thumbnail"><img src="/resources/images/mongja2.jpg"></div>
                        <div class="board">
                            <div class="title">1</div>
                            <div class="content">2</div>
                            <div class="etc">3</div>
                        </div>
                    </div>
                    <div class="listOne">
                        <div class="thumbnail"><img src="/resources/images/mongja2.jpg"></div>
                        <div class="board">
                            <div class="title">1</div>
                            <div class="content">2</div>
                            <div class="etc">3</div>
                        </div>
                    </div>
                    <div class="listOne">
                        <div class="thumbnail"><img src="/resources/images/mongja2.jpg"></div>
                        <div class="board">
                            <div class="title">1</div>
                            <div class="content">2</div>
                            <div class="etc">3</div>
                        </div>
                    </div>
                    <div class="listOne">
                        <div class="thumbnail"><img src="/resources/images/mongja2.jpg"></div>
                        <div class="board">
                            <div class="title">1</div>
                            <div class="content">2</div>
                            <div class="etc">3</div>
                        </div>
                    </div>
                   

                    
                    <div class="page">
                        <a href="#">&lt;&lt;</a>
                        <a href="#">&lt;</a>
                        <a href="#">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                        <a href="#">5</a>
                        <a href="#">6</a>
                        <a href="#">7</a>
                        <a href="#">8</a>
                        <a href="#">9</a>
                        <a href="#">10</a>
                        <a href="#">&gt;</a>
                        <a href="#">&gt;&gt;</a>
                    </div>
                    
                </div>
           

            </section>

        </section>
        
    </main>
    
</body>
</html>