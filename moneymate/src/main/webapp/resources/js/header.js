/* 알람 페이지 영역 */
const alarmPage = document.getElementById("alarm-page")

/* 알람 종 */
const alarm = document.getElementById("alarm-btn")



/* 알람 숫자 */
let alarmNum = document.getElementById("alarm-number")



/* 모달(내용 뜨는 창) */
const modal = document.getElementById("modal")


// 알림함 즉시실행 함수
if(member !== ''){
    console.log("로그인 함")

    fetch("/alert/alertNumber")
    .then(resp => resp.json())
    .then(result => {
        console.log(result)
        
        alarmNum.innerHTML = result.length;
        
        for(let i=0; i<result.length; i++){

            const a = document.createElement("a")
            a.setAttribute("href" , "/community/3/" + result[i].boardNo)

            const div = document.createElement("div")
            div.classList.add("alarm-check")



            const img = document.createElement("img")
            img.classList.add("alarm-profile")
            if(result[i].profile == '이미지경로'){

                img.setAttribute("src", "/resources/images/id.png")
            } else {
                img.setAttribute("src", result[i].profile)
            }

            if(result[i].profile == ''){

                img.setAttribute("src", "/resources/images/id.png")
            }



            const content = document.createElement("div")



            const date = document.createElement("div")
            date.classList.add("alarm-date")


            console.log(result[i].alertTarget)

            if(result[i].alertTarget == 'O'){
                content.innerHTML = '목표 예산 달성을 축하드립니다~!'
                return;
            }

            
            content.innerHTML = result[i].memberNickname + '님이 게시글에 댓글을 달았습니다. "'  
            + result[i].content + '"'
            
            date.innerHTML = result[i].alarmDate
            
            div.append(img,content)
            a.append(div)
            modal.append(a,date)
            alarmPage.append(modal)

            /* 알림 내역 */
            const alarmContent = document.getElementsByClassName("alarm-check")

            /* 알림 내역 누르면 읽음으로 변경하기 */
            for(let i=0; i<alarmContent.length; i++){

                alarmContent[i].addEventListener("click", e=>{
                    console.log("읽음")

                    // 비동기로 서버로 보내고 update 실행하기
                    
                })

            }
            
            
        }



    })
    .catch(e => {
        console.log(e)
        console.log("못가져옴 ㅅㄱ")
    })





}







alarm.addEventListener("click", ()=>{
    alarmPage.style.display = 'flex'
    alarmPage.style.justifyContent = 'center'
    alarmPage.style.alignItems = 'center'
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
