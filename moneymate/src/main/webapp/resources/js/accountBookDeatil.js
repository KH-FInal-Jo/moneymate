// 수입 차트
const incomeDiv = document.querySelector(".chart-div2")
// 지출 차트
const spendDiv = document.querySelector(".chart-div")
// 수입내역 테이블
const incomeTb = document.querySelector(".income-tb")
// 지출내역 테이블
const tb = document.querySelector(".tb")


/* default 월 설정(현재월) */

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


window.onload = function () {
    pieChartDraw();
    pieChartDraw2();
    
    /* 수입 차트 처음엔 안보임 */
    incomeDiv.style.display = 'none';
}






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

/* 월 변경 페이지 */
const changePage = document.querySelector(".change-area")

/* 캘린더 눌렀을때 */
const cal = document.querySelector(".fa-calendar")
cal.addEventListener("click", ()=>{

    changePage.style.display = 'block'

})

const changeBtn = document.getElementById("month-btn")

/* 설정되어있는 월 */
const dateMonth = document.getElementById("date-month")

/* 1-12월 */
const lineMonth = document.querySelectorAll(".line-month")

/* 클릭 시 이벤트 발생 */
for(let i=0; i<lineMonth.length; i++){
    lineMonth[i].addEventListener("click", e=>{
        console.log(e.currentTarget.firstElementChild.innerText)

        const month = e.currentTarget.firstElementChild.innerText;

        changePage.style.display = 'none'
        dateMonth.innerText = ""
        dateMonth.innerText = month + "월"

        changeBtn.addEventListener("click", () => {
            console.log(month);
            // ajax 코드 작성
            fetch(`/account/changeMonth?month=${month}`)
                .then(resp => resp.json()) // JSON 응답 파싱
                .then(data => {
                    console.log("응답 데이터: ", data);
                    // 여기서 data를 사용하여 필요한 처리를 수행하세요.

                    const spend = document.getElementById("spend")

                    


                    spend.innerText = ""
                    spend.innerText = "지출 : " + data + "원"




                })
                .catch(err => {
                    console.log("예외 발생");
                    console.log(err);

                    spend.innerText = ""
                    spend.innerText = "내역 없음"
                });
        });

    })

}



/* 지출,수입 내역 업데이트 */

for(let i=0; i<lineMonth.length; i++){
    lineMonth[i].addEventListener("click", e=>{
    console.log(e.currentTarget.firstElementChild.innerText)

    const month = e.currentTarget.firstElementChild.innerText;
    
    

    changeBtn.addEventListener("click", () => {
        // ajax 코드 작성
        fetch(`/account/changeMonthUpdate?month=${month}`)
            .then(resp => resp.json()) // JSON 응답 파싱
            .then(aList => {
                console.log("응답 데이터: ", aList);
                const tb = document.querySelector(".tb")
                tb.innerHTML = ""
                // 여기서 data를 사용하여 필요한 처리를 수행하세요.
                for(let account of aList){
    
                    const tr = document.createElement("tr")
                    const td1 = document.createElement("td")
                    const td2 = document.createElement("td")

                    td1.classList.add("spend-date")
                    td1.innerHTML = account.accountDate;

                    td2.classList.add("price")
                    td1.innerHTML = account.accountMoney;



    
    
                }
    
    
                
    
            })
            .catch(err => {
                console.log("예외 발생");
                console.log(err);
    
                spend.innerText = ""
                spend.innerText = "내역 없음"
            });
    });


    })
}