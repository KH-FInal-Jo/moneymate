// 휴대폰인증으로 아이디 찾기

const MemberName = document.getElementById("MemberName");
const MemberTel = document.getElementById("MemberTel");
const textCertification = document.getElementById("textCertification");
const Send= document.getElementById("Send");
const check= document.getElementById("check");
const findId= document.getElementById("findId");

Send.addEventListener("click", e=>{

    console.log("버튼작동하니?");

    fetch("/member/findId2?memberTel=" + MemberTel.value + "&memberName="+MemberName.value)
            // 얘가 주소값 // 패치 쓰고 바로 컨트롤러
    .then(resp => resp.text())
    
    .then(result => { // 2번쨰 then에 ajax가 성공적으로 실행되서 결과값을 잘 받아왔을때 실행될 함수를 적는 곳
        const regEx= /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;
        const name=/^[가-힣a-zA-Z]+$/;
        if(!regEx.test(MemberTel.value)){
            alert("휴대폰 번호를 입력해 주세요");
        }else if(!name.test(MemberName.value)){
            alert("이름을 입력해주세요.");
        }else{
            alert("인증번호를 발송하였습니다.");

        }
       
        check.addEventListener("click", function(){
            if(textCertification.value == result){
                alert("인증 성공");
                
                fetch("/member/findId3?memberTel=" + MemberTel.value + "&memberName="+MemberName.value)
                .then(resp=>resp.text())
                .then(realId =>{
                    findId.value=realId;
                })
                .catch(console.log("인증번호 발송 중 에러 발생"));

            }
        })

        
    })
    .catch(err => {
        console.log("인증번호 발송 중 에러 발생");
    });
})

