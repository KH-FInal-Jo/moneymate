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

// 주소변경
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = '';

            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else {
                addr = data.jibunAddress;
            }

            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            document.getElementById("sample6_detailAddress").focus();

            // FormData에도 주소 값을 설정
            formData.set("memberAddress", data.zonecode + "^^^" + addr);
        }
    }).open();
}





    // 페이지가 로드될 때 이벤트 리스너 등록
    $(document).ready(function () {
        // "변경하기" 버튼 클릭 시 이벤트 처리
        $("#changeButton").click(function (e) {
            e.preventDefault(); // 기본 폼 제출 동작 방지

            // FormData 객체 생성
            var formData = new FormData($("#updateInfo")[0]);

            // Ajax 요청 보내기
            $.ajax({
                type: "POST",
                url: "/member/mypage",
                data: formData,
                processData: false, // FormData 사용 시 필수
                contentType: false, // FormData 사용 시 필수
                success: function (data) {
                    // 서버로부터의 응답 처리
                    console.log("서버 응답:", data);
                    // 필요한 동작 수행 (예: 화면 갱신, 알림 표시 등)
                },
                error: function (error) {
                    // 오류 처리
                    console.error("오류 발생:", error);
                }
            });
        });
    });

    //사진 변경
    $("#changeButton").click(function (e) {
        e.preventDefault();
    
        var formData = new FormData($("#updateInfo")[0]);
        
        // 이미지 파일 추가
        var imageInput = $("#imageInput")[0].files[0];
        formData.append("imageInput", imageInput);
    
        $.ajax({
            type: "POST",
            url: "/member/mypage",
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                console.log("서버 응답:", data);
                // 필요한 동작 수행
            },
            error: function (error) {
                console.error("오류 발생:", error);
            }
        });
    });
    