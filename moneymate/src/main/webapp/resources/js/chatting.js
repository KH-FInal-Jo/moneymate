const leftBarIcon1 = document.getElementsByClassName("leftBarIcon1")[0];
const leftBarIcon2 = document.getElementsByClassName("leftBarIcon2")[0];
const leftBarIcon3 = document.getElementsByClassName("leftBarIcon3")[0];
const leftBarIcon4 = document.getElementsByClassName("leftBarIcon4")[0];

let leftBar1 = document.getElementById("leftBar1");
let leftBar2 = document.getElementById("leftBar2");
let leftBar3 = document.getElementById("leftBar3");

leftBarIcon1.addEventListener("click", function(){
   window.location.href = "http://localhost/";
})

leftBarIcon2.addEventListener("click", function(){

    leftBar1.style.display = 'block';
    leftBar2.style.display = 'none';
    leftBar3.style.display = 'none';
    leftBarIcon2.style.color = 'white';
    leftBarIcon3.style.color = 'black';
    leftBarIcon4.style.color = 'black';
   })
   leftBarIcon3.addEventListener("click", function(){
   location.reload();

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



/* 모달창 띄우기 */
document.querySelectorAll('.result-row').forEach(function (friendItem) {
    friendItem.addEventListener('click', function () {
        const friendId = friendItem.getAttribute('data-room-id');
        const friendModal = document.getElementById('myModal-' + friendId);

        if (friendModal) {
            friendModal.style.display = 'block';
        }
    });
});


document.querySelectorAll('.close').forEach(function (closeBtn) {
   closeBtn.addEventListener('click', function () {
       const modal = closeBtn.closest('.modal'); // 현재 클릭한 닫기 버튼과 연결된 모달 선택

       // 모달 닫기
       if (modal) {
           modal.style.display = 'none';
       }
   });
});


let divdiv = document.querySelector(".wrap");

divdiv.scrollTop = divdiv.scrollHeight;

const modal = document.getElementsByClassName("modal")[0];

var showModalButtons = document.querySelectorAll('.showModalButton');

showModalButtons.forEach(function(showModalButton) {
    showModalButton.addEventListener('click', function() {
        var modalId = showModalButton.getAttribute('data-target-modal');
        var modal = document.getElementById(modalId);

        var modal2Id = showModalButton.getAttribute('data-toggle-modal');
        var modal2 = document.getElementById(modal2Id);

        // 초기에 modal2를 숨겨진 상태로 설정

        if (modal2.style.display === 'none' || modal2.style.display === '') {
            modal2.style.display = 'block'; 
            modal.style.height = '660px';
        } else {
            modal2.style.display = 'none';
            modal.style.height = '430px';
        }
    });
});







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
               console.log(member);
                // li요소 생성(한 행을 감싸는 요소)
                const li = document.createElement("li");
                li.classList.add("result-row");
                li.setAttribute("data-id", member.memberNo);
 
                // 프로필 이미지 요소
                const img = document.createElement("img");
                img.classList.add("result-row-img");
 
                // 프로필 이미지 여부에 따른 src 속성 선택
                if (member.profileImage == null) img.setAttribute("src", "http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg");
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
                  alert("친구 추가");

                  targetInput.value = "";
                  resultArea.innerHTML = "";
                  chattingEnter(li);

                  // 친구 추가 알림이 뜨면 leftBar3 스타일을 변경
                });
             }
          }
       })
       .catch(err => console.log(err));
 }
 
});


// 모달 열기/닫기 함수
function toggleModal(modalId) {
   const modal = document.getElementById(modalId);
 
   if (modal) {
     // 모달이 존재할 때만 처리
     if (modal.style.display === 'none' || modal.style.display === '') {
       modal.style.display = 'block'; // 모달 열기
     } else {
       modal.style.display = 'none'; // 모달 닫기
     }
   } else {
     console.log(`모달 ${modalId}이(가) HTML에 존재하지 않습니다.`);
   }
 }
 



// 내 친구 검색하기
const MytargetInput = document.querySelector(".MytargetInput");
const myFriendList = document.querySelector(".myFrSer");

