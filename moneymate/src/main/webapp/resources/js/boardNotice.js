const NoticeWriteBtn = document.getElementById("NoticeWriteBtn");

if(NoticeWriteBtn != null){
    NoticeWriteBtn.addEventListener("click", () => {

        location.href = `/community/${location.pathname.split("/")[2]}/insert`
    
    })

}
