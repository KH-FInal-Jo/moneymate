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









// 수입 내역 영역
const incomeArea = document.querySelector(".income-area")
// 지출 내역 영역
const spendArea = document.querySelector(".spend-area")


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

    spendArea.style.display = 'none'
    incomeArea.style.display = 'block'

     // 전체보기 버튼 나타나기
     const allViewBtn = document.getElementById("allView-btn")

      allViewBtn.addEventListener("click", ()=>{

       allViewBtn.style.display = 'none'
     })


})

/* 지출 눌렀을 때 */
spendBtn.addEventListener("click", ()=>{
    spendBtn.style.backgroundColor = '#31c770'
    incomeBtn.style.backgroundColor = '#ccc'

    incomeDiv.style.display = 'none';
    spendDiv.style.display = 'flex';

    spendArea.style.display = 'block'
    incomeArea.style.display = 'none'

    // 전체보기 버튼 나타나기
    const allViewBtn = document.getElementById("allView-btn")
    allViewBtn.style.display = 'none'

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
    handleFetchIncome(month);

    handleFetchView(month);
    handleFetchViewIncome(month);

    handleFetchChart(month);
    handleFetchChartIncome(month);
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

          // DB에서 얻어온 지출 합계 금액 콤파 표기법으로 변환
          var formattedMoney = parseInt(data).toLocaleString('ko-KR');

          spend.innerHTML = "지출 : " + formattedMoney + "원";




      } 
      
    })
      .catch(err => {
        console.log("예외 발생");
        console.log(err);
        const spend = document.getElementById("spend");
        spend.innerText = "내역 없음";

        
        const incomebtn = document.getElementById("income");
        if(incomebtn.innerText == '내역 없음' && spend.innerText == '내역 없음'){
          alert("해당 월에 지출,수입 내역이 존재하지 않습니다.")
          return;
        }
        if(spend.innerText == '내역 없음'){
          alert("해당 월에 지출 내역이 존재하지 않습니다.")

        }

        

        

      });
  }



// 월 수입 합계 금액 fetch 함수
function handleFetchIncome(month) {
    console.log("월:", month);
    console.log("가계부 번호:", accountNo);
  
    fetch(`/account/changeMonthIncome?month=${month}&accountNo=${accountNo}`)
      .then(resp => resp.json())
      .then(income => {

        const incomebtn = document.getElementById("income");

        if (income !== '') {

          // DB에서 얻어온 지출 합계 금액 콤파 표기법으로 변환
          var formattedMoney = parseInt(income).toLocaleString('ko-KR');

          incomebtn.innerHTML = "수입 : " + formattedMoney + "원";

        }
      })
      .catch(err => {
        console.log("예외 발생");
        console.log(err);
        const incomebtn = document.getElementById("income");
        incomebtn.innerText = "내역 없음";

        const spend = document.getElementById("spend");

        if(spend.innerText !== '내역 없음' && incomebtn.innerText == '내역 없음'){
          alert("해당 월에 수입 내역이 존재하지 않습니다.")

        }

      });
  }