MytargetInput.addEventListener("input", function () {
   const query = MytargetInput.value.trim();

   if (query.length === 0) {
      myFriendList.innerHTML = "";
      return;
   }



   fetch(`/chatting/myf/selectTarget?query=${query}`)
      .then((resp) => resp.json())
      .then((friendList) => {
         
         myFriendList.innerHTML = "";

         if (friendList.length === 0) {
            const li = document.createElement("li");
            li.classList.add("result-row");
            li.innerText = "일치하는 친구가 없습니다";
            myFriendList.appendChild(li);
         } else {
            friendList.forEach((member) => {
               const li = document.createElement("li");
               li.classList.add("result-row");
               li.setAttribute("data-id", member.memberNo);

               const img = document.createElement("img");
               img.classList.add("result-row-img");
               img.setAttribute("src", member.profileImage || "http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg");

               const span = document.createElement("span");
               span.innerHTML = member.memberNickname;

               // 모달 열기 이벤트 리스너
               li.addEventListener("click", () => {
                  
                  const modalId = `myModal-${member.memberNo}`;
                  const modal = document.getElementById(modalId);
               
                  if (modal) {
                  toggleModal(modalId); 
                  } else {
                  console.log(`모달 ${modalId}이(가) HTML에 존재하지 않습니다.`);
                  }
               });

               li.style.color = "blue";
               li.style.fontWeight = "bold";

               li.appendChild(img);
               li.appendChild(span);
               myFriendList.appendChild(li);
            });
         }
      })
      .catch((err) => console.log(err));
});






// 채팅방 입장 또는 선택 함수
function chattingEnter(e){

   const targetNo = e.getAttribute("data-id");

   fetch("/chatting/enter?targetNo="+targetNo)
   .then(resp => resp.text())
   .then(chattingNo => {
      console.log(chattingNo);
      
      selectRoomList(); // 채팅방 목록 조회
      
      setTimeout(()=>{ 
         // 만약 채팅방 목록 중 이미 존재하는 채팅방이 있으면 클릭해서 입장
         const itemList = document.querySelectorAll(".result-row3")
         for(let item of itemList) {      
            if(item.getAttribute("chat-no") == chattingNo){
               item.click();
               targetInput.value = "";
               resultArea.innerHTML = "";
               return;
            }
         }

      }, 200);

   })
   .catch(err => console.log(err));
}

// 친구 추가 알림이 떴을 때 leftBar3 스타일을 변경하는 함수
function showLeftBar3() {
   leftBar3.style.display = 'block';
   leftBar2.style.display = 'none';
   leftBar1.style.display = 'none';
   leftBarIcon4.style.color = 'white';
   leftBarIcon3.style.color = 'black';
   leftBarIcon2.style.color = 'black';
   window.location.reload();
}



