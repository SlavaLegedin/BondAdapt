package testcases.CalendarTC;

import static com.codeborne.selenide.Condition.visible;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.generalFunctions.S_UserCalendar;
import pages.generalFunctions.W_SynchronizeAppoint;


@Report
public class UserCalendarSyncVerify extends TestBase {

	/*
	 * check 6. Synchronization - Verify - WF - Verify - DDL - verify - Date - Run
	 * Synchronization 
	 * 7. Click on Refresh
	 */

	@Test (enabled = false)
	public void syncVerify() throws InterruptedException {

		SoftAssert softAssertL = new SoftAssert();

		M_LeftHandMenu lhm = new M_LeftHandMenu();
		S_UserCalendar uc = new S_UserCalendar();
		W_SynchronizeAppoint sa = new W_SynchronizeAppoint();
		lhm.openMyAdapt();
		lhm.lCalendar().shouldBe(visible).click();

		switchTo().defaultContent();
		switchToFrame(uc.frame, uc.leftFrame);
		
		// 6. click on refresh
		uc.bRefresh().shouldBe(visible).click();
		uc.verifySelectedDate(softAssert);
		
		//5. Synchronization
		uc.bSynchronize().click();
		switchTo().defaultContent();
		sa.verifySyncheader(softAssertL, sa.wfSyncAppointHeader, sa.wHeader());
	
		// next 3 month
		sa.bDdlDownArrow().shouldBe(visible).click();
		sa.optDateRange(sa.qSyncOpt3NxMonth).shouldBe(visible).click();
		sa.verifyDataPopulation(softAssertL, sa.qSyncOpt3NxMonth);
		// previous 6 month
		sa.bDdlDownArrow().shouldBe(visible).click();
		sa.optDateRange(sa.qSyncOpt8Pt6Month).shouldBe(visible).click();
		sa.verifyDataPopulation(softAssertL, sa.qSyncOpt8Pt6Month);
		
		// today
		sa.bDdlDownArrow().shouldBe(visible).click();
		sa.optDateRange(sa.qSyncOpt1Today).shouldBe(visible).click();
		sa.verifyDataPopulation(softAssertL, sa.qSyncOpt1Today);
		//confirm
		sa.bStartsync().shouldBe(visible).click();

		softAssertL.assertAll();
	}
	
}