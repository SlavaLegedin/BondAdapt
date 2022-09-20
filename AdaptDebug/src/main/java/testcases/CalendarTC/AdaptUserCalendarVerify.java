package testcases.CalendarTC;

import static com.codeborne.selenide.Condition.visible;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.generalFunctions.S_UserCalendar;


@Report
public class AdaptUserCalendarVerify extends TestBase {

	/*
	 * Order of testing Open Calendar Click on Today 
	 * 1. Verifying of different views 	 * - Today view - Day view - 5 day view - Week view - Month view 
	 * 2. Return back  to Today day view 
	 * 3. Use arrows to move forward/backward 
	 * 4. Select month view  and jump to particular date 
	 */

	@Test (invocationCount = 1)
	public void calendarVerifyFunctions() throws InterruptedException {
		
		SoftAssert softAssertL = new SoftAssert();

		switchTo().defaultContent();
		M_LeftHandMenu lhm = new M_LeftHandMenu();
		S_UserCalendar uc = new S_UserCalendar();

		lhm.openMyAdapt();
		lhm.lCalendar().shouldBe(visible).click();

		switchToFrame(uc.frame, uc.leftFrame);

		// 1. Various views
		uc.bMonth().shouldBe(visible).click();
		uc.verifyMonthView(softAssert);
		uc.bWeek().shouldBe(visible).click();
		uc.weekAssert(softAssert);
		uc.bFiveDay().shouldBe(visible).click();
		uc.fiveDayAssert(softAssert);
		uc.bDay().shouldBe(visible).click();
		uc.dayAssert(softAssert);
		
		// 2. Today button
		uc.bTodayCalendar().shouldBe(visible).click();
		uc.verifyTodayView(softAssert);
		
		// 3. Using left arrow and right arrow
		// Click on left arrow two times
		uc.bLeftArrow().shouldBe(visible).click();
		uc.bLeftArrow().shouldBe(visible).click();
		uc.verifyLeftArrow(softAssert);
		
		// click on right arrow three times
		uc.bRightArrow().shouldBe(visible).click();
		uc.bRightArrow().shouldBe(visible).click();
		uc.bRightArrow().shouldBe(visible).click();
		// assert that particular date is presented
		uc.verifyRightArrow(softAssert);
		
		// 4. Click on particular day
		Thread.sleep(1000);
		
		uc.bMonth().shouldBe(visible).click();
		
		Thread.sleep(1000);
		
		uc.lDate().shouldBe(visible).click();
		uc.verifySelectedDate(softAssert);
		
		switchTo().defaultContent();
		
		softAssertL.assertAll();
	}

}
