<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10/dist/sweetalert2.min.css">

<!-- SweetAlert JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<meta charset="UTF-8">
<title>가계부 작성</title>
<link rel="stylesheet"
	href="/resources/css/account/accountBookInout.css">

<script src="https://kit.fontawesome.com/98acdabf0d.js"
	crossorigin="anonymous"></script>

</head>
<body>

	<main>
		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<section class="accBk-thumbnail">
			<img src="/resources/images/accountThumbnail.jpg">
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
								placeholder="금액을 입력해주세요."><h2>원</h2>
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
								<input type="text" class="inputCategoryName" name="categoryName" readonly/>
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
										<option value="1">무통장입금</option>
										<option value="2">신용카드</option>
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