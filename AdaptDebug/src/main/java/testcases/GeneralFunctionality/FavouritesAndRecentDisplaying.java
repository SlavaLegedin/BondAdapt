package testcases.GeneralFunctionality;

import static com.codeborne.selenide.Condition.*;

import org.testng.annotations.Test;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.S_PeopleHome;

public class FavouritesAndRecentDisplaying extends TestBase {

	@Test
	public void favouritesAndRecentDisplaying() throws InterruptedException {
		switchTo().defaultContent();
		M_LeftHandMenu lh = new M_LeftHandMenu();
		lh.openPeople();
		lh.lPeople_General().click();
		S_PeopleHome pg = new S_PeopleHome();
		pg.switchToPersonAdvansedLookup();
		pg.chCandidate().click();
		pg.bFind().click();
		pg.swithToLookupResults();
		String firstResultName = pg.lFirstSearchResult().shouldBe(visible).getText();
		pg.lFirstSearchResult2().shouldBe(visible).click();
		pg.switchToHeader();
		softAssert.assertEquals(firstResultName, pg.hMainHeader().getText(), "Switched To candidate: ");
		pg.swithToRootPeople();
		pg.bAddToFavourites().shouldBe(visible).click();
		switchTo().defaultContent();
		lh.lPeople_General().click();
		pg.swithToRootPeople();
		pg.lFavorText(firstResultName).shouldBe(visible);
		pg.swithToRecentHystory();
		pg.lRecentHistoryText(firstResultName).shouldBe(visible);
		pg.swithToRootPeople();
		pg.lFavorText(firstResultName).shouldBe(visible).click();
		pg.swithToRootPeople();
		pg.bDelToFavourites().shouldBe(visible).click();
		switchTo().defaultContent();
		lh.lPeople_General().click();
		pg.swithToRootPeople();
		pg.lFavorText(firstResultName).shouldNotBe(exist).click();
		softAssert.assertAll();
	}

}
