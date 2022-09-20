package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import _helpers.MySoftAssert;
import _helpers.TestBase;

public class M_Calendar extends TestBase {
	public By	header			= By.cssSelector(".date");
	public By	lGoToCalendar	= By.cssSelector(".notification-link");

	public SelenideElement header() {
		return $(header);
	}

	public SelenideElement lGoToCalendar() {
		return $(lGoToCalendar);
	}

	public void verifyCalendarsDate(MySoftAssert softAssert) {
		String date = header().shouldBe(visible).getText();
		String sysdate = time.getSysdate("EEEE, MMMM dd, yyyy");
		//System.out.println(sysdate);
		softAssert.assertEquals(date, sysdate, "Todays Date");
	}

}