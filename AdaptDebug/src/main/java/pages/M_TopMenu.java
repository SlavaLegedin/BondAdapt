package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class M_TopMenu {
	public By	mWorkstack			= By.id("globalWorkstack");
	public By	mReminders			= By.id("Reminders");
	public By	counterReminders	= By.cssSelector("#Reminders>i>span");
	public By	counterTasks		= By.cssSelector("#Tasks>i>span");
	public By	mTasks				= By.id("Tasks");
	public By	mCalendar			= By.id("Calendar");
	public By	mEmail				= By.id("Email");
	public By	fFastFind			= By.id("FastFindInput");
	public By	bFastFind			= By.id("FastFindButton");
	public By	mProfileMenu		= By.cssSelector("a.dropdown-toggle");
	public By	mConfigurations		= By.id("cogButton");
	public By	lLogOut				= By.cssSelector("a#logout");
	public By	FF_All				= By.xpath(".//li[@class='popup-item']/span[text()='All']");
	public By	FF_People			= By.xpath(".//li[@class='popup-item']/span[text()='People']");
	public By	FF_Companies		= By.xpath(".//li[@class='popup-item']/span[text()='Companies']");
	public By	FF_Jobs				= By.xpath(".//li[@class='popup-item']/span[text()='Jobs']");
	public By	FF_Assignments		= By.xpath(".//li[@class='popup-item']/span[text()='Assignments']");

	public M_TopMenu() {
		switchTo().defaultContent();
	}

	public SelenideElement FF_All() {
		return $(FF_All);
	}

	public SelenideElement FF_People() {
		return $(FF_People);
	}

	public SelenideElement FF_Companies() {
		return $(FF_Companies);
	}

	public SelenideElement FF_Jobs() {
		return $(FF_Jobs);
	}

	public SelenideElement FF_Assignments() {
		return $(FF_Assignments);
	}

	public SelenideElement lLogOut() {
		return $(lLogOut);
	}

	public SelenideElement counterTasks() {
		return $(counterTasks);
	}

	public SelenideElement counterReminders() {
		return $(counterReminders);
	}

	public SelenideElement mEmail() {
		return $(mEmail);
	}

	public SelenideElement bFastFind() {
		return $(bFastFind);
	}

	public SelenideElement mWorkstack() {
		return $(mWorkstack).shouldBe(visible);

	}

	public SelenideElement mReminders() {
		return $(mReminders).shouldBe(visible);

	}

	public SelenideElement mTasks() {
		return $(mTasks).shouldBe(visible);
	}

	public SelenideElement mCalendar() {
		return $(mCalendar);
	}

	public SelenideElement fFastFind() {
		return $(fFastFind);
	}

	public SelenideElement mProfileMenu() {
		return $(mProfileMenu);
	}

	public SelenideElement mConfigurations() {
		return $(mConfigurations);
	}
}