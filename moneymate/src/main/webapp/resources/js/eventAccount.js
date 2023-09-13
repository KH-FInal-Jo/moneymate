const preview = document.getElementsByClassName("preview"); // 미리보기 이미지 태그
const imgInput = document.getElementsByClassName("imgInput"); // 파일 태그
const deleteImage = document.getElementsByClassName("delete-image"); // x버튼

let flag = true; // 댓글 등록 시 또 댓글 등록 못하게 !!!
// 삭제할 경우 true로 바꿔주고
// 다시 등록하는 경우엔 false로 바꿔줘야 함

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
function updateBtn(commentNo, btn){

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
    cameraImg.setAttribute("src", "/resources/images/camera1.png");

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
    cancelBtn.setAttribute("onclick", "updateCancel(this)");

    commentBtnArea.append(updateBtn, cancelBtn);

    commentRow.append(bigDiv, commentBtnArea);

    /* -------------------------------------------------------- */

    // 수정 미리보기 
    const preview1 = document.getElementsByClassName("preview1")[0]; // 미리보기
    const deleteImage1 = document.getElementsByClassName("delete-image1")[0]; // 미리보기
    const updateImg = document.getElementById("updateImg"); // 파일 태그

    updateImg.addEventListener("change", e => { // 파일 선택
        console.log(1111111)
        const file = e.target.files[0];


        if(file != undefined){ // 선택눌렀다가 취소된 게 경우가 아닐 경우

            const reader = new FileReader();

            reader.readAsDataURL(file);

            reader.onload = e => {
                preview1.setAttribute("src", e.target.result);
                deleteImage1.style.display = "block"
            }


        } else { // 선택 -> 취소 인 경우
            preview1.removeAttribute("src");
            deleteImage1.style.display = "none"
        }
    });

    // 수정 미리보기 사진 삭제하는 경우
    deleteImage1.addEventListener("click", () => {
        if(preview1.getAttribute("src") != ""){

            preview1.removeAttribute("src");

            deleteImage1.style.display = "none";

            updateImg.value="";
        }
    })



}

// 수정 취소
function updateCancel(btn){

    if(confirm("댓글 수정을 취소하시겠습니까?")){
        btn.parentElement.parentElement.innerHTML = rowContent;
    }
}

// 댓글 좋아요 백에서 진행하깅
/* const commentLike = document.getElementById("commentLike");

commentLike.addEventListener("cilck", e => {
    // 로그인 여부 검사

    let check; // 이미 좋아요 -> 0
               // 기존 빈하트 -> 1

    if(e.target.classList.contains("fa-regular")){
        check = 0;
    } else {
        check = 1;
    }

}) */

// 댓글 등록
const insertBtn = document.getElementById("insertBtn"); // 등록 버튼
const commentWrite = document.getElementById("commentWrite"); // 내용
const inputImg = document.getElementById("imgInput"); // 사진

insertBtn.addEventListener("click" , () => {

    if(loginMemberNo == ""){ // 로그인을 안 한 경우
        alert("로그인 후 이용해주세요.");
        return;
    }

    if(commentWrite.value.trim().length == 0){ // 내용 X
        alert("댓글 내용 입력 후 등록해주세요");
        commentWrite.value = "";
        commentWrite.focus();
        return;
    }

    if(inputImg.value == ""){
        alert("사진 등록은 필수입니다.");
        return;
    }

    var form = $('#commentFrm')[0];
    var formData = new FormData(form);
    $.ajax({
        type:"post",
        enctype:'multipart/form-data',
        url:'/event/account/insert',
        data:formData,
        dataType:'json',
        processData:false,
        contentType:false,
        cache:false,
        success:function(data){
            console.log("success : ", data);
        },
        error:function(e){
            console.log("error : ", e);
        }
    });







})

