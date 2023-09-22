// 휴대폰인증으로 비밀번호 변경

const memberName = document.getElementById("memberName");
const memberEmail = document.getElementById("memberEmail");
const memberTel = document.getElementById("memberTel");
const certification = document.getElementById("certification");
const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");
const sendmessage= document.getElementById("sendmessage");
const check= document.getElementById("check");
const changePw= document.getElementById("changePw");

sendmessage.addEventListener("click", e=>{

    fetch("/member/findPw1?memberTel=" + memberTel.value + "&memberEmail=" + memberEmail.value + "&memberName="+memberName.value)
            // 얘가 주소값
    .then(resp => resp.text())
    
    .then(result => {

        alert("인증번호 전송완료");

        check.addEventListener("click", function(){
            if(certification.value == result){
                alert("인증 성공!");

                newPw.focus();

                changePw.addEventListener("click", function(){


                    // POST 방식으로 data에 담아서 넘겨도 상관x
                    // 비밀번호 바꾸기
                    if(newPw.value == newPwConfirm.value){
                        fetch("/member/findPw1/newPw?newPw=" + newPw.value + "&memberEmail=" + memberEmail.value + "&memberTel=" + memberTel.value)
                        .then(resp => resp.text())
                        .then( result => {
                            console.log(result);

                            const regEx = /^[a-zA-Z\d\!\@\#\-\_]{8,20}$/;
                            if(result > 0 && regEx.test(newPw.value)){
                                alert("비밀번호가 변경되었습니다.");
                                location.href= "/";
                            } else{
                                alert("영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.");
                            }
                        })
                        .catch();
                    } else{
                        alert("비밀번호를 확인해주세요.");
                        newPw.focus();
                    }
              })

            }

        })

        
    })
    .catch(err => {
        console.log("인증번호 발송 중 에러 발생");
    });
})



// 이메일 인증으로 비밀번호 변경
const memberName2 = document.getElementById("memberName2");
const memberEmail2 = document.getElementById("memberEmail2");
const certification2 = document.getElementById("certification2");
const newPw2 = document.getElementById("newPw2");
const newPwConfirm2 = document.getElementById("newPwConfirm2");
const sendmessage2 = document.getElementById("sendmessage2");
const check2 = document.getElementById("check2");
const changePw2 = document.getElementById("changePw2");
const authKeyMessage = document.getElementById("authKeyMessage");

let authTimer;
let authMin = 4;
let authSec = 59;

let tempEmail;

sendmessage2.addEventListener("click", function(){
    
    fetch("/member/findPw2?&memberEmail=" + memberEmail2.value + "&memberName="+memberName2.value)
    .then(resp => resp.text())
    .then(count => {
        console.log(count);
        if(count > 0){
            fetch("/member/setPw/sendEmail?memberEmail="+memberEmail2.value)
            .then(resp => resp.text())
            .then(result => {
                console.log(result);

                if(result > 0){
                    console.log("인증 번호가 발송되었습니다.")
                    tempEmail = memberEmail2.value;
                } else{
                    console.log("인증번호 발송 실패")
                }
            })
            .catch(console.log("이메일 발송 중 에러 발생"));

            alert("인증번호가 발송 되었습니다.");

            authKeyMessage.innerText = "05:00";
            authKeyMessage.classList.remove("confirm");


            authTimer = window.setInterval(()=>{

                authKeyMessage.innerText = "0" + authMin + ":" + (authSec<10 ? "0" + authSec : authSec);
               
                // 남은 시간이 0분 0초인 경우
                if(authMin == 0 && authSec == 0){
                    checkObj.authKey = false;
                    clearInterval(authTimer);
                    return;
                }
    
                // 0초인 경우
                if(authSec == 0){
                    authSec = 60;
                    authMin--;
                }
    
                authSec--; // 1초 감소
    
            }, 1000)
    

        }
    })
    .catch(console.log("이메일 발송 중 에러 발생"));

    
    authMin = 4;
    authSec = 59; // 4분 59초로 세팅



})

check2.addEventListener("click", function(){
    if(authMin > 0 || authSec > 0){
        const obj = {"inputKey":certification2.value, "email":memberEmail2.value}
        const query = new URLSearchParams(obj).toString();


        fetch("/member/setPw/checkAuthKey?" + query)
        .then(resp => resp.text())
        .then(result => {

            console.log(result);

            if(result > 0){
                clearInterval(authTimer);
                alert("인증되었습니다!")
                authKeyMessage.innerText = "인증되었습니다.";
                authKeyMessage.classList.add("confirm");
                memberEmail2.focus();

                changePw2.addEventListener("click", function(){

                    if(newPw2.value == newPwConfirm2.value){
                        fetch("/member/findPw2/newPw?newPw=" + newPw2.value + "&memberEmail=" + memberEmail2.value )
                        .then(resp => resp.text())
                        .then(result => {
                            console.log(result);
    
                            const regEx = /^[a-zA-Z\d\!\@\#\-\_]{8,20}$/;
                            if(result > 0 && regEx.test(newPw2.value)){
                                alert("비밀번호가 변경되었습니다.");
                                location.href= "/";
                            } else{
                                alert("영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.");
                            }
                        })
                        .catch();
    
                    } else{
                        alert("인증번호가 일치하지 않습니다.");
                    }
                });
            }

        })
        .catch(err => console.log(err));
    }else{
        alert("인증 시간이 만료되었습니다. 다시 시도해주세요.")

    }
})
