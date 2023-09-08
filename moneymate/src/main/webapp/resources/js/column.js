
// 모든 칼럼 숨김
$('.one > div').hide();
// 첫번째 칼럼부터 6번째 칼럼까지는 보이게
$(".one > div").slice(0, 6).css("display", "block"); 
// 더보기 버튼 클릭시 실행 함수
$("#load").click(function(e){
    // 숨겨져있는 칼럼 중 여섯개 단위로 fadeIn 효과를 줘서 나타나게함
   $(".one >div:hidden").slice(0, 6).fadeIn(200).css('display', 'block'); // 클릭시 more 갯수 지저정
   if($(".one >div:hidden").length == 0){ // 컨텐츠 남아있는지 확인
       $('#load').fadeOut(100); // 컨텐츠 없을 시 버튼 사라짐
   }
});