// 월 지출 내역 조회 fetch함수
function handleFetchView(month) {
    console.log("월:", month);
    console.log("가계부 번호:", accountNo);

    //전체보기 버튼 나타나기
    const allViewBtn = document.getElementById("allView-btn")
    allViewBtn.style.display = 'none'
  
    fetch(`/account/changeMonthUpdate?month=${month}&accountNo=${accountNo}`)
      .then(resp => resp.json())
      .then(aList => {
        const spendArea = document.querySelector(".spend-area")
        spendArea.innerText = ""
        if(aList != ''){



            

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

                // DB에서 얻어온 지출 합계 금액 콤파 표기법으로 변환
                var spendMoney = parseInt(account.accountMoney).toLocaleString('ko-KR');
                const moneyDiv = document.createElement("div")
                moneyDiv.innerText = "-" + spendMoney + "원"


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



// 월 수입 내역 조회 fetch함수
function handleFetchViewIncome(month) {
    //전체보기 버튼 나타나기
    const allViewBtn = document.getElementById("allView-btn")
    allViewBtn.style.display = 'none'

    console.log("월:", month);
    console.log("가계부 번호:", accountNo);
  
    fetch(`/account/changeMonthUpdateIncome?month=${month}&accountNo=${accountNo}`)
      .then(resp => resp.json())
      .then(aListIncome => {
        const incomeArea = document.querySelector(".income-area")
        incomeArea.innerText = ""
        if(aListIncome != ''){



            

            /* 지출 내역 영역 */
            // 여기서 data를 사용하여 필요한 처리를 수행하세요.
            for(let account of aListIncome){
                
                

                const incomeLine = document.createElement("div")
                incomeLine.classList.add("income-line")

                const incomeLeft = document.createElement("div")
                incomeLeft.classList.add("income-left")

                const div1 = document.createElement("div")
                const div2 = document.createElement("div")
                const div3 = document.createElement("div")
                
                div1.innerText = account.accountDate
                div2.innerText = account.accountContent
                div3.innerText = account.category

                incomeLeft.append(div1, div2, div3)

                // DB에서 얻어온 지출 합계 금액 콤파 표기법으로 변환
                var incomeMoney = parseInt(account.accountMoney).toLocaleString('ko-KR');
                const moneyDiv = document.createElement("div")
                moneyDiv.innerText = "+" + incomeMoney + "원"


                incomeLine.append(incomeLeft, moneyDiv)

                const hr = document.createElement("hr")



                incomeArea.append(incomeLine, hr)

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
            const categoryArea = document.querySelector(".category-area")
            categoryArea.style.display = 'none'
            return;
            



        }
        if(cList != ''){

            // 차트 데이터 영역
            let pieChartData = {
              labels: [],
              datasets: [{
                  data: [],
                  backgroundColor: ['rgb(216, 63, 50)', 'rgb(248, 207, 18)', 'rgb(192, 192, 192)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)', 'rgb(233, 171, 182)', 'rgb(104, 216, 225)','rgb(76, 76, 76)', 'rgb(226, 97, 113)', 'rgb(85, 116, 187)', 'rgb(104, 200, 121)']
              }] 

            };


            /* 지출 */
            const categoryArea = document.querySelector(".category-area")
            categoryArea.style.display = 'flex'
            categoryArea.innerHTML = ''
            for(let chart of cList){

                pieChartData.labels.push(chart.category);
                pieChartData.datasets[0].data.push(chart.percent);

                const categoryPercent = document.createElement("div")
                categoryPercent.classList.add("category-percent")

                const span1 = document.createElement("span")
                const span2 = document.createElement("span")
                const span3 = document.createElement("span")
                const span4 = document.createElement("span")
                const span5 = document.createElement("span")
                span1.classList.add("round")
                span2.classList.add("categoryName")
                span3.classList.add("equal")
                span4.classList.add("percentNo")
                span5.classList.add("sumMoney")

             


                // 카테고리별 차트 색상 설정
                if(chart.category == pieChartData.labels[0]){
                  span1.style.backgroundColor = 'rgb(216, 63, 50)'
                
                }else if(chart.category == pieChartData.labels[1]){
                  span1.style.backgroundColor = 'rgb(248, 207, 18)'
                }else if(chart.category == pieChartData.labels[2]){
                  span1.style.backgroundColor = 'rgb(192, 192, 192)'
                }
                else if(chart.category == pieChartData.labels[3]){
                  span1.style.backgroundColor = 'rgb(75, 192, 192)'
                }
                else if(chart.category == pieChartData.labels[4]){
                  span1.style.backgroundColor = 'rgb(54, 162, 235)'
                }
                else if(chart.category == pieChartData.labels[5]){
                  span1.style.backgroundColor = 'rgb(153, 102, 255)'
                }
                else if(chart.category == pieChartData.labels[6]){
                  span1.style.backgroundColor = 'rgb(233, 171, 182)'
                }
                else if(chart.category == pieChartData.labels[7]){
                  span1.style.backgroundColor = 'rgb(104, 216, 225)'
                }
                else if(chart.category == pieChartData.labels[8]){
                  span1.style.backgroundColor = 'rgb(76, 76, 76)'
                }
                else if(chart.category == pieChartData.labels[9]){
                  span1.style.backgroundColor = 'rgb(226, 97, 113)'
                }
                else if(chart.category == pieChartData.labels[10]){
                  span1.style.backgroundColor = 'rgb(85, 116, 187)'
                }
                else if(chart.category == pieChartData.labels[11]){
                  span1.style.backgroundColor = 'rgb(104, 200, 121)'
                }

                span2.innerHTML = chart.category
                span3.innerHTML = ":"
                span4.innerHTML = chart.percent + "%"
                // DB에서 얻어온 지출 합계 금액 콤파 표기법으로 변환
                var sumMoney = parseInt(chart.sumMoney).toLocaleString('ko-KR');
                span5.innerText = "(" + sumMoney + "원)"

                // 카테고리명 누르면 그 항목에 관한 내역 보기
                span2.addEventListener("click", e=>{
                  // 전체보기 버튼 나타나기
                  const allViewBtn = document.getElementById("allView-btn")
                  allViewBtn.style.display = 'block'

                  // 전체보기 버튼 클릭시 이벤트
                  allViewBtn.addEventListener("click", ()=>{
                    // 지출내역 조회 함수 호출
                    handleFetchView(month)

                    // 다시 가리기
                    allViewBtn.style.display = 'none'

                  })

                  const incomebtn = document.getElementById("income");
                  incomebtn.addEventListener("click", ()=>{
                    allViewBtn.style.display = 'none'

                    handleFetchView(month)

                  })

                  // console.log("클릭ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ")
                  console.log(e.target.innerText)
                  const name = e.target.innerText;

                  fetch(`/account/categoryName?month=${month}&accountNo=${accountNo}&name=${name}`)
                  .then(resp => resp.json())
                  .then(nameList => {

                    if(nameList != ''){

                      const spendArea = document.querySelector(".spend-area")
                      spendArea.innerText = ""

                      for(let name of nameList){
                        console.log(name)
  
  
                            /* 지출 내역 영역 */
                            // 여기서 data를 사용하여 필요한 처리를 수행하세요.
                              const spendLine = document.createElement("div")
                              spendLine.classList.add("spend-line")
  
                              const spendLeft = document.createElement("div")
                              spendLeft.classList.add("spend-left")
  
                              const div1 = document.createElement("div")
                              const div2 = document.createElement("div")
                              const div3 = document.createElement("div")
                              
                              div1.innerText = name.accountDate
                              div2.innerText = name.accountContent
                              div3.innerText = name.category
  
                              spendLeft.append(div1, div2, div3)
  
                              // DB에서 얻어온 지출 합계 금액 콤파 표기법으로 변환
                              var spendMoney = parseInt(name.accountMoney).toLocaleString('ko-KR');
                              const moneyDiv = document.createElement("div")
                              moneyDiv.innerText = "-" + spendMoney + "원"
  
  
                              spendLine.append(spendLeft, moneyDiv)
  
                              const hr = document.createElement("hr")
  
                              spendArea.append(spendLine, hr)
  
  
                      }


                    }




                  })
                  .catch(e=> {
                    console.log(e)
                    console.log("예외발생")
                  })

                })

                categoryPercent.append(span1, span2, span3, span4, span5)


                categoryArea.append(categoryPercent)




            }
            // 새로운 차트 생성
            window.pieChart = new Chart(ctx, {
                type: 'pie',
                data: pieChartData,
                options:{
                  responsive: false,
                 
                  legend: {
                      display: false
                  }
              
              }
            });
           
        }
    })
    .catch(err => {
        console.log("예외 발생");
        console.log(err);

    });
}




// 월 수입 금액 차트호출 fetch 함수
function handleFetchChartIncome(month) {
    console.log("월:", month);
    console.log("가계부 번호:", accountNo);
  
       fetch(`/account/changeChartIncome?month=${month}&accountNo=${accountNo}`)
      .then(resp => resp.json())
      .then(cList => {
        const pieChartCanvas2 = document.getElementById('pieChartCanvas2');
        const ctx = pieChartCanvas2.getContext('2d');

        // 이전 차트 제거
        if (window.pieChart2) {
            window.pieChart2.destroy();
        }


        if(cList == ''){

            console.log("숨김")
            const IcategoryArea = document.querySelector(".Icategory-area")
            IcategoryArea.style.display = 'none'
            return;

        }
        if(cList != ''){
            console.log("응답 데이터있음: ", cList);

            // 차트 데이터 영역
            let pieChartData2 = {
              labels: [],
              datasets: [{
                  data: [],
                  backgroundColor: ['rgb(216, 63, 50)', 'rgb(248, 207, 18)', 'rgb(192, 192, 192)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)', 'rgb(233, 171, 182)', 'rgb(104, 216, 225)','rgb(76, 76, 76)', 'rgb(226, 97, 113)', 'rgb(85, 116, 187)', 'rgb(104, 200, 121)']
              }] 

            };


            /* 수입 */
            const IcategoryArea = document.querySelector(".Icategory-area")
            IcategoryArea.style.display = 'flex'
            IcategoryArea.innerHTML = ''
            for(let chart of cList){
                console.log(chart.category)
                console.log(chart.percent)

                pieChartData2.labels.push(chart.category);
                pieChartData2.datasets[0].data.push(chart.percent);

                const categoryPercent = document.createElement("div")
                categoryPercent.classList.add("categoryIncome-percent")

                const span1 = document.createElement("span")
                const span2 = document.createElement("categoryName")
                const span3 = document.createElement("equal")
                const span4 = document.createElement("percentNo")
                const span5 = document.createElement("span")
                span1.classList.add("Iround")
                span2.classList.add("IcategoryName")
                span3.classList.add("Iequal")
                span4.classList.add("IpercentNo")
                span5.classList.add("sumMoney")

                  // 카테고리별 차트 색상 설정
                  if(chart.category == pieChartData2.labels[0]){
                    span1.style.backgroundColor = 'rgb(216, 63, 50)'
                  
                  }else if(chart.category == pieChartData2.labels[1]){
                    span1.style.backgroundColor = 'rgb(248, 207, 18)'
                  }else if(chart.category == pieChartData2.labels[2]){
                    span1.style.backgroundColor = 'rgb(192, 192, 192)'
                  }
                  else if(chart.category == pieChartData2.labels[3]){
                    span1.style.backgroundColor = 'rgb(75, 192, 192)'
                  }
                  else if(chart.category == pieChartData2.labels[4]){
                    span1.style.backgroundColor = 'rgb(54, 162, 235)'
                  }
                  else if(chart.category == pieChartData2.labels[5]){
                    span1.style.backgroundColor = 'rgb(153, 102, 255)'
                  }
                  else if(chart.category == pieChartData2.labels[6]){
                    span1.style.backgroundColor = 'rgb(233, 171, 182)'
                  }
                  else if(chart.category == pieChartData2.labels[7]){
                    span1.style.backgroundColor = 'rgb(104, 216, 225)'
                  }
                  else if(chart.category == pieChartData2.labels[8]){
                    span1.style.backgroundColor = 'rgb(76, 76, 76)'
                  }
                  else if(chart.category == pieChartData2.labels[9]){
                    span1.style.backgroundColor = 'rgb(226, 97, 113)'
                  }
                  else if(chart.category == pieChartData2.labels[10]){
                    span1.style.backgroundColor = 'rgb(85, 116, 187)'
                  }
                  else if(chart.category == pieChartData2.labels[11]){
                    span1.style.backgroundColor = 'rgb(104, 200, 121)'
                  }

                span2.innerHTML = chart.category
                span3.innerHTML = ":"
                span4.innerHTML = chart.percent + "%"
                var sumMoney = parseInt(chart.sumMoney).toLocaleString('ko-KR');
                span5.innerText = "(" + sumMoney + "원)"

                // 카테고리명 누르면 그 항목에 관한 내역 보기
                span2.addEventListener("click", e=>{
                  // console.log("클릭ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ")

                   // 전체보기 버튼 나타나기
                   const allViewBtn = document.getElementById("allView-btn")
                   allViewBtn.style.display = 'block'
 
                   // 전체보기 버튼 클릭시 이벤트
                   allViewBtn.addEventListener("click", ()=>{
                     // 지출내역 조회 함수 호출
                     handleFetchViewIncome(month)
 
                     // 다시 가리기
                     allViewBtn.style.display = 'none'
 
                   })

                   const spend = document.getElementById("spend")
                   spend.addEventListener("click", ()=>{
                    allViewBtn.style.display = 'none'

                    handleFetchViewIncome(month)

                  })

                  console.log(e.target.innerText)
                  const name = e.target.innerText;

                  fetch(`/account/categoryNameIncome?month=${month}&accountNo=${accountNo}&name=${name}`)
                  .then(resp => resp.json())
                  .then(nameList => {

                    if(nameList != ''){

                      const incomeArea = document.querySelector(".income-area")
                      incomeArea.innerText = ""

                      for(let name of nameList){
                          console.log(name)
  
  
                          /* 수입 내역 영역 */
                          // 여기서 data를 사용하여 필요한 처리를 수행하세요.
                          const incomeLine = document.createElement("div")
                          incomeLine.classList.add("income-line")
          
                          const incomeLeft = document.createElement("div")
                          incomeLeft.classList.add("income-left")
          
                          const div1 = document.createElement("div")
                          const div2 = document.createElement("div")
                          const div3 = document.createElement("div")
                          
                          div1.innerText = name.accountDate
                          div2.innerText = name.accountContent
                          div3.innerText = name.category
          
                          incomeLeft.append(div1, div2, div3)
          
                          // DB에서 얻어온 지출 합계 금액 콤파 표기법으로 변환
                          var incomeMoney = parseInt(name.accountMoney).toLocaleString('ko-KR');
                          const moneyDiv = document.createElement("div")
                          moneyDiv.innerText = "+" + incomeMoney + "원"
          
          
                          incomeLine.append(incomeLeft, moneyDiv)
          
                          const hr = document.createElement("hr")
          
          
          
                          incomeArea.append(incomeLine, hr)
  
  
                      }


                    }




                  })
                  .catch(e=> {
                    console.log(e)
                    console.log("예외발생")
                  })

                })

                categoryPercent.append(span1, span2, span3, span4, span5)


                IcategoryArea.append(categoryPercent)




            }
            // 새로운 차트 생성
            window.pieChart2 = new Chart(ctx, {
                type: 'pie',
                data: pieChartData2,
                options:{
                  responsive: false,
                  maintainAspectRatio :false,
                  legend: {
                      display: false
                  }
              
              }
                });
           
        }
    })
    .catch(err => {
        console.log("예외 발생");
        console.log(err);
    });
}








