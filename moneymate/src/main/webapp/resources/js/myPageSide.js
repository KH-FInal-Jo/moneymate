function selectAll(){ // 회원 전체 조회 함수

    // ajax 코드
    $.ajax({
        url : "/member/mypage/sidemenu",

        type : "get",

        dataType : "json", 

        success : function(list){

            console.log(list);

            for(let item of list){

                const sub = document.getElementById("sub");
                const mig = document.getElementById("mig");

                if (item.subscribeLevel === 0) {
                    const button = document.createElement("button");
                    button.textContent = "구독하기  💨";

                    button.style.backgroundColor = "skyblue";    
                    button.style.color = "white"; 
                    button.style.border = "none"; 
                    button.style.cursor = "pointer";
                    button.style.width = "100px";
                    button.style.height = "25px";

                    button.addEventListener("mouseenter", function () {
                        button.style.backgroundColor = "white"; 
                        button.style.color = "skyblue";
                        button.style.border = "2px solid skyblue";
                    });

                    button.addEventListener("mouseleave", function () {
                        button.style.backgroundColor = "skyblue";
                        button.style.color = "white";
                        button.style.border = "none";
                        button.style.width = "100px";
                        button.style.height = "25px";
                    });


                    button.addEventListener("click", function () {
                        // 호진언니 구독 화면으로 이동
                        window.location.href = "http://localhost/subscribe/info"; 
                    });

                    sub.appendChild(button);
                } else {
                    if (item.subscribeLevel === 1) {
                        sub.innerHTML = "한 달";
                    } else if (item.subscribeLevel === 2) {
                        sub.innerHTML = "6개월";
                    } else if (item.subscribeLevel === 3) {
                        sub.innerHTML = "일 년";
                    }
                }

                mig.innerHTML = item.mileage;

            }


        },
        error : function(request, status, error){

            console.log("AJAX 에러 발생");

            console.log("상태코드 : " + request.status); // 404, 500

            console.log(request.responseText); // 에러 메세지

            console.log(error); // 에러 객체 출력
        }
    });

}

(function(){

    selectAll(); 

    
})();





