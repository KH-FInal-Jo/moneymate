// 목표 예산 날짜 정하기

const startDateInput = document.getElementById('startDateInput');

const endDateInput = document.getElementById('endDateInput');

const startDate1 = document.getElementsByClassName("startDate")[0];
const endDate1 = document.getElementsByClassName("endDate")[0];

document.getElementById('accDateChange').addEventListener('click', function () {
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

    const startDate = new Date(document.querySelector('.startDate').textContent);
    const endDate = new Date(document.querySelector('.endDate').textContent);

    const startDate1 = startDate.toISOString().slice(0, 10);

    const data = {
        bigAccountNo: bigAccountNo,
        startDate: startDate1,
        endDate: endDate,
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

        document.querySelector('.accTargetMoney').innerHTML = targetMoney;
        document.querySelector('.startDate').innerHTML = startDate1;
        document.querySelector('.endDate').innerHTML = endDate.toISOString().slice(0, 10);


    })
    .catch(error => {
        console.error('오류 발생:', error);
        alert('목표 예산을 저장하는 동안 오류가 발생했습니다.');
    });
}

