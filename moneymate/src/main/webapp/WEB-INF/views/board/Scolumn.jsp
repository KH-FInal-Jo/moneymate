<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칼럼게시판</title>

    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/column.css">
    <link rel="stylesheet" href="/resources/css/board/boardSidemenu-style.css">

    <script src="/resources/js/jquery-3.7.0.min.js"></script>
</head>
<body>
    <!-- 헤드 -->
    <main class="headMain">
    
    	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>




    </main>


    <main class="columnMain">

        <jsp:include page="/WEB-INF/views/board/boardSideMenu.jsp"></jsp:include>


        <section class="main">


            
            <div class="explain">
                <div><img src="/resources/images/금융칼럼.jpg"></div>
                <div class="ex-title"> 
                    <div>
                        #경제,금융에 대해서 얼마나 아니?
                    </div>
                    <div>
                        <br><br> 정부 지원 상품인 만큼 청년도약계좌와 청년희망적금 중복 가입은 불가능해요. 하지만 과거 정부 지원 상품에 비추어보면, 만기 이후 추가 가입이나 갈아타기는 가능했던 것으로 보이는데요. 신청 기간 전에 해지하거나 갈아타기를 진행할 때는 중도해지이율을 반드시 확인해야 해요.
                       중도해지이율은 처음 가입 시 약속한 이율이 아닌, 중도 해지 시 별도 적용하는 이율을 의미하는데요. 만약 올해 6월 대략 1년이 넘은 시점에 중도해지한다면, 기본이율의 90%에 보유일수를 계약일수로 나눈 금액을 곱한(기본이율의 90% * 보유일수/계약일수) 중도 해지이율을 적용받을 수 있어요. 기본이율의 90%를 유지한 기간에 비례해 적용하겠다는 셈인 거죠.</div>

                </div>
            </div>
            <!-- 컬럼 목록 -->       


                <c:choose>
                
                    <c:when test="${empty columnList}">

                        <%-- 조회된 게시글이 존재하지 않을 경우 --%>
                         <a href="/community/4/insert"><button id="Swrite">글쓰기</button></a>

                        <div class="one">
                            게시글이 존재하지 않습니다.
                        </div>

                    </c:when>

                    <c:otherwise>
                    <a href="/community/4/insert"><button id="Swrite">글쓰기</button></a>
                    
                        <%-- 게시글 목록 조회 결과가 있다면 --%>
                        <c:forEach items="${columnList}" var="column">
                        

                            <div class="column-area">
                                <div><a href="/community/4/${column.boardNo}"><img src="${column.thumbNail}"></a></div>

                                <div class="title-area">
                                    <div>
                                        <a href="/community/4/${column.boardNo}" class="a-title">${column.boardTitle}</a>
                                    </div>
                                    <div>
                                        작성일 : ${column.boardCreateDate}
                                    </div>
                                </div>
                            </div>
                            
                            
                        </c:forEach>
                        <!-- <a href="#" id="load">MORE</a> -->
                        <button id="load">더보기</button>

                    </c:otherwise>
                
                
                
                
                </c:choose>

              




               
                

        </section>





    </main>

   <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

   


   

    <script src="/resources/js/column.js"></script>
    
    
</body>
</html>