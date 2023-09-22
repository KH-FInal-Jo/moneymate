const profileImageDisplay = document.getElementById("profileImageDisplay") // 프로필 이미지
const deleteImage = document.getElementById("deleteImage") // x 삭제
const profileImage = document.getElementById("profileImage") // 이미지 태그


let initCheck; // 초기 프로필 이미지 상태 저장 변수
let deleteCheck = -1; // 새로 이미지 업로드 되거나 삭제 됐을때 변수
let originalImage; //초기 프로필 이미지 파일 경로 저장

if(profileImage != null){

    originalImage = profileImageDisplay.getAttribute("src");

    if(originalImage == "/resources/images/id.png"){ //기본 이미지
        initCheck = false;
    }else{
        initCheck = true;
    }


    profileImage.addEventListener("change",e=>{

        const maxSize= 1 * 1024 * 1024 * 2; // 파일 크기 최대 지정

        console.log(e.target) // input
        console.log(e.target.value) // 업로드된 파일 경로
        console.log(e.target.files) // 업로드된 파일의 정보가 담긴 배열

        const file = e.target.files[0];

        if(file == undefined){
            console.log("파일 선택이 취소됨")
            deleteCheck = -1;
            
            profileImageDisplay.setAttribute("src","/resources/images/id.png")

            return;
        }

        if(file.size > maxSize){ // 선택된 파일의 크기가 최대 크기를 초과한 경우
            alert("2MB 이하의 이미지를 선택해주세요.")
            profileImage.value = "";
            // input type="file" 태그에 대입할 수 있는 value는 ""(빈칸) 뿐이다!

            deleteCheck = -1; // 취소 == 파일 없음 == 초기상태

            // 기존 프로필 이미지로 변경
            profileImageDisplay.setAttribute("src", originalImage)

            return;
        }

        const reader = new FileReader();

        reader.readAsDataURL(file)
        // 매개변수에 작성된 파일을 읽어서 저장 후
        // 파일을 나타내는 URL을 result 속성으로 얻어올 수 있게 함 

        // 다 읽었을 때
        reader.onload = e=>{
            //console.log(e.target)
            //console.log(e.target.result) 읽은 파일의 URL

            const url = e.target.result;

            // 프로필 이미지(img) 태그에 src 속성으로 추가
            profileImageDisplay.setAttribute("src", url);

            deleteCheck = 1;
        }

        
        
        deleteImage.addEventListener("click", ()=>{
    
            // 프로필 이미지를 기본 이미지로 변경 
            profileImageDisplay.setAttribute("src", originalImage)
            profileImage.value = "" // input type="file"의 value를 삭제
    
            deleteCheck = 0;
    
    
        })
    });
    
    document.getElementById("UpdateProfile").addEventListener("submit", e=>{

        let flag =true;
        if(!initCheck && deleteCheck == 1) flag = false;  // 프로필 이미지가 없다 -> 있다

        if(initCheck && deleteCheck == 0) flag = false; // 이전 프로필 이미지가 있다 -> 삭제

        if(initCheck && deleteCheck == 1) flag = false; // 이전 프로필 이미지가 있다 -> 새 이미지

        if(flag){

            e.preventDefault(); // form 기본 이벤트 제거
            alert("이미지 변경 후 클릭하세요.");
        }
    });

}