Kakao.init('47e9495bf5271c60736965397a22179b');
console.log( Kakao.isInitialized() );

function loginWithKakao() {

    Kakao.Auth.login({
        success: function (authObj) {
            console.log(authObj); // access토큰 값
            Kakao.Auth.setAccessToken(authObj.access_token); // access토큰값 저장
        },
        fail: function (err) {
            console.log(err);
        }
    });
    Kakao.Auth.authorize({
      redirectUri: 'http://localhost/',
      prompt : "login",
    });
  }

  Kakao.Auth.setAccessToken('${ACCESS_TOKEN}');

  /* function requestUserInfo() {
    Kakao.API.request({
      url: '/v2/user/me',
    })
      .then(function(res) {
        alert(JSON.stringify(res));
      })
      .catch(function(err) {
        alert(
          'failed to request user information: ' + JSON.stringify(err)
        );
      });
  }
  
  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    var token = getCookie('authorize-access-token');

    if(token) {
      Kakao.Auth.setAccessToken(token);
      Kakao.Auth.getStatusInfo()
        .then(function(res) {
          if (res.status === 'connected') {
            document.getElementById('token-result').innerText
              = 'login success, token: ' + Kakao.Auth.getAccessToken();
          }
        })
        .catch(function(err) {
          Kakao.Auth.setAccessToken(null);
        });
    }
  }

  function getCookie(name) {
    var parts = document.cookie.split(name + '=');
    if (parts.length === 2) { return parts[1].split(';')[0]; }
  } */

  /* function requestUserInfo() {
    Kakao.API.request({
        url: '/v2/user/me',
        success: function (res) {
            console.log("res" + res);
            // 이메일, 성별, 닉네임, 프로필이미지
            var email = res.kakao_account.email;
            var nickname = res.kakao_account.profile.nickname;
            var profile = res.kakao_account.profile.profile_image_url;

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
  
  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    var token = getCookie('authorize-access-token');

    if(token) {
      Kakao.Auth.setAccessToken(token);
      Kakao.Auth.getStatusInfo()
        .then(function(res) {
          if (res.status === 'connected') {
            document.getElementById('token-result').innerText
              = 'login success, token: ' + Kakao.Auth.getAccessToken();

              alert(Kakao.Auth.getAccessToken());
          }
        })
        .catch(function(err) {
          Kakao.Auth.setAccessToken(null);
        });
    }
  }

  function getCookie(name) {
    var parts = document.cookie.split(name + '=');
    if (parts.length === 2) { return parts[1].split(';')[0]; }
  } */