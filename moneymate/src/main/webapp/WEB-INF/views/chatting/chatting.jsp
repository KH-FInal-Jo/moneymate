<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/member/chatting.css">
    <script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>
    <title>채팅</title>
</head>
<body>

    <main>
        <div class="chat-left-bar">
            <div class="leftBarIcon1"><i class="fa-solid fa-house fa-2xl"></i></div>
            <div class="leftBarIcon3"><i class="fa-solid fa-users fa-2xl"></i></div>
            <div class="leftBarIcon2"><i class="fa-solid fa-user-plus fa-2xl"></i></div>
            <div class="leftBarIcon4"><i class="fa-solid fa-comments fa-2xl"></i></div>
        </div>

        <!-- 유저 이름으로 찾아서 채팅하기 -->
        <%-- 성공 --%>
        <div id="leftBar1">
            <div>
                <i class="fa-solid fa-magnifying-glass fa-2xl"></i><input type="search" id="targetInput" name="inputName" placeholder="검색어를 입력하세요.">
            </div>
            <div>친구 추가 <i class="fa-solid fa-plus fa-sm"></i></div>
            
            <div id=resultArea>
                <li class="result-row">
                    <img class="result-row-img" src="../images/몽자.jpg">
                    <span>유저일</span>
                </li>
            </div>
            <!-- <div class="undefind">일치하는 회원이 없습니다.</div> -->

        </div>
        <!-- 나랑 친구들 구경 -->
            <div id="leftBar2">
                <div>
                    <i class="fa-solid fa-magnifying-glass fa-2xl"></i><input type="text" name="inputName" placeholder="검색어를 입력하세요.">
                </div>

                <div class="chat-my-profile">
                    <div>
                        <img src="../images/mongja2.jpg">
                    </div>
                    <div>
                        몽자
                    </div>
                    <div>
                        멍멍멍 집갈래...
                    </div>
                </div>


                <div>
                    <li class="result-row">

                        <c:forEach var="room" items="${roomList}">
                        ${room}
                            <c:if test="${!empty room.targetProfile}">
                                <img class="result-row-img" src="${room.targetProfile}">
                            </c:if>
                            <c:if test="${empty room.targetProfile}">
                                <%-- <img class="result-row-img" src="/resources/images/user.png"> --%>
                                <img class="result-row-img" src="/resources/images/몽자.jpg">
                            </c:if>
                            <span>${room.targetNickName}</span>
                        </c:forEach>
                    </li>
                    <li class="result-row">
                        <img class="result-row-img" src="../images/i.jpg">
                        <span>유저이</span>
                    </li>
                    <li class="result-row">
                        <img class="result-row-img" src="../images/몽자.jpg">
                        <span>유저삼</span>
                    </li>
                    <li class="result-row">
                        <img class="result-row-img" src="../images/accountThumbnail.jpg">
                        <span>유저사</span>
                    </li>
                    <li class="result-row">
                        <img class="result-row-img" src="../images/consumeTest-thumbnail.png">
                        <span>유저오</span>
                    </li>
        
                </div>

            </div>

        

        <!-- 메세지 확인 -->
        <div id="leftBar3">

            <div>
                <i class="fa-solid fa-magnifying-glass fa-2xl"></i><input type="text" name="inputName" placeholder="검색어를 입력하세요.">
            </div>

            <li class="result-row3">
                <div class="chatMessage3">
                    <div>
                        <img class="result-row-img" src="../images/몽자.jpg">
                    </div>
                    <div>
                        <div>유저임ㅇㅇ</div>
                        <div>채팅채팅~! 되나? 테스트</div>
                    </div>
                    <div>
                        <div>
                            오후 1:15
                        </div>
                        <div>
                            <div>2</div>
                        </div>
                    </div>
                </div>
            </li>
            <li class="result-row3">
                <div class="chatMessage3">
                    <div>
                        <img class="result-row-img" src="../images/mongja2.jpg">
                    </div>
                    <div>
                        <div>유저임ㅇㅇ</div>
                        <div>채팅채팅~! 되나? 테스트</div>
                    </div>
                    <div>
                        <div>
                            오후 1:15
                        </div>
                        <div>
                            <div>2</div>
                        </div>
                    </div>
                </div>
            </li>

            <li class="result-row3">
                <div class="chatMessage3">
                    <div>
                        <img class="result-row-img" src="../images/몽자.jpg">
                    </div>
                    <div>
                        <div>유저임ㅇㅇ</div>
                        <div>채팅채팅~! 되나? 테스트</div>
                    </div>
                    <div>
                        <div>
                            오후 1:15
                        </div>
                        <div>
                            <div>2</div>
                        </div>
                    </div>
                </div>
            </li>

            <li class="result-row3">
                <div class="chatMessage3">
                    <div>
                        <img class="result-row-img" src="../images/i.jpg">
                    </div>
                    <div>
                        <div>유저임ㅇㅇ</div>
                        <div>채팅채팅~! 되나? 테스트</div>
                    </div>
                    <div>
                        <div>
                            오후 1:15
                        </div>
                        <div>
                            <div>2</div>
                        </div>
                    </div>
                </div>
            </li>


            

        </div>

        <div class="chatting-main">

            <div>
                <i class="fa-regular fa-comment fa-2xl"></i> 채팅
            </div>

            <div class="display-chatting">
                <div class="opponentUser">
                    <img class="result-row-img" src="../images/몽자.jpg">
                    <span>유저일</span>
                </div>

                <!-- <ul class="chatting-message">
                    <li class="my-chat">
                       <span class="chatDate">00:01</span>
                       <p class="chat">안녕~~~~~~~~~~</p>
                    </li>
     
                    <li class="target-chat">
                        <div>
                            <div>
                                <img src="../images/몽자.jpg">
    
                            </div>
                            <div>유저일</div>
                        </div>
     
                        <div>
                            <p class="chat">
                                안녕하세요~~~~~~~~~~~~~
                            </p>
                            <span class="chatDate">00:02</span>
                        </div>
                    </li>
                 </ul>    -->

                 <div class="wrap">
                    <div class="chat ch1">
                        <div class="icon"><img src="../images/몽자.jpg" alt=""></div>
                        <div class="textbox">안녕하세요. 반갑습니다.</div>
                    </div>
                    <div class="chat ch2">
                        <div class="textbox">안녕하세요. 유저일입니다. 잘지냈나용</div>
                    </div>
                    <div class="chat ch1">
                        <div class="icon"><img src="../images/몽자.jpg" alt=""></div>
                        <div class="textbox">넹 잘 지내고있죵 제 영상 자주 시청하시나용 속삭이는 몽자요!!</div>
                    </div>
                    <div class="chat ch2">
                        <div class="textbox">잘 보고있죵! 너무 재밌어요 혹시 사람 아닌가요 ㅋㅋ</div>
                    </div>
                    <div class="chat ch1">
                        <div class="icon"><img src="../images/몽자.jpg" alt=""></div>
                        <div class="textbox">들켰다..... 멍멍</div>
                    </div>
                    <div class="chat ch2">
                        <div class="textbox">ㅋㅋㅋㅋㅋ 너무 귀여웡 ㅎㅎ 집 가고싶다</div>
                    </div>
                    <div class="chat ch1">
                        <div class="icon"><img src="../images/몽자.jpg" alt=""></div>
                        <div class="textbox">저도.. 아 엽떡 먹고싶다</div>
                    </div>
                    <div class="chat ch2">
                        <div class="textbox">엽떡이랑 치킨 고고 난 좀이따 집간다~~~~ 행복해~~~ ❤❤❤</div>
                    </div>
                </div>

            </div>

            <div>
                <div>
                    <input type="text" name="chatting-input">
                </div>
                <div>
                    <button>보내기</button>
                </div>
            </div>

        </div>


    </main>
    <script src="/resources/js/chatting.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

    
</body>
</html>