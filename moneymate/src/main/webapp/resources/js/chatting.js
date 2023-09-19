const leftBarIcon1 = document.getElementsByClassName("leftBarIcon1")[0];
const leftBarIcon2 = document.getElementsByClassName("leftBarIcon2")[0];
const leftBarIcon3 = document.getElementsByClassName("leftBarIcon3")[0];
const leftBarIcon4 = document.getElementsByClassName("leftBarIcon4")[0];

let leftBar1 = document.getElementById("leftBar1");
let leftBar2 = document.getElementById("leftBar2");
let leftBar3 = document.getElementById("leftBar3");



leftBarIcon2.addEventListener("click", function(){

    leftBar1.style.display = 'block';
    leftBar2.style.display = 'none';
    leftBar3.style.display = 'none';
    leftBarIcon2.style.color = 'white';
    leftBarIcon3.style.color = 'black';
    leftBarIcon4.style.color = 'black';

})
leftBarIcon3.addEventListener("click", function(){

    leftBar2.style.display = 'block';
    leftBar1.style.display = 'none';
    leftBar3.style.display = 'none';
    leftBarIcon3.style.color = 'white';
    leftBarIcon2.style.color = 'black';
    leftBarIcon4.style.color = 'black';
})
leftBarIcon4.addEventListener("click", function(){

    leftBar3.style.display = 'block';
    leftBar2.style.display = 'none';
    leftBar1.style.display = 'none';
    leftBarIcon4.style.color = 'white';
    leftBarIcon3.style.color = 'black';
    leftBarIcon2.style.color = 'black';
})


let divdiv = document.querySelector(".wrap");

divdiv.scrollTop = divdiv.scrollHeight;




const addTarget = document.querySelector("#addTarget"); // 추가 버튼

const addTargetPopupLayer = document.querySelector("#addTargetPopupLayer"); // 팝업 레이어

const closeBtn = document.querySelector("#closeBtn"); // 닫기 버튼

const targetInput = document.querySelector("#targetInput"); // 사용자 검색

const resultArea = document.querySelector("#resultArea"); // 검색 결과



let selectChattingNo; // 선택한 채팅방 번호
let selectTargetNo; // 현재 채팅 대상
let selectTargetName; // 대상의 이름
let selectTargetProfile; // 대상의 프로필



// 사용자 검색(ajax)


// 검색 결과 클릭 시 처리
/* function selectResult(result) {
   const results = resultArea.querySelectorAll(".result-row");
   results.forEach(row => row.classList.remove("selected"));
   result.classList.add("selected");
} */

targetInput.addEventListener("input", e => {
   const query = e.target.value.trim();

   // 입력된게 없을 때
   if (query.length === 0) {
      resultArea.innerHTML = ""; // 이전 검색 결과 비우기
      return;
   }

   // 입력된게 있을 때
   if (query.length > 0) {
    fetch(`/chatting/selectTarget?query=${query}`)
       .then(resp => resp.json())
       .then(list => {
          console.log(list);
 
          // 검색 결과가 있는지 확인
          if (list.length === 0) {
             const li = document.createElement("li");
             li.classList.add("result-row");
             li.innerText = "일치하는 회원이 없습니다";
             resultArea.innerHTML = ""; // 이전 검색 결과 비우기
             resultArea.append(li);
          } else {
             resultArea.innerHTML = ""; // 이전 검색 결과 비우기
 
             for (let member of list) {
                // li요소 생성(한 행을 감싸는 요소)
                const li = document.createElement("li");
                li.classList.add("result-row");
                li.setAttribute("data-id", member.memberNo);
 
                // 프로필 이미지 요소
                const img = document.createElement("img");
                img.classList.add("result-row-img");
 
                // 프로필 이미지 여부에 따른 src 속성 선택
                if (member.profileImage == null) img.setAttribute("src", "/resources/images/user.png");
                else img.setAttribute("src", member.profileImage);
 
                let nickname = member.memberNickname;
                let email = member.memberEmail;
 
                const span = document.createElement("span");
                span.innerHTML = `${nickname} ${email}`.replace(query, `<mark>${query}</mark>`);
 
                // 요소 조립(화면에 추가)
                li.append(img, span);
                resultArea.append(li);
 
                // li요소에 클릭 시 채팅방에 입장하는 이벤트 추가
                li.addEventListener('click', () => {
                    chattingEnter(li);
                });
             }
          }
       })
       .catch(err => console.log(err));
 }
 
});

 


// 채팅방 입장 또는 선택 함수
function chattingEnter(element){

   const targetNo = element.getAttribute("data-id");

   fetch("/chatting/enter?targetNo="+targetNo)
   .then(resp => resp.text())
   .then(chattingNo => {
      console.log(chattingNo);
      
      selectRoomList(); // 채팅방 목록 조회
      
      setTimeout(()=>{ 
         // 만약 채팅방 목록 중 이미 존재하는 채팅방이 있으면 클릭해서 입장
         const itemList = document.querySelectorAll(".chatting-item")
         for(let item of itemList) {      
            if(item.getAttribute("chat-no") == chattingNo){
               item.focus();
               item.click();
               addTargetPopupLayer.classList.toggle("popup-layer-close");
               targetInput.value = "";
               resultArea.innerHTML = "";
               return;
            }
         }

      }, 200);

   })
   .catch(err => console.log(err));
}



