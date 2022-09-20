package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

import _helpers.TestBase;

public class W_AddTask extends TestBase {
	
	public By header				= By.xpath(".//span[@id = 'modalHeading']");
	
	private By fSubject				= By.xpath(".//input[@id = 'task-title']");
	private By fDueDate				= By.xpath("");
	private By ddlStatus				= By.xpath("");
	private By fPercCompleted		= By.xpath("");
	private By chbReminder			= By.xpath("");
	private By fDate					= By.xpath("");
	private By fTime					= By.xpath("");
	private By fStartDate			= By.xpath("");
	private By fCompletedDate		= By.xpath("");
	private By ddlCategory			= By.xpath("");
	private By ddlPriority			= By.xpath("");
	private By ddlPriorityLevel		= By.xpath("");
	private By refRegarding			= By.xpath("");
	private By refPrimary			= By.xpath("");
	private By refAssignedTo			= By.xpath("");
	private By fNotes				= By.xpath("");
	private By bAdd					= By.xpath("");
	private By bCancel				= By.xpath("");
	
	
	//initialization
	public SelenideElement fSublect () {
		return $(fSubject);
	}
	
	
	
	//asserts

}
