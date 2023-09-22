const memberName = document.getElementById("memberName");
const memberEmail = document.getElementById("memberEmail");
const memberTel = document.getElementById("memberTel");
const certification = document.getElementById("certification");
const findPw = document.getElementById("findPw");
const sendmessage= document.getElementById("sendmessage");

sendmessage.addEventListener("click", e=>{

    fetch("/member/findPw1?memberTel=" + memberTel.value)
    
    .then(resp => resp.text())
    
    .then(result => {

        alert("인증번호 전송완료");
        console.log(result);

        confirmNum.addEventListener("click", function(){
            if(inputNum.value == result){
                alert("휴대폰 인증 성공!")
                modal.style.display = "none";
                checkObj.authKey = true;
                authKeyMessage.innerText = "인증되었습니다.";
                authKeyMessage.classList.add("confirm");
                body.style.overflow = "auto";
                checkObj.authKey = true;
                openmodal.remove();
            }
        })

        
    })
    .catch(err => {
        console.log("인증번호 발송 중 에러 발생");
    });
})
