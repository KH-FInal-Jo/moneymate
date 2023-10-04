// 스크롤 이벤트 리스너 추가
window.addEventListener('scroll', function() {
    // 스크롤 위치 확인
    var scrollPosition = window.scrollY;

    console.log(scrollPosition); // 900

    
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

    if(scrollPosition >= 2200){
      document.querySelector('#left1').classList.add('animate__animated');
      document.querySelector('#left1').classList.add('animate__slideInLeft');
      document.querySelector('#right1').classList.add('animate__animated');
      document.querySelector('#right1').classList.add('animate__slideInRight');
    }else{
      document.querySelector('#left1').classList.remove('animate__animated');
      document.querySelector('#left1').classList.remove('animate__slideInLeft');
      document.querySelector('#right1').classList.remove('animate__animated');
      document.querySelector('#right1').classList.remove('animate__slideInRight');
    }

    if(scrollPosition >= 3200){
      document.querySelector('#image-container').classList.add('animate__animated');
      document.querySelector('#image-container').classList.add('animate__zoomInLeft');
    }else{
      document.querySelector('#image-container').classList.remove('animate__animated');
      document.querySelector('#image-container').classList.remove('animate__zoomInLeft');
    }

    if(scrollPosition >= 4200){
      document.querySelector('#right5').classList.add('animate__animated');
      document.querySelector('#right5').classList.add('animate__flipInY');
      document.querySelector('#right6').classList.add('animate__animated');
      document.querySelector('#right6').classList.add('animate__flipInY');  
      document.querySelector('#right7').classList.add('animate__animated');
      document.querySelector('#right7').classList.add('animate__flipInY');
      document.querySelector('#right8').classList.add('animate__animated');
      document.querySelector('#right8').classList.add('animate__flipInY');        
    }else{
      document.querySelector('#right5').classList.remove('animate__animated');
      document.querySelector('#right5').classList.remove('animate__flipInY');
      document.querySelector('#right6').classList.remove('animate__animated');
      document.querySelector('#right6').classList.remove('animate__flipInY');
      document.querySelector('#right7').classList.remove('animate__animated');
      document.querySelector('#right7').classList.remove('animate__flipInY'); 
      document.querySelector('#right8').classList.remove('animate__animated');
      document.querySelector('#right8').classList.remove('animate__flipInY');       
    }

    if(scrollPosition >= 5500){
      document.querySelector('#image-container1').classList.add('animate__animated');
      document.querySelector('#image-container1').classList.add('animate__jackInTheBox');
    }else{
      document.querySelector('#image-container1').classList.remove('animate__animated');
      document.querySelector('#image-container1').classList.remove('animate__jackInTheBox');
    }
  });
  