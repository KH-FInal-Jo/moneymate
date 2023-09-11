<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

				<form action="#">

					<div class="accBk-record">

						<div>
							<input type="number" id="accBk-money" name="inputMoney"
								placeholder="금액을 입력해주세요.">원
						</div>
						<div>
							<button type="button" value="expenditure">지출</button>
							<button type="button" value="income">수입</button>
							<button type="button" value="transfer">이체</button>

						</div>
						<div class="accBk-record-category">
							<!--  <table border="1" id="table">
                                <tr>
                                    <th>카테고리</th>
                                    <td><button type="button" class="categoryBtn">선택 <i class="fa-solid fa-right-to-bracket fa-lg"></i>
                                            <div class="category">식비</div></button></td>
                                </tr>
                                <tr class="tr1">
                                    <th>결제내역</th>
                                    <td><input type="text" name="accBk-list"></td>
                                </tr>
                                <tr class="tr2">
                                    <th>결제수단</th>
                                    <td><select name="accBk-payment" id="accBk-payment" value="accBkPayment">
                                        <option value="1">무통장입금</option>
                                    </select></td>
                                </tr>
                                <tr class="tr3">
                                    <th>날짜</th>
                                    <td><input type="date" value="accBkDate"></td>
                                </tr>
                                <tr class="tr4">
                                    <th>메모</th>
                                    <td><input type="text" name="accBk-memo" id="accBk-memp"></td>
                                </tr> 
                                
                            </table> -->

							<div>
								<div>카테고리</div>
								<div class="categoryBtn">
									선택 <i class="fa-solid fa-right-to-bracket fa-lg"></i>
								</div>
								<span class="inputCategoryName"></span>
							</div>
							<div class="accBk-category-table">
								<div>
									<div class="accBk1" name="eat">식비</div>
									<div class="accBk2" name="traffic">교통</div>
									<div class="accBk3" name="culrural">문화생활</div>
									<div class="accBk4" name="mart">마트</div>
								</div>
								<div>
									<div class="accBk5" name="fashion">패션</div>
									<div class="accBk6" name="beauty">미용</div>
									<div class="accBk7" name="lifeStyle">생활용품</div>
									<div class="accBk8" name="residential">주거/통신</div>
								</div>
								<div>
									<div class="accBk9" name="health">건강</div>
									<div class="accBk10" name="education">교육</div>
									<div class="accBk11" name="event">경조사</div>
									<div class="accBk12" name="parent">부모님</div>
								</div>
							</div>
							<div class="accBkResult2">
								<div>결제내역</div>
								<div>
									<input type="text" name="accBkWrite">
								</div>
							</div>
							<div class="accBkResult3">
								<div>결제수단</div>
								<div>
									<select name="accBk-payment" id="accBk-payment"
										value="accBkPayment">
										<option value="1">무통장입금</option>
										<option value="2">신용카드</option>
									</select>
								</div>
							</div>
							<div class="accBkResult4">
								<div>날짜</div>
								<div>
									<input type="date" value="accBkDate" class="date">
								</div>
							</div>
							<div class="accBkResult5">
								<div>메모</div>
								<div>
									<input type="text" name="accBkMemo">
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
						<span class="startDate"> 2023-08-01</span> ~ <span class="endDate">2023-08-31</span>
					</div>
				</div>

				<div class="accTargetCon">
					<div>한달 목표 예산</div>
					<div>
						<div class="accTargetMoney">5,000,000</div>
						<div>원</div>
					</div>
				</div>
				<div class="accTargetUsed">
					<div>사용 금액</div>
					<div>
						<div class="accUsedMoney">3,000,000</div>
						<div>원</div>
					</div>
				</div>
				<!-- 목표예산 프로그레스 -->
				<progress value="60" max="100" class="accProgress"></progress>
				<div class="accTarget-container">
					<button type="button" class="accTargetBtn">
						<i class="fa-solid fa-gear fa-lg"></i>목표 예산설정
					</button>
					<div class="accTarget">
						<input type="text" class="accTargetInput"
							placeholder="금액을 입력해주세요." name="accTarget"> 원
						<button class="accTargetBtn2" onclick="accTargetInput2()">등록</button>
					</div>

				</div>
			</div>
			<div>
				<button class="accDateRecordBtn">기간선택</button>
				<div class="accDateRecord">
					<input type="date" id="startDateInput"> <input type="date"
						id="endDateInput"> <input type="submit" id="accDateChange"
						value="변경하기"></input>
				</div>

			</div>


			<div class="accMileage-right">
				<div>
					<img src="/resources/images/MileageThumbnail.jpg">
				</div>
				<div>
					<button type="button">나의 마일리지 확인하러 가기!</button>
				</div>
			</div>
		</section>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />



	</main>



	<script src="/resources/js/accountInout.js"></script>




</body>
</html>