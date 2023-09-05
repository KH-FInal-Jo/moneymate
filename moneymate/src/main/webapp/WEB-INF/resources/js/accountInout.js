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

/* 목표 금액 input값 콤마 넣기 */
const a = 1000000000000;

const input = document.getElementsByClassName("accTargetInput")[0];

input.addEventListener('keyup', function(e) {

  let value = e.target.value;

  value = Number(value.replaceAll(',', ''));
  if(isNaN(value)) {
    input.value = "";

  }else {
    const formatValue = value.toLocaleString('ko-KR');
    input.value = formatValue;
  }
})

/* 목표예산 설정 유효성 검사 */
function accTargetInput2(){

  const regEx = /^[0-9,]+$/;

  if(accTargetInput.value == 0 || accTargetInput.value == ""){

    alert("입력 형식이 유효하지 않습니다.");

    accTargetInput.value = "";
    accTargetInput.focus();
    return;

  }

  if(regEx.test(accTargetInput.value)){

    alert("목표 예산이 설정되었습니다.");
    accTargetMoney.innerHTML = accTargetInput.value;
    accTargetInput.value = "";

    accTarget.style.display = 'none';
    faGear.style.color = '#b4adad';

  }

}

const accUsedMoney = document.getElementsByClassName("accUsedMoney")[0];
const accProgress = document.getElementsByClassName("accProgress")[0];
const accTargetBtn2 = document.getElementsByClassName("accTargetBtn2")[0];

/* 프로그래스바 .. */
accTargetBtn2.addEventListener("click", function(){
  
  
  let str1 = accTargetMoney.innerHTML;
  let str2 = accUsedMoney.innerHTML;
  let num1 = parseInt(str1.replace(/,/g, ''), 10);
  let num2 = parseInt(str2.replace(/,/g, ''), 10);
  
  let result = num2/num1*100;
  
  accProgress.value = result;

  console.log(num1);
  console.log(num2);
  console.log(result);
  
})

/* 카테고리 상세 박스 */
const categoryBox = document.getElementsByClassName("accBk-category-table")[0];
const categoryBtn = document.getElementsByClassName("categoryBtn")[0];
const accBkResult2 = document.getElementsByClassName("accBkResult2")[0];
const accBkResult3 = document.getElementsByClassName("accBkResult3")[0];
const accBkResult4 = document.getElementsByClassName("accBkResult4")[0];
const accBkResult5 = document.getElementsByClassName("accBkResult5")[0];

categoryBtn.addEventListener("click", function(){

  
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
      categoryBox.style.display = 'flex';
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

const inputCategoryName = document.getElementsByClassName("inputCategoryName")[0];

accBk1.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk1.innerHTML;
})
accBk2.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk2.innerHTML;
})
accBk3.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk3.innerHTML;
})
accBk4.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk4.innerHTML;
})
accBk5.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk5.innerHTML;
})
accBk6.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk6.innerHTML;
})
accBk7.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk7.innerHTML;
})
accBk8.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk8.innerHTML;
})
accBk9.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk9.innerHTML;
})
accBk10.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk10.innerHTML;
})
accBk11.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk11.innerHTML;
})
accBk12.addEventListener("click", function(){
  inputCategoryName.innerHTML = "";
  inputCategoryName.innerHTML = accBk12.innerHTML;
})




