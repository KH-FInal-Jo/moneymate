const updateBtn= document.getElementById("updateBtn");
const deleteBtn= document.getElementById("deleteBtn");
const goToList= document.getElementById("goToList");


if(updateBtn != null){

    updateBtn.addEventListener("click", ()=>{
    
        location.href 
            = location.pathname + "/update" + location.search
        
    })
}

if(deleteBtn != null){   

    deleteBtn.addEventListener("click", ()=>{
               
        if(confirm("정말로 삭제하시겠습니까?")){
            location.href 
            = location.pathname + "/delete";
        }
        alert("삭제되었습니다.");
    })
}


if(goToList != null){

    goToList.addEventListener("click", e=>{
        let url = "/community/2"

        const params = new URL(location.href).searchParams

        let cp;

        if(params.get("cp") != ""){
            // 쿼리스트링에 cp가 있을 경우
            cp = "?cp=" + params.get("cp");
        }else{
            cp = "?cp=1"
        }
    
        // 조립
        url += cp;
    
        // 검색 key, query가 존재하는 경우 url에 추가
        if(params.get("key") != null){
            const key = "&key=" + params.get("key")
            const query = "&query=" + params.get("query")
    
            url += key + query; // url뒤에 붙이기
        }
    
        location.href = url;


    })

}

// 댓글 작성
const addComment=document.getElementById("addComment");
const commentContent=document.getElementById("commentContent");

addComment.addEventListener("click", e=>{

     // 1) 로그인이 되어있나? -> 전역변수 memberNo 이용
     if(loginMemberNo == ""){ // 로그인 X
        alert("로그인 후 이용해주세요.");
        return;
    }

    // 2) 댓글 내용이 작성되어있나?
    if(commentContent.value.trim().length == 0){ // 미작성인 경우
        alert("댓글을 작성한 후 버튼을 클릭해주세요.");

        commentContent.value = ""; // 띄어쓰기, 개행문자 제거
        commentContent.focus();
        return;
    }

    // 3) AJAX를 이용해서 댓글 내용 DB에 저장(INSERT)
    const data = {"commentContent" : commentContent.value,
                    "memberNo" : loginMemberNo,
                    "boardNo" : boardNo}; //JS 객체
    
    fetch("/community/inquiry/comment",{
        method : "POST", 
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data) // JS 객체 -> JSON 파싱

    })
    .then(resp => resp.text())
    .then(result => {
        if(result > 0){ // 등록 성공
            alert("댓글이 등록되었습니다.");

            commentContent.value = ""; // 작성했던 댓글 삭제

            location.reload(true);
            // -> 새로운 댓글이 추가되어짐

        } else { // 실패
            alert("댓글 등록에 실패했습니다...");
        }
    })
    .catch(err => console.log(err));



})

// 댓글 수정

let beforeCommentRow;
function showUpdateComment(commentNo, btn){

    const temp = document.getElementsByClassName("update-textarea");

    if(temp.length > 0){ // 수정이 한 개 이상 열려 있는 경우

        if(confirm("다른 댓글이 수정 중입니다. 현재 댓글을 수정 하시겠습니까?")){ // 확인

            temp[0].parentElement.innerHTML = beforeCommentRow;
            // comment-row                       // 백업한 댓글
            // 백업 내용으로 덮어 씌워 지면서 textarea 사라짐
       
        }else{ // 취소
            return;
        }
    }

    // 1. 댓글 수정이 클릭된 행을 선택
    const commentRow = btn.parentElement.parentElement; // 수정 버튼의 부모의 부모

    // 2. 행 내용 삭제 전 현재 상태를 저장(백업) (문자열)
    //    (전역변수 이용)
    beforeCommentRow = commentRow.innerHTML;


    // 3. 댓글에 작성되어 있던 내용만 얻어오기 -> 새롭게 생성된 textarea 추가될 예정
    
    let beforeContent = commentRow.children[1].innerHTML;

    // 4. 댓글 행 내부 내용을 모두 삭제
    commentRow.innerHTML = "";

    // 5. textarea 요소 생성 + 클래스 추가  +  **내용 추가**
    const textarea = document.createElement("textarea");
    textarea.classList.add("update-textarea");

    // ******************************************
    // XSS 방지 처리 해제
    beforeContent =  beforeContent.replaceAll("&amp;", "&");
    beforeContent =  beforeContent.replaceAll("&lt;", "<");
    beforeContent =  beforeContent.replaceAll("&gt;", ">");
    beforeContent =  beforeContent.replaceAll("&quot;", "\"");

    // ******************************************
    textarea.value = beforeContent; // 내용 추가

    // 6. commentRow에 생성된 textarea 추가
    commentRow.append(textarea);

    // 7. 버튼 영역 + 수정/취소 버튼 생성
    const commentBtnArea = document.createElement("div");
    commentBtnArea.classList.add("comment-btn-area");

    const updateBtn = document.createElement("button");
    updateBtn.innerText = "수정";
    updateBtn.setAttribute("onclick", "updateComment("+commentNo+", this)");


    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.setAttribute("onclick", "updateCancel(this)");


     // 8. 버튼영역에 버튼 추가 후 
    //    commentRow(행)에 버튼영역 추가
    commentBtnArea.append(updateBtn, cancelBtn);
    commentRow.append(commentBtnArea);


}

// 댓글 수정 취소
function updateCancel(btn){
    // 매개변수 btn : 클릭된 취소 버튼
    // 전역변수 beforeCommentRow : 수정 전 원래 행(댓글)을 저장한 변수

    if(confirm("댓글 수정을 취소하시겠습니까?")){
        btn.parentElement.parentElement.innerHTML = beforeCommentRow;
    }
}


// 댓글 수정(AJAX)
function updateComment(commentNo, btn){

    // 새로 작성된 댓글 내용 얻어오기
    const commentContent = btn.parentElement.previousElementSibling.value;
    const data = {
        "commentNo" : commentNo,
        "commentContent" : commentContent
    }

    fetch("/community/inquiry/comment",{
        method : "PUT",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.text())
    .then(result => {
        if(result > 0){
            alert("댓글이 수정되었습니다.");
            location.reload(true); // 새로 고침 해주는것!
        }else{
            alert("댓글 수정 실패");
        }
    })
    .catch(err => console.log(err));

}



//-----------------------------------------------------------------------------------------
// 댓글 삭제

function deleteComment(commentNo){

    if( confirm("정말로 삭제 하시겠습니까?") ){

        fetch("/community/inquiry/comment", {
            method : "DELETE",
            headers : {"Content-Type" : "application/json"},
            body : commentNo// 값 하나 전달 시에는 JSON이 필요 없다.
        })
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                alert("삭제되었습니다");
                location.reload(true); // 목록을 다시 조회해서 삭제된 글을 제거
            }else{
                alert("삭제 실패");
            }
        })
        .catch(err => console.log(err));

    }
}
