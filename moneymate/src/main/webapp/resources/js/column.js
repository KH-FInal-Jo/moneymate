
// // 모든 칼럼 숨김
// $('.column-area > div').hide();
// // 첫번째 칼럼부터 6번째 칼럼까지는 보이게
// $(".column-area > div").slice(0, 12).css("display", "flex"); 
// // 더보기 버튼 클릭시 실행 함수
// $("#load").click(function(e){
//     // 숨겨져있는 칼럼 중 여섯개 단위로 fadeIn 효과를 줘서 나타나게함
//    $(".column-area >div:hidden").slice(0, 12).show(200) // 클릭시 more 갯수 지저정
//    if($(".column-area >div:hidden").length == 0){ // 컨텐츠 남아있는지 확인
//        $('#load').fadeOut(100); // 컨텐츠 없을 시 버튼 사라짐
//    }
// });

// 칼럼 글
const columns = document.querySelectorAll(".column-area");
// 더보기 버튼
const loadButton = document.getElementById("load");
// 글쓰기 버튼
writeBtn = document.getElementById("Swrite")


writeBtn.style.display = 'none'
// 관리자일 때만 글쓰기 보이기
if(memberNo == 1){
    writeBtn.style.display = 'block'
}

loadButton.style.display = 'none'

// 초기에 처음 6개의 칼럼을 보이게 함
for (let i = 6; i < columns.length; i++) {
    columns[i].style.display = 'none';
    loadButton.style.display = 'flex'
}

let visibleItemCount = 6; // 현재 보이는 게시글 수
let totalItemCount = columns.length; // 전체 게시글 수

console.log(totalItemCount);

loadButton.addEventListener("click", function() {
    // 숨겨진 칼럼 중 2개씩 보이게 함
    for (let i = visibleItemCount; i < visibleItemCount + 6; i++) {
        if (i >= totalItemCount) {
            loadButton.style.display = "none"; // 더 이상 게시글이 없으면 버튼 숨기기
            break;
        }
        columns[i].style.display = "flex"; // 새로운 칼럼을 보이게 함
    }
    visibleItemCount += 6; // 더보기를 클릭할 때 2개의 게시글 더 보이도록
});
