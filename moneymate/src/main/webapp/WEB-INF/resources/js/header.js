/* 알람 페이지 영역 */
const alarmPage = document.getElementById("alarm-page")

/* 알람 종 */
const alarm = document.getElementById("alarm-btn")
/* 알람 숫자 */
let alarmNum = document.getElementById("alarm-number")

alarm.addEventListener("click", ()=>{
    alarmPage.style.display = 'flex'
})

/* 알림함 닫기버튼 */
const closeBtn = document.getElementById("close-btn")

closeBtn.addEventListener("click",()=>{

    alarmPage.style.display = 'none'    

})

/* 알람 목록 갯수 */
const alarmArr = document.querySelectorAll(".alarm-check")

/* 알람 숫자 증가 */
if(alarmArr.length == ""){
    /* 알람없으면 숫자 안보이게 */
    alarmNum.style.display = 'none'
    
}else{
    for(let i=0; i<alarmArr.length; i++){
        alarmNum.innerHTML = i+1
    
    }

}

/* 알람 목록 누르면 없애기 */
for(let i=0; i<alarmArr.length; i++){

    alarmArr[i].addEventListener("click", e=>{
        alarmArr[i].remove()
    })
}
