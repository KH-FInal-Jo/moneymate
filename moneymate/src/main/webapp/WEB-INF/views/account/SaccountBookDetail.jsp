<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/resources/css/account/accountBookDetail.css">
    
    <%-- <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script> --%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>


    <title>가계부 상세보기</title>
</head>
<body>

	
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	

 





    <h1>
        나의 지출 현황과 통계를 확인해보세요!
    </h1>

    <section class="intro">

        <div class="head-img">
            <img src="https://img.freepik.com/free-vector/calculator-and-budget-management-icons_603843-1525.jpg?w=2000">
        </div>

        <div>
            #충동적인 <br>
            #계획없는 <br>
            #소비는 이제 그만 <br>
            #가계부로 관리해보세요. <br>
        </div>
    </section>
    


    <main class="accountBook-main">

        <section>
            
            <div class="date">
                <!-- 월 변경 -->
                <div >
                    <span>2023년</span>
                    <span id="date-month"></span>
                    <span><i class="fa-regular fa-calendar" style="color: #ec1818;"></i></span>

                </div>
                <button id="month-btn">변경하기</button>
            </div>
            
            <div class="change-area">
                
                <div class="line">
                    <div class="line-month">
                        <div id="1">1</div>
                        <div>월</div>
                    </div>
                    <div class="line-month">
                        <div>2</div>
                        <div>월</div>
                    </div>
                    <div class="line-month">
                        <div>3</div>
                        <div>월</div>
                    </div>
                    <div class="line-month">
                        <div>4</div>
                        <div>월</div>
                    </div>
                </div>
                <div class="line">
                    <div class="line-month">
                        <div>5</div>
                        <div>월</div>
                    </div>
                    <div class="line-month">
                        <div>6</div>
                        <div>월</div>
                    </div>
                    <div class="line-month">
                        <div>7</div>
                        <div>월</div>
                    </div>
                    <div class="line-month">
                        <div>8</div>
                        <div>월</div>
                    </div>
                </div>
                <div class="line">
                    <div class="line-month">
                        <div>9</div>
                        <div>월</div>
                    </div>
                    <div class="line-month">
                        <div>10</div>
                        <div>월</div>
                    </div>
                    <div class="line-month">
                        <div>11</div>
                        <div>월</div>
                    </div>
                    <div class="line-month">
                        <div>12</div>
                        <div>월</div>
                    </div>
                </div>
            </div>

    
            <!-- 일 변경(시작, 끝) -->
            
    
            <div class="btn-area">
                <span><button id="spend">지출 : 2,000,450원</button></span>
                <span><button id="income">수입 : 5,123,456원</button></span>
                <c:if test="${!empty loginMember}" >
                    <span><a href="/account/insert/1"><i class="fa-regular fa-square-plus fa-4x" style="color: #0c40ca;"></i></a></span>
                </c:if>
            </div>

            <!-- 지출 차트 -->
            <div class="chart-div">
                <canvas id="pieChartCanvas" width="300px" height="300px"></canvas>
                <div class="category-area">
                    <div class="category-percent">
                        <span class="round"></span>
                        <span class="categoryName"></span>
                        <span class="equal">:</span>
                        <span class="percentNo"></span>
                        <span class="sumMoney"></span>
                    </div>
                </div>

            </div>
            


            <!-- 수입 차트 -->
            <div class="chart-div2">
                <canvas id="pieChartCanvas2" width="300px" height="300px"></canvas>
                <div class="Icategory-area">
                    <div class="categoryIncome-percent">
                            <span class="Iround"></span>
                            <span class="IcategoryName"></span>
                            <span class="Iequal">:</span>
                            <span class="IpercentNo"></span>
                            <span class="sumMoney"></span>
                    </div>
                </div>
            </div>


        </section>

        
        <section class="all-area">

            <%-- 지출 내역 영역 --%>
            <section class="detail-area">
                <button id="allView-btn">전체보기</button>
                
                <div class="spend-area">

                    <div class="spend-line">
                        <div class="spend-left">
                            <div></div>
                            <div></div>
                            <div></div>
                        </div>
                        <div></div>
                    </div>

                </div>
                <%-- 수입 내역 영역 --%>
                <div class="income-area">

                    <div class="income-line">
                        <div class="income-left">
                            <div></div>
                            <div></div>
                            <div></div>
                        </div>
                        <div></div>
                    </div>

                </div>

                
    
            </section>


        </section>


    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    



    <script>
        document.addEventListener("DOMContentLoaded", function () {

            incomeDiv.style.display = 'none'
            incomeArea.style.display = 'none'

            var currentURL = window.location.href;

            // URL에서 "1" 추출하기
            var parts = currentURL.split('/');
            var accountNo = parts.pop();

            const dateMonth = document.getElementById("date-month")
            const month = dateMonth.innerText.replace("월", "");
            handleFetch(month, accountNo);
            handleFetchIncome(month, accountNo);

            handleFetchView(month, accountNo);
            handleFetchViewIncome(month, accountNo);

            handleFetchChart(month, accountNo);
            handleFetchChartIncome(month, accountNo);



        });

    </script>
    <script src="/resources/js/accountBookDeatil.js"></script>
</body>
</html>
