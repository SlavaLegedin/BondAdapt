package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import _helpers.TestBase;

public class W_ScheduleInternalInterview extends TestBase {
	
	public String schedInterInterview = "Schedule Internal Interview";
	
	private By fDate			= By.xpath(".//input[@id = 'DATE$W_US_ScheInterInterview$W_US_ScheInterInterview']");
	private By bCurrDate		= By.xpath(".//input[@name = 'currentDate' and @group_id = 'DATE$W_US_ScheInterInterview$W_US_ScheInterInterview']");
	private By fTime			= By.xpath(".//input[@id = 'STARTTIME$W_US_ScheInterInterview$W_US_ScheInterInterview']");
	private By bCurrTime		= By.xpath(".//input[@name = 'currentTime']");
	private By bConfirm			= By.xpath(".//button[@id = 'Button1$W_US_ScheInterInterview$W_US_ScheInterInterview']");
	
	private By frameFields		= By.xpath(".//iframe[@id = 'blank']");
	
	
	public SelenideElement frameFields () {
		return $(frameFields);
	}
	
	public SelenideElement fDate () {
		return $(fDate);
	}
	
	public SelenideElement bCurrDate () {
		return $(bCurrDate);
	}
	
	public SelenideElement fTime () {
		return $(fTime);
	}
	
	public SelenideElement bConfirm () {
		return $(bConfirm);
	}
	
	public SelenideElement bCurrTime () {
		return $(bCurrTime);
	}

}
