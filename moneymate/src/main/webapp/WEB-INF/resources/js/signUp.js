const checkObj = {
        "check" : false,
        "memberEmail" : false,
        "memberPw" : false,
        "memberPwConfirm" : false,
        "memberNickname" : false,
        "memberTel" : false,
        "authKey" : false
};


const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");
const check = document.getElementById("check");

check.addEventListener("click", ()=> {
    if(confirm("정말 동의하시겠습니까?")){
        check.checked;
        checkObj.check = true;
    }else{
        check.checked = false;
        checkObj.check = false;
    }
})


memberEmail.addEventListener("input", () => {

    if(!check.checked){
        alert("동의 먼저 진행해주세요.");
        check.focus();
        checkObj.check = false;
    } else{
        checkObj.check = true;
    }

    if(memberEmail.value.trim().length == 0){
        memberEmail.value == "";
        emailMessage.innerText="메일을 입력해주세요.";
        emailMessage.classList.remove("confirm", "error");

        checkObj.memberEmail = false;

        return;
    }

    const regEx = /^[A-Za-z\d\-\_]{4,}@[가-힣\w\-\_]+(\.\w+){1,3}$/;

    if(regEx.test(memberEmail.value)){
       /*  fetch()
        .then()
        .then()
        .catch() */
        // 중복검사 해야함
        emailMessage.innerText="올바른 이메일 형식입니다.";
        emailMessage.classList.remove("error");
        emailMessage.classList.add("confirm");

        checkObj.memberEmail = true;

    } else{
        emailMessage.innerText="이메일 형식을 확인해주세요.";
        emailMessage.classList.remove("confirm");
        emailMessage.classList.add("error");

        checkObj.memberEmail = false;
    }
});

// 이메일 인증







// 비밀번호/비밀번호 확인 유효성 검사
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage = document.getElementById("pwMessages");

memberPw.addEventListener("input", ()=> {

    if(memberPw.value.trim().length == 0){
        memberPw.value = "";
        pwMessage.innerText="영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.";
        pwMessage.classList.remove("confirm", "error");

        checkObj.memberPw = false;

        return;
    }

    const regEx = /^[a-zA-Z\d\!\@\#\-\_]{8,20}$/;

    if(regEx.test(memberPw.value)){
        checkObj.memberPw = true;


    }
})
