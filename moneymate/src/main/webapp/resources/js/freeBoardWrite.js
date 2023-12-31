const preview = document.getElementsByClassName("preview");
const inputImage = document.getElementsByClassName("inputImage");
const deleteImage = document.getElementsByClassName("delete-image");



for(let i = 1 ; i < inputImage.length ; i++){
    
    inputImage[i].addEventListener("change", e => {
        if(inputImage[0].value == ""){
            alert("첫번째 항목부터 그림을 첨부해주세요.");
            inputImage[i].value = "";
            preview[i].removeAttribute("src");

        }
    });
}

for(let i = 0 ; i < inputImage.length ; i++){

    inputImage[i].addEventListener("change", e => {

        const file = e.target.files[0]; 

        if(file != undefined){ 
            
            const reader = new FileReader(); 

            reader.readAsDataURL(file);

            reader.onload = e =>{ 
                preview[i].setAttribute("src", e.target.result);
            }
        } else { 
            preview[i].removeAttribute("src");
        }
    });

    deleteImage[i].addEventListener("click", () => {

        if(preview[i].getAttribute("src") != ""){

            preview[i].removeAttribute("src");

            inputImage[i].value="";
        }
    });
}

const boardWriteFrm = document.getElementById("boardWriteFrm");
const boardTitle = document.getElementById("boardTitle");
const boardContent = document.getElementById("boardContent");

boardWriteFrm.addEventListener("submit", e=>{
    if(boardTitle.value.trim().length == 0){
        alert("제목을 입력해주세요.");
        boardTitle.focus();
        boardTitle.value="";
        e.preventDefault();
        return;
    }
    if(boardContent.value.trim().length == 0){
        alert("내용을 입력해주세요.");
        boardContent.focus();
        boardContent.value="";
        e.preventDefault();
        return;
    }
})





