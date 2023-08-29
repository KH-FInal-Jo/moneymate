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
allMile.addEventListener("change", () => { /* 전액 사용 */

    if(allMile.checked){
        useMile1.value = temp;
        haveMile.value = 0;
        realPrice.value = parseInt(prePrice) - parseInt(useMile2); // NAN.........ㅋㅋㅋㅋㅋ
    } else {
        haveMile.value = temp;
        useMile1.value = 0;
    }

    useMile2.value = useMile1.value;

})

useMile1.addEventListener("input", () => { /* 사용 마일리지 누르면 자동으로 밑 금액도 바뀌게 */
    useMile2.value = useMile1.value;
})

useMile1.addEventListener("change", () => {
    if(useMile1.value == ""){
        useMile1.value = 0;
        useMile2.value = 0;
    } 
})

useMile1.addEventListener("input", () => { /* 사용 마일리지에 직접 입력하는 경우 */
    if(isNaN(useMile1.value)){
        alert("숫자만 입력가능합니다.");
        useMile1.value=0;
        useMile1.focus();
    }
})

Frm.addEventListener("submit", e => {

})
