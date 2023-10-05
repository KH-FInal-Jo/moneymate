/* 알람 페이지 영역 */
const alarmPage = document.getElementById("alarm-page")

/* 알람 종 */
const alarm = document.getElementById("alarm-btn")



/* 알람 숫자 */
let alarmNum = document.getElementById("alarm-number")

/* 알람 내역 컨테이너 */
const container = document.getElementById("content-container")


/* 모달(내용 뜨는 창) */
const modal = document.getElementById("modal")


// 알림함 즉시실행 함수
if(member !== ''){
    // 알람 갯수 조회 함수호출
    countAlarm()

    let alertSock;
    alertSock = new SockJS("/alertSock")

    alertSock.onmessage = e => {

        var alertList = JSON.parse(e.data);
        console.log(alertList.length);
        alarmNum.innerHTML = alertList.length;
        
        selectAlarm(alertList)

    }

    alarm.addEventListener("click", ()=>{

        fetch("/alert/alertNumber")
        .then(resp => resp.json())
        .then(result => {
            console.log(result)
            selectAlarm(result)
        })
    })

    // 알람 갯수 조회 비동기
    function countAlarm(){

        fetch("/alert/countAlarm")
        .then(resp => resp.json())
        .then(count =>{

            alarmNum.innerHTML = count;

        })
        .catch(e=>{
            console.log(e)
        })

    }



    console.log("로그인 함")

    function selectAlarm(result){


            
        container.innerHTML = ''
        
        for(let i=0; i<result.length; i++){
            
                const a = document.createElement("a")
                a.setAttribute("href" , "/alert/update?alertNo=" + result[i].alertNo + "&boardNo=" + result[i].boardNo)
    
                const div = document.createElement("div")
                div.classList.add("alarm-check")
    
    
    
                const img = document.createElement("img")
                img.classList.add("alarm-profile")
                if(result[i].profile == null){
    
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
                container.append(a, date)
                modal.append(container)
                alarmPage.append(modal)
    
                /* 알림 내역 */
                const alarmContent = document.getElementsByClassName("alarm-check")
    
                
                
            }
    
    

    }





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
// if(alarmArr.length == ""){
//     /* 알람없으면 숫자 안보이게 */
//     alarmNum.style.display = 'none'
    
// }else{
//     for(let i=0; i<alarmArr.length; i++){
//         alarmNum.innerHTML = i+1
    
//     }

// }

/* 알람 목록 누르면 없애기 */
for(let i=0; i<alarmArr.length; i++){

    alarmArr[i].addEventListener("click", e=>{
        alarmArr[i].remove()
    })
}
