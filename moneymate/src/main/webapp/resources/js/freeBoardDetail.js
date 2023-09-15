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

        // 현재 게시글의 좋아요 수를 화면에 출력
        document.getElementById("likeCount").innerText = result;

    })
    .catch( e => console.log(e));



});

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