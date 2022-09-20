package testcases.GeneralFunctionality;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Condition.*;
import org.testng.annotations.Test;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.generalFunctions.S_RecruitmentStudio;


public class HomePageVerifying extends TestBase {

	@Test
	public void tc_FastFindVerifying() {
		switchTo().defaultContent();
		M_LeftHandMenu lm = new M_LeftHandMenu();
		lm.openMyAdapt();
		lm.myAdapt_Home().shouldBe(visible).click();
		S_RecruitmentStudio rc = new S_RecruitmentStudio();
		rc.verifyHeader();
		softAssert.assertAll();
	}

}
