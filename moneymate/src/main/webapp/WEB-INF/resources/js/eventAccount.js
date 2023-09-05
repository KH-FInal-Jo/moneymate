const preview = document.getElementsByClassName("preview"); // 미리보기 이미지 태그
const imgInput = document.getElementsByClassName("imgInput"); // 파일 태그
const deleteImage = document.getElementsByClassName("delete-image"); // x버튼

for(let i = 0; i<imgInput.length; i++){ 
    imgInput[i].addEventListener("change", e => { // 파일 선택
        const file = e.target.files[0];

        if(file != undefined){ // 선택눌렀다가 취소 게 경우가 아닐 경우

            const reader = new FileReader();

            reader.readAsDataURL(file);

            reader.onload = e => {
                preview[i].setAttribute("src", e.target.result);
                deleteImage[i].style.display = "block";
            }


        } else { // 선택 -> 취소 인 경우
            preview[i].removeAttribute("src");
        }
    });

    deleteImage[i].addEventListener("click", () => {
        if(preview[i].getAttribute("src") != ""){

            preview[i].removeAttribute("src");

            deleteImage[i].style.display = "none";

            inputImage[i].value="";
        }
    })
}

/* 댓글 수정 화면 전환 */
function updateBtn(btn){

    

}