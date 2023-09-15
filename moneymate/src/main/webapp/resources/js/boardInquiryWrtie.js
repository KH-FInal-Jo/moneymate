const boardWriteFrm=document.getElementById("boardWriteFrm");

const writebtn = document.getElementById("writebtn");
const boardtitle = document.getElementsByClassName("boardTitle")[0];
const boardContent = document.getElementsByClassName("boardContent")[0];

boardWriteFrm.addEventListener("submit", e=>{

    console.log("sadasd")

    if(boardtitle.value.trim().length==0){
        alert("제목을 입력해주세요.");
        boardtitle.focus();
        boardtitle.value="";
        e.preventDefault();
        return;
    }

    if(boardContent.value.trim().length==0){
        alert("내용을 입력해주세요.");
        boardContent.focus();
        boardContent.value="";
        e.preventDefault();
        return;
    }
})