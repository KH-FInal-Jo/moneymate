// 스크롤 이벤트 리스너 추가
window.addEventListener('scroll', function() {
    // 스크롤 위치 확인
    var scrollPosition = window.scrollY;

    // console.log(scrollPosition); // 900

    
    // 특정 스크롤 위치에서 스타일 변경
    if (scrollPosition >= 800) {
      document.querySelector('#top').classList.add('animate__animated');
      document.querySelector('#top').classList.add('animate__bounce');
    } else {
      document.querySelector('#top').classList.remove('animate__animated');
      document.querySelector('#top').classList.remove('animate__bounce');
    }


    if (scrollPosition >= 900) {
      document.querySelector('#left').classList.add('animate__animated');
      document.querySelector('#left').classList.add('animate__flipInY');
      document.querySelector('#middle').classList.add('animate__animated');
      document.querySelector('#middle').classList.add('animate__flipInY');
      document.querySelector('#right').classList.add('animate__animated');
      document.querySelector('#right').classList.add('animate__flipInY');
    } else {
        document.querySelector('#left').classList.remove('animate__animated');
        document.querySelector('#left').classList.remove('animate__flipInY');
        document.querySelector('#middle').classList.remove('animate__animated');
        document.querySelector('#middle').classList.remove('animate__flipInY');
        document.querySelector('#right').classList.remove('animate__animated');
        document.querySelector('#right').classList.remove('animate__flipInY');
    }
  });
  