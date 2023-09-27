const goBack = document.getElementById("goBack");

goBack.addEventListener("click", function(){
    history.back();
})


const reportContent = document.getElementById("reportContent");
const submitReport = document.getElementById("submitReport");

submitReport.addEventListener("submit", e => {
    if(reportContent.value.trim().length == 0){
        e.preventDefault();
        alert("신고 내용을 입력해주세요.");
    }
    
})