// 비동기로 채팅방 목록 조회
function selectRoomList(){

   fetch("/chatting/roomList")
   .then(resp => resp.json())
   .then(roomList => {
      console.log(roomList);

      // 채팅방 목록 출력 영역 선택
      const chattingList = document.querySelector(".chatting-list");

      // 채팅방 목록 지우기
      chattingList.innerHTML = "";

      // 조회한 채팅방 목록을 화면에 추가
      for(let room of roomList){
         const li = document.createElement("li");
         li.classList.add("chatting-item");
         li.setAttribute("chat-no", room.chattingNo);
         li.setAttribute("target-no", room.targetNo);

         // 여기에 로그인 멤버 번호를 data-id 속성으로 설정
         li.setAttribute("data-id", loginMemberNo);

         if(room.chattingNo == selectChattingNo){
            li.classList.add("select");
         }

         // item-header 부분
         const itemHeader = document.createElement("div");
         itemHeader.classList.add("item-header");

         const listProfile = document.createElement("img");
         listProfile.classList.add("list-profile");

         if(room.targetProfile == undefined)   
            listProfile.setAttribute("src", "/resources/images/user.png");
         else                        
            listProfile.setAttribute("src", room.targetProfile);

         itemHeader.append(listProfile);

         // item-body 부분
         const itemBody = document.createElement("div");
         itemBody.classList.add("item-body");

         const p = document.createElement("p");

         const targetName = document.createElement("span");
         targetName.classList.add("target-name");
         targetName.innerText = room.targetNickName;
         
         const recentSendTime = document.createElement("span");
         recentSendTime.classList.add("recent-send-time");
         recentSendTime.innerText = room.sendTime;
         
         
         p.append(targetName, recentSendTime);
         
         
         const div = document.createElement("div");
         
         const recentMessage = document.createElement("p");
         recentMessage.classList.add("recent-message");

         if(room.lastMessage != undefined){
            recentMessage.innerHTML = room.lastMessage;
         }
         
         div.append(recentMessage);

         itemBody.append(p,div);

         // 현재 채팅방을 보고있는게 아니고 읽지 않은 개수가 0개 이상인 경우 -> 읽지 않은 메세지 개수 출력
         if(room.notReadCount > 0 && room.chattingNo != selectChattingNo ){
         // if(room.chattingNo != selectChattingNo ){
            const notReadCount = document.createElement("p");
            notReadCount.classList.add("not-read-count");
            notReadCount.innerText = room.notReadCount;
            div.append(notReadCount);
         }else{

            // 현재 채팅방을 보고있는 경우
            // 비동기로 해당 채팅방 글을 읽음으로 표시
            fetch("/chatting/updateReadFlag",{
               method : "PUT",
               headers : {"Content-Type": "application/json"},
               body : JSON.stringify({"chattingNo" : selectChattingNo, "memberNo" : loginMemberNo})
            })
            .then(resp => resp.text())
            .then(result => console.log(result))
            .catch(err => console.log(err));

         }
         

         li.append(itemHeader, itemBody);
         chattingList.append(li);
      }

      roomListAddEvent();
   })
   .catch(err => console.log(err));


   /*$.ajax({
      url: "/chatting/roomList",
      data : {"memberNo" : loginMemberNo},
      dataType : "JSON",
      success : roomList => {
         
      }
   })*/
}






// 채팅 메세지 영역
const display = document.querySelector(".wrap");


// 상대방 닉네임 표시 엘리먼트 선택
const opponentNameElement = document.querySelector(".opponentUser span");

// 상대방 이미지 표시 엘리먼트 선택
const opponentImageElement = document.querySelector(".opponentUser img");



// 채팅방 목록에 이벤트를 추가하는 함수 
function roomListAddEvent() {
  const chattingItemList = document.getElementsByClassName("result-row3");

  for (let item of chattingItemList) {
    item.addEventListener("click", e => {

      // 클릭한 채팅방의 번호 얻어오기
      selectChattingNo = item.getAttribute("chat-no");
      selectTargetNo = item.getAttribute("target-no");

      selectTargetProfile = item.querySelector(".result-row-img").getAttribute("src");
      selectTargetName = item.querySelector(".target-name").innerText;


      // 상대방 닉네임 업데이트
      opponentNameElement.innerText = selectTargetName;

      // 상대방 이미지 업데이트
      opponentImageElement.src = selectTargetProfile;

      // 메세지 목록 초기화
      display.innerHTML = "";

      // 모든 채팅방에서 select 클래스를 제거
      for (let it of chattingItemList) it.classList.remove("select")

      // 현재 클릭한 채팅방에 select 클래스 추가
      item.classList.add("select");

      // 비동기로 메세지 목록을 조회하는 함수 호출
      selectChattingFn();
    });
  }
}

