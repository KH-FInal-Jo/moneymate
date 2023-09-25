<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소비 테스트 질문</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/resources/css/consumeTest-question.css">
<link rel="stylesheet" href="/resources/css/consumeTest-result.css">

</head>
<body class="body">

    <div class="top">
        <h2>진행상황</h2>
        <progress id="progress" value="0" min="0" max="100"></progress> 
        <span id="progressNum">0/5</span>
    </div>

    <div class="thumbnail">
        <img id="img" src="/resources/images/질문1.png">
    </div>



    <div class="q1">

        <div class="question">
            <h1>통장의 잔고가</h1>
            <h1>'0'일때??</h1>
        </div>
        <div class="answer">
            <label for="answer1">
                <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="1">
                    <h3>기피</h3>
                    <p>돈을 쓸 수 없어서 사람들 만나기가 꺼려진다.</p>
                </button>
            </label>
            <label for="answer2">
                <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="2">
                    <h3>불안</h3>
                    <p>마음 상태가 무척 불안해지고 조급해진다.</p>
                </button>
            </label>
            <label for="answer3">
                <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="3">
                    <h3>무관심</h3>
                    <p>신용카드나 대출을 이용해서 쓰면 된다.</p>
                </button>
            </label>
           
        </div>
    </div>

    
    <div class="q2">

        <div class="question">
            <h1>날씨 탓에 배달음식을 자주 먹게되는 요즘,</h1>
            <h1>문득 드는 생각은??</h1>
        </div>
    
        <div class="answer">
            <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="1">
                <h3>점점 얇아지는 지갑을 보면서</h3>
                <h3>씁쓸함이 몰려온다.</h3>
            </button>
            <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="2">
                <h3>쌓여가는 플라스틱을 보면서</h3>
                <h3>마음 한 켠 죄책감이 밀려온다.</h3>
            </button>
            
           
        </div>
    </div>

    
    <div class="q3">

        <div class="question">
            <h1>마음이 훈훈해지는 5월.</h1>
            <h1>모처럼 가족들과 시간을 보내기로 했다!</h1>
        </div>
    
        <div class="answer">
            <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="1">
                <h3>오늘만큼은 따뜻한 집에서</h3>
                <h3>가족들만의 오붓한 시간을 보낸다.</h3>
            </button>
            <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="2">
                <h3>함께 즐기기 좋은 프로그램을 하러 가</h3>
                <h3>잊지 못할 추억을 남긴다.</h3>
            </button>
            
           
        </div>
    </div>

    
    <div class="q4">

        <div class="question">
            <h1>여름 휴가 2주 전,</h1>
            <h1>끝내주는 여름 휴가를 위해 나는</h1>
        </div>
    
        <div class="answer">
            <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="1">
                <h3>'첫날에는 여기에서 저녁먹고...'</h3>
                <h3>세세하게 일정을 짠다.</h3>
            </button>
            <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="2">
                <h3>아직도 여행지만 정해둔 상태...</h3>
                <h3>핫플만 간간히 사용한다.</h3>
            </button>
            
           
        </div>
    </div>

    <div class="q5">

        <div class="question">
            <h1>2번의 공휴일이 있는 10월!</h1>
            <h1>모처럼 쉬는 날 나는</h1>
        </div>
    
        <div class="answer">
            <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="1">
                <h3>집에만 있으면 답답해...</h3>
                <h3>나가서 진정한 자유를 누린다.</h3>
            </button>
            <button class="w-btn w-btn-gra1 w-btn-gra-anim" data-num="2">
                <h3>집에 있어야 에너지가 충전되지!</h3>
                <h3>집밖으로는 한 발자국도 안나간다.</h3>
            </button>
            
           
        </div>
    </div>

    <div class="result-main">
        <h1>소비테스트 결과</h1>

        <h2>당신의 돈에 대한 태도는</h2> <span class="result" id="resultTitle">"덕질하는 알뜰형" 입니다.</span>
        


        <div class="result-img">    
            <img src="/resources/images/testResult2.webp" class="result-img1 vibration" id="resultImg">
        </div>

        <div>
            <ol>
                <li id="li1">울적할 때 통장잔고를 보면 마음이 안정돼요.</li>
                <li id="li2">힘들게 모은 돈을 위험한 곳에 투자하고 싶지 않아요.</li>
                <li id="li3">신용카드보다는 체크카드를 선호해요.</li>
                <li id="li4">대출받아 주식투자하는 사람들을 이해하기 힘들어요.</li>
            </ol>
        </div>

        <div>
            <button id="btn-re">다시하기</button>
        </div>
        <div>
            <button id="btn2">메인페이지로(저장)</button>
        </div>
    </div>

    

    <script src="/resources/js/consumeTest.js"></script>

   
</body>
</html>