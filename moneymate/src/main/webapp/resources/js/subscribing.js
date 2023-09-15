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

/* 

    !!!!!!!!!!!! 마일리지를 상품금액보다 크게 보유한 경우.. 전액사용 막기

*/

    if(allMile.checked){
        useMile1.value = temp;

        if(parseInt(haveMile.value) > parseInt(prePrice.value)){
            haveMile.value = parseInt(haveMile.value) - parseInt(prePrice.value);
            useMile1.value = prePrice.value;
        } else {
            haveMile.value = 0;
        }
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
/* cashBtn.addEventListener("click", () => {

    flag = false;

    document.getElementsByClassName("none-area")[0].style.display = "block";
    document.getElementsByClassName("none-area")[1].style.display = "block";
    document.getElementsByClassName("none-area")[2].style.display = "block";

    document.getElementById("inform-area").style.display = "none";
}) */

creditBtn.addEventListener("click", () => {

    flag = true;

    document.getElementsByClassName("none-area")[0].style.display = "none";
    document.getElementsByClassName("none-area")[1].style.display = "none";
    document.getElementsByClassName("none-area")[2].style.display = "none";

    document.getElementById("inform-area").style.display = "block";
});


// 결제 api
$("#creditBtn").click(function () {

    if(!yes.checked){
        alert("약관 동의 후 진행해주세요");
        return;
    } else {

        IMP.init('imp71418067'); 
        IMP.request_pay({
        pg: "inicis",
        pay_method: "card",
        merchant_uid : 'merchant_'+new Date().getTime(),
        name : 'moneyMate',
        amount : parseInt(realPrice.value),
        buyer_email : memberEmail,
        buyer_name : memberNickname,
      }, function (rsp) { // callback
          if (rsp.success) {
            // 결제 성공 시 로직,
            var msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;
            msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            msg += '카드 승인번호 : ' + rsp.apply_num;

            const data = { "amount" : realPrice.value,
                    "useMile" : useMile1.value,
                    "prePrice" : prePrice.value };


            // ajax
            fetch("/subscribe/calculate/kg", {
                method  : "POST",
                headers : {"Content-Type" : "application/json"},
                body    : JSON.stringify(data)
            })

            .then(resp => resp.text())

            .then( result => {
                if(result > 0 ){
                    location.href = "/subscribe/end?no=" + result;
                } else {
                    alert("결제에 실패하셨습니다.");
                    location.href = "/";
                }
            })

            .catch(err => {
                console.log(err);
            });

          } else {
            // 결제 실패 시 로직,
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
          }
    
         // alert(msg)
      })
    }

})

// 무통장입금일 경우
Frm.addEventListener("submit", e => {

    if(!yes.checked){
        alert("약관동의는 필수입니다.");
        e.preventDefault();
        return;
    }

    // 가져가야 할 것
    // 사용한 마일리지, 입금자명, 무통장 입금이라는 정보, 결제금액 ! , preprice...(레벨용)

    if(document.getElementById("cashName").value== ""){
        alert("입금자명을 입력해주세요");
        e.preventDefault();
        return;
    }


})