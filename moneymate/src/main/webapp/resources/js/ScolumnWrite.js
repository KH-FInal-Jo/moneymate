// 사진첨부
const inputImages = document.querySelectorAll(".inputImage");

// div text 부분
const textArea = document.getElementById("text");

window.onload = function () {
  textArea.scrollTop = textArea.scrollHeight;
};

const formData = new FormData();

for (let i = 0; i < inputImages.length; i++) {
  // 파일이 선택되거나 선택 후 취소되었을 때
  inputImages[i].addEventListener("change", (e) => {
    const files = e.target.files; // 선택된 파일의 데이터 배열

    for (let j = 0; j < files.length; j++) {
      const file = files[j];

      if (file != undefined) {
        const div = document.createElement("div");
        const img = document.createElement("img");
        img.classList.add("text-img");

        const reader = new FileReader(); // 파일을 읽는 객체

        reader.readAsDataURL(file);
        // reader.readAsDataURL(file)를 통해 파일을 읽은 후, 
        //읽은 데이터는 reader.onload 이벤트 핸들러 내에서 사용할 수 있는 e.target.result에 저장됩니다. 
        //  readAsDataURL를 사용하면 해당 이미지 파일을 데이터 URL로 읽어와서 웹 페이지에서 이미지로 표시할 수 있습니다.
        // 지정된 파일을 읽은 후 result 변수에 URL 형식으로 저장


        reader.onload = (e) => {
          img.setAttribute("src", e.target.result);
        };

        div.append(img);
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
  const textArea = document.getElementById("text");
  const boardTitle = document.getElementById("Wtitle").value;
  const boardContent = textArea.innerText;

  // 글제목과 글내용을 FormData에 추가
  formData.append("boardTitle", boardTitle);
  formData.append("boardContent", boardContent);

  // fetch를 사용하여 서버로 데이터 전송
  fetch("/community/4/insert/register", {
    method: "POST",
    body: formData,
  })
    .then((response) => response.json())
    .then((result) => {
      console.log(result);
    })
    .catch((error) => {
      console.error("파일 업로드 중 오류 발생: ", error);
    });
});