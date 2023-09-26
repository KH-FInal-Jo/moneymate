<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10/dist/sweetalert2.min.css">
<link rel="stylesheet" href="/resources/css/header.css">

<!-- SweetAlert JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>가계부 작성</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet"
	href="/resources/css/account/accountBookInout.css">

<script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>


</head>
<body>

	<main>
		<section class="JheadMain">

			<div class="Jhead">
				<div><a href="/"><img src="/resources/images/로고.png"></a></div>
				<div class="head-board">
					<!-- 헤더 글 -->
					<div class="nav">


						<div class="headback color-5">
							<div class="row columns">
							<h3 class="headH3"></h3>
							<ul class="Jmenu align-center expanded text-center SMN_effect-25">
								<li class="headLi"><a href="/community/1" class="headA">커뮤니티</a></li>

								<c:if test="${!empty loginMember}" >
									<li class="headLi"><a href="/account/list" class="headA">가계부</a></li>
								</c:if>

								<li class="headLi"><a href="/consumetest" class="headA">소비 테스트</a></li>

								<li class="headLi"><a href="/event" class="headA">이벤트</a></li>

								<c:if test="${!empty loginMember}" >
									<li class="headLi"><a href="/member/mypage" class="headA">마이페이지</a></li>
								</c:if>
								
								<c:if test="${!empty loginMember}" >
									<li class="headLi"><a href="/chatting" class="headA">채팅</a></li>
								</c:if>

								<c:if test="${loginMember.authority == 1}">
									<li class="headLi"><a href="/admin/member" class="headA">관리자</a></li>
								</c:if>
							</ul>
							</div>
						</div>


						<%-- <a href="/community/1"><span>커뮤니티</span></a>
						<c:if test="${!empty loginMember}" >
						<a href="/account/list"><span>가계부</span></a>
						</c:if>
						<a href="/consumetest"><span>소비 테스트</span></a>
						<a href="/event"><span>이벤트게시판</span></a>
						<c:if test="${!empty loginMember}" >
							<a href="/member/mypage"><span>마이페이지</span></a>
						</c:if>
						<c:if test="${!empty loginMember}" >
							<a href="/chatting"><span>채팅</span></a>
						</c:if>
						
						<c:if test="${loginMember.authority == 1}">
						<a href="/admin/member"><span>관리자</span></a>
						</c:if> --%>
						<span class="Jalert"><i class="fa-solid fa-bell fa-2x" id="alarm-btn" style="color: #efe834;"></i></span>
						<div class="alarm-area">
							
							<span id="alarm-number">1</span>
							<div id="alarm-page">
								<div class="alarm-check">
									<span><i class="fa-solid fa-right-to-bracket"></i></span>
									<a href="#"><span>작성하신 댓글에 답글이 달렸습니다.11</span></a>
								</div>
								<div class="alarm-check">
									<span><i class="fa-solid fa-right-to-bracket"></i></span>
									<a href="#"><span>작성하신 댓글에 답글이 달렸습니다.22</span></a>
								</div>
								<div class="alarm-check">
									<span><i class="fa-solid fa-right-to-bracket"></i></span>
									<a href="#"><span>작성하신 댓글에 답글이 달렸습니다.33</span></a>
								</div>
								<button id="close-btn">닫기</button>
		

							</div>
						</div>
		
					</div>
					<!-- 헤더 프로필 -->
					<div class="login">
						<div>
							
							<img src="/resources/images/로그인 아이콘.png">
						</div>
						<div>
							<c:choose>
								<c:when test="${empty loginMember}">
									<a href="/member/login"><span>LOGIN</span></a>
									<a href="/member/signUp"><span>회원가입</span></a>
								</c:when>
							
								<c:otherwise>
									<a href="/member/logout"><span>로그아웃</span></a>
								</c:otherwise>
							</c:choose>
							
						</div>
						<div>
							
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="accBk-thumbnail">
			<img src="/resources/images/accountThumbnail.jpg">
		</section>

		<section>
		<c:if test="${sub  != 'Y'}" >

			<div class="adver1">
				<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
					<div class="carousel-inner" onclick="location.href='#'  ">

						<div class="carousel-item active" data-bs-interval="2000">
							<img src="/resources/images/khotel.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item" data-bs-interval="2000">
							<img src="/resources/images/aniLogo.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item" data-bs-interval="2000">
							<img src="/resources/images/Slogo.png" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<div class="subGo">광고가 싫다면~? <a href="/subscribe/info">구독하러가기 💨</a></div>

			</div>

		</c:if>
		</section>


		<!-- 가계부 윗부분 -->
		<section class="accBk-container">
			<div class="accBk-top">


				<div>
					<i class="fa-solid fa-pen-to-square fa-xl"></i>가계부
				</div>

				<form action="/account/insert/${bigAccountNo}" method="POST">

					<div class="accBk-record">

						<div>
							<input type="number" id="accBk-money" name="accountMoney"
								placeholder="금액을 입력해주세요."><h3>원</h3>
						</div>
						<div>
							<input type="text" name="selectedValue" value="지출" class="out" readonly/>
							<input type="text" name="selectedValue" value="수입" class="in" readonly/>
							<input type="text" name="selectedValue" value="이체" class="trans" readonly/>


							<input type="hidden" name="inoutName" class="inoutResult"/>

						</div>
						<div class="accBk-record-category">

							<div>
								<div>카테고리</div>
								<div class="categoryBtn">
									선택 <i class="fa-solid fa-right-to-bracket fa-lg"></i>
								</div>
								<div class="hiddenCate">
									<input type="text" class="inputCategoryName" name="categoryName" readonly/>
									<button type="button" id="cateChBtn">변경하기</button>
								
								</div>
							</div>

							<div class="accBk-category-table">
								<div id="cate1">
									<input type="text" value="식비" class="accBk1" name="1" readonly/>
									<input type="text" value="교통" class="accBk2" name="2" readonly/>
									<input type="text" value="문화생활" class="accBk3" name="3" readonly/>
									<input type="text" value="마트" class="accBk4" name="4" readonly/>
								</div>
								<div id="cate2">
									<input type="text" value="패션" class="accBk5" name="5" readonly/>
									<input type="text" value="미용" class="accBk6" name="6" readonly/>
									<input type="text" value="생활용품" class="accBk7" name="7" readonly/>
									<input type="text" value="주거/통신" class="accBk8" name="8" readonly/>
								</div>
								<div id="cate3">
									<input type="text" value="건강" class="accBk9" name="9" readonly/>
									<input type="text" value="교육" class="accBk10" name="10" readonly/>
									<input type="text" value="경조사" class="accBk11" name="11" readonly/>
									<input type="text" value="부모님" class="accBk12" name="12" readonly/>
								</div>


								<%-- 수입 버튼 눌렀을 때 --%>
								<div id="cate4">
									<input type="text" value="월급" class="accBk2-1" name="1" readonly/>
									<input type="text" value="부수입" class="accBk2-2" name="2" readonly/>
									<input type="text" value="용돈" class="accBk2-3" name="3" readonly/>
								</div>

								<div id="cate5">
									<input type="text" value="상여" class="accBk2-4" name="4" readonly/>
									<input type="text" value="금융소득" class="accBk2-5" name="5" readonly/>
									<input type="text" value="기타" class="accBk2-6" name="6" readonly/>
								</div>
							</div>



							<div class="accBkResult2">
								<div>결제내역</div>
								<div>
									<input type="text" name="account">
								</div>
							</div>
							<div class="accBkResult3">
								<div>결제수단</div>
								<div>
									<select name="paymentMethod" id="accBk-payment"
										value="paymentMethod">
										<option value="현금">현금</option>
										<option value="무통장입금">무통장입금</option>
										<option value="신용카드">신용카드</option>
									</select>
								</div>
							</div>
							<div class="accBkResult4">
								<div>날짜</div>
								<div>
									<input type="date" value="accBkDate" class="date" name="relevantDate">
								</div>
							</div>
							<div class="accBkResult5">
								<div>메모</div>
								<div>
									<input type="text" name="memo">
								</div>
							</div>


						</div>

						<div>
							<button type="submit" class="btn-hover color-1">제출하기</button>
						</div>


					</div>


				</form>
			</div>
			<!-- 가계부 계산기 -->
			<div class="accBk-cal">
				<div class="calculator">
					<div class="calculator__display--for-advanced">0</div>
					<div class="calculator__buttons">
						<div class="clear__and__enter">
							<button class="clear">AC</button>
							<button class="calculate">Enter</button>
						</div>
						<div class="button__row">
							<button class="number">7</button>
							<button class="number">8</button>
							<button class="number">9</button>
							<button class="operator">+</button>
						</div>
						<div class="button__row">
							<button class="number">4</button>
							<button class="number">5</button>
							<button class="number">6</button>
							<button class="operator">-</button>
						</div>
						<div class="button__row">
							<button class="number">1</button>
							<button class="number">2</button>
							<button class="number">3</button>
							<button class="operator">*</button>
						</div>
						<div class="button__row">
							<button class="number double">0</button>
							<button class="decimal">.</button>
							<button class="operator">/</button>
						</div>
					</div>
				</div>
			</div>

		</section>

		<!-- 가계부 밑부분 -->
		<section class="accMileage-container">
			<div class="accMileage-left">
				<div>
					<i class="fa-regular fa-calendar-days fa-xl"></i>
					<div class="accDate">
						<span class="startDate">${account.startDate}</span>~<span class="endDate">${account.endDate}</span>
					</div>
				</div>

				<div class="accTargetCon">
					<div>한달 목표 예산</div>
					<div>
						<div class="accTargetMoney" id="accTargetMoneyId">${account.targetMoney}</div>
						<div>원</div>
					</div>
				</div>
				<div class="accTargetUsed">
					<div>사용 금액</div>
					<div>
						<div class="accUsedMoney">${useMoney}</div>
						<div>원</div>
					</div>
				</div>
				<!-- 목표예산 프로그레스 -->
				<c:if test="${useMoney != 0}" >
					<progress value="" max="100" class="accProgress"></progress>

				</c:if>

				<div class="accTarget-container">
					<button type="button" class="accTargetBtn">
						<i class="fa-solid fa-gear fa-lg"></i>목표 예산설정
					</button>
					<div class="accTarget">
						<input type="text" class="accTargetInput"
							placeholder="금액을 입력해주세요." name="accTarget"> 원
						<button class="accTargetBtn2"  onclick="submitTarget()">등록</button>
					</div>

				</div>
			</div>
			<div>
				<button class="accDateRecordBtn">기간선택</button>
				<div class="accDateRecord">
					<input type="date" id="startDateInput" min="yyyy-MM-dd">
					<input type="date" id="endDateInput">
					<button id="accDateChange">변경하기</button>
				</div>

			</div>


			<div class="accMileage-right">
				<div>
					<img src="/resources/images/MileageThumbnail.jpg">
				</div>
				<div>
					<button type="button" onclick="window.location.href='/member/mypage'">나의 마일리지 확인하러 가기!</button>
				</div>
			</div>
		</section>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />



	</main>
	<script src="/resources/js/header.js"></script>
	<script src="/resources/js/accountTarget.js"></script>
	<script src="/resources/js/accountInout.js"></script>

	<script>

	

	
		const bigAccountNo = `${bigAccountNo}`;
		const startDate1 = `${account.startDate}`;
		const endDate1 = `${account.endDate}`;
		const targetMoney = `${account.targetMoney}`;
		const useMoney = `${useMoney}`;
		console.log(useMoney);
		console.log(bigAccountNo);
		console.log(startDate1);
		console.log(targetMoney);
		console.log(endDate1);
	</script>








</body>
</html>