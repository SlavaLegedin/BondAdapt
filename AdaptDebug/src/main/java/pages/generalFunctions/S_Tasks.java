package pages.generalFunctions;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import _helpers.TestBase;

public class S_Tasks extends TestBase {
	
	public By header = By.cssSelector(".main-header-text");
	
	//top panel left side
	
	//top panel right side
	private By bAddTask 		= By.xpath(".//div[@id = 'add_new_task_icon']");
	private By bAddTaskText		= By.xpath(".//td[@id = 'add_new_task_td']");
	
	//middle panel  -list control
	
	//bottom panel - preview

	public SelenideElement header() {
		return $(header);
	}
	
	
}