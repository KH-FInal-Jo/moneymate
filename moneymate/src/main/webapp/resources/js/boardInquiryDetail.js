const updateBtn= document.getElementById("updateBtn");
const deleteBtn= document.getElementById("deleteBtn");
const goToList= document.getElementById("goToList");

if(updateBtn != null){

    updateBtn.addEventListener("click", ()=>{
    
        location.href 
            = location.pathname + "/update" + location.search
        
    })
}

if(deleteBtn != null){

    deleteBtn.addEventListener("click", ()=>{

        var currentURL = location.href;
        var slicedURL = currentURL.slice(0, currentURL.lastIndexOf('/') + 1);
        console.log(slicedURL);


        if(confirm("정말로 삭제하시겠습니까?")){
            location.href = rurl; // get방식으로 url에 요청
        }
    })
}


if(goToList != null){

    goToList.addEventListener("click", e=>{
        let url = "/community/2"

        const params = new URL(location.href).searchParams

        let cp;

        if(params.get("cp") != ""){
            // 쿼리스트링에 cp가 있을 경우
            cp = "?cp=" + params.get("cp");
        }else{
            cp = "?cp=1"
        }
    
        // 조립
        url += cp;
    
        // 검색 key, query가 존재하는 경우 url에 추가
        if(params.get("key") != null){
            const key = "&key=" + params.get("key")
            const query = "&query=" + params.get("query")
    
            url += key + query; // url뒤에 붙이기
        }
    
        location.href = url;


    })

}

