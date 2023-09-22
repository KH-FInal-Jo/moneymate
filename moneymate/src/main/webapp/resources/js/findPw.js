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
    
    .then(resp => resp.text())
    
    .then(result => {

        alert("인증번호 전송완료");

        check.addEventListener("click", function(){
            if(certification.value == result){
                alert("인증 성공!");

                changePw.addEventListener("click", function(){


                    // POST 방식으로 data에 담아서 넘겨도 상관x
                    // 비밀번호 바꾸기
                    fetch("/member/findPw1/newPw?newPw=" + newPw.value + "&memberEmail=" + memberEmail.value + "&memberTel=" + memberTel.value)
                    .then(resp => resp.text())
                    .then( result => {
                        console.log(result);

                        alert("비밀번호가 변경되었습니다.");
                    })
                    .catch();
              })

            }

        })

        
    })
    .catch(err => {
        console.log("인증번호 발송 중 에러 발생");
    });
})
