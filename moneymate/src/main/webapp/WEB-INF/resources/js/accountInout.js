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