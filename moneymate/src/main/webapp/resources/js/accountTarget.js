// 목표 예산 날짜 정하기


document.getElementById('accDateChange').addEventListener('click', function () {
    const startDateInput = document.getElementById('startDateInput');
    
    const endDateInput = document.getElementById('endDateInput');
    
    const startDate1 = document.getElementsByClassName("startDate")[0];
    const endDate1 = document.getElementsByClassName("endDate")[0];
    const startDate = new Date(startDateInput.value);

    const endDate = new Date(startDate);
    endDate.setMonth(endDate.getMonth() + 1);

    const endDateString = endDate.toISOString().slice(0, 10);

    endDateInput.value = endDateString;

    startDate1.innerHTML = startDateInput.value;
    endDate1.innerHTML = endDateInput.value;
    
    
});

startDateInput.addEventListener('change', function () {

    
    const startDate = new Date(startDateInput.value);
    
    const endDate = new Date(startDate);
    endDate.setMonth(endDate.getMonth() + 1);
    
    const endDateString = endDate.toISOString().slice(0, 10);
    
    endDateInput.value = endDateString;


});


  

// 목표예산
function submitTarget() {
    const targetMoney = document.querySelector('.accTargetInput').value;

    const endDate = new Date(document.querySelector('.endDate').textContent);

    //const startDate1 = startDate.toISOString().slice(0, 10);

    const startDate = document.querySelector('.startDate').textContent;



    // Date 객체로 변환
    const date = new Date(startDate);
    const date2 = new Date(endDate);

    // 원하는 형식으로 날짜 문자열 생성
    const startDate1 = `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')}`;
    const endDate2 = `${date2.getFullYear()}-${(date2.getMonth() + 1).toString().padStart(2, '0')}-${date2.getDate().toString().padStart(2, '0')}`;

    const data = {
        bigAccountNo: bigAccountNo,
        startDate: startDate1,
        endDate: endDate2,
        targetMoney: targetMoney
    };

    fetch('/account/target', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(result => {
        console.log(result);
        alert('목표 예산이 저장되었습니다.');

        location.reload(true);

        document.querySelector('.accTargetMoney').innerHTML = "";
        document.querySelector('.accTargetMoney').innerHTML = targetMoney;
        document.querySelector('.startDate').innerHTML = "";
        document.querySelector('.startDate').innerHTML = startDate1;
        document.querySelector('.endDate').innerHTML = "";
        document.querySelector('.endDate').innerHTML = endDate.toISOString().slice(0, 10);

    })
    .catch(error => {
        console.error('오류 발생:', error);
        alert('목표 예산을 저장하는 동안 오류가 발생했습니다.');
    });
}

    function updateProgressBar() {
      // 여기에 프로그래스바 업데이트 로직을 추가
      let result = (useMoney / targetMoney) * 100;
  
      console.log(result);
  
      if (accProgress != null) {
        accProgress.value = result;
      }
    }
    
    // 0.01초(10밀리초) 간격으로 updateProgressBar 함수 호출
    const intervalId = setInterval(updateProgressBar, 100);
  
    window.addEventListener('unload', () => {
      clearInterval(intervalId);
    });
  
  





