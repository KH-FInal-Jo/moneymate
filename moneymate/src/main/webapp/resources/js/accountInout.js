/* 계산기 스타일 */

const calculator = document.querySelector('.calculator'); 
const buttons = calculator.querySelector('.calculator__buttons'); 
const operator = document.querySelector('.calculator__operator');
const display = document.querySelector('.calculator__display--for-advanced'); 

function calculate(n1, operator, n2) {
    let result = 0;
    if(operator === '+') {
      result = Number(n1) + Number(n2);
    }
    else if(operator === '-') {
       result = Number(n1) - Number(n2); 
    }
    else if(operator === '*') {
       result = Number(n1) * Number(n2); 
    }
    if(operator === '/') {
       result = Number(n1) / Number(n2); 
    }
    return String(result);
}

let firstNum = '';
let operatorForAdvanced = '';
let previousKey = '';
let previousNum = '';

buttons.addEventListener('click', function (event) {
    const target = event.target; 
    const action = target.classList[0]; 
    const buttonContent = target.textContent; 

    if (target.matches('button')) {
      if (action === 'number') { 
        if (display.textContent === '0' && operatorForAdvanced === '') {
          display.textContent = buttonContent;
          firstNum = display.textContent 
        }
        else if (display.textContent !== '0' && operatorForAdvanced === ''){
          display.textContent = display.textContent + buttonContent;

          firstNum = display.textContent ;
        } 
        else if (display.textContent !== '0' && operatorForAdvanced !== '') {
          if(previousKey === operatorForAdvanced) {
            display.textContent = buttonContent;
            previousKey = display.textContent; 
            
            previousNum = display.textContent; 
          } 
          else if(previousKey !== operatorForAdvanced) {
            display.textContent = display.textContent + buttonContent;
            previousNum = display.textContent;
          }
        }    
      }

      if (action === 'operator') { 
        operatorForAdvanced = buttonContent; 
        previousKey = operatorForAdvanced;
      }
      if (action === 'clear') { 
        display.textContent = '0';
        firstNum = '';
        previousNum = '';
        operatorForAdvanced = '';
        previousKey = '';
      }
      if (action === 'calculate') { 
        if(firstNum !== '' && operatorForAdvanced === '') {
          display.textContent = firstNum;
        }
        else if(firstNum !== '' && previousNum === '') {
          display.textContent = calculate(display.textContent, operatorForAdvanced, display.textContent)
        }
        else if(previousKey === display.textContent){
          display.textContent = calculate(firstNum, operatorForAdvanced, previousNum)
         } 
         else if(previousKey !== display.textContent && previousNum !== '') {
          display.textContent = calculate(display.textContent, operatorForAdvanced, previousNum)
         }   
         else if(previousKey !== display.textContent && previousNum === '') {
          display.textContent = firstNum;
         }
       }
     }
  });


/* 목표 예산 설정하기 스타일을 위한 변수 */
const accTargetBtn = document.getElementsByClassName("accTargetBtn")[0];
const accTarget = document.getElementsByClassName("accTarget")[0];
const accTargetContainer = document.getElementsByClassName("accTarget-container")[0];
const faGear = document.getElementsByClassName("fa-gear")[0];

/* 목표 예산 설정을 위해 가져와야할 변수 */
const accTargetMoney = document.getElementsByClassName("accTargetMoney")[0];
const accTargetInput = document.getElementsByClassName("accTargetInput")[0];
const accTargetBtn2 = document.getElementsByClassName("accTargetBtn2")[0];

accTargetBtn.addEventListener("click", function(){
    if(accTarget.style.display !== 'none'){
        accTarget.style.display = 'none';
        accTarget.style.border = '4px solid #ddd';
        faGear.style.color = '#b4adad';
      }else{
        accTarget.style.display = 'block';
        accTarget.style.border = '4px solid skyblue';
        accTarget.style.borderRadius = '10px';
        faGear.style.color = 'skyblue';

    }

})

accTargetBtn2.addEventListener("click", function(){

  accTarget.style.display = 'none';
})



/* 사용금액 콤마 넣기 */
document.addEventListener("DOMContentLoaded", function() {

  (function() {

    const input = document.querySelector(".accUsedMoney");
    const input2 = document.querySelector(".accTargetMoney");
    var useMoney = input.innerHTML;
    var useMoney2 = input2.innerHTML;
    var formattedMoney = parseInt(useMoney).toLocaleString('ko-KR');
    var formattedMoney2 = parseInt(useMoney2).toLocaleString('ko-KR');
    input.innerHTML = formattedMoney;
    input2.innerHTML = formattedMoney2;



  })();

});

/* 수입, 지출, 이체 버튼 */
const out = document.getElementsByClassName("out")[0];
const inin = document.getElementsByClassName("in")[0];
const trans = document.getElementsByClassName("trans")[0];
const inoutResult = document.getElementsByClassName("inoutResult")[0];




const accUsedMoney = document.getElementsByClassName("accUsedMoney")[0];
const accProgress = document.getElementsByClassName("accProgress")[0];


/* 카테고리 상세 박스 */
const categoryBox = document.getElementsByClassName("accBk-category-table")[0];
const categoryBtn = document.getElementsByClassName("categoryBtn")[0];
const accBkResult2 = document.getElementsByClassName("accBkResult2")[0];
const accBkResult3 = document.getElementsByClassName("accBkResult3")[0];
const accBkResult4 = document.getElementsByClassName("accBkResult4")[0];
const accBkResult5 = document.getElementsByClassName("accBkResult5")[0];



