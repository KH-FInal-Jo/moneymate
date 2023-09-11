<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="resources/css/header.css">
    <link rel="stylesheet" href="resources/css/account/accountBookDetail.css">
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>


    <title>가계부 상세보기</title>
</head>
<body>

	
	<<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	

 





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
                    <span id="date-month">8월</span>
                    <span><i class="fa-regular fa-calendar" style="color: #ec1818;"></i></span>

                </div>
                <button id="month-btn">변경하기</button>
            </div>
            
            <div class="change-area">
                
                <div class="line">
                    <div>
                        <div>1</div>
                        <div>월</div>
                    </div>
                    <div>
                        <div>2</div>
                        <div>월</div>
                    </div>
                    <div>
                        <div>3</div>
                        <div>월</div>
                    </div>
                    <div>
                        <div>4</div>
                        <div>월</div>
                    </div>
                </div>
                <div class="line">
                    <div>
                        <div>5</div>
                        <div>월</div>
                    </div>
                    <div>
                        <div>6</div>
                        <div>월</div>
                    </div>
                    <div>
                        <div>7</div>
                        <div>월</div>
                    </div>
                    <div>
                        <div>8</div>
                        <div>월</div>
                    </div>
                </div>
                <div class="line">
                    <div>
                        <div>9</div>
                        <div>월</div>
                    </div>
                    <div>
                        <div>10</div>
                        <div>월</div>
                    </div>
                    <div>
                        <div>11</div>
                        <div>월</div>
                    </div>
                    <div>
                        <div>12</div>
                        <div>월</div>
                    </div>
                </div>
            </div>

    
            <!-- 일 변경(시작, 끝) -->
            
    
            <div class="btn-area">
                <span><button id="spend">지출 : 2,000,450원</button></span>
                <span><button id="income">수입 : 5,123,456원</button></span>
                <span><i class="fa-regular fa-square-plus fa-4x" style="color: #0c40ca;"></i></span>
            </div>

            <!-- 지출 차트 -->
            <div class="chart-div">
                <canvas id="pieChartCanvas" width="300px" height="300px"></canvas>
            </div>
            <!-- 수입 차트 -->
            <div class="chart-div2">
                <canvas id="pieChartCanvas2" width="300px" height="300px"></canvas>
            </div>

        </section>

        
        <section class="all-area">

    
            <section class="detail-area">
                
                <table class="tb">

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">-10,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">소풍</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">-10,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">소풍</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">-10,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">소풍</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">-10,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">소풍</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">-10,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">소풍</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">-10,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">소풍</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">-10,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">소풍</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">-10,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">소풍</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">-10,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">소풍</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                   
                </table>


                <table class="income-tb">
                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">+1000,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">월급</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">+1000,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">월급</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="spend-date">09-04(월)</td>
                        <td rowspan="3" class="price">+1000,500원</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="where">월급</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="category">한식</td>
                    </tr>
                </table>
                
    
            </section>


        </section>


    </main>
    
    <script src="resources/js/accountBookDeatil.js"></script>

</body>
</html>