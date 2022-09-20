package testcases.GeneralFunctionality;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.codeborne.selenide.Selenide;

import _helpers.TestBase;
import pages.M_Calendar;
import pages.M_Reminders;
import pages.M_Tasks;
import pages.M_TopMenu;
import pages.M_WorkStack;
import pages.M_configurations;
import pages.generalFunctions.S_Tasks;
import pages.generalFunctions.S_UserCalendar;

public class TopPanelVerifying extends TestBase {

	@Test
	public void tc_verifyLeftTabPanel() throws AssertionError, IOException, InterruptedException {
		Selenide.switchTo().defaultContent();

		M_Reminders reminders = new M_Reminders();
		M_Tasks tasks = new M_Tasks();
		S_Tasks sTasks = new S_Tasks();
		M_Calendar calendar = new M_Calendar();
		S_UserCalendar sCalendar = new S_UserCalendar();
		M_configurations conf = new M_configurations();
		M_WorkStack workStack = new M_WorkStack();
		M_TopMenu topMenu = new M_TopMenu();

		topMenu.mWorkstack().click();
		workStack.lCloseAll().shouldBe(visible).click();

		topMenu.mReminders().shouldBe(visible).click();
		reminders.header().shouldBe(visible);
		reminders.verifyRemidersCounter(softAssert, topMenu);

		topMenu.mTasks().shouldBe(visible).click();
		tasks.hDueToday().shouldBe(visible);
		tasks.hOverdue().shouldBe(visible);
		tasks.verifyCounter(softAssert);
		tasks.lGoToTasks().click();

		System.out.println(sTasks.header().shouldBe(visible).getText());

		topMenu.mCalendar().shouldBe(visible).click();
		calendar.header().should(visible);
		calendar.verifyCalendarsDate(softAssert);
		calendar.lGoToCalendar().click();
		switchToFrame(sCalendar.frame, sCalendar.header);
		$(sCalendar.header).shouldBe(visible);

		switchTo().defaultContent();
		topMenu.fFastFind().shouldBe(visible).clear();
		topMenu.fFastFind().click();
		topMenu.fFastFind().val("as");
		softAssert.assertEquals(switchTo().alert().getText(), "Please enter minimum 3 character(s) for fast find search", "Error Message");
		switchTo().alert().accept();

		topMenu.mProfileMenu().click();
		topMenu.lLogOut().shouldBe(visible);

		topMenu.mConfigurations().shouldBe(visible).click();
		conf.lLanguage().click();
		softAssert.assertEquals(conf.Lang_header().getText(), "Change Language", "Lang Header");
		conf.Lang_selectMenu().click();
		softAssert.assertEquals(conf.Lang_quantity(), "0", "Lang Quantity");
		conf.Lang_close().click();

		topMenu.mConfigurations().click();
		conf.lPassword().click();
		softAssert.assertEquals(conf.Pwd_header().getText(), "Change Password", "Password Header");
		switchTo().frame(conf.Pwd_frame());
		conf.Pwd_fNewPwd().shouldBe(visible).sendKeys("asdas");
		conf.Pwd_fCurrentPwd().shouldBe(visible);
		conf.Pwd_fConfirmPwd().shouldBe(visible);
		switchTo().defaultContent();
		conf.Pwd_bClose().shouldBe(visible).click();

		topMenu.mConfigurations().click();
		conf.lMyDetails().click();
		softAssert.assertEquals(conf.Details_header().shouldBe(visible).getText(), "User Details", "Header");
		conf.Details_domain().shouldBe(visible);
		conf.Details_profile().shouldBe(visible);
		conf.Details_language().shouldBe(visible);
		conf.Details_close().click();

//		topMenu.mConfigurations().click();
//		conf.lControlPanelSettings().click();
//		softAssert.assertEquals(conf.CPL_Header().getText(), "Control Panel Settings", "CPL Header");
//		softAssert.assertEquals(conf.CPL_Message().getText(), "Are you sure to restore default settings for control panel? Click Ok button to continue.", "CPL Message");
//		conf.CPL_bOk().click();

		softAssert.assertAll();
	}
	
	

}
