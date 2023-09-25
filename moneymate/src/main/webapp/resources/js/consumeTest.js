const buttons = document.querySelectorAll("button");
const q1 = document.querySelector(".q1");
const q2 = document.querySelector(".q2");
const q3 = document.querySelector(".q3");
const q4 = document.querySelector(".q4");
const q5 = document.querySelector(".q5");
const thumbnail = document.querySelector(".thumbnail");
const resultPage = document.querySelector(".result-main");
const progress = document.getElementById("progress");
const progressNum = document.getElementById("progressNum");
const resultTitle = document.getElementById("resultTitle");
const resultImg = document.getElementById("resultImg");

const li1 = document.getElementById("li1");
const li2 = document.getElementById("li2");
const li3 = document.getElementById("li3");
const li4 = document.getElementById("li4");



const img = document.getElementById("img");


const btnRe = document.getElementById("btn-re");
const btn2 = document.getElementById("btn2");


let result = [];


const onClick = (e) => {
    if (e.target.dataset.num) {
        result.push(e.target.dataset.num);
        localStorage.setItem("key", result);
        
    }


    if(result.length === 0){
        img.setAttribute("src", "/resources/images/질문1.png");

    } else if (result.length === 1) {
        q1.style.display = "none";
        q2.style.display = "block";
        progress.value = 20;
        progressNum.innerText="1/5";
        img.setAttribute("src", "/resources/images/질문2.png");

    } else if (result.length === 2) {
        q1.style.display = "none";
        q2.style.display = "none";
        q3.style.display = "block";
        progress.value = 40;
        progressNum.innerText="2/5";
        img.setAttribute("src", "/resources/images/질문3.png");

    } else if (result.length === 3) {
        q1.style.display = "none";
        q2.style.display = "none";
        q3.style.display = "none";
        q4.style.display = "block";
        progress.value = 60;
        progressNum.innerText="3/5";
        img.setAttribute("src", "/resources/images/질문4.png");

    } else if (result.length === 4) {
        q1.style.display = "none";
        q2.style.display = "none";
        q3.style.display = "none";
        q4.style.display = "none";
        q5.style.display = "block";
        progress.value = 80;
        progressNum.innerText="4/5";
        img.setAttribute("src", "/resources/images/질문5.png");
        
    } else if (result.length === 5) {
        q5.style.display = "none";
        resultPage.style.display="flex";
        progress.value = 100;
        progressNum.innerText="5/5";
        img.style.display = "none";
        thumbnail.style.display = "none";

     
        localStorage.setItem("key", result);
        let resultNum = localStorage.getItem("key").split(",");
        resultNum = resultNum.reduce((pre,cur)=>pre+cur);
        

        let Num = resultNum.substr(1);

        
        if(Num == '1111'){
            resultTitle.innerHTML = "과소비 막아줄게!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/과소비막아줄게.jpg");
            console.log("1111");
            li1.innerHTML = "이동 반경이 넓고 새로운 곳을 좋아해요.";
            li2.innerHTML = "온라인 쇼핑할 때 다시 한번 혜택이나 포인트 적립을 확인해봐요.";
            li3.innerHTML = "예정에 없던 소비를 하진 않으나, 착한 소비는 자주 해요.";
            li4.innerHTML = "마케팅 정보를 수시로 확인해요.";
        }
        if(Num == '1112'){
            resultTitle.innerHTML = "과소비 막아줄게!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/과소비막아줄게.jpg");
            console.log("1112");
            li1.innerHTML = "이동 반경이 넓고 새로운 곳을 좋아해요.";
            li2.innerHTML = "온라인 쇼핑할 때 다시 한번 혜택이나 포인트 적립을 확인해봐요.";
            li3.innerHTML = "예정에 없던 소비를 하진 않으나, 착한 소비는 자주 해요.";
            li4.innerHTML = "마케팅 정보를 수시로 확인해요.";
        }
        if(Num == '1121'){
            resultTitle.innerHTML = "과소비 막아줄게!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/과소비막아줄게.jpg");
            console.log("1121");
            li1.innerHTML = "이동 반경이 넓고 새로운 곳을 좋아해요.";
            li2.innerHTML = "온라인 쇼핑할 때 다시 한번 혜택이나 포인트 적립을 확인해봐요.";
            li3.innerHTML = "예정에 없던 소비를 하진 않으나, 착한 소비는 자주 해요.";
            li4.innerHTML = "마케팅 정보를 수시로 확인해요.";
        }
        if(Num == '1122'){
            resultTitle.innerHTML = "나에게 예외란 없다!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/나에게예외란없다.jpg");
            console.log("1122");
            li1.innerHTML = "줄서서 기다리는 핫플레이스보다 단골가게를 선호해요.";
            li2.innerHTML = "온라인보다 오프라인쇼핑을 더 선호해요.";
            li3.innerHTML = "자기계발에도 열심히 투자하는 편이에요";
            li4.innerHTML = "장 볼 때도 미리 리스트를 정리해 가서 필요한 것만 구매해요.";
        }
        if(Num == '1211'){
            resultTitle.innerHTML = "내가 제일 잘나가!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/내가 제일 잘나가.jpg");
            console.log("1211");
            li1.innerHTML = "혼자보다는 사람들과 함께 있을 때 돈을 쓰는 편";
            li2.innerHTML = "오프라인 쇼핑을 좋아해요.";
            li3.innerHTML = "기분에 따라 과소비를 하기도 하나 아깝지 않아요.";
            li4.innerHTML = "새로운 것을 좋아하고, 유행을 꿰뚫고 있어요.";


        }
        if(Num == '1212'){
            resultTitle.innerHTML = "나에게 예외란 없다!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/나에게예외란없다.jpg");
            console.log("1212");
            li1.innerHTML = "줄서서 기다리는 핫플레이스보다 단골가게를 선호해요.";
            li2.innerHTML = "온라인보다 오프라인쇼핑을 더 선호해요.";
            li3.innerHTML = "자기계발에도 열심히 투자하는 편이에요";
            li4.innerHTML = "장 볼 때도 미리 리스트를 정리해 가서 필요한 것만 구매해요.";
        }
        if(Num == '1221'){
            resultTitle.innerHTML = "야망은 무조건 크게!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/2.jpg");
            console.log("1221");
            li1.innerHTML = "사람들과 함께 있을 때, 아끼지 않고 쓸 줄 아는 스타일";
            li2.innerHTML = "후회없이 온라인보다 오프라인 쇼핑을 선호해요.";
            li3.innerHTML = "자기계발에는 아낌없이 투자해요.";
            li4.innerHTML = "돈관리는 무조건 철저하게 빈틈없게!";
        }
        if(Num == '1222'){
            resultTitle.innerHTML = "가까운게 최고!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/6.webp");
            console.log("1222");
            li1.innerHTML = "여행을 먼 곳 보다 가까운 곳을 선호해요.";
            li2.innerHTML = "필요한 물품은 백화점이나 마트에서 구매하는 편.";
            li3.innerHTML = "나의 외모를 가꿔줄 아이템에 아낌없이 투자해요.";
            li4.innerHTML = "트랜드에 밝아 유행템은 항상 가지고 있어요.";
        }
        if(Num == '2111'){
            resultTitle.innerHTML = "가까운게 최고!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/6.webp");
            console.log("2111");
            li1.innerHTML = "여행을 먼 곳 보다 가까운 곳을 선호해요.";
            li2.innerHTML = "필요한 물품은 백화점이나 마트에서 구매하는 편.";
            li3.innerHTML = "나의 외모를 가꿔줄 아이템에 아낌없이 투자해요.";
            li4.innerHTML = "트랜드에 밝아 유행템은 항상 가지고 있어요.";
        }
        if(Num == '2112'){
            resultTitle.innerHTML = "쓸땐 확실히!!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/1.webp");
            console.log("2112");
            li1.innerHTML = "멀리 나가기보다는 집이나 집주변에서 소비하는 편";
            li2.innerHTML = "심심하면 온라인 쇼핑을 해서, 택배상자 한가득..";
            li3.innerHTML = "가치있는 일에 앞장서는 브랜드를 보면 마음이 움직여요.";
            li4.innerHTML = "트랜드에 관심이 많고, 유행템을 자주 구매해요.";
        }
        if(Num == '2121'){
            resultTitle.innerHTML = "절약 끝판왕!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/5.webp");
            console.log("2121");
            li1.innerHTML = "진정한 집콕 라이프를 즐겨요.";
            li2.innerHTML = "온라인으로 꼼꼼히 찾아보고 구매를 하는 스타일";
            li3.innerHTML = "무심해보이지만 사회에 관심이 많아 가치있는 소비를 해요.";
            li4.innerHTML = "결제 직전까지 꼼꼼히 고민해요.";
        }
        if(Num == '2122'){
            resultTitle.innerHTML = "절약 끝판왕!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/5.webp");
            console.log("2122");
            li1.innerHTML = "진정한 집콕 라이프를 즐겨요.";
            li2.innerHTML = "온라인으로 꼼꼼히 찾아보고 구매를 하는 스타일";
            li3.innerHTML = "무심해보이지만 사회에 관심이 많아 가치있는 소비를 해요.";
            li4.innerHTML = "결제 직전까지 꼼꼼히 고민해요.";
        }
        if(Num == '2211'){
            resultTitle.innerHTML = "쓸 땐 쓰고, 아낄 땐 아끼고!";
            resultImg.setAttribute("src", "/resources/images/consumeTest/4.jpg");
            console.log("2211");
            li1.innerHTML = "여행이나 직접 보고 체험하는 것을 좋아해요";
            li2.innerHTML = "사고 싶은 아이템이 근처매장에 있으면 무조건 사러가요.";
            li3.innerHTML = "착한 소비에도 관심이 많고, 소문도 잘내요.";
            li4.innerHTML = "가성비에 신경을 쓰고, 혜택도 꼼꼼히 비교해봐요.";
        }
        if(Num == '2212'){
            resultTitle.innerHTML = "스케줄이 한가득...";
            resultImg.setAttribute("src", "/resources/images/consumeTest/스케줄이한가득.jpg");
            console.log("2212");
            li1.innerHTML = "소비활동 범위가 평균치보다 넓어요.";
            li2.innerHTML = "디지털 페이 등 빠르게 정산하고 끝내요.";
            li3.innerHTML = "나은 미래를 위해 자기계발에 힘써요.";
            li4.innerHTML = "짠테크 정보에 밝은 나는 스스로 고수라 생각해요.";
        }
        if(Num == '2221'){
            resultTitle.innerHTML = "스케줄이 한가득...";
            resultImg.setAttribute("src", "/resources/images/consumeTest/스케줄이한가득.jpg");
            console.log("2221");
            li1.innerHTML = "소비활동 범위가 평균치보다 넓어요.";
            li2.innerHTML = "디지털 페이 등 빠르게 정산하고 끝내요.";
            li3.innerHTML = "나은 미래를 위해 자기계발에 힘써요.";
            li4.innerHTML = "짠테크 정보에 밝은 나는 스스로 고수라 생각해요.";

        }
        if(Num == '2222'){
            resultTitle.innerHTML = "스케줄이 한가득...";
            resultImg.setAttribute("src", "/resources/images/consumeTest/스케줄이한가득.jpg");
            console.log("2222");
            li1.innerHTML = "소비활동 범위가 평균치보다 넓어요.";
            li2.innerHTML = "디지털 페이 등 빠르게 정산하고 끝내요.";
            li3.innerHTML = "나은 미래를 위해 자기계발에 힘써요.";
            li4.innerHTML = "짠테크 정보에 밝은 나는 스스로 고수라 생각해요.";
        }

    }
};


buttons.forEach((btn)=>btn.addEventListener("click", onClick));



btnRe.addEventListener("click", function(){
    location.href = "/consumetest";
})

btn2.addEventListener("click", function(){
    const tResult = resultTitle.innerHTML;

    console.log(tResult);

    fetch("/member/dupCheckTestResult?testResult=" + tResult)
    .then(resp => resp.text())
    .then(count => {
        console.log(count);

        if(count == 0){

            // 추가
            fetch("/member/insertTestResult?testResult=" + tResult)
            .then(resp => resp.text())
            .then(result =>{
                alert("저장완료!");
                location.href = "/";
            })
            .catch();

        } else{
            // 업데이트
            fetch("/member/updateTestResult?testResult=" + tResult)
            .then(resp => resp.text())
            .then(result =>{
                alert("저장완료!");
                location.href = "/";
            })
            .catch();
        }

    })
    .catch(console.log("테스트를 다시 해주세요."));
})






