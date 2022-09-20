package testcases.GeneralFunctionality;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;

import org.testng.annotations.Test;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.M_TopMenu;
import pages.S_FastFindResults;
import pages.S_PeopleHome;


public class FastFindVerifying extends TestBase {

	@Test
	public void tc_FastFindVerifying() {
		switchTo().defaultContent();
		M_TopMenu topMenu = new M_TopMenu();
		S_FastFindResults ffr = new S_FastFindResults();
		topMenu.fFastFind().shouldBe(visible).hover();
		topMenu.FF_All().shouldBe(visible).click();
		topMenu.fFastFind().shouldBe(visible).click();
		topMenu.fFastFind().clear();
		topMenu.fFastFind().sendKeys("test");
		topMenu.bFastFind().click();
		softAssert.assertEquals(ffr.header().shouldBe(visible).getText(), "FastFind Results for test", "Fast Find Results Header");
		ffr.tCandidate().shouldBe(visible);
		ffr.tCandidateExpand();
		ffr.verifyResultsTabsHeaders(softAssert, "Candidate", "Contact", "Supplier Candidate", "Supplier Contact", "Client", "Prospect", "Lead", "Supplier", "Contract Job", "Contract Job Opportunity",
				"Direct Job", "Contract Assignment", "Direct Placement");
		ffr.bClose().shouldBe(visible).click();

		topMenu.fFastFind().shouldBe(visible).hover();
		topMenu.FF_Companies().shouldBe(visible).click();
		topMenu.fFastFind().clear();
		topMenu.fFastFind().shouldBe(visible).click();
		topMenu.fFastFind().sendKeys("test");
		topMenu.bFastFind().click();
		ffr.verifyResultsTabsHeaders(softAssert, "Client", "Prospect", "Lead", "Supplier");
		ffr.bClose().shouldBe(visible).click();

		topMenu.fFastFind().shouldBe(visible).hover();
		topMenu.FF_Jobs().shouldBe(visible).click();
		topMenu.fFastFind().clear();
		topMenu.fFastFind().shouldBe(visible).click();
		topMenu.fFastFind().sendKeys("test");
		topMenu.bFastFind().click();
		ffr.verifyResultsTabsHeaders(softAssert, "Contract Job", "Contract Job Opportunity", "Direct Job");
		ffr.bClose().shouldBe(visible).click();

		topMenu.fFastFind().shouldBe(visible).hover();
		topMenu.FF_Assignments().shouldBe(visible).click();
		topMenu.fFastFind().clear();
		topMenu.fFastFind().shouldBe(visible).click();
		topMenu.fFastFind().sendKeys("test");
		topMenu.bFastFind().click();
		ffr.verifyResultsTabsHeaders(softAssert, "Contracta Assignment", "Direct Placement");
		ffr.bClose().shouldBe(visible).click();

		topMenu.fFastFind().shouldBe(visible).hover();
		topMenu.FF_People().shouldBe(visible).click();
		topMenu.fFastFind().clear();
		topMenu.fFastFind().shouldBe(visible).click();
		topMenu.fFastFind().sendKeys("test");
		topMenu.bFastFind().click();
		ffr.verifyResultsTabsHeaders(softAssert, "Candidate", "Contact", "Supplier Candidate", "Supplier Contact");
		ffr.tCandidate().shouldBe(visible);
		ffr.tCandidateExpand();
		String firstName = ffr.lFirstCandidateTableName().getText();
		if (!ffr.lFirstCandidateTableDelFav().is(visible)) {
			ffr.lFirstCandidateTableAddFav().shouldBe(visible).click();
		}
		ffr.lWF().hover();
		ffr.lLogCall().click();
		switchTo().window("Log a Call").close();
		switchTo().window("Adapt Control Panel");
		switchTo().defaultContent();

		ffr.bClose().shouldBe(visible).click();

		topMenu.fFastFind().clear();
		topMenu.fFastFind().click();
		// switchTo().alert().accept();

		M_LeftHandMenu lhm = new M_LeftHandMenu();
		lhm.openPeople();
		lhm.lPeople_General().click();
		S_PeopleHome pg = new S_PeopleHome();
		pg.lFavouriteName(firstName).shouldBe(visible);

		softAssert.assertAll();
	}

}
