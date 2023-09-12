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

function cancelLike(boardNo){

  if(!confirm("좋아요를 취소하시겠습니까?")){
    return;
  }

  fetch("/member/mypage/likeList/cancelLike?boardNo=" + boardNo)

  .then(resp => resp.text())

  .then(result => {
    console.log(result);
  })

  .catch(e => console.log(e));

}