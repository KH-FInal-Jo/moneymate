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
                    <c:if test="${empty loginMember.profileImage}" >
                        <img src="http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg">
                    </c:if>

                    <c:if test="${!empty loginMember.profileImage}" >
                        <img src="${loginMember.profileImage}" >
                    </c:if>
                </div>
                <div>
                    ${loginMember.memberNickname}
                </div>
            </div>


                <c:forEach var="room" items="${roomList}">
                    <li class="result-row" data-toggle="modal" data-room-id="${room.targetNo}">
                        <div>
                            <c:if test="${!empty room.targetProfile}">
                                <img class="result-row-img" src="${room.targetProfile}">
                            </c:if>
                            <c:if test="${empty room.targetProfile}">
                                <img class="result-row-img" src="http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg">
                            </c:if>
                        </div>
                        <span>${room.targetNickName}</span>
                        <div class="stateMessage">${room.stateMessage}</div>
                    </li>

                    <div id="myModal-${room.targetNo}" class="modal">
                        <form action="/chat/report" method="post" >
                            <div class="modal-content">
                                <div class="close" data-dismiss="modal">&times;</div>
                                <div class="modalImg">
                                    <c:if test="${!empty room.targetProfile}">
                                        <img class="result-row-img2" src="${room.targetProfile}">
                                    </c:if>
                                    <c:if test="${empty room.targetProfile}">
                                        <img class="result-row-img2" src="http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg">
                                    </c:if>
                                </div>
                                <input type="hidden" name="reportNo" value="${loginMember.memberNo}">
                                <input type="hidden" name="reportedNo" value="${room.targetNo}">
                                <input type="hidden" name="reportCode" value="2">
                                <input type="hidden" name="bcNo" value="${room.chattingNo}">

                                <div class="modalNick">${room.targetNickName}</div>
                                <div class="modalAdmin"><button type="button"  id="showModalButton">신고</button></div>

                                <div id="HidChatReport">
                                    <div>신고 이유</div>
                                    <div><textarea name="reportContent" class="inputReport"></textarea></div>
                                    <div><button>신고하기</button></div>

                                </div>
                                <%-- <div>Message</div>
                                <div>
                                    <div class="modalSta">${room.stateMessage}</div>
                                    <button class="edit-button" onclick="openEditModal(${room.targetNo})" data-toggle="modal" data-target="#editModal-${room.targetNo}">수정하기</button>
                                </div> --%>
                            </div>

                        </form>
                    </div>



                    <!-- 수정 모달 -->
                    <div id="editModal-${room.targetNo}" class="modal">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="close" data-modal-close="#editModal-${room.targetNo}">&times;</div>
                                <div>상태 메시지 수정</div>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <textarea id="editMessage-${room.targetNo}" class="form-control" rows="3">${room.stateMessage}</textarea>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-primary" onclick="updateStateMessage(${room.targetNo})">저장</button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
        </div>

        <!-- 메세지 확인 -->
        <div id="leftBar3">

            <%-- <div>
                <i class="fa-solid fa-magnifying-glass fa-2xl"></i><input type="text" name="inputName" placeholder="검색어를 입력하세요.">
            </div> --%>
            <div>
                <div><i class="fa-solid fa-ellipsis fa-xl"></i></div>            
                <div>채팅목록</div>            
            </div>

            <ul class="chatting-list">
            <c:forEach var="room" items="${roomList}">
                <li class="result-row3" chat-no="${room.chattingNo}" target-no="${room.targetNo}"  onclick="roomListAddEvent(this)" data-id="${room.targetNo}">
                    <div class="chatMessage3">
                        <div class="con1">
                            <c:if test="${!empty room.targetProfile}">
                                <img class="result-row-img" src="${room.targetProfile}">
                            </c:if>
                            <c:if test="${empty room.targetProfile}">
                                <img class="result-row-img" src="http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg">
                            </c:if>
                        </div>
                        <div class="con2">
                            <div class="target-name">${room.targetNickName}</div>
                            <div class="lastmessage">${room.lastMessage}</div>
                        </div>
                        <div class="con3">
                            <div class="sendtime">
                                ${room.sendTime}
                            </div>
                            <div class="notreadcount">
                                 <c:if test="${room.notReadCount > 0}">
                                <p class="not-read-count">${room.notReadCount}</p>
                                </c:if>
                            </div>
                        </div>

                    </div>
                </li>
            </c:forEach>
            </ul>
        </div>

        <div class="chatting-main">

            <div>
                <i class="fa-regular fa-comment fa-2xl"></i> 채팅
            </div>

            <div class="display-chatting">
                <div class="opponentUser">
                    <img class="result-row-img" src="/resources/images/gray.jpg">
                    <span></span>
                </div>

                 <div class="wrap">
                    <div class="chat ch1">
                    </div>
                    <div class="chat ch2">
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