function selectAll(){ // 회원 전체 조회 함수

    // ajax 코드
    $.ajax({
        url : "sidemenu",

        dataType : "json", 

        success : function(list){

            const memberList = document.getElementById("memberList");

            memberList.innerText = "";

            console.log(list);

            for(let item of list){


            }
        },
        error : function(){
            console.log("에러 발생");
        }
    });

}

// 즉시 실행 함수
(function(){

    selectAll(); 

    console("zzzzzzzzzzzzzz");

    window.setInterval(selectAll, 10000); 
    
    
})();