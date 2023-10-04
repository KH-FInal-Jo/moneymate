package edu.kh.project.common.scheduling;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
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
import edu.kh.project.board.model.service.HBoardService;
import edu.kh.project.member.model.dto.JMember;
import edu.kh.project.member.model.dto.Member;

@Component
public class TargetBudgetScheduling {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private JAccountBkService service;

	@Autowired
	private HBoardService hService;

	@Autowired
	private HttpSession httpSession;

	SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	// @Scheduled(cron = "0,30 * * * * *") // 30초 마다 업데이트
	@Scheduled(cron = "0 0 * * * *") // 자정에만 업데이트
	public void accountBkSelect() {

		List<JAccountBook> accountBk = service.selectAccountBk2();

		System.out.println(accountBk);

		LocalDate currentDate = LocalDate.now();

		try {

			for (JAccountBook account : accountBk) {
				int bigAccountNo = account.getBigAccountNo();
				int targetMoney = account.getTargetMoney();
				int memberNo = account.getMemberNo();
				System.out.println("big" + bigAccountNo);
				System.out.println("targetMoney :" + targetMoney);
				System.out.println("memberNo : " + memberNo);

				String endDateStr = account.getEndDate();

				// 날짜 값이 null인 경우 처리
				if (endDateStr != null) {
					Date endDate = inputDateFormat.parse(endDateStr);
					String formattedDate = outputDateFormat.format(endDate);

					if (formattedDate.equals(currentDate.toString())) {
						int selbigAccountNo = account.getBigAccountNo();
						int selmemberNo = account.getMemberNo();

						// 지출 금액 가져오기
						int useMoney = service.accountBkSelect(selbigAccountNo);

						System.out.println("번호 가져오기" + selbigAccountNo);
						System.out.println("지출금액 가져오기" + useMoney);
						System.out.println("멤버넘버 가져오기" + selmemberNo);

						if (useMoney <= targetMoney) {
							System.out.println("목표예산 성공!!");
							// 마일리지 update
							int result = service.insertMileage(selmemberNo);
							// 알림함 insert
							int result2 = service.insertAlert(selmemberNo);
							System.out.println("result 찍히나?" + result);
						} else {
							System.out.println("목표예산 실패");
						}
					} else {
					}
				} else {
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// 삭제된 이벤트 이미지 제거 메소드
	
	  @Scheduled(cron = "0,30 * * * * *") public void deleteImage() {
	  System.out.println("----------- 삭제된 이미지 DB 제거 -----------");
	  
	  String filePath = servletContext.getRealPath("/resources/images/event");
	  
	  File path = new File(filePath); File[] eventArr = path.listFiles();
	  
	  List<File> imageList = Arrays.asList(eventArr);
	 
	  List<String> dbEventList = hService.selectDbEvent();
	  
	  if(!imageList.isEmpty()) { for(File file : imageList) {
	  if(dbEventList.indexOf(file.getName()) == -1) {
	  System.out.println(file.getName() + " 삭제"); file.delete(); } } }
	  
	  System.out.println("----------- 이벤트 이미지 삭제 스케줄러 종료 -----------");
	  
	  }
	  
	  // 삭제된 게시판 이미지 제거 메소드
	  
	  @Scheduled(cron = "0,30 * * * * *") public void deleteBoardImage() {
	  System.out.println("----------- 삭제된 이미지 DB 제거 -----------");
	  
	  String filePath = servletContext.getRealPath("/resources/images/board");
	  
	  File path = new File(filePath); File[] eventArr = path.listFiles();
	  
	  List<File> imageList = Arrays.asList(eventArr);
	  
	  List<String> dbEventList = hService.selectDbEvent();
	  
	  if(!imageList.isEmpty()) { for(File file : imageList) {
	  if(dbEventList.indexOf(file.getName()) == -1) {
	  System.out.println(file.getName() + " 삭제"); file.delete(); } } }
	  
	  System.out.println("----------- 이벤트 이미지 삭제 스케줄러 종료 -----------");
	  
	  }
	 

}
