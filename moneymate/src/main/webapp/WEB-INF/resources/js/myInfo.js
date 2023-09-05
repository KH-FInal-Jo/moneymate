// Daum 주소 찾기 API 스크립트 로드 완료 시 실행
Kakao.init('YOUR_API_KEY'); // Daum 주소 찾기 API 초기화

// 주소 검색 버튼 클릭 시 실행
document.getElementById('searchButton').addEventListener('click', function () {
    var address = document.getElementById('address').value;

    // 주소 검색 요청
    Kakao.API.request({
        url: '/v2/local/search/address.json',
        data: {
            query: address
        },
        success: function (response) {
            // 주소 검색 결과를 처리하고 표시
            var result = response.documents[0]; // 첫 번째 검색 결과를 사용
            var addressResult = document.getElementById('addressResult');
            
            if (result) {
                var fullAddress = result.address_name;
                var zoneCode = result.zone_code;

                addressResult.innerHTML = '주소: ' + fullAddress + '<br>우편번호: ' + zoneCode;
            } else {
                addressResult.innerHTML = '주소를 찾을 수 없습니다.';
            }
        },
        fail: function (error) {
            console.error(error);
        }
    });
});
