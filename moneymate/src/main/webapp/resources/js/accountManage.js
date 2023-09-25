$(".hover").mouseleave(
    function() {
      $(this).removeClass("hover");
    }
  );


/* $("#new").click(function(){

  // console.log(11111);

  $("#modal").css("display", "block");
  $("#main-container").css("backgroundColor", "rgba(0, 0, 0, 0.5)");
  $("#main-container").css("z-index", "100");
  $("#new").css("z-index", "auto");

}); */

$(document).ready(function() {
  
  const modal = $("#modal");
  const mainContainer = $("#main-container");

  // 모달 끄기
  mainContainer.on("click", function(e) {
    if (e.target === mainContainer[0]) {
        /* modal.css("display", "none");
        mainContainer.css("backgroundColor", "transparent");
        mainContainer.css("z-index", "0");
        $("#new").css("z-index", "100"); */

        mainContainer.css("z-index", "0");
        $("#new").css("z-index", "100")

        modal.css("opacity", 0); // 투명도를 0으로 설정하여 사라지도록 함
        mainContainer.css("opacity", 0); // 투명도를 0으로 설정하여 사라지도록 함
          setTimeout(function() {
              modal.css("display", "none");
              mainContainer.css("backgroundColor", "transparent");
          }, 300); // 애니메이션 종료 후 요소 숨김
    }
});

  // 추가 버튼을 클릭했을 때 모달 창을 보이게 합니다.
  $("#new").click(function() {
      modal.css("display", "block");
      mainContainer.css("backgroundColor", "rgba(0, 0, 0, 0.5)");

      setTimeout(function() {
        modal.css("opacity", 1); // 투명도를 1로 설정하여 나타나도록 함
        mainContainer.css("opacity", 1); // 투명도를 1로 설정하여 나타나도록 함
      }, 0);
      $("#main-container").css("z-index", "100");
      $("#new").css("z-index", "auto");
  });

  // 모달 안의 요소들이 클릭되었을 때 이벤트 전파를 막습니다.
  modal.on("click", function(e) {
      e.stopPropagation();
  });
});







/* 이메일 추가 버튼 */
const addBtn = document.getElementById("addBtn");
const addGroup = document.getElementById("add-group");
const groups = document.getElementById("groups");
const inputEmail = document.getElementsByClassName("input-email");
const checkImg = document.getElementById("check-img");
const warnImg = document.getElementById("warn-img");

let flag = true; // 유효한 경우에만 추가될 수 있게 검사      
                  // false - 가능


if(addGroup != null){

  addGroup.addEventListener("input", () => {

    /* const reqEx = /^[A-Za-z\d\-\_]{4,}@[가-힣\w\-\_]+(\.\w+){1,3}$/;

    if(reqEx.test(addGroup.value)){ // 형식 유효

      flag = false;

      checkImg.style.display = "none";
      warnImg.style.display = "block";
    } */

    fetch("/account/emailCheck",{
      method : "POST",
      headers : {"Content-Type" : "application/text"},
      body : addGroup.value
    })

    .then(resp => resp.text())

    .then(result => {
      console.log(result)
      if(result>0){ // 있는 경우에 가능 !!

        const reqEx = /^[A-Za-z\d\-\_]{4,}@[가-힣\w\-\_]+(\.\w+){1,3}$/;

        if(reqEx.test(addGroup.value)){ // 형식 유효

          flag = false;

          checkImg.style.display = "block";
          warnImg.style.display = "none";
        }

        for(let i of inputEmail){
          if(i.value == addGroup.value){
            flag = true; // 이미 입력한 이메일
            checkImg.style.display = "none";
            warnImg.style.display = "block";
            return;
          }
        }

        if(addGroup.value == loginMemberEmail){
          flag = true; // 본인 이메일
          checkImg.style.display = "none";
          warnImg.style.display = "block";
        }

        if(!flag){
          checkImg.style.display = "block";
          warnImg.style.display = "none";
        }


      } else {

        flag = true; 

        warnImg.style.display = "block";
        checkImg.style.display = "none";

        /* if(!flag){
          
          checkImg.style.display = "block";
          warnImg.style.display = "none";
  
          flag = false;
        } */
      }
    })

    .catch(e => console.log(e))

  })
}


