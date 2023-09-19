function confirm(boardNo, memberNo){

    

    const data = {
        "boardNo" : boardNo,
        "memberNo" : memberNo
    }


    fetch("/admin/reportManage/confirm", {
        method : 'POST',
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.text())
    .then(result => {

        console.log("확인했니?" + result);

        if(result > 0){
            alert("처리 완료");
        } 

        location.reload(true);
    })
    .catch();
}