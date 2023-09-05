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

let flag = true; // 댓글 등록 시 또 댓글 등록 못하게 !!!

/* 댓글 수정 화면 전환 */
function updateBtn(btn){

    // 수정 버튼의 부모의 부모
    const commentRow = btn.parentElement.parentElement; // li

    rowContent = commentRow.innerHTML; // li의 모든 요소 저장

    let beforeContent = commentRow.children[1].children[1].innerHTML; // 내용만

    // console.log(beforeContent);
    
    let beforeImage = commentRow.children[1].children[0].getAttribute("src"); // 사진만
    
    // console.log(beforeImage);

    commentRow.innerHTML = ""; // li 요소 모두 삭제

    /* ----------------------------------------------------- */

    // 새로운 요소 추가
    const bigDiv = document.createElement("div");
    bigDiv.classList.add("writeArea1");

    const textarea = document.createElement("textarea");
    textarea.classList.add("updateWrite1");

    beforeContent =  beforeContent.replaceAll("&amp;", "&");
    beforeContent =  beforeContent.replaceAll("&lt;", "<");
    beforeContent =  beforeContent.replaceAll("&gt;", ">");
    beforeContent =  beforeContent.replaceAll("&quot;", "\"");

    textarea.value = beforeContent;
    
    const img = document.createElement("img");
    img.classList.add("preview1");
    img.setAttribute("src", beforeImage);

    const cameraImg = document.createElement("img");
    cameraImg.classList.add("camera1");
    cameraImg.setAttribute("src", "../images/camera1.png");

    const fileInput = document.createElement("input");
    fileInput.classList.add("imgInput1");
    fileInput.setAttribute("id", "updateImg");
    fileInput.setAttribute("type", "file");

    const label = document.createElement("label");
    label.setAttribute("for", "updateImg");
    label.append(cameraImg);


    // <span class="delete-image">&times;</span>
    const span = document.createElement("span");
    span.classList.add("delete-image1");
    span.innerHTML = 'X';



    bigDiv.append(span, fileInput,  label, img, textarea);



    // 수정 취소 버튼

    const commentBtnArea = document.createElement("div");
    commentBtnArea.classList.add("btn-area");
    

    const updateBtn = document.createElement("button");
    updateBtn.innerText = "수정";
    updateBtn.setAttribute("onclick", "updateComment()");


    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.setAttribute("onclick", "updateCancel()");

    commentBtnArea.append(updateBtn, cancelBtn);

    commentRow.append(bigDiv, commentBtnArea);



}