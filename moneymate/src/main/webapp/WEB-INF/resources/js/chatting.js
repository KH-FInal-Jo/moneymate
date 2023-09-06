const leftBarIcon1 = document.getElementsByClassName("leftBarIcon1")[0];
const leftBarIcon2 = document.getElementsByClassName("leftBarIcon2")[0];
const leftBarIcon3 = document.getElementsByClassName("leftBarIcon3")[0];
const leftBarIcon4 = document.getElementsByClassName("leftBarIcon4")[0];

let leftBar1 = document.getElementsByClassName("leftBar1")[0];
let leftBar2 = document.getElementsByClassName("leftBar2")[0];
let leftBar3 = document.getElementsByClassName("leftBar3")[0];



leftBarIcon2.addEventListener("click", function(){

    leftBar1.style.display = 'block';
    leftBar2.style.display = 'none';
    leftBar3.style.display = 'none';
    leftBarIcon2.style.color = 'white';
    leftBarIcon3.style.color = 'black';
    leftBarIcon4.style.color = 'black';

})
leftBarIcon3.addEventListener("click", function(){

    leftBar2.style.display = 'block';
    leftBar1.style.display = 'none';
    leftBar3.style.display = 'none';
    leftBarIcon3.style.color = 'white';
    leftBarIcon2.style.color = 'black';
    leftBarIcon4.style.color = 'black';
})
leftBarIcon4.addEventListener("click", function(){

    leftBar3.style.display = 'block';
    leftBar2.style.display = 'none';
    leftBar1.style.display = 'none';
    leftBarIcon4.style.color = 'white';
    leftBarIcon3.style.color = 'black';
    leftBarIcon2.style.color = 'black';
})


let divdiv = document.querySelector(".wrap");

divdiv.scrollTop = divdiv.scrollHeight;

