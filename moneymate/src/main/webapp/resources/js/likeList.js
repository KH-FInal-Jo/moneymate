const btn = document.querySelector('.btn-select');
const list = document.querySelector('.list-member');
btn.addEventListener('click', () => {
  btn.classList.toggle('on');
});
list.addEventListener('click', (event) => {
  if (event.target.nodeName === "BUTTON") {
    btn.innerText = event.target.innerText;
    btn.classList.remove('on');
  }
});

(function(){
  if(location.pathname.split("/")[4] == 0){
    document.getElementById("realBtn").innerHTML = "전체"
  }
  if(location.pathname.split("/")[4] == 3){
    document.getElementById("realBtn").innerHTML = "자유게시판"
  }
  if(location.pathname.split("/")[4] == 4){
    document.getElementById("realBtn").innerHTML = "컬럼게시판"
  }
})();

/* 선택하면 유지되게 수정해조 */

/* function cancelLike(boardNo){

  if(!confirm("좋아요를 취소하시겠습니까?")){
    return;
  }

  fetch("/member/mypage/likeList/cancelLike?boardNo=" + boardNo)

  .then(resp => resp.text())

  .then(result => {
    console.log(result);
  })

  .catch(e => console.log(e));

} */