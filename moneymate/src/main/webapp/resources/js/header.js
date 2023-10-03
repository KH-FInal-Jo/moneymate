/* 알람 페이지 영역 */
const alarmPage = document.getElementById("alarm-page")

/* 알람 종 */
const alarm = document.getElementById("alarm-btn")



/* 알람 숫자 */
let alarmNum = document.getElementById("alarm-number")

const alarmContent = document.getElementsByClassName("alarm-content")
// 알림 페이지


// 알림함 즉시실행 함수
if(member !== ''){
    console.log("로그인 함")

    fetch("/alert/alertNumber")
    .then(resp => resp.json())
    .then(result => {
        console.log(result)
        
        alarmNum.innerHTML = result.length;
        
        for(let i=0; i<result.length; i++){

            const div = document.createElement("div")
            div.classList.add("alarm-check")


            const a = document.createElement("a")
            a.setAttribute("href" , "/community/3/" + result[i].boardNo)

            const span = document.createElement("span")
            span.classList.add("alarm-content")

            span.innerHTML = '댓글 달림'

            a.append(span)
            div.append(a)
            alarmPage.append(div)


        }



    })
    .catch(e => {
        console.log(e)
        console.log("못가져옴 ㅅㄱ")
    })





}





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
