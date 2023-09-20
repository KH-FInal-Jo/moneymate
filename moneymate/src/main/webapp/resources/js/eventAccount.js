const preview = document.getElementsByClassName("preview"); // 미리보기 이미지 태그
const imgInput = document.getElementsByClassName("imgInput"); // 파일 태그
const deleteImage = document.getElementsByClassName("delete-image"); // x버튼

const deleteImg = document.getElementsByClassName("delete-image1"); // 수정 x버튼
const updateImg11 = document.getElementsByClassName("imgInput1"); // 수정 파일

let chk = 1; // 이미지 삭제한 경우 고려

let flag = true; // 댓글 등록 시 또 댓글 등록 못하게 !!!
// 삭제할 경우 true로 바꿔주고
// 다시 등록하는 경우엔 false로 바꿔줘야 함

function selectList(){
    fetch("/event/account/comment")

    .then(resp => resp.json())

    .then(cList => {
        // console.log(cList)
        const commentList = document.getElementById("commentList");
        commentList.innerHTML = ""; // 큰 ul 비우기

        for(let comment of cList){

            if(comment.memberNo == loginMemberNo){
                flag = false;
            }

            const li = document.createElement("li");
            li.classList.add("comment-li");

            const p = document.createElement("p");
            p.classList.add("writer");
            
            const profileImg = document.createElement("img");

            if( comment.profileImage != null ){ // 프로필 이미지가 있을 경우
                profileImg.setAttribute("src", comment.profileImage);
            }else{ // 없을 경우 == 기본이미지
                profileImg.setAttribute("src", "/resources/images/id.png");
            }
            
            const nickSpan = document.createElement("span");
            nickSpan.innerHTML = comment.memberNickname;
            
            const wDate = document.createElement("span");
            wDate.classList.add("writeDate");
            wDate.innerHTML = comment.commentCreateDate;

            p.append(profileImg, nickSpan, wDate);

            /* --------- */

            const cDiv = document.createElement("div");
            cDiv.classList.add("comment-area"); 

            const contentImg = document.createElement("img");
            contentImg.classList.add("contentImg");
            contentImg.setAttribute("src", comment.commentImage);

            const pContent = document.createElement("p");
            pContent.classList.add("contentArea");
            pContent.innerHTML = comment.commentContent;

            const lDiv = document.createElement("div");
            lDiv.classList.add("likeArea");

            const likeI = document.createElement("i");
            likeI.setAttribute("onclick", "updateLike("+comment.commentNo+", this)");

            if( comment.likeCheck == 1 ){ // 좋아요 되어 있는 경우
                likeI.classList.add("fa-solid", "fa-heart", "commentLike");
            }else{ // 빈 하트
                likeI.classList.add("fa-regular", "fa-heart", "commentLike");
            }

            const countSpan = document.createElement("span");
            countSpan.innerHTML = comment.likeCount;

            lDiv.append(likeI, countSpan);

            cDiv.append(contentImg, pContent, lDiv);

            /* -------------- */

            const bDiv = document.createElement("div");
            bDiv.classList.add("btn-area"); 

            const updateBtn = document.createElement("button");
            updateBtn.innerText = "수정";

            updateBtn.setAttribute("onclick", "updateBtn("+comment.commentNo+", this)");                        

            const deleteBtn = document.createElement("button");
            deleteBtn.innerText = "삭제";

            deleteBtn.setAttribute("onclick", "deleteBtn("+comment.commentNo+")");  
            
            bDiv.append(updateBtn, deleteBtn);

            /* -------------- */

            li.append(p, cDiv, bDiv);

            commentList.append(li)
        }

    })

    .catch(e => console.log(e));
}




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
    const updateFrm = document.createElement("form");
    updateFrm.setAttribute("id", "updateFrm");
    const bigDiv = document.createElement("div");
    bigDiv.classList.add("writeArea1");

    const textarea = document.createElement("textarea");
    textarea.setAttribute("name", "updateContent");
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
    fileInput.setAttribute("name", "updateFile");

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
    updateBtn.setAttribute("onclick", "updateComment(" +commentNo+ ", this, event)");


    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.setAttribute("type", "button");
    cancelBtn.setAttribute("onclick", "updateCancel(this)");

    commentBtnArea.append(updateBtn, cancelBtn);

    updateFrm.append(bigDiv, commentBtnArea)

    commentRow.append(updateFrm);

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

    // 댓글 수정
    
    
    /* const deleteImg = document.getElementsByClassName("delete-image1");
    const updateImg11 = document.getElementsByClassName("imgInput1"); */
    
    
    
    if(deleteImg[0] != null){
    
        for(let i = 0; i<deleteImg.length; i++){
            deleteImg[i].addEventListener("click", () => {
                chk = 0; // x 버튼 눌렀을 경우
            })
            
        }
    
    }

    for(let i = 0; i<updateImg11.length; i++){ // x버튼 누른 후 다시 사진 등록했을 때
        updateImg11[i].addEventListener("change", e => {
            chk = 2;
        })
    }
}

/* if(document.getElementById("updateFrm") != null){
    document.getElementById("updateFrm").addEventListener("submit", e=>{
        e.preventDefault();
    })

} */




