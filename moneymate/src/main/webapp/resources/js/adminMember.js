function mileUpdate(memberNo, btn){
    
    const input = btn.previousElementSibling;
    console.log(input)

    if(!confirm(memberNo + "번 회원의 마일리지를 변경하시겠습니까?")){
        return;
    }

    const data = {
        "memberNo" : memberNo,
        "mileage" : input.value
    }

    console.log(data)

    fetch("/admin/member/mile", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })

    .then(resp => resp.text())

    .then(result => {
        if(result>0){
            alert("마일리지가 변경되었습니다.")
        } else {
            alert("마일리지 변경 실패")
        }
    })

    .catch(e => console.log(e))


}

function secession(memberNo, btn){

    if(!confirm(memberNo + "번 회원을 탈퇴시키겠습니까?")){
        return;
    }

    fetch("/admin/member/secession?no=" + memberNo)

    .then(resp => resp.text())

    .then(result => {
        if(result>0){
            alert("탈퇴되었습니다.")
        } else {
            console.log("탈퇴 실패..")
        }
        location.reload(true);
    })

    .catch(e => console.log(e))
}