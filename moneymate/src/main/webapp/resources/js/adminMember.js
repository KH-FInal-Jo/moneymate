function mileUpdate(memberNo, btn){
    
    const input = btn.previousElementSibling;
    console.log(input)

    if(!confirm(memberNo + "번 회원의 마일리지를 변경하시겠습니까?")){
        return;
    }

    const data = {
        "memberNo" : memberNo,
        "mileage" : input.value
    }

    console.log(data)

    fetch("/admin/member/mile", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })

    .then(resp => resp.text())

    .then(result => {
        if(result>0){
            alert("마일리지가 변경되었습니다.")
        } else {
            alert("마일리지 변경 실패")
        }
    })

    .catch(e => console.log(e))


}

function secession(memberNo, btn){

    if(!confirm(memberNo + "번 회원을 탈퇴시키겠습니까?")){
        return;
    }

    fetch("/admin/member/secession?no=" + memberNo)

    .then(resp => resp.text())

    .then(result => {
        if(result>0){
            alert("탈퇴되었습니다.")
        } else {
            console.log("탈퇴 실패..")
        }
        location.reload(true);
    })

    .catch(e => console.log(e))
}

/* 자동완성 */
const frm = document.getElementById("frm");
const search = document.getElementById("search");
const ulArea = document.getElementById("ulArea");

const lis = document.querySelectorAll('li');

let currentIndex = -1;

search.addEventListener('keydown', function (event) {

    if (event.key === 'ArrowDown') {

        lis[2].focus();
        console.log(222222222222)
        event.preventDefault();
        currentIndex = (currentIndex + 1) % lis.length;
        //lis[currentIndex].focus();
    }
});

lis.forEach((li, index) => {
    li.addEventListener('focus', () => {
      currentIndex = index;
    });
});

search.addEventListener("click", () => {
    ulArea.style.display = "block";
});

document.addEventListener('click', function (event) {
    if (event.target !== search) {
      ulArea.style.display = 'none';
    }
});

// 클릭하면 input창에 들어가는 건 백 끝내고 요소 생성할 때 진행 !!

search.addEventListener("input", e => {

    console.log(lis)
    
    const query = e.target.value.trim();
    ulArea.innerHTML = "";

    // 입력된 게 없을 때
    if(query.length == 0){
        return;
    }

    // 입력된 게 있을 때
    if(query.length > 0){
        fetch("/admin/member/selectMember?query=" + query)

        .then(resp => resp.json())

        .then(list => {
           // console.log(list);

           ulArea.innerHTML = "";

            if(list.length == 0){
                const li = document.createElement("li");
                li.innerText = "일치하는 회원이 없습니다";
                ulArea.append(li);
            }

            for(let member of list){

                const li = document.createElement("li");
                li.setAttribute("data-id", member.memberNickname);

                li.innerHTML = `${member.memberName} | ${member.memberNickname} | ${member.memberEmail}`.replace(query, `<mark>${query}</mark>`)

                ulArea.append(li)

                li.addEventListener("click", selecting);
            }

        })

        .catch(e => console.log(e))
    }

})

function selecting(e){
    search.value = e.target.getAttribute("data-id");
}