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