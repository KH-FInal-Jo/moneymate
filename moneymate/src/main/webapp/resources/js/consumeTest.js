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

const img = document.getElementById("img");

let result = [];

const onClick = (e) => {
    if (e.target.dataset.num) {
        result.push(e.target.dataset.num);
        localStorage.setItem("key", result);
    }


    if(result.length === 0){
        img.setAttribute("src", "../images/질문1.png");

    } else if (result.length === 1) {
        q1.style.display = "none";
        q2.style.display = "block";
        progress.value = 20;
        progressNum.innerText="1/5";
        img.setAttribute("src", "../images/질문2.png");

    } else if (result.length === 2) {
        q1.style.display = "none";
        q2.style.display = "none";
        q3.style.display = "block";
        progress.value = 40;
        progressNum.innerText="2/5";
        img.setAttribute("src", "../images/질문3.png");

    } else if (result.length === 3) {
        q1.style.display = "none";
        q2.style.display = "none";
        q3.style.display = "none";
        q4.style.display = "block";
        progress.value = 60;
        progressNum.innerText="3/5";
        img.setAttribute("src", "../images/질문4.png");

    } else if (result.length === 4) {
        q1.style.display = "none";
        q2.style.display = "none";
        q3.style.display = "none";
        q4.style.display = "none";
        q5.style.display = "block";
        progress.value = 80;
        progressNum.innerText="4/5";
        img.setAttribute("src", "../images/질문5.png");
        
    } else if (result.length === 5) {
        q5.style.display = "none";
        resultPage.style.display="flex";
        progress.value = 100;
        progressNum.innerText="5/5";
        img.style.display = "none";
        thumbnail.style.display = "none";
    }
};

buttons.forEach((btn)=>btn.addEventListener("click", onClick));

