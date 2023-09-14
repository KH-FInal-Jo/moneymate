// 수입 차트
const incomeDiv = document.querySelector(".chart-div2")
// 지출 차트
const spendDiv = document.querySelector(".chart-div")

// 현재 날짜 구하는 변수
let today = new Date();
// 현재 월
let nowMonth = today.getMonth()+1
// 현재 월 넣어주기
document.getElementById("date-month").innerHTML = nowMonth + "월";







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



                        

/* 지출 */
// let pieChartData = {
// labels: ['식비', '교통비', '주거비', '관리비', '유흥', '생필품'],
// datasets: [{
//     data: [10, 20, 50, 5, 10, 5],
//     backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)']
// }] 
// };







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
// 변경하기 버튼
const changeBtn = document.getElementById("month-btn")

/* 설정되어있는 월 */
const dateMonth = document.getElementById("date-month")

/* 1-12월 */
const lineMonth = document.querySelectorAll(".line-month")


// 현재 페이지의 URL 가져오기
var currentURL = window.location.href;

// URL에서 "1" 추출하기
var parts = currentURL.split('/');
var accountNo = parts.pop(); // URL을 '/' 문자로 나누고 가장 마지막 요소를 가져옴


// 캘린더 클릭 시 월 변경 페이지 보이게
cal.addEventListener("click", () => {
  changePage.style.display = 'block';
});


// 클릭 시 이벤트 발생
for (let i = 0; i < lineMonth.length; i++) {
    lineMonth[i].addEventListener("click", e => {
      const month = e.currentTarget.firstElementChild.innerText;
      changePage.style.display = 'none';
      dateMonth.innerText = month + "월";
  
      // 이벤트 핸들러 밖에서 fetch 호출
    });
  }


// changeBtn 클릭 이벤트 핸들러
changeBtn.addEventListener("click", () => {
    const month = dateMonth.innerText.replace("월", "");
    handleFetch(month);
    handleFetchView(month);
    handleFetchChart(month);
});

// 월 지출 합계 금액 fetch 함수
function handleFetch(month) {
    console.log("월:", month);
    console.log("가계부 번호:", accountNo);
  
    fetch(`/account/changeMonth?month=${month}&accountNo=${accountNo}`)
      .then(resp => resp.json())
      .then(data => {
        const spend = document.getElementById("spend");
        if (data !== '') {
          console.log("응답 데이터 금액:", data);
          spend.innerHTML = "지출 : " + data + "원";
        } else {
          spend.innerText = "내역 없음";
        }
      })
      .catch(err => {
        console.log("예외 발생");
        console.log(err);
        const spend = document.getElementById("spend");
        spend.innerText = "내역 없음";
      });
  }



// 월 지출 내역 조회 fetch함수
function handleFetchView(month) {
    console.log("월:", month);
    console.log("가계부 번호:", accountNo);
  
    fetch(`/account/changeMonthUpdate?month=${month}&accountNo=${accountNo}`)
      .then(resp => resp.json())
      .then(aList => {
        const spendArea = document.querySelector(".spend-area")
        spendArea.innerText = ""
        if(aList != ''){


            console.log("응답 데이터 지출 내역: ", aList);

            

            /* 지출 내역 영역 */
            // 여기서 data를 사용하여 필요한 처리를 수행하세요.
            for(let account of aList){
                
                

                const spendLine = document.createElement("div")
                spendLine.classList.add("spend-line")

                const spendLeft = document.createElement("div")
                spendLeft.classList.add("spend-left")

                const div1 = document.createElement("div")
                const div2 = document.createElement("div")
                const div3 = document.createElement("div")
                
                div1.innerText = account.accountDate
                div2.innerText = account.accountContent
                div3.innerText = account.category

                spendLeft.append(div1, div2, div3)

                const moneyDiv = document.createElement("div")
                moneyDiv.innerText = "-" + account.accountMoney + "원"


                spendLine.append(spendLeft, moneyDiv)

                const hr = document.createElement("hr")



                spendArea.append(spendLine, hr)

            }





        }
      })
      .catch(err => {
        console.log("예외 발생");
        console.log(err);

      });
}




// 월 지출 금액 차트호출 fetch 함수
function handleFetchChart(month) {
    console.log("월:", month);
    console.log("가계부 번호:", accountNo);
  
       fetch(`/account/changeChart?month=${month}&accountNo=${accountNo}`)
      .then(resp => resp.json())
      .then(cList => {
        const pieChartCanvas = document.getElementById('pieChartCanvas');
        const ctx = pieChartCanvas.getContext('2d');

        // 이전 차트 제거
        if (window.pieChart) {
            window.pieChart.destroy();
        }


        if(cList == ''){

            console.log("숨김")

            return;

        }
        if(cList != ''){
            console.log("응답 데이터있음: ", cList);

            let pieChartData = {
              labels: [],
              datasets: [{
                  data: [],
                  backgroundColor: ['rgb(216, 63, 50)', 'rgb(248, 207, 18)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)']
              }] 

            };

            /* 지출 */

            for(let chart of cList){
                console.log(chart.category)
                console.log(chart.percent)

                pieChartData.labels.push(chart.category);
                pieChartData.datasets[0].data.push(chart.percent);

            }
            // 새로운 차트 생성
            window.pieChart = new Chart(ctx, {
                type: 'pie',
                data: pieChartData,
                options: {
                    responsive: false
                }
            });
        }
    })
    .catch(err => {
        console.log("예외 발생");
        console.log(err);
    });
}







