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
                <%-- <li class="result-row">
                    <img class="result-row-img" src="../images/몽자.jpg">
                    <span>유저일</span>
                </li> --%>
            </div>
            <!-- <div class="undefind">일치하는 회원이 없습니다.</div> -->

        </div>
        <!-- 나랑 친구들 구경 -->
            <div id="leftBar2">

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
                    <c:forEach var="room" items="${roomList}">
                        <li class="result-row">

                            <c:if test="${!empty room.targetProfile}">
                                <img class="result-row-img" src="${room.targetProfile}">
                            </c:if>
                            <c:if test="${empty room.targetProfile}">
                                <%-- <img class="result-row-img" src="/resources/images/user.png"> --%>
                                <img class="result-row-img" src="/resources/images/몽자.jpg">
                            </c:if>
                            <span>${room.targetNickName}</span>
                            <div class="stateMessage">${room.stateMessage}</div>
                        </li>
                    </c:forEach>
                </div>

            </div>

        <!-- 메세지 확인 -->
        <div id="leftBar3">

            <div>
                <i class="fa-solid fa-magnifying-glass fa-2xl"></i><input type="text" name="inputName" placeholder="검색어를 입력하세요.">
            </div>

            <c:forEach var="room" items="${roomList}">
                <li class="result-row3" chat-no="${room.chattingNo}" target-no="${room.targetNo}"  onclick="roomListAddEvent(this)" data-id="${room.targetNo}">
                    <div class="chatMessage3">
                    ${room.targetNo}
                        <div>
                            <c:if test="${!empty room.targetProfile}">
                                <img class="result-row-img" src="${room.targetProfile}">
                            </c:if>
                            <c:if test="${empty room.targetProfile}">
                                <%-- <img class="result-row-img" src="/resources/images/user.png"> --%>
                                <img class="result-row-img" src="/resources/images/몽자.jpg">
                            </c:if>
                        </div>
                        <div>
                            <div class="target-name">${room.targetNickName}</div>
                            <div>${room.lastMessage}</div>
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
            </c:forEach>

        </div>

        <div class="chatting-main">

            <div>
                <i class="fa-regular fa-comment fa-2xl"></i> 채팅
            </div>

            <div class="display-chatting">
                <div class="opponentUser">
                    <img class="result-row-img" src="/resources/images/몽자.jpg">
                    <span>유저일</span>
                </div>

                 <div class="wrap">
                    <div class="chat ch1">
                    </div>
                    <div class="chat ch2">
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
                    <input type="text" id="inputChatting" name="chatting-input">
                </div>
                <div>
                    <button id="messageSend">보내기</button>
                </div>
            </div>

        </div>


    </main>

    
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

    <script>
        const loginMemberNo = `${loginMember.memberNo}`;
        console.log(loginMemberNo);
    </script>
    <script src="/resources/js/chatting.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

    
</body>
</html>