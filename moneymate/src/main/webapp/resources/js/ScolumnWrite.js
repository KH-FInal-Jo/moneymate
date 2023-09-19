// 사진첨부
const inputImage = document.getElementsByClassName("inputImage")

// div text부분
const textArea = document.getElementById("text")

window.onload=function(){
    textArea.scrollTop = textArea.scrollHeight;
}

for(let i =0; i < inputImage.length; i++){

    // 파일이 선택되거나 선택 후 취소되었을 때
    inputImage[i].addEventListener("change", e =>{
        
        const file = e.target.files[0]; // 선택된 파일의 데이터

        
        if(file != undefined){ // 파일이 선택되었을 때
            
            console.log(file)

            const div = document.createElement("div")
            const img = document.createElement("img")
            img.classList.add("text-img")
            img.setAttribute("value" , images)
            

            const reader = new FileReader(); // 파일을 읽는 객체

            reader.readAsDataURL(file);
            // 지정된 파일을 읽은 후 result 변수에 URL 형식으로 저장

            reader.onload = e=>{ // 파일을 다 읽은 후 수행
                img.setAttribute("src", e.target.result);

            }

            div.append(img)
            textArea.append(div)
            

        }

    });

}

// 등록 버튼 ajax
const registerBtn = document.getElementById("finish")

registerBtn.addEventListener("click", ()=>{
    
    // 글제목
    const title = document.getElementById("Wtitle").value
    // 글 내용
    const content = textArea.innerHTML

    console.log(title)
    console.log(content)



    fetch("/4/register", {
        method : "POST",
        headers : {'Content-type' : 'application/json'},
        body : JSON.stringify({"title" : boardTitle, "content" : boardContent})
    })
    .then(resp => resp.json())
    .then(result => {
        if(result > 0){
            alert("게시글으 등록되었습니다.")
        }


    })
    .catch(e => {
        console.log(e)
    })





})