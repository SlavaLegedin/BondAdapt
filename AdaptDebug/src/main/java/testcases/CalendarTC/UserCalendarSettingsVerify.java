package testcases.CalendarTC;

import static com.codeborne.selenide.Condition.visible;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.annotations.Report;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.generalFunctions.S_UserCalendar;
import pages.generalFunctions.W_UserCalendarSettings;

@Report
public class UserCalendarSettingsVerify extends TestBase {
	
	/*5.Verify settings page - My Calendar - User
	 * Calendar - check - Open WF again and change to My Calendar - Change Time
	 * format, confirm and Check - Open Settings again change interval, confirm and
	 * */
	
	@Test
	public void settingsVerify () throws InterruptedException {
		
	M_LeftHandMenu lhm = new M_LeftHandMenu();
	S_UserCalendar uc = new S_UserCalendar();
	W_UserCalendarSettings cs = new W_UserCalendarSettings();
	SoftAssert softAssertL = new SoftAssert();

	lhm.openMyAdapt();
	lhm.lCalendar().shouldBe(visible).click();

	switchTo().defaultContent();
	
	// 5. Open of settings window
	switchToFrame(uc.frame, uc.leftFrame);
	uc.bSettings().shouldBe(visible).click();
	switchTo().defaultContent();
	cs.bCalendarSave().shouldBe(visible);

	// 5.1 View Calendar of another user
	cs.rbUserCalendar().shouldBe(visible).click();
	cs.ddlUserCalendar().shouldBe(visible).click();
	cs.fUserName().shouldBe(visible).click();
	cs.fUserName().sendKeys(uc.ucName);
	cs.bCalendarSave().shouldBe(visible).click();
	switchToFrame(uc.frame, uc.leftFrame);
	cs.verifyOtherUserCalendarView(softAssert);
	
	uc.bSettings().shouldBe(visible).click();
	switchTo().defaultContent();
	cs.rbMyCalendar().shouldBe(visible).click();
	cs.bCalendarSave().shouldBe(visible).click();
	switchToFrame(uc.frame, uc.leftFrame);
	cs.verifyOtherUserCalendarView(softAssert);

	// 5.2 Change Time Format
	uc.bDay().shouldBe(visible).click();
	
	//24h format
	uc.bSettings().shouldBe(visible).click();
	switchTo().defaultContent();
	cs.ddlTimeFormat().shouldBe(visible).click();
	cs.display24h().shouldBe(visible).click();
	cs.bCalendarSave().shouldBe(visible).click();
	switchToFrame(uc.frame, uc.leftFrame);
	uc.verifyTimeFormat(softAssert, uc.lFirstTimeValue(), uc.fullTime);
	
	//12h format
	uc.bSettings().shouldBe(visible).click();
	switchTo().defaultContent();
	cs.ddlTimeFormat().shouldBe(visible).click();
	cs.display12h().shouldBe(visible).click();
	cs.bCalendarSave().click();
	switchToFrame(uc.frame, uc.leftFrame);
	uc.verifyTimeFormat(softAssert, uc.lFirstTimeValue(), uc.usTime);

	// 5.3 Change Time Interval
	uc.bDay().shouldBe(visible).click();
	
	// 15 minutes
	uc.bSettings().shouldBe(visible).click();
	Selenide.switchTo().defaultContent();
	cs.ddlTimeInterval().shouldBe(visible).click();
	cs.interval_15().shouldBe(visible).click();
	cs.bCalendarSave().shouldBe(visible).click();
	switchToFrame(uc.frame, uc.leftFrame);
	uc.verifyTimeInterval(softAssert, uc.size15m);

	// 30 minutes
	uc.bSettings().click();
	switchTo().defaultContent();
	cs.ddlTimeInterval().shouldBe(visible).click();
	cs.interval_30().shouldBe(visible).click();
	cs.bCalendarSave().shouldBe(visible).click();
	switchToFrame(uc.frame, uc.leftFrame);
	uc.verifyTimeInterval(softAssert, uc.size30m);
	
	// 1 hour
	uc.bSettings().click();
	switchTo().defaultContent();
	cs.ddlTimeInterval().shouldBe(visible).click();
	cs.interval_1h().shouldBe(visible).click();
	cs.bCalendarSave().shouldBe(visible).click();
	switchToFrame(uc.frame, uc.leftFrame);
	uc.verifyTimeInterval(softAssert, uc.size1h);
	
	Selenide.switchTo().defaultContent();
				
	softAssertL.assertAll();

	}

}
