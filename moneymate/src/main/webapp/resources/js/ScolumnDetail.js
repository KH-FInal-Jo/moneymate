// console.log("Ddddddddd")

// 이전글 버튼
const previeous = document.getElementById("previous")
// 다음글 버튼
const next = document.getElementById("next")

// 삭제하기 버튼
const deleteBtn = document.getElementById("delete-btn")

previeous.addEventListener("click", ()=>{

    // 현재 URL을 가져오기
    // http://localhost/community/4/9
    let url = window.location.href;

    // URL을 "/"문자로 분할하여 배열로 저장
    let urlParts = url.split("/")
    console.log(urlParts)
    // = ['http:', '', 'localhost', 'community', '4', '9']

    // urlParts[5] == 9
    let boardNo = urlParts[urlParts.length - 1]

    // console.log(boardNo)

    fetch(`/community/previous?boardNo=${boardNo}`)
    .then(resp => resp.json())
    .then(result => {
        console.log(result)

        location.href = '/community/4/' + result

    })
    .catch(e => {
        console.log(e)
        alert("첫번째 게시글 입니다.")
    })

})

next.addEventListener("click", ()=>{

    // 현재 URL을 가져오기
    // http://localhost/community/4/9
    let url = window.location.href;

    // URL을 "/"문자로 분할하여 배열로 저장
    let urlParts = url.split("/")
    console.log(urlParts)
    // = ['http:', '', 'localhost', 'community', '4', '9']

    // urlParts[5] == 9
    let boardNo = urlParts[urlParts.length - 1]

    // console.log(boardNo)

    fetch(`/community/next?boardNo=${boardNo}`)
    .then(resp => resp.json())
    .then(result => {
        console.log(result)


        location.href = '/community/4/' + result

    })
    .catch(e => {
        console.log(e)
        alert("마지막 게시글 입니다.")
    })

})

// 삭제하기 버튼 누를 시
deleteBtn.addEventListener("click", ()=>{

    if(confirm("게시글을 삭제하시겠습니까?")){

        // 현재 URL을 가져오기
        // http://localhost/community/4/9
        let url = window.location.href;
    
        // URL을 "/"문자로 분할하여 배열로 저장
        let urlParts = url.split("/")
        console.log(urlParts)
        // = ['http:', '', 'localhost', 'community', '4', '9']
    
        // urlParts[5] == 9
        let boardNo = urlParts[urlParts.length - 1]
    
        // console.log(boardNo)
    
        fetch(`/community/columnDelete?boardNo=${boardNo}`)
        .then(resp => resp.json())
        .then(result => {
            console.log(result)
    
            if(result > 0){
    
                alert("게시글이 삭제되었습니다.")
            }
    
            location.href = '/community/4/'
    
    
    
        })
        .catch(e => {
            console.log(e)
        })
    }

})


/* 좋아요 클릭 시 이벤트 */
const likeBtn = document.getElementById("likeBtn")
const boardLike = document.getElementById("boardLike")
boardLike.addEventListener("click", e=>{
    // console.log("눌림")

    let check;

    if(e.target.classList.contains("fa-regular")){
        // 좋아요 안눌러져 있을 때
        check = 0;
    } else{
        // 좋아요 눌러져 있을 때
        check = 1;
    }

    const data = {
        "boardNo" : boardNo,
        "memberNo" : memberNo,
        "check"   : check
    }

    fetch("/community/4/like", {
        method : "POST",
        headers : {"Content-type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.json())
    .then(count => {
        console.log(count)

        if(count == -1){
            console.log("좋아요 처리 실패")
            return;
        }

        // toggle : 클래스가 있으면 없애고, 없으면 추가하고
        e.target.classList.toggle("fa-regular")
        e.target.classList.toggle("fa-solid")

        // 좋아요 수 업데이트
        e.target.nextElementSibling.innerText = count;

    })
    .catch(e => {
        console.log(e)
    })







})