const checkObj = {
        "check" : false,
        "memberEmail" : false,
        "memberPw" : false,
        "memberPwConfirm" : false,
        "memberName" : false,
        "memberNickname" : false,
        "memberTel" : false,
        "authKey" : false
};


const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");
const check = document.getElementById("check");




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
        fetch("/member/signUp/emaildupCheck?email="+ memberEmail.value)
        .then(resp => resp.text())
        .then(count => {

            console.log(count);
            if(count == 0){

                checkObj.memberEmail = true;
                emailMessage.innerText="올바른 이메일 형식입니다.";
                emailMessage.classList.remove("error");
                emailMessage.classList.add("confirm");

                
            } else{
                emailMessage.innerText="이미 사용중인 이메일입니다.";
                emailMessage.classList.remove("confirm");
                emailMessage.classList.add("error");

                checkObj.memberEmail = false;
            }
    
            checkObj.memberEmail = true;
        })
        .catch(e => console.log(e));
        // 중복검사 해야함 햇어

    } else{
        emailMessage.innerText="이메일 형식을 확인해주세요.";
        emailMessage.classList.remove("confirm");
        emailMessage.classList.add("error");

        checkObj.memberEmail = false;
    }
});

// 이메일 인증
const sendAuthKeyBtn = document.getElementById("sendAuthKeyBtn");
const authKeyMessage = document.getElementById("authKeyMessage");

let authTimer;
let authMin = 4;
let authSec = 59;

let tempEmail;

sendAuthKeyBtn.addEventListener("click", function(){
    authMin = 4;
    authSec = 59; // 4분 59초로 세팅

    checkObj.authKey = false;

    if(memberEmail.value.trim().length == 0){
        alert("이메일을 입력해주세요.");
        return;
    }


    if(checkObj.memberEmail){
        fetch("/member/signUp/sendEmail?email="+memberEmail.value)
        .then(resp => resp.text())
        .then(result => {

            console.log(result);

            if(result > 0){
                console.log("인증 번호가 발송되었습니다.")
                tempEmail = memberEmail.value;
            }else{
                console.log("인증번호 발송 실패")
            }
        })
        .catch(err => {
            console.log("이메일 발송 중 에러 발생");
            console.log(err);
        });

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

    }else{
        alert("중복되지 않은 이메일을 작성해주세요.");
        memberEmail.focus();
    }


});


const authKey = document.getElementById("authKey");
const checkAuthKeyBtn = document.getElementById("checkAuthKeyBtn");

checkAuthKeyBtn.addEventListener("click", function(){

    if(authKey.value.trim().length == 0){
        alert("인증번호를 입력해주세요.");
        return;
    }

    if(authMin > 0 || authSec > 0){
        const obj = {"inputKey":authKey.value, "email":tempEmail}
        const query = new URLSearchParams(obj).toString();

        fetch("/member/signUp/checkAuthKey?" + query)
        .then(resp => resp.text())
        .then(result => {

            console.log(result);

            if(result > 0){
                clearInterval(authTimer);
                authKeyMessage.innerText = "인증되었습니다.";
                authKeyMessage.classList.add("confirm");
                checkObj.authKey = true;

            } else{
                alert("인증번호가 일치하지 않습니다.")
                checkObj.authKey = false;
            }
        })
        .catch(err => console.log(err));
    }else{
        alert("인증 시간이 만료되었습니다. 다시 시도해주세요.")
    }
});



function authPhone(){

    if(checkObj.authKey == true){
        alert("이미 인증하셨습니다.");
        return;
    }

    
    const mTel = document.getElementById("mTel");
    const confirmNum = document.getElementById("confirmNum");
    const inputNum = document.getElementById("inputNum");
    const modal = document.getElementById("modal1");
    const authKeyMessage = document.getElementById("authKeyMessage");
    const body = document.getElementById("body");
    const openmodal = document.getElementById("open-modal");
    
    if(mTel.value.trim().length == 0){
        alert("휴대폰 번호를 입력해주세요.");
        return;
    }

    

    fetch("/member/signUp/authPhone?mTel=" + mTel.value)
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

    
};




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
            checkObj.memberPwConfirm=true;
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

// 이름 유효성 검사
const memberName = document.getElementById("memberName");
const nameMessage = document.getElementById("nameMessage");

memberName.addEventListener("input", () => {
    if(memberName.value.trim().length == 0){
        nameMessage.innerText = "한글,영어,숫자로만 2~20글자"
        nameMessage.classList.remove("error", "confirm");

        checkObj.memberName = false;
        return;
    }

    const regEx = /[가-힣\a-z\A-Z]{2,20}$/;

    if(regEx.test(memberName.value)){
        nameMessage.innerText = "이름 형식이 유효합니다.";
        nameMessage.classList.remove("error");
        nameMessage.classList.add("confirm");

        checkObj.memberName = true;
    } else {
        nameMessage.innerText = "이름 형식이 유효하지 않습니다.";
        nameMessage.classList.remove("confirm");
        nameMessage.classList.add("error");

        checkObj.memberName = false;
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
        fetch("/member/signUp/dupNicknameCheck?nickname="+memberNickname.value)
        .then(resp => resp.text())
        .then(count => {

            console.log(count);

            if(count == 0){
                checkObj.memberNickname = true;
        
                nickMessage.innerText="사용 가능한 닉네임입니다.";
                nickMessage.classList.add("confirm");
                nickMessage.classList.remove("error");
            } else{
                nickMessage.innerText="이미 사용중인 닉네임입니다.";
                nickMessage.classList.add("error");
                nickMessage.classList.remove("confirm");
        
                checkObj.memberNickname = false;
            }
        })
        .catch(e => console.log(e));


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
                case "authKey"        : alert("인증번호가 유효하지 않습니다."); break;
                case "memberPw"         : alert("비밀번호가 유효하지 않습니다."); break;
                case "memberPwConfirm"  : alert("비밀번호가 확인되지 않았습니다."); break;
                case "memberName"  : alert("이름이 유효하지 않습니다."); break;
                case "memberNickname"   : alert("닉네임이 유효하지 않습니다."); break;
                case "memberTel"        : alert("전화번호가 유효하지 않습니다."); break;
            }

            document.getElementById(key).focus();

            e.preventDefault();
            return; 
        }
    }

});

const modal = document.getElementById("modal1");
const openModalBtn = document.getElementById("open-modal");
const closeModalBtn = document.getElementById("close-modal");

// 모달창 열기
openModalBtn.addEventListener("click", () => {
  modal.style.display = "block";
  document.body.style.overflow = "hidden"; // 스크롤바 제거
});

// 모달창 닫기
closeModalBtn.addEventListener("click", () => {
  modal.style.display = "none";
  document.body.style.overflow = "auto"; // 스크롤바 보이기
});