// 비동기로 메세지 목록을 조회하는 함수
function selectChattingFn() {
    // 이전 메시지 초기화
    display.innerHTML = "";

    fetch("/chatting/selectMessage?" + `chattingNo=${selectChattingNo}&memberNo=${loginMemberNo}`)
        .then(resp => resp.json())
        .then(messageList => {
            console.log(messageList);

            // 이전 내용 유지하면서 메시지 추가
            for (let msg of messageList) {

                console.log(msg.senderNo);
                console.log(loginMemberNo);


                const chatDiv = document.createElement("div");
                chatDiv.classList.add("chat", msg.senderNo === loginMemberNo ? "ch2" : "ch1");

                // 아이콘 부분 (프로필 이미지) 생성
                const iconDiv = document.createElement("div");
                iconDiv.classList.add("icon");
                const img = document.createElement("img");
                img.src = msg.senderNo === loginMemberNo ? "/resources/images/내프로필.jpg" : selectTargetProfile; // 프로필 이미지 경로 설정
                iconDiv.appendChild(img);

                // 텍스트 박스 부분 생성
                const textboxDiv = document.createElement("div");
                textboxDiv.classList.add("textbox");
                const messageParagraph = document.createElement("p");
                messageParagraph.innerText = msg.messageContent;
                textboxDiv.appendChild(messageParagraph);

                // 아이콘과 텍스트 박스를 채팅 div에 추가
                chatDiv.appendChild(iconDiv);
                chatDiv.appendChild(textboxDiv);

                display.appendChild(chatDiv);
            }

            // 스크롤 제일 밑으로 이동
            display.scrollTop = display.scrollHeight;
        })
        .catch(err => console.log(err));
}




// ----------------------------------------------------------------------------------------------------------------

// sockjs를 이용한 WebSocket 구현

// 로그인이 되어 있을 경우에만
// /chattingSock 이라는 요청 주소로 통신할 수 있는  WebSocket 객체 생성
let chattingSock;

if(loginMemberNo != ""){
   chattingSock = new SockJS("/chattingSock");
}



// 채팅 입력
const send = document.getElementById("messageSend");
const inputChatting = document.getElementById("inputChatting");

const sendMessage = () => {

   if (inputChatting.value.trim().length == 0) {
      alert("채팅을 입력해주세요.");
      inputChatting.value = "";
   } else {
      var obj = {
         "senderNo": loginMemberNo,
         "targetNo": selectTargetNo,
         "chattingNo": selectChattingNo,
         "messageContent": inputChatting.value,
      };
      console.log(obj)

      // JSON.stringify() : 자바스크립트 객체를 JSON 문자열로 변환
      chattingSock.send(JSON.stringify(obj));

      inputChatting.value = "";
   }
}

// 엔터 == 제출
// 쉬프트 + 엔터 == 줄바꿈
inputChatting.addEventListener("keyup", e => {
   if(e.key == "Enter"){ 
      if (!e.shiftKey) {
         sendMessage();
      }
   }
})



// WebSocket 객체 chattingSock이 서버로부터 메세지를 받으면 자동으로 실행될 콜백 함수
chattingSock.onmessage = function (e) {
    // 메소드를 통해 전달받은 객체값을 JSON 객체로 변환해서 msg 변수에 저장.
    const msg = JSON.parse(e.data);
    console.log(msg);
 
    // 현재 채팅방을 보고 있는 경우
    if (selectChattingNo == msg.chattingNo) {
       // 메세지 출력할 부모 요소 선택
       const chatDisplay = document.querySelector(".wrap");
 
       // 채팅 메세지를 감싸는 div 요소 생성
       const chatDiv = document.createElement("div");
       chatDiv.classList.add("chat", msg.senderNo === loginMemberNo ? "ch2" : "ch1");
 
       // 아이콘 부분 (프로필 이미지) 생성
       const iconDiv = document.createElement("div");
       iconDiv.classList.add("icon");
       const img = document.createElement("img");
       img.src = msg.senderNo === loginMemberNo ? "/resources/images/내프로필.jpg" : selectTargetProfile; // 프로필 이미지 경로 설정
       iconDiv.appendChild(img);
 
       // 텍스트 박스 부분 생성
       const textboxDiv = document.createElement("div");
       textboxDiv.classList.add("textbox");
       const messageParagraph = document.createElement("p");
       messageParagraph.innerText = msg.messageContent;
       textboxDiv.appendChild(messageParagraph);
 
       // 아이콘과 텍스트 박스를 채팅 div에 추가
       chatDiv.appendChild(iconDiv);
       chatDiv.appendChild(textboxDiv);
 
       // 채팅 메세지를 채팅 영역에 추가
       chatDisplay.appendChild(chatDiv);
 
       // 스크롤을 제일 밑으로 이동
       chatDisplay.scrollTop = chatDisplay.scrollHeight;
    }
 
    selectRoomList();
 }
 
 



// 문서 로딩 완료 후 수행할 기능
document.addEventListener("DOMContentLoaded", ()=>{
   
   // 채팅방 목록에 클릭 이벤트 추가
   roomListAddEvent(); 

   // 보내기 버튼에 이벤트 추가
   send.addEventListener("click", sendMessage);
});