function confirm(reportNo, reportedNo){

    

    const data = {
        "reportNo" : reportNo,
        "reportedNo" : reportedNo
    }


    fetch("/admin/reportManage/confirm2", {
        method : 'POST',
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.text())
    .then(result => {


        if(result > 0){
            alert("처리 완료");
        } 

        location.reload(true);
    })
    .catch();
}