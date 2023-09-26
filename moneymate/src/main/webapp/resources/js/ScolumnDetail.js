// console.log("Ddddddddd")

// 이전글 버튼
const previeous = document.getElementById("previous")
// 다음글 버튼
const next = document.getElementById("next")

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
    })

})

/* 좋아요 클릭 시 이벤트 */
const likeBtn = document.getElementById("likeBtn")
likeBtn.addEventListener("click", e=>{
    // console.log("눌림")

    let check;

    if(e.target.classList.contains("fa-regular")){
        // 좋아요 안눌렀을때
        check = 0;
    } else{
        // 좋아요 눌러져 있을때
        check = 1;
    }

    const data = {
        "boardNo" : boardNo,
        "memberNo" : memberNo,
        "check"   : check
    }

    fetch("/community/like", {
        method : "POST",
        headers : {"Content-type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.json())
    .then(count => {
        console.log(count)
    })
    .catch(e => {
        console.log(e)
    })







})