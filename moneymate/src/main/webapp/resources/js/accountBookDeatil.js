// 수입 차트
const incomeDiv = document.querySelector(".chart-div2")
// 지출 차트
const spendDiv = document.querySelector(".chart-div")
// 수입내역 테이블
const incomeTb = document.querySelector(".income-tb")
// 지출내역 테이블
const tb = document.querySelector(".tb")



window.onload = function () {
    pieChartDraw();
    pieChartDraw2();
    
    /* 수입 차트 처음엔 안보임 */
    incomeDiv.style.display = 'none';
}

/* default 월 설정(현재월) */
document.getElementById("month").value= new Date().toISOString().slice(0, 7);



/* 지출 */
let pieChartData = {
    labels: ['식비', '교통비', '주거비', '관리비', '유흥', '생필품'],
    datasets: [{
        data: [10, 20, 50, 5, 10, 5],
        backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)']
    }] 
};
/* 수입 */
let pieChartData2 = {
    labels: ['수입','성공'],
    datasets: [{
        data: [50,50],
        backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)']
    }] 
};

/* 지출 차트 */
let pieChartDraw = function () {
    let ctx = document.getElementById('pieChartCanvas').getContext('2d');
    
    window.pieChart = new Chart(ctx, {
        type: 'pie',
        data: pieChartData,
        options: {
            responsive: false
        }
    });
};

/* 수입 차트 */
let pieChartDraw2 = function () {
    let ctx = document.getElementById('pieChartCanvas2').getContext('2d');
    
    window.pieChart = new Chart(ctx, {
        type: 'pie',
        data: pieChartData2,
        options: {
            responsive: false
        }
    });
};

// 수입 버튼
const incomeBtn = document.getElementById("income")
// 지출 버튼
const spendBtn = document.getElementById("spend")


/* 수입 눌렀을 때 */
incomeBtn.addEventListener("click", ()=>{
    incomeBtn.style.backgroundColor = '#31c770'
    spendBtn.style.backgroundColor = '#ccc'

    spendDiv.style.display = 'none';
    incomeDiv.style.display = 'flex';

    tb.style.display = 'none';
    incomeTb.style.display = 'block';


})

/* 지출 눌렀을 때 */
spendBtn.addEventListener("click", ()=>{
    spendBtn.style.backgroundColor = '#31c770'
    incomeBtn.style.backgroundColor = '#ccc'

    incomeDiv.style.display = 'none';
    spendDiv.style.display = 'flex';

    incomeTb.style.display = 'none';
    tb.style.display = 'block';
})


/* 달력 default 월 */
const month = new Date().toISOString().slice(5, 7);

// console.log(month)