function updateComment(commentNo, btn, event){

    event.preventDefault();

    // 내용, 사진 얻어오기
    const cImage = btn.parentElement.previousElementSibling.children[3].getAttribute("src");
    const cContent = btn.parentElement.previousElementSibling.children[4].value;

    if(cContent == ""){
        alert("댓글 내용 작성 후 등록해주세요.");
        return;
    }

    if(chk == 0){
        alert("사진 등록은 필수입니다.");
        return;
    }

    // 비동기 처리
    var form = $('#updateFrm')[0];
    var formData = new FormData(form);

    formData.append('commentNo', commentNo);
    $.ajax({
        type:"post",
        enctype:'multipart/form-data',
        url:'/event/account/update',
        data:formData,
        dataType:'json',
        processData:false,
        contentType:false,
        cache:false,
        success:function(result){
            console.log("success : ", result);
            alert("수정되었습니다.")
            selectList();
        },
        error:function(e){
            console.log("error : ", e);
        }
    });
    
    // 마지막에 화면 비동기 처리

    
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

if(document.getElementById("commentFrm") != null){
    const temp = document.getElementById("commentFrm").innerHTML;

}


// 댓글 등록
const insertBtn = document.getElementById("insertBtn"); // 등록 버튼
const commentWrite = document.getElementById("commentWrite"); // 내용
const inputImg = document.getElementById("imgInput"); // 사진

if(insertBtn != null){
    insertBtn.addEventListener("click" , (e) => {
    
        e.preventDefault();
    
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
                
                commentWrite.value = "";
                inputImg.value = "";
                document.getElementById("pre").setAttribute("src", "");
                deleteImage[0].style.display = 'none';
    
                document.getElementById("commentFrm").innerHTML = "";
    
                alert("등록되었습니다.")
                selectList();
    
                return;
            },
            error:function(e){
                console.log("error : ", e);
            }
        });
    
    });

}



// 좋아요
function updateLike(commentNo, btn){

    console.log(commentNo)

    if(loginMemberNo == ""){
        alert("로그인 후 이용해주세요");
        return;
    }

    let check;

    if(btn.classList.contains("fa-regular")){ // 빈 하트인 경우
        check = 0;
    } else { // 좋아요가 되어있는 경우
        check = 1;
    }

    const data = {
        "commentNo" : commentNo,
        "memberNo" : loginMemberNo,
        "likeCheck" : check
    }

    fetch("/event/account/like", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })

    .then(resp => resp.text())

    .then(count => {
        if(count == -1){
            console.log("좋아요 처리 실패(-1)");
            return;
        }

        btn.classList.toggle("fa-regular");
        btn.classList.toggle("fa-solid");

        btn.nextElementSibling.innerText = count;
    })

    .catch(e => console.log(e))
}


// 댓글 삭제
function deleteBtn(commentNo){
    if(!confirm("댓글을 삭제하시겠습니까?")){
        return;
    }

    
    fetch("/event/account/delete?no=" + commentNo)

    .then(resp => resp.text())

    .then(result => {
        console.log(result);
        
        flag = true;

        alert("삭제되었습니다.")

        //document.getElementById("commentFrm").innerHTML = temp;

        location.reload(true);
        

       /* const reFrm = document.createElement("form");
       reFrm.setAttribute("id", "commentFrm");
       reFrm.setAttribute("action", "#");

       const reDiv = document.createElement("div")
       reDiv.classList.add("writeArea")

       const reInput = document.createElement("input")
       reInput.setAttribute("type", "file");
       reInput.setAttribute("class", "imgInput");
       reInput.setAttribute("id", "imgInput");
       reInput.setAttribute("name", "commentImage");
       
       const reLabel = document.createElement("label")
       reLabel.setAttribute("for", "imgInput");
       
       const reImg = document.createElement("img")
       reImg.setAttribute("src", "/resources/images/camera1.png");
       reImg.setAttribute("class", "camera");
       
       const rereImg = document.createElement("img");
       rereImg.setAttribute("id", "pre");
       rereImg.setAttribute("class", "preview");

       const reButton = document.createElement("button");
       reButton.innerText="등록"
       reButton.setAttribute("id", "insertBtn");

       const reSpan = document.createElement("span")
       reSpan.classList.add("delete-image");
       reSpan.innerHTML = "X"

       const reText = document.createElement("textarea");
       reText.setAttribute("id", "commentWrite");
       reText.setAttribute("name", "commentContent");

       reLabel.append(reImg);
        reDiv.append(reInput, reLabel, rereImg, reButton, reSpan, reText);
        reFrm.appendChild(reDiv);

        document.getElementById("main").append(reFrm); */

        //selectList();
        

    })

    .catch(e => console.log(e))
}

// 이벤트 위임을 사용하여 main 부모 요소에 이벤트 리스너를 추가합니다.
document.getElementById("main").addEventListener("click", function (event) {
    const target = event.target;

    // 등록 버튼 클릭 이벤트 처리
    if (target && target.id === "insertBtn") {
        e.preventDefault();

        if (loginMemberNo === "") {
            alert("로그인 후 이용해주세요.");
            return;
        }

        const commentWrite = target.parentElement.querySelector("#commentWrite");
        const inputImg = target.parentElement.querySelector("#imgInput");

        if (commentWrite.value.trim().length === 0) {
            alert("댓글 내용 입력 후 등록해주세요.");
            commentWrite.value = "";
            commentWrite.focus();
            return;
        }

        if (inputImg.value === "") {
            alert("사진 등록은 필수입니다.");
            return;
        }

        // 나머지 코드 추가 (Ajax 호출 등)
    }

    // 삭제 버튼 클릭 이벤트 처리
    if (target && target.classList.contains("delete-image")) {
        const preview = target.parentElement.querySelector(".preview");
        const imgInput = target.parentElement.querySelector(".imgInput");

        if (preview.getAttribute("src") !== "") {
            preview.removeAttribute("src");
            imgInput.value = "";
            target.style.display = "none";
        }
    }

    // 수정 버튼 클릭 이벤트 처리
    if (target && target.innerText === "수정") {
        const commentRow = target.parentElement.parentElement;
        const commentNo = commentRow.dataset.commentNo;

        // 나머지 수정 버튼 클릭 이벤트 처리 코드 추가
    }

    // 기타 이벤트 처리 (좋아요 등)

});
