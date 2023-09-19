Kakao.init('47e9495bf5271c60736965397a22179b'); //★ 수정 할 것
// SDK 초기화 여부를 판단합니다.
console.log(Kakao.isInitialized());

function loginWithKakao() {
    Kakao.Auth.authorize({
        redirectUri: 'http://localhost/' //★ 수정 할 것
    })
}     