// 비동기로 채팅방 목록 조회
function selectRoomList() {
   fetch("/chatting/roomList")
      .then(resp => resp.json())
      .then(roomList => {
         console.log("roomlist 출력");
         console.log(roomList);

         // 채팅방 목록 출력 영역 선택
         const chattingList = document.querySelector(".chatting-list");

         // 채팅방 목록 지우기
         chattingList.innerHTML = "";

         // 조회한 채팅방 목록을 화면에 추가
         for (let room of roomList) {
            leftBar3.style.display = 'block';
            leftBar2.style.display = 'none';
            leftBar1.style.display = 'none';
            leftBarIcon4.style.color = 'white';
            leftBarIcon3.style.color = 'black';
            leftBarIcon2.style.color = 'black';
        
            const li = document.createElement("li");
            li.classList.add("result-row3");
            li.setAttribute("chat-no", room.chattingNo);
            li.setAttribute("target-no", room.targetNo);
            li.setAttribute("data-id", room.targetNo);
        
            const chatMessageDiv = document.createElement("div");
            chatMessageDiv.classList.add("chatMessage3");
        
            const con1Div = document.createElement("div");
            con1Div.classList.add("con1");
        
            const con2Div = document.createElement("div");
            con2Div.classList.add("con2");
        
            const con3Div = document.createElement("div");
            con3Div.classList.add("con3");
        
            const profileImgSrc = room.targetProfile ? room.targetProfile : "http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg";
            const profileImg = document.createElement("img");
            profileImg.classList.add("result-row-img");
            profileImg.setAttribute("src", profileImgSrc);
        
            const nameDiv = document.createElement("div");
            nameDiv.classList.add("target-name");
            nameDiv.textContent = room.targetNickName;
        
            const messageDiv = document.createElement("div");
            messageDiv.classList.add("lastmessage");
            messageDiv.textContent = room.lastMessage;
        
            const timeDiv = document.createElement("div");
            timeDiv.classList.add("sendtime");
            timeDiv.textContent = room.sendTime;

            const notDiv = document.createElement("div");
            notDiv.classList.add("notreadcount");
        
            let notReadCountP = null;
            if (room.notReadCount > 0 && room.chattingNo != selectChattingNo) {
               notReadCountP = document.createElement("p");
               notReadCountP.classList.add("not-read-count");
               notReadCountP.textContent = room.notReadCount;
               notDiv.appendChild(notReadCountP);
           } else {
               // 현재 채팅방을 보고 있는 경우, 읽지 않은 플래그를 업데이트
               fetch("/chatting/updateReadFlag", {
                   method: "PUT",
                   headers: { "Content-Type": "application/json" },
                   body: JSON.stringify({ "chattingNo": selectChattingNo, "memberNo": loginMemberNo })
               })
               .then(resp => resp.text())
               .then(result => {
                  console.log(result);

                  if (room.chattingNo == selectChattingNo) {
                     notDiv.innerHTML = "";
                  }

               })
               .catch(err => console.log(err));
           }
        
            con1Div.appendChild(profileImg);
            con2Div.appendChild(nameDiv);
            con2Div.appendChild(messageDiv);
            con3Div.appendChild(timeDiv);
            con3Div.appendChild(notDiv);
        
            chatMessageDiv.appendChild(con1Div);
            chatMessageDiv.appendChild(con2Div);
            chatMessageDiv.appendChild(con3Div);
        
            li.appendChild(chatMessageDiv);
            chattingList.appendChild(li);
        }
        

         roomListAddEvent();
      })
      .catch(err => console.log(err));
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
    
    fetch("/chatting/selectMessage?" + `chattingNo=${selectChattingNo}&memberNo=${loginMemberNo}`)
    .then(resp => resp.json())
    .then(messageList => {
        console.log(messageList);
        display.innerHTML = "";

      // 이전 내용 유지하면서 메시지 추가
      for (let msg of messageList) {
        const chatDiv = document.createElement("div");
        chatDiv.classList.add("chat", msg.senderNo == loginMemberNo ? "ch2" : "ch1");

        const iconDiv = document.createElement("div");
        iconDiv.classList.add("icon");
        const img = document.createElement("img");
        img.src = msg.senderNo === loginMemberNo ? "http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg" : selectTargetProfile;
        iconDiv.appendChild(img);

        const textboxDiv = document.createElement("div");
        textboxDiv.classList.add("textbox");
        textboxDiv.innerText = msg.messageContent;

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
      console.log(selectTargetNo);
      console.log(loginMemberNo);
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
       chatDiv.classList.add("chat", msg.senderNo == loginMemberNo ? "ch2" : "ch1");
 
       // 아이콘 부분 (프로필 이미지) 생성
       const iconDiv = document.createElement("div");
       iconDiv.classList.add("icon");
       const img = document.createElement("img");
       img.src = msg.senderNo === loginMemberNo ? "/resources/images/내프로필.jpg" : selectTargetProfile; // 프로필 이미지 경로 설정
       iconDiv.appendChild(img);



       const textboxDiv = document.createElement("div");
        textboxDiv.classList.add("textbox");
        textboxDiv.innerText = msg.messageContent;

        chatDiv.appendChild(iconDiv);
        chatDiv.appendChild(textboxDiv);

        display.appendChild(chatDiv);


 
       // 텍스트 박스 부분 생성
 
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