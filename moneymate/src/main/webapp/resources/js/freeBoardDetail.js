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
