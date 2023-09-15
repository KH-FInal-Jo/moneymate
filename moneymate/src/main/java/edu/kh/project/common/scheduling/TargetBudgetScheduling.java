package edu.kh.project.common.scheduling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import edu.kh.project.account.model.dto.JAccountBook;
import edu.kh.project.account.model.service.JAccountBkService;
import edu.kh.project.member.model.dto.JMember;
import edu.kh.project.member.model.dto.Member;


@Component
public class TargetBudgetScheduling {


	@Autowired
	private ServletContext servletContext;

	@Autowired
	private JAccountBkService service;

	@Autowired
	private HttpSession httpSession;

	SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");


	@Scheduled(cron = "0 0 * * * *") // 자정
	//@Scheduled(cron = "0,30 * * * * *")
	public void accountBkSelect() {

		List<JAccountBook> accountBk = service.selectAccountBk2();

		LocalDate currentDate = LocalDate.now();

		try {


			for (JAccountBook account : accountBk) {


				int bigAccountNo = account.getBigAccountNo();
				int targetMoney = account.getTargetMoney();
				int memberNo = account.getMemberNo();


				String endDateStr = account.getEndDate(); 

				Date endDate = inputDateFormat.parse(endDateStr);

				String formattedDate = outputDateFormat.format(endDate);

				// 지출 금액 가져오기

				if(formattedDate.equals(currentDate.toString())) {


					int selbigAccountNo = account.getBigAccountNo();
					int selmemberNo = account.getMemberNo();

					// 지출 금액 가져오기
					int useMoney = service.accountBkSelect(selbigAccountNo);

					System.out.println("번호 가져오기" + selbigAccountNo);
					System.out.println("지출금액 가져오기" + useMoney);
					System.out.println("멤버넘버 가져오기" + selmemberNo);

					if(useMoney <= targetMoney) {

						System.out.println("목표예산 성공!!");
						
						// 마일리지 update
						int result = service.insertMileage(selmemberNo);
						
						// 알림함 insert
						int result2 = service.insertAlert(selmemberNo);

						System.out.println("result 찍히나?" + result);

					}else {
						System.out.println("목표예산 실패");
					}

				}else {
					System.out.println("날짜가 달라");
				}

				System.out.println("포맷된 날짜: " + formattedDate);
				System.out.println("currentDate: " + currentDate);

				System.out.println("bigAccountNo" + bigAccountNo);
				System.out.println("targetMoney" + targetMoney);

				System.out.println("값 제발" +accountBk);
			}

		} catch (ParseException e) {

			e.printStackTrace();
		} 



	}






}
