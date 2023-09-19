
Kakao.init('47e9495bf5271c60736965397a22179b');
console.log( Kakao.isInitialized() ); // 초기화 판단여부

// 3. 데모버전으로 들어가서 카카오로그인 코드를 확인.

function loginWithKakao(){
    Kakao.Auth.login({
        success: function (authObj) {
            console.log(authObj); 
            Kakao.Auth.setAccessToken(authObj.access_token); 

            getInfo();
        },
        fail: function (err) {
            console.log(err);
        }
    })

} 

// 4. 엑세스 토큰을 발급받고, 아래 함수를 호출시켜서 사용자 정보를 받아옴.
function getInfo() {
    Kakao.API.request({
        url: '/v2/user/me',
        success: function (res) {
            console.log( res);
            // 이메일, 닉네임, 프로필이미지
            let email = res.kakao_account.email;
            let nickname = res.kakao_account.profile.nickname;
            let profile = res.kakao_account.profile.profile_image_url;

            const data = {
                "email" : email,
                "nickname" : nickname,
                "profile" : profile
            }

            fetch("/member/kakao", {
                method : "POST",
                headers : {"Content-Type" : "application/json"},
                body : JSON.stringify(data)
            })

            .then(resp => resp.text())

            .then( result => {

                // result 가 1이면 회원가입 성공
                // result 가 -1이면 로그인  성공
                

                if(result == 0){
                    alert("로그인 실패..")
                }

                if(result == 1){
                    alert("로그인 성공!!");
                    location.href="/";
                }

                }
            )
            .catch(err => console.log(err));

            //location.href="/member/kakao"
            //console.log(email,  nickname);
        },
        fail: function (error) {
            alert('카카오 로그인에 실패했습니다. 관리자에게 문의하세요.' + JSON.stringify(error));
        }
    });
}

// 5. 로그아웃 기능 - 카카오 서버에 접속하는 엑세스 토큰을 만료, 사용자 어플리케이션의 로그아웃은 따로 진행.
function kakaoLogout() {
    
    if (!Kakao.Auth.getAccessToken()) {
        
        alert('Not logged in.');
        
        return;
    }
    Kakao.Auth.logout(function() {
        alert(22222)
        alert('logout ok\naccess token -> ' + Kakao.Auth.getAccessToken());
    });
}