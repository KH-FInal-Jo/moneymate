
Kakao.init('47e9495bf5271c60736965397a22179b');
console.log( Kakao.isInitialized() ); // 초기화 판단여부

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

                if(result == 0){
                    alert("로그인 실패..")
                }

                if(result == 1){
                    alert(nickname + "님 환영합니다.");
                    location.href="/";
                }

                }
            )
            .catch(err => console.log(err));

        },
        fail: function (error) {
            alert('카카오 로그인에 실패했습니다. 관리자에게 문의하세요.' + JSON.stringify(error));
        }
    });
}

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