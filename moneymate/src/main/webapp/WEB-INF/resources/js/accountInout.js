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

/* 프로그래스바 .. 하다가 실패 */
(function(){

  let num1 = accUsedMoney.innerHTML;
  num1 = Number(num1);

  console.log(num1);

  if(accTargetMoney != null){
  }




})();

