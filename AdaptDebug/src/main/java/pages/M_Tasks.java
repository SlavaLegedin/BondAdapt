package pages;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

import _helpers.MySoftAssert;
import _helpers.TestBase;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;

public class M_Tasks extends TestBase {
	public By						hDueToday		= By.cssSelector("[id='tasks-notifications-dueToday']");
	public List<SelenideElement>	listReminders	= $$("p.tasks-notification");
	public By						hOverdue		= By.cssSelector("p#tasks-notifications-overdue");
	public By						lGoToTasks		= By.cssSelector(".notification-link");
	public By						nMoreTasks		= By.xpath(".//p[contains(text(),'...and another')]");
	public List<SelenideElement>	listTasks		= $$("p.tasks-notification");

	public SelenideElement nMoreTasks() {
		return $(nMoreTasks);
	}

	public SelenideElement hOverdue() {
		return $(hOverdue);
	}

	public SelenideElement lGoToTasks() {
		return $(lGoToTasks);
	}

	public SelenideElement hDueToday() {
		return $(hDueToday);
	}

	public String getMoreTasksCount() {
		String moreTasks = null;
		if (nMoreTasks().should(exist).is(exist)) {
			nMoreTasks().should(exist).scrollIntoView("{block: \"center\"}");
			moreTasks = nMoreTasks().should(exist).getText();
			moreTasks = moreTasks.replace("...and another ", "");
			moreTasks = moreTasks.replaceAll(" tasks", "");
		}
		return moreTasks;

	}

	public void verifyCounter(MySoftAssert softAssert) {
		M_TopMenu topMenu = new M_TopMenu();
		if (topMenu.counterTasks().is(exist)) {
			int taskCounter = Integer.parseInt(topMenu.counterTasks().getText());
			if (taskCounter > 25) {
				int listedTasks = listTasks.size() + Integer.parseInt(getMoreTasksCount());
				softAssert.assertEquals(Integer.toString(taskCounter), Integer.toString(listedTasks), "Tasks counter");
			}
		}
	}

}