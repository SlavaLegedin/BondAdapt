package pages;

import com.codeborne.selenide.SelenideElement;

import _helpers.MySoftAssert;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;

public class M_Reminders {
	public By						header			= By.cssSelector("p.heading");
	public List<SelenideElement>	listReminders	= $$("span.dueInOverDue");

	public SelenideElement header() {
		return $(header);
	}

	public void verifyRemidersCounter(MySoftAssert softAssert, M_TopMenu topMenu) {
		if (listReminders.size() > 0) {
			softAssert.assertEquals(listReminders.size(), topMenu.counterReminders().getText(), "Reminder Counter");
		}
	}

}