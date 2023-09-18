const NoticeWriteBtn = document.getElementById("NoticeWriteBtn");

if(NoticeWriteBtn != null){
    NoticeWriteBtn.addEventListener("click", () => {

        location.href = `/community/${location.pathname.split("/")[2]}/insert`
    
    })

}





// 상세조회, 게시글 작성 - 목록으로 버튼
(function() {
	const goToListBtn = document.getElementById("goToBtn");
	if (goToListBtn != null) {

		goToListBtn.addEventListener("click", function() {


			const pathname = location.pathname; 

			let url = pathname.substring(0, pathname.indexOf("/", 1));

			url += "/1" 

			location.href = url;
		});
	}
})();

//  즉시 실행 함수 : 성능 up, 변수명 중복 X
(function(){

    const deleteBtn = document.getElementById("deleteBtn"); // 존재하지 않으면 null

    if(deleteBtn != null){ // 버튼이 화면에 존재할 때만
        deleteBtn.addEventListener("click", function(){

            const url = window.location.href; // 현재 페이지의 URL
            const parts = url.split("/"); // URL을 "/"로 분할하여 배열로 저장
            const boardNo = parts[parts.length - 1]; // 배열의 마지막 요소를 가져와서 boardNo 변수에 저장

            let rurl = "/community/1/" +boardNo+ "/delete" ;

            console.log("boardNo:", boardNo); // 추출한 boardNo를 콘솔에 출력 (테스트용)


            if(confirm("정말로 삭제하시겠습니까?")){
                location.href = rurl; // get방식으로 url에 요청
            }
        });
    }
})();


/* 게시글 수정 ㅜㅜ */
function goBack() {
    const boardNo = getBoardNo(); 

    const form = document.getElementById("board-form");

    if (boardNo) {
        form.action = `/community/${boardCode}/${boardNo}/update`;
    } else {
        form.action = `/community/${boardCode}/insert`;
    }

    form.submit();
}

function getBoardNo() {
    const url = window.location.href;
    const match = url.match(/\/community\/\w+\/(\d+)/);

    if (match && match[1]) {
        return match[1];
    }

    return null;
}

const board = document.getElementsByClassName("board-notice-detail-container")[0];

  

