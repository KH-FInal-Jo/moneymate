const Frm = document.getElementById("Frm");
const yes = document.getElementById("yes");

const haveMile = document.getElementById("haveMile");
const useMile1 = document.getElementsByClassName("useMile")[0];
const useMile2 = document.getElementsByClassName("useMile")[1];
const allMile = document.getElementById("allMile");

const prePrice = document.getElementById("prePrice");
const realPrice = document.getElementById("realPrice");



const cashBtn = document.getElementById("cashBtn");
const creditBtn = document.getElementById("creditBtn");

const prevBtn = document.getElementById("prevBtn");
const nextBtn = document.getElementById("nextBtn");

let temp = haveMile.value;
let realTemp = realPrice.value;
allMile.addEventListener("change", () => { /* 전액 사용 */

    if(allMile.checked){
        useMile1.value = temp;
        haveMile.value = 0;
        realPrice.value = parseInt(prePrice.value) - parseInt(useMile1.value);
    } else {
        haveMile.value = temp;
        useMile1.value = 0;
        realPrice.value = realTemp; /// 수정해야겠다ㅣ.
    }

    useMile2.value = useMile1.value;

}) 

useMile1.addEventListener("input", () => { /* 사용 마일리지 누르면 자동으로 밑 금액도 바뀌게 */
    
    useMile2.value = useMile1.value;
    
    
    if(isNaN(useMile1.value)){ /* 사용 마일리지에 직접 입력하는 경우 */
        alert("숫자만 입력가능합니다.");
        useMile2.value=0;
        useMile1.focus();
        useMile1.value="";
    } else {
        if(parseInt(useMile1.value) > temp){
            useMile1.value = temp;
            useMile2.value = temp;
        }
    
        if(useMile1.value == ""){
            realPrice.value = realTemp;
            useMile2.value = 0;
            haveMile.value = temp;
        } else {
            realPrice.value = parseInt(prePrice.value) - parseInt(useMile1.value);
            haveMile.value = temp - parseInt(useMile1.value);
        }
    
        

    }



})

useMile1.addEventListener("change", () => {
    if(useMile1.value == ""){
        useMile2.value = 0;
    } 
})

useMile1.addEventListener("click", () => {
    if(useMile1.value == 0){
        useMile1.value = "";
    }
})

/* ------------------------------------------------------ */

let flag = true;

/* 무통장입금 버튼 눌렸을 때 */
cashBtn.addEventListener("click", () => {

    flag = false;

    document.getElementsByClassName("none-area")[0].style.display = "block";
    document.getElementsByClassName("none-area")[1].style.display = "block";
    document.getElementsByClassName("none-area")[2].style.display = "block";

    document.getElementById("inform-area").style.display = "none";
})

creditBtn.addEventListener("click", () => {

    flag = true;

    document.getElementsByClassName("none-area")[0].style.display = "none";
    document.getElementsByClassName("none-area")[1].style.display = "none";
    document.getElementsByClassName("none-area")[2].style.display = "none";

    document.getElementById("inform-area").style.display = "block";
})










Frm.addEventListener("submit", e => {

})