if(addBtn!= null){
  addBtn.addEventListener("click", () => {

    
    if(!flag){

      checkImg.style.display = "none";
      warnImg.style.display = "block";
      

      // ajax로 일치하는 회원이 있는지 먼저 검사 후 다음 과정들 실행 ..
      const div1 = document.createElement("div");
      div1.classList.add("each-email");

      const input = document.createElement("input");
      input.classList.add("input-email");
      input.setAttribute("type", "text");
      input.setAttribute("name", "gEmail");
      input.setAttribute("readonly", "readonly");
      input.value = addGroup.value;

      const img = document.createElement("img");
      img.setAttribute("src", "/resources/images/close.png")
      img.classList.add("x-btn");

      div1.append(input)
      div1.append(img);

      groups.prepend(div1);

      addGroup.value = "";
      
      // x버튼이 눌렸을 경우
      const xBtns = document.querySelectorAll(".x-btn");

      xBtns.forEach(function(xBtn) {
        xBtn.addEventListener("click", function() {
            const parentDiv = this.closest(".each-email");
            if (parentDiv) {
                parentDiv.remove();
            }
        });
      });


    }else {
      addGroup.value = "";
      addGroup.focus();
    }
  })
}

// 생성하기 버튼 누를 시
const inviteFrm = document.getElementById("inviteFrm");

inviteFrm.addEventListener("submit", e => {

  const modal = $("#modal");
  const mainContainer = $("#main-container");

  mainContainer.css("z-index", "0");
  $("#new").css("z-index", "100")

  modal.css("opacity", 0); // 투명도를 0으로 설정하여 사라지도록 함
  mainContainer.css("opacity", 0); // 투명도를 0으로 설정하여 사라지도록 함
    setTimeout(function() {
        modal.css("display", "none");
        mainContainer.css("backgroundColor", "transparent");
    }, 300); // 애니메이션 종료 후 요소 숨김



    if(document.getElementById("accountName").value.trim().length == 0){
      alert("가계부 이름을 입력해주세요 !!");
      e.preventDefault();
      return;
    }



  // 가계부 만드는 코드
  const container = document.getElementById("container");
  const accountDiv = document.createElement("div");
  const newDiv = document.getElementById("new");
  const accountName = document.getElementById("accountName");
  accountDiv.classList.add("account");

  fetch("/account/make/person?name=" + accountName)

  .then(resp => resp.text())

  .then(result => {
    console.log(result);
  })

  .catch(e => console.log(e));
  
  /* const nameDiv = document.createElement("div");

  nameDiv.classList.add("name");

  const contentDiv = document.createElement("div");
  contentDiv.classList.add("content");

  const emails = document.getElementsByClassName("input-email");

  for(let e of emails){
    const userDiv = document.createElement("div");
    const emailImg = document.createElement("img");
    userDiv.classList.add("user");
    emailImg.classList.add("profile");
    const spans = document.createElement("spans");

    emailImg.setAttribute("src", "../images/id.png");
    spans.classList.add("spans")
    spans.innerText = e.value;

    userDiv.append(emailImg);
    userDiv.append(spans);
    contentDiv.append(userDiv);
  } */

  /* 버튼 */
  /* const btnDiv = document.createElement("div")
  const snipBtn = document.createElement("button");

  btnDiv.classList.add("btn-area")
  snipBtn.classList.add("snip1535");
  snipBtn.innerText="상세";

  btnDiv.append(snipBtn)

  accountDiv.append(nameDiv);
  accountDiv.append(contentDiv);
  accountDiv.append(btnDiv);

  container.insertBefore(accountDiv, newDiv);

  accountName.value = "";
  groups.innerText = ""; */

})


/* 이메일 초대 */
// 이메일 유효성 검사
