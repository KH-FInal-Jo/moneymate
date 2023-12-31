// 사진첨부
const inputImages = document.querySelectorAll(".inputImage");

// div text 부분
const textArea = document.getElementById("text");

window.onload = function () {
  textArea.scrollTop = textArea.scrollHeight;
};




// 파일을 저장할 배열 생성
let selectedFiles = [];


//input 요소와 버튼 요소 가져오기
// const fileInput = document.getElementById('fileInput');

// // 파일 선택 시 이벤트 처리
// fileInput.addEventListener('change', () => {
//     const files = fileInput.files;
  
//     // 선택한 파일을 배열에 추가
//     for (let i = 0; i < files.length; i++) {
//         selectedFiles.push(files[i].name);
    
//       }
    
    
    
//     });
    
const formData = new FormData();


/* 글 제목 input */
const cTitle = document.getElementById("Wtitle")


console.log(cTitle.value.trim().length)



for (let i = 0; i < inputImages.length; i++) {
  // 파일이 선택되거나 선택 후 취소되었을 때
  inputImages[i].addEventListener("change", (e) => {
    const files = e.target.files; // 선택된 파일의 데이터 배열
    
    for (let j = 0; j < files.length; j++) {
      const file = files[j];
      console.log(file)
      
      if (file != undefined) {
        const div = document.createElement("div");
        const content = document.createElement("textarea")
        content.classList.add("content")
        const img = document.createElement("img");
        img.classList.add("text-img")
        
        const reader = new FileReader(); // 파일을 읽는 객체

        reader.readAsDataURL(file);
        // reader.readAsDataURL(file)를 통해 파일을 읽은 후, 
        //읽은 데이터는 reader.onload 이벤트 핸들러 내에서 사용할 수 있는 e.target.result에 저장됩니다. 
        //  readAsDataURL를 사용하면 해당 이미지 파일을 데이터 URL로 읽어와서 웹 페이지에서 이미지로 표시할 수 있습니다.
        // 지정된 파일을 읽은 후 result 변수에 URL 형식으로 저장


        reader.onload = (e) => {
          img.setAttribute("src", e.target.result)
        };

        div.append(img,content);
        textArea.append(div);

        // 파일을 FormData에 추가 (images[] 배열에 추가)
        formData.append("images", file);
      }
    }
  });
}

// 등록 버튼 ajax
const registerBtn = document.getElementById("finish");

registerBtn.addEventListener("click", () => {
    console.log("눌림")
    const textArea = document.getElementById("text");
    const boardTitle = document.getElementById("Wtitle").value;
  // content div 요소들을 가져옵니다.
  const contentDivs = document.getElementsByClassName("content");
  console.log(contentDivs)

  // content div 안의 내용을 저장할 배열을 생성합니다.
  const contentArray = [];
  // console.log(contentArray)

  // 각 content div의 내용을 가져와서 배열에 추가합니다.
  for (let i = 0; i < contentDivs.length; i++) {
    const content = contentDivs[i].value;
    // contentArray.push(content);
    console.log(content);

    contentArray.push(content)
  }
  /* 구분자 줘서 DB로 전송 */
  const boardContent = contentArray.join('^^^')
  console.log(boardContent)
  formData.append("boardContent", boardContent)

  // contentArray 배열에는 각 content div 안의 내용이 저장됩니다.


    // 글제목과 글내용을 FormData에 추가
    formData.append("boardTitle", boardTitle);

    // fetch를 사용하여 서버로 데이터 전송
    if(cTitle.value.trim().length == 0){
      alert("제목을 입력해 주세요.")
      cTitle.focus()
      return;
    }

    fetch("/community/register", {
      method: "POST",
      body: formData,
    })
    .then((response) => response.json())
    .then((result) => {
      if(result > 0){
        alert("게시글이 등록되었습니다.")

        location.href = '/community/4'
      }
    })
    .catch((error) => {
      console.error("파일 업로드 중 오류 발생: ", error);
    });
  
})