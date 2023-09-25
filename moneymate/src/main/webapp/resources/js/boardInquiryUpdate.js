const updateBtn=document.getElementById("updateBtn");
const boardTitle=document.getElementById("boardTitle");
const boardContent=document.getElementById("boardContent");
const boardWriteFrm=document.getElementById("boardWriteFrm");


boardWriteFrm.addEventListener("submit", e=>{
 
    if(boardTitle.value.trim().length == 0){
        alert("제목을 수정 해주세요.");
        boardTitle.focus();
        boardTitle.value = "";
        e.preventDefault();
        return;
    }

    if(boardContent.value.trim().length == 0){
        alert("내용을 수정 해주세요.");
        boardContent.focus();
        boardContent.value="";
        e.preventDefault();
        return;
    }

    
})