const inputCategoryName = document.getElementsByClassName("inputCategoryName")[0];

const inoutResult2 = document.getElementsByClassName("inoutResult")[0];

/* 수입상세 박스 */
const categoryBox2 = document.getElementsByClassName("accBk-category-table2")[0];

const cate1 = document.getElementById("cate1");
const cate2 = document.getElementById("cate2");
const cate3 = document.getElementById("cate3");
const cate4 = document.getElementById("cate4");
const cate5 = document.getElementById("cate5");




categoryBtn.addEventListener("click", function(){

  if(inoutResult2.value == '수입'){
    cate1.style.display = 'none';
    cate2.style.display = 'none';
    cate3.style.display = 'none';
    cate4.style.display = 'block';
    cate5.style.display = 'block';

  }else{

    cate1.style.display = 'block';
    cate2.style.display = 'block';
    cate3.style.display = 'block';
    cate4.style.display = 'none';
    cate5.style.display = 'none';
  }


  if(categoryBox.style.display !== 'none'){
    categoryBox.style.display = 'none';
    accBkResult2.style.display = 'block';
    accBkResult2.style.display = 'flex';
    accBkResult3.style.display = 'block';
    accBkResult3.style.display = 'flex';
    accBkResult4.style.display = 'block';
    accBkResult4.style.display = 'flex';
    accBkResult5.style.display = 'block';
    accBkResult5.style.display = 'flex';
  }else{
    categoryBox.style.display = 'block';
    categoryBox.style.height = '300px';
    
    accBkResult2.style.display = 'none';
    accBkResult3.style.display = 'none';
    accBkResult4.style.display = 'none';
    accBkResult5.style.display = 'none';
    
  }
  

  
  
  

})

/* 카테고리 상세 내용 클릭시 이벤트  */
const accBk1 = document.getElementsByClassName("accBk1")[0];
const accBk2 = document.getElementsByClassName("accBk2")[0];
const accBk3 = document.getElementsByClassName("accBk3")[0];
const accBk4 = document.getElementsByClassName("accBk4")[0];
const accBk5 = document.getElementsByClassName("accBk5")[0];
const accBk6 = document.getElementsByClassName("accBk6")[0];
const accBk7 = document.getElementsByClassName("accBk7")[0];
const accBk8 = document.getElementsByClassName("accBk8")[0];
const accBk9 = document.getElementsByClassName("accBk9")[0];
const accBk10 = document.getElementsByClassName("accBk10")[0];
const accBk11 = document.getElementsByClassName("accBk11")[0];
const accBk12 = document.getElementsByClassName("accBk12")[0];


const accBk13 = document.getElementsByClassName("accBk2-1")[0];
const accBk14 = document.getElementsByClassName("accBk2-2")[0];
const accBk15 = document.getElementsByClassName("accBk2-3")[0];
const accBk16 = document.getElementsByClassName("accBk2-4")[0];
const accBk17 = document.getElementsByClassName("accBk2-5")[0];
const accBk18 = document.getElementsByClassName("accBk2-6")[0];






accBk1.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk1.value;
})
accBk2.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk2.value;
})
accBk3.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk3.value;
})
accBk4.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk4.value;
})
accBk5.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk5.value;
})
accBk6.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk6.value;
})
accBk7.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk7.value;
})
accBk8.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk8.value;
})
accBk9.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk9.value;
})
accBk10.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk10.value;
})
accBk11.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk11.value;
})
accBk12.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk12.value;
})




/* 수입 버튼 */
accBk13.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk13.value;
})

accBk14.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk14.value;
})

accBk15.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk15.value;
})

accBk16.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk16.value;
})

accBk17.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk17.value;
})

accBk18.addEventListener("click", function(){
  inputCategoryName.value = "";
  inputCategoryName.value = accBk18.value;
})















/* 기간 설정 */
const accDateRecordBtn = document.getElementsByClassName("accDateRecordBtn")[0];
const accDateRecord = document.getElementsByClassName("accDateRecord")[0];
const accDateCh = document.getElementById("accDateChange");


accDateRecordBtn.addEventListener("click", function(){

  
  if(accDateRecord.style.display !== 'none'){
      accDateRecord.style.display = 'none';
    }else{
      accDateRecord.style.display = 'block';
  
    }

})

accDateCh.addEventListener("click", function(){

  accDateRecord.style.display = 'none';
})




out.addEventListener("click",  function(){
  inoutResult.value="";
  inoutResult.value = out.value;

  out.style.color = "blue"; 
  inin.style.color = "white"; 
  trans.style.color = "white"; 

})
inin.addEventListener("click",  function(){
  inoutResult.value="";
  inoutResult.value = inin.value;

  inin.style.color = "blue"; 
  out.style.color = "white"; 
  trans.style.color = "white";

})
trans.addEventListener("click",  function(){
  inoutResult.value="";
  inoutResult.value = trans.value;

  trans.style.color = "blue"; 
  out.style.color = "white"; 
  inin.style.color = "white";
  
})

/* 현재 날짜 얻어오기 */

function getCurrentDate() {
  const now = new Date();
  const year = now.getFullYear();
  const month = String(now.getMonth() + 1).padStart(2, '0');
  const day = String(now.getDate()).padStart(2, '0'); 
  return `${year}-${month}-${day}`;
}

document.getElementById('startDateInput').setAttribute('min', getCurrentDate());







