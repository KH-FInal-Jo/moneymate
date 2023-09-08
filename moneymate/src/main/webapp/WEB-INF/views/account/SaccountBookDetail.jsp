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

    <head>
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
    </head>
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
                <span>
                    <input id="month" type="month" value="2023-08">
                        
                </span>
                <button id="month-btn">변경하기</button>
            </div>
    
            <!-- 일 변경(시작, 끝) -->
            <div class="day-date">
                시작 : <input type="date" value="2023-08-01" min="2023-08-01">
                끝 : <input type="date" value="2023-08-31" max="2023-08-31">
                <button id="day-btn">변경하기</button>
            </div>
            
    
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