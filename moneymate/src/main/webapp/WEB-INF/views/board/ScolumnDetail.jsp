<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칼럼 상세보기</title>

    <link rel="stylesheet" href="/resources/css/columnDetail.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">

    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
</head>
<body>

    <main class="headMain">


        <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>


    </main>



    <main class="detailMain">

        <section class="board-sidemenu">
            <div class="board-community-header">
                <div>커뮤니티 </div>
                <div>community</div>
            </div>
            <ul class="board-sidemenu-list">

                <li><a href="#">공지사항<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                
                <li><a href="#">문의게시판<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                
                <li><a href="#">자유게시판<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
                
                <li><a href="#">컬럼게시판<i class="fa-solid fa-caret-right fa-xl"></i></a></li>
            </ul>

        </section>

        <div class="detail">

            <div class="writer">
                작성자 : 조성진
            </div>
            <div class="createDate">
                작성일 : 2023년 8월 30일 16:11
            </div>
            <div class="readCount">   
                조회수 : 10
            </div>
            <div class="title">
                칼럼 제목
            </div>
            <div class="article">
                <div class="articleImage">
                    <img src="/resources/images/금융칼럼.jpg">
                </div>
                <div class="articleMain">

                    정부 지원 상품인 만큼 청년도약계좌와 청년희망적금 중복 가입은 불가능해요. 하지만 과거 정부 지원 상품에 비추어보면, 만기 이후 추가 가입이나 갈아타기는 가능했던 것으로 보이는데요. 신청 기간 전에 해지하거나 갈아타기를 진행할 때는 중도해지이율을 반드시 확인해야 해요.
                    중도해지이율은 처음 가입 시 약속한 이율이 아닌, 중도 해지 시 별도 적용하는 이율을 의미하는데요. 만약 올해 6월 대략 1년이 넘은 시점에 중도해지한다면, 기본이율의 90%에 보유일수를 계약일수로 나눈 금액을 곱한(기본이율의 90% * 보유일수/계약일수) 중도 해지이율을 적용받을 수 있어요. 기본이율의 90%를 유지한 기간에 비례해 적용하겠다는 셈인 거죠.
                </div>

                <div class="articleImage">
                    <img src="/resources/images/금융칼럼.jpg">
                </div>
                <div class="articleMain">

                    정부 지원 상품인 만큼 청년도약계좌와 청년희망적금 중복 가입은 불가능해요. 하지만 과거 정부 지원 상품에 비추어보면, 만기 이후 추가 가입이나 갈아타기는 가능했던 것으로 보이는데요. 신청 기간 전에 해지하거나 갈아타기를 진행할 때는 중도해지이율을 반드시 확인해야 해요.
                    중도해지이율은 처음 가입 시 약속한 이율이 아닌, 중도 해지 시 별도 적용하는 이율을 의미하는데요. 만약 올해 6월 대략 1년이 넘은 시점에 중도해지한다면, 기본이율의 90%에 보유일수를 계약일수로 나눈 금액을 곱한(기본이율의 90% * 보유일수/계약일수) 중도 해지이율을 적용받을 수 있어요. 기본이율의 90%를 유지한 기간에 비례해 적용하겠다는 셈인 거죠.
                </div>


            </div>
            <div>
                
                    <span><button id="previous">이전글</button></span>
                    <span id="likeBtn"><i class="fa-regular fa-thumbs-up fa-2x" style="color: #0c40ca;"></i></i> 10</span>
                    <span><button id="next">다음글</button></span>
            </div>

            
            <div class="other-title">다른 칼럼 보러가기</div>
            <div class="other">
                <div class="otherView">

                    <div><a href="#"><img src="/resources/images/dog1.jpg"></a></div>
                    <div><a href="#">다른 칼럼 제목</a></div>

                </div>
                <div class="otherView">
                    <div><a href=""><img src="/resources/images/금융칼럼.jpg"></a></div>
                    <div><a href="">다른 칼럼 제목다른 칼럼 제목다른 칼럼 제목다른 칼럼 제목다른 칼럼 제목</a></div>

                </div>
                <div class="otherView">
                    <div><a href=""><img src="/resources/images/dog1.jpg"></a></div>
                    <div><a href="#">다른 칼럼 제목</a></div>

                </div>
            </div>
        </div>
    </main>

    <footer>
        footer
    </footer>
    
</body>
</html>