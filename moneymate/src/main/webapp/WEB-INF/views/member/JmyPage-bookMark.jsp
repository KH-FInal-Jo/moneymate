<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/member/myPageSidemenu.css">
<link rel="stylesheet" href="/resources/css/member/myPageBookMark.css">
<script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
<title>마이페이지 사이드메뉴</title>
</head>
<body>

    <main>
        <section>
            <div class="head">
                <div><a href=""><img src="../images/로고.png"></a></div>
                <div class="head-board">
                    <!-- 헤더 글 -->
                    <div class="nav">
                        <a href=""><span>커뮤니티</span></a>
                        <a href=""><span>가계부</span></a>
                        <a href=""><span>소비 테스트</span></a>
                        <a href=""><span>이벤트게시판</span></a>
                        <a href=""><span>마이페이지</span></a>
        
                    </div>
                    <!-- 헤더 프로필 -->
                    <div class="login">
                        <div>
                            
                            <img src="../images/로그인 아이콘.png">
                        </div>
                        <div>
                            <a href=""><span>LOGIN</span></a>
                            <a href=""><span>회원가입</span></a>
    
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="myPage-container">

            <section class="j-myPage-sidemenu">
                <div class="j-myPage-content-header">
                    <div>MY PAGE</div>
                    <div class="j-myPage-sub-content">
                        <div><span>나의 구독 현황 >></span><span> 플래티넘</span></div>
                        <div>
                            <div>베이직</div>
                            <div>스탠다드</div>
                            <div>프리미엄</div>
                        </div>
                        <div><i class="fa-solid fa-coins fa-xl"></i></i>마일리지 : 1500점</div>

                    </div>
                </div>
                <div class="j-myPage-member-list">
                    <ul class="j-myPage-sidemenu-list">
    
                        <li><a href="#">내 정보 조회</i></a></li>
                        
                        <li><a href="#">내 정보 수정</i></a></li>
                        
                        <li><a href="#">비밀번호 재설정</i></a></li>
                        
                        <li><a href="#">내가 쓴 글</i></a></li>
    
                        <li><a href="#">좋아요 목록</a></li>
    
                        <li><a href="#">북마크 조회</a></li>
    
                        <li><a href="#">회원 탈퇴</a></li>
                    </ul>

                </div>

            </section>

            <section class="myPage-main">
                <div class="myPage-list-header-name">북마크 목록</div>
                <div class="myPage-list-container">
                    <div class="myPage-bookmark">
                        <div><i class="fa-solid fa-bookmark fa-xl"></i></div>
                        <div><a href="#"><img src="../images/dog1.jpg"></a></div>
                        <div>
                            <div>게시글 제목~</div>
                            <div>게시글내용용용</div>
                        </div>
                    </div>

                    <div class="myPage-bookmark">
                        <div><i class="fa-solid fa-bookmark fa-xl"></i></div>
                        <div><a href="#"><img src="../images/금융칼럼.jpg"></a></div>
                        <div>
                            <div>게시글 제목~</div>
                            <div>게시글내용용용</div>
                        </div>
                    </div>

                    <div class="myPage-bookmark">
                        <div><i class="fa-solid fa-bookmark fa-xl"></i></div>
                        <div><a href="#"><img src="../images/dog1.jpg"></a></div>
                        <div>
                            <div>게시글 제목~</div>
                            <div>게시글내용용용</div>
                        </div>
                    </div>

                    <div class="myPage-bookmark">
                        <div><i class="fa-solid fa-bookmark fa-xl"></i></div>
                        <div><a href="#"><img src="../images/dog1.jpg"></a></div>
                        <div>
                            <div>게시글 제목~</div>
                            <div>게시글내용용용</div>
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