const NoticeWriteBtn = document.getElementById("NoticeWriteBtn");

if(NoticeWriteBtn != null){
    NoticeWriteBtn.addEventListener("click", () => {

        location.href = `/community/${location.pathname.split("/")[2]}/insert`
    
    })

}

// 게시글 수정 버튼
const updateBtn = document.getElementById("updateBtn");
if(updateBtn != null){

    // 게시글 수정 버튼 클릭 시 
    document.getElementById("updateBtn").addEventListener("click", () => {
    
        location.href = `/community/${location.pathname.split("/")[2]}/update`
    
    })
}