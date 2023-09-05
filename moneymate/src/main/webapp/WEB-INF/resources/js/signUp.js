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
const pwMessage = document.getElementById("pwMessage");

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

        if(memberPwConfirm.value.trim().length == 0){
            pwMessage.innerText="유효한 비밀번호 형식입니다.";
            pwMessage.classList.remove("error");
            pwMessage.classList.add("confirm");
        } else {
            if(memberPw.value == memberPwConfirm.value){
    
                pwMessage.innerText = "비밀번호가 일치합니다.";
                pwMessage.classList.remove("error");
                pwMessage.classList.add("confirm");
    
                checkObj.memberPwConfirm=true;
    
            } else { 
    
            pwMessage.innerText="비밀번호가 일치하지 않습니다.";
            pwMessage.classList.remove("confirm");
            pwMessage.classList.add("error");
    
            checkObj.memberPwConfirm=false;
    
            }
        }
        
    } else{
        pwMessage.innerText="비밀번호 형식이 유효하지 않습니다.";
        pwMessage.classList.remove("confirm");
        pwMessage.classList.add("error");

        checkObj.memberPw=false;
    }
});

// 비밀번호 확인 유효성 검사
memberPwConfirm.addEventListener("input", () => {

    if(checkObj.memberPw){

        if(memberPw.value == memberPwConfirm.value){

            pwMessage.innerText = "비밀번호가 일치합니다.";
            pwMessage.classList.remove("error");
            pwMessage.classList.add("confirm");

            checkObj.memberPwConfirm=true;

        } else { 

        pwMessage.innerText="비밀번호가 일치하지 않습니다.";
        pwMessage.classList.remove("confirm");
        pwMessage.classList.add("error");

        checkObj.memberPwConfirm=false;

        }
    } 
});


// 닉네임 유효성 검사
const memberNickname = document.getElementById("memberNickname");
const nickMessage = document.getElementById("nickMessage");

memberNickname.addEventListener("input", ()=> {
    if(memberNickname.value.trim().length == 0){
        nickMessage.innerText = "한글,영어,숫자로만 2~10글자"
        nickMessage.classList.remove("error", "confirm");

        checkObj.memberNickname = false;
        return;
    }

    const regEx = /[가-힣\w\d]{2,10}$/;

    if(regEx.test(memberNickname.value)){
        // 닉네임 중복검사 진행해야함
        console.log("1");


    } else{
        nickMessage.innerText="유효하지 않은 닉네임 형식입니다.";
        nickMessage.classList.add("error");
        nickMessage.classList.remove("confirm");

        checkObj.memberNickname = false;
    }
});


// 전화번호 유효성 검사
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

memberTel.addEventListener("input", () => {

    if(memberTel.value.trim().length == 0){
        telMessage.innerText = "전화번호를 입력해주세요.(- 제외)";
        telMessage.classList.remove("error", "confirm");

        checkObj.memberTel = false;
        return;
    }

    // 전화번호가 입력되었을 때
    // 정규표현식s
    const regEx = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;
    // 내가 작성한 정규식 : /^0([1|3|5][\d]|2)\d{7,8}$/

    if(regEx.test(memberTel.value)){
        telMessage.innerText = "전화번호 형식이 유효합니다.";
        telMessage.classList.remove("error");
        telMessage.classList.add("confirm");

        checkObj.memberTel = true;
    } else {
        telMessage.innerText = "전화번호 형식이 유효하지 않습니다.";
        telMessage.classList.remove("confirm");
        telMessage.classList.add("error");

        checkObj.memberTel = false;
    }
});


document.getElementById("signUpFrm").addEventListener("submit", e => {


    for(let key in checkObj){
        if(!checkObj[key]){ 

            switch(key){
                case "check"      : alert("위 약관을 동의해주세요."); break;
                case "memberEmail"      : alert("이메일이 유효하지 않습니다."); break;
                case "memberPw"         : alert("비밀번호가 유효하지 않습니다."); break;
                case "memberPwConfirm"  : alert("비밀번호가 확인되지 않았습니다."); break;
                case "memberNickname"   : alert("닉네임이 유효하지 않습니다."); break;
                case "memberTel"        : alert("전화번호가 유효하지 않습니다."); break;
                case "authKey"        : alert("인증번호가 유효하지 않습니다."); break;
            }

            document.getElementById(key).focus();

            e.preventDefault();
            return; 
        }
    }

});





