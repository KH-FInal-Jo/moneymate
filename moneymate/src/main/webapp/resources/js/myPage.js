// 비밀번호 변경하기
const Password = document.getElementById("Password");
const newPassword = document.getElementById("newPassword");
const confirmPassword = document.getElementById("confirmPassword");
const changePwFrm = document.getElementById("changePwFrm");

if(changePwFrm != null){
    changePwFrm.addEventListener("submit", e=>{

        //비밀번호 미작성
        if(Password.value.trim() == ""){
            alert("현재 비밀번호를 입력해주세요.");
            e.preventDefault();
            Password.focus();
            Password.value="";
            return;
        }

        //비번 유효성 검사
        const regEx = /^[a-zA-Z0-9!@#\-_]{6,20}$/;

        if(!regEx.test(newPassword.value)){
            alert("비밀번호가 유효하지 않습니다.")
            e.preventDefault();
            newPassword.focus();
            return;
        }

        // 비밀번호랑 비밀번호 확인 같을떄랑
        // 일치하지 않을때 막기
        if(newPassword.value != confirmPassword.value){
            alert("비밀번호가 일치하지 않습니다.");

            confirmPassword.focus()
            e.preventDefault();
            return;
        }

    })
}