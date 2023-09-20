const like = document.querySelector(".like-area");

like.addEventListener("click", (e) => {
    console.log("-");

    if(loginMemberNo == ""){
        alert("로그인 후 이용해주세요");
        return;
    }

    let check;
    if(e.target.classList.contains("fa-regular")){ // 빈 하트 (좋아요 X)
        check = 0;
    } else { // 꽉 찬 하트 (좋아요 O)
        check = 1;
    }

    const data = { "boardNo" : boardNo,
                    "memberNo" : loginMemberNo,
                    "check" : check};


    fetch("/community/like", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.text())
    .then(result => {

        if(result == -1){ // insert 혹은 delete 실패
            console.log("좋아요 처리 실패");
            return;
        }

        // toggle() : class가 있으면 없애고, 없으면 추가하고 
        e.target.classList.toggle("fa-regular");
        e.target.classList.toggle("fa-solid");
        e.target.classList.add("red");

        // 현재 게시글의 좋아요 수를 화면에 출력
        document.getElementById("likeCount").innerText = result;

    })
    .catch( e => console.log(e));



});


function reportMember(boardNo, loginMemberNo){

    const data = {
        "boardNo" : boardNo,
        "memberNo" : loginMemberNo
    }
    
    
    fetch("/admin/reportManage/dupCheck", {
        method : 'POST',
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.text())
    .then(count => {
        if(count == 0){
            location.href = "/community/report?boardNo="+boardNo;
        } else{
            alert("같은 게시글을 중복 신고할 수 없습니다.");
        }
    })
    .catch();





}


// 회원 신고하기 
const memberNickname = document.getElementById("memberNickname");
const report = document.getElementById("report");
const likeArea = document.getElementById("likeArea");

memberNickname.addEventListener("click", function(){

    const report = document.getElementsByClassName("report");

    const reportBtn = document.createElement("button");
    reportBtn.innerText = "신고하기";
    reportBtn.setAttribute("onclick", "reportMember("+boardNo+","+loginMemberNo+", this)");
    reportBtn.classList.add("report");
    memberNickname.append(reportBtn);

    if(report.length > 0){

        if(true){
            report[0].nextElementSibling.remove(); 
            report[0].remove();
        
        } else{
            return;
        }
    }
    
})




const updateBtn = document.getElementById("updateBtn");

if(updateBtn != null){
    updateBtn.addEventListener("click", () => {
        location.href = location.pathname
                      + "/update" 
                      + location.search; 
    });
}



const deleteBtn = document.getElementById("deleteBtn");

if(deleteBtn != null){

    // 게시글 삭제 버튼이 클릭 되었을 때
    deleteBtn.addEventListener("click", () => {
    
        if(confirm("정말 삭제 하시겠습니까?")){
            location.href 
            = location.pathname
                + "/delete";
        }
    })
}


// 목록으로 버튼
const goToListBtn = document.getElementById("goToListBtn");


goToListBtn.addEventListener("click", ()=> {


    // 이동할 주소 저장
    let url = "/community/3" 

    // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
    // URL.searchParams : 쿼리스트링만 별도 객체로 반환

    const params = new URL(location.href).searchParams;

    let cp;
    if(params.get("cp") != ""){ // 쿼리 스트링에 cp가 있을 경우
        cp = "?cp=" + params.get("cp");
    } else{
        cp="?cp=1";
    }

    // 조립
    url += cp;

    // 검색 key, query가 존재하는 경우 url에 추가
    if(params.get("sel") != null){
        const sel = "&sel=" + params.get("sel");
        const query = "&query=" + params.get("query");

        url += sel + query; // url 뒤에 붙이기
    }
    
    location.href = url;

})


// 댓글 조회
function selectCommentList() {
    fetch("/community/comment?boardNo=" + boardNo)
    .then(resp => resp.json())
    .then(cList => {
        console.log("댓글불러오기성공");
        const commentList = document.getElementById("commentList"); // ul태그
        commentList.innerHTML = "";

        for(let comment of cList){
            const commentRow = document.createElement("li");
            commentRow.classList.add("comment-row");

            if(comment.parentNo != 0){
                commentRow.classList.add("child-comment");
            }

            const commentWriter = document.createElement("p");
            commentWriter.classList.add("comment-writer");


            const profileImage = document.createElement("img");

            if( comment.profileImage != null ){ 
                profileImage.setAttribute("src", comment.profileImage);
            }else{ 
                profileImage.setAttribute("src", "/resources/images/id.png");
            }

            const memberNickname = document.createElement("span");
            memberNickname.innerText = comment.memberNickname;

            const commentDate = document.createElement("span");
            commentDate.classList.add("comment-date");
            commentDate.innerText =  "(" + comment.commentCreateDate + ")";

            commentWriter.append(profileImage , memberNickname , commentDate);

            const commentContent = document.createElement("p");
            commentContent.classList.add("comment-content");
            commentContent.innerHTML = comment.commentContent;

            commentRow.append(commentWriter, commentContent);

            if(loginMemberNo != ""){

                const commentBtnArea = document.createElement("div");
                commentBtnArea.classList.add("comment-btn-area");

                const childCommentBtn = document.createElement("button");
                childCommentBtn.setAttribute("onclick", "showInsertComment("+comment.commentNo+", this)");
                childCommentBtn.innerText = "답글";

                commentBtnArea.append(childCommentBtn);
                if(loginMemberNo == comment.memberNo){
                    const updateBtn = document.createElement("button");
                    updateBtn.innerText = "수정";

                    updateBtn.setAttribute("onclick", "showUpdateComment("+comment.commentNo+", this)");                        


                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "삭제";

                    deleteBtn.setAttribute("onclick", "deleteComment("+comment.commentNo+")");                       

                    commentBtnArea.append(updateBtn, deleteBtn);

                }

                commentRow.append(commentBtnArea); 
            }

            commentList.append(commentRow);

        }
    })
    .catch(err => console.log("오류발생"));
}



// 댓글 등록
const addComment = document.getElementById("addComment");
const commentContent = document.getElementById("commentContent");

addComment.addEventListener("click", e => {
    if(loginMemberNo == ""){ 
        alert("로그인 후 이용해주세요.");
        return;
    }

    if(commentContent.value.trim().length == 0){ 
        alert("댓글을 작성한 후 버튼을 클릭해주세요.");

        commentContent.value = "";
        commentContent.focus();
        return;
    }

    const data = {
        "commentContent" : commentContent.value,
                    "memberNo"       : loginMemberNo,
                    "boardNo"        : boardNo 
    };

    fetch("/community/comment", {
        method : 'post',
        headers : {"content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.text())
    .then(result => {
        if(result > 0){
            alert("댓글 등록 성공!");

            commentContent.value = "";

            selectCommentList();
        } else{
            alert("댓글 등록 실패");
        }
    })
    .catch(e => console.log(e));
});




// 댓글 삭제
function deleteComment(commentNo) {
    if(confirm("정말 삭제 하겠습니까?")){
        fetch("/community/comment", {
            method : 'DELETE',
            headers : {"content-Type" : "application/json"},
            body : commentNo 
        })
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                alert("삭제되었습니다.");
                selectCommentList();

            } else {
                alert("삭제 실패");
            }

        })
        .catch(console.log("오류발생"));
    }
}



// 댓글 수정
let beforeCommentRow;

function showUpdateComment(commentNo, btn){

    const temp = document.getElementsByClassName("update-textarea");  

    if(temp.length > 0){ // 수정이 한 개 이상 열려 있는 경우

        if(confirm("다른 댓글이 수정 중입니다. 현재 댓글을 수정 하시겠습니까?")){ // 확인

            temp[0].parentElement.innerHTML = beforeCommentRow;
        }else{ 
            return;
        }
    }


    const commentRow = btn.parentElement.parentElement; // 댓글 하나전부

    beforeCommentRow = commentRow.innerHTML;

    let beforeContent = commentRow.children[1].innerHTML;

    commentRow.innerHTML = "";

    const textarea = document.createElement("textarea");
    textarea.classList.add("update-textarea");

    beforeContent =  beforeContent.replaceAll("&amp;", "&");
    beforeContent =  beforeContent.replaceAll("&lt;", "<");
    beforeContent =  beforeContent.replaceAll("&gt;", ">");
    beforeContent =  beforeContent.replaceAll("&quot;", "\"");

    textarea.value = beforeContent;

    commentRow.append(textarea);

    const commentBtnArea = document.createElement("div");
    commentBtnArea.classList.add("comment-btn-area");

    const updateBtn = document.createElement("button");
    updateBtn.innerText = "수정";
    updateBtn.setAttribute("onclick", "updateComment("+commentNo+", this)");

    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.setAttribute("onclick", "updateCancel(this)");

    commentBtnArea.append(updateBtn, cancelBtn);
    commentRow.append(commentBtnArea);

};

function updateCancel(btn){
    if(confirm("댓글 수정을 취소하시겠습니까?")){
        btn.parentElement.parentElement.innerHTML = beforeCommentRow;
    }
}


// 찐 댓글 수정
function updateComment(commentNo, btn) {

    const commentContent = btn.parentElement.previousElementSibling.value; // 썻던 내용

    const data = {
        "commentNo" : commentNo,
        "commentContent" : commentContent
    }

    fetch("/community/comment", {
        method : 'put',
        headers : {"content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.text())
    .then(result => {
        if(result > 0){
            alert("댓글이 수정되었습니다.");
            selectCommentList();
        } else {
            alert("댓글 수정 실패");
        }

    })

    .catch(console.log("수정 중 오류 발생"));
}


// 대댓글 작성하기 누를 떄 칸만들기
function showInsertComment(parentNo, btn){
    
    const temp = document.getElementsByClassName("commentInsertContent");

    if(temp.length > 0){

        if(confirm("다른 답글을 작성 중입니다. 현재 댓글에 답글을 작성 하시겠습니까?")){
            temp[0].nextElementSibling.remove(); 
            temp[0].remove();
        
        } else{
            return;
        }
    }
    const textarea = document.createElement("textarea");
    textarea.classList.add("commentInsertContent"); 

    btn.parentElement.after(textarea);

    const commentBtnArea = document.createElement("div");
    commentBtnArea.classList.add("comment-btn-area");

    const insertBtn = document.createElement("button");
    insertBtn.innerText = "등록";
    insertBtn.setAttribute("onclick", "insertChildComment("+parentNo+", this)");

    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.setAttribute("onclick", "insertCancel(this)");

    commentBtnArea.append(insertBtn, cancelBtn);

    textarea.after(commentBtnArea);
    
}


// 대댓글 취소
function insertCancel(btn){
    btn.parentElement.previousElementSibling.remove();
    btn.parentElement.remove();
}

// 대댓글 작성
function insertChildComment(parentNo, btn){
    const commentContent = btn.parentElement.previousElementSibling.value;

    if(commentContent.trim().length == 0){
        alert("답글 작성 후 등록 버튼을 클릭해주세요.");
        btn.parentElement.previousElementSibling.value = "";
        btn.parentElement.previousElementSibling.focus();
        return;
    }

    const data = {"commentContent" : commentContent,
                    "memberNo" : loginMemberNo,
                    "boardNo" : boardNo,
                    "parentNo" : parentNo
                }



    fetch("/community/comment" , {
        method : "POST",
        headers : {"content-Type" : "application/json"},
        body : JSON.stringify(data)

    })
    .then(resp => resp.text())
    .then(result => {
        if(result > 0){
            alert("답글이 등록되었습니다.");
            selectCommentList();

        } else {
            alert("답글 등록에 실패했습니다...");
        }
    })
    .catch(err => console.log(err));

}