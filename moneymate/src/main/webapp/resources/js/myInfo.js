
const changeButton = document.getElementById("changeButton") // 변경하기 버튼
const chooseButton = document.getElementById("chooseButton") // 이미지 선택
const profileImage = document.getElementById("profileImage")
const deleteImage = document.getElementById("deleteImage")

let initCheck;

let deleteCheck = -1;

let originalImage;

if(chooseButton != null){

    originalImage =profileImage.getAttribute("src");

    if(originalImage = "/resources/images/로고.png"){
        initCheck = false;
    }else{
        initCheck = true;
    }


    chooseButton.addEventListener("change",e=>{

        // 2MB로 최대 크기 제한
        const maxSize = 1 * 1024 * 1024 * 2; // 파일 최대 크기 지정(바이트 단위)

        console.log(e.target) // input
        console.log(e.target.value) // 업로드된 파일 경로
        console.log(e.target.files) // 업로드된 파일의 정보가 담긴 배열

        const file = e.target.files[0]; // 업로드한 파일의 정보가 담긴 객체

        // 파일을 한번 선택한 후 취소했을 때
        if(file == undefined){
            console.log("파일 선택이 취소됨")
            deleteCheck = -1; // 취소 == 파일 없음 == 초기상태

            // 취소 시 기존 프로필 이미지로 변경
            profileImage.setAttribute("src", originalImage)

            return;
        }

        if(file.size > maxSize){ // 선택된 파일의 크기가 최대 크기를 초과한 경우
            alert("2MB 이하의 이미지를 선택해주세요.")
            chooseButton.value = "";
            // input type="file" 태그에 대입할 수 있는 value는 ""(빈칸) 뿐이다!

            deleteCheck = -1; // 취소 == 파일 없음 == 초기상태

            // 기존 프로필 이미지로 변경
            profileImage.setAttribute("src", originalImage)

            return;
        }

        // JS에서 파일을 읽는 객체
        // - 파일을 읽고 클라이언트 컴퓨터에 파일을 저장할 수 있음 
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
            profileImage.setAttribute("src", url);

            deleteCheck = 1;
        }
       
    });


     // x 버튼 클릭 시 
     deleteImage.addEventListener("click", ()=>{

        // 프로필 이미지를 기본 이미지로 변경 
        profileImage.setAttribute("src", originalImage)
        chooseButton.value = "" // input type="file"의 value를 삭제

        deleteCheck = 0;


    });



    // #profileFrm이 제출 되었을 때
    document.getElementById("profileFrm").addEventListener("submit", e=>{

        //let initCheck; // 초기 프로필 이미지 상태를 저장하는 변수
                // false == 기본 이미지, true == 이전 업로드 이미지

        //let deleteCheck = -1;
        // 프로필 이미지가 새로 업로드 되거나 삭제 되었음을 나타내는 변수
        // -1 == 초기값, 0 == 프로필 삭제(X), 1 == 새 이미지 업로드 

        let flag = true;
        // 프로필 이미지가 없다 -> 있다
        if(!initCheck && deleteCheck == 1) flag = false;

        // 이전 프로필 이미지가 있다 -> 삭제
        if(initCheck && deleteCheck == 0) flag = false;

        // 이전 프로필 이미지가 있다 -> 새 이미지
        if(initCheck && deleteCheck == 1) flag = false;

        if(flag){ // flag == true -> 제출하면 안되는 경우

            e.preventDefault(); // form 기본 이벤트 제거
            alert("이미지 변경 후 클릭하세요.")


        }

    })
   
}
    
