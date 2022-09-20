package pages.generalFunctions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import _helpers.MySoftAssert;
import _helpers.SelenideElem;

public class W_UserCalendarSettings {

	// Calendar settings pop-up
	private By header = 					By.xpath(".//[@id = 'modalHeading']");

	// view type block
	private By rbMyCalendar = 			By.xpath(".//input[@id = 'myCal_rdo']");
	private By rbUserCalendar = 			By.xpath(".//input[@id = 'userCal_rdo']");
	private By ddlUserCalendar = 		By.xpath(".//button[@data-id ='viewTypeUserID']");
	private By fUserName = 				By.xpath(".//div[@class = 'bs-searchbox']/input"); // do we have better variant???

	// parameters block
	private By ddlTimeFormat = 			By.xpath(".//button[@data-id ='timeDisplayFormat']");
	private By ddlWeekStarts = 			By.xpath(".//button[@data-id ='weekStartDay']");
	private By ddlDayStarts = 			By.xpath(".//button[@data-id ='dayStartHour']");
	private By ddlTimeInterval = 		By.xpath(".//button[@data-id ='intervalSelect']");

	// save button
	private By bCalendarSave = 			By.xpath(".//button[@id = 'calendar_settings_save']");
	
	//options in DDL
	private By opInterval_15 =			By.xpath(".//span[contains(text(),'15 Minutes') and @class = 'text']");
	private By opInterval_30 = 			By.xpath(".//span[contains(text(),'30 Minutes') and @class = 'text']");	
	private By opInterval_1h = 			By.xpath(".//span[contains(text(),'1 Hour') and @class = 'text']");	
	private By opDisplay24h =			By.xpath("//span[contains(text(),'24-hour') and @class = 'text']");
	private By opDisplay12h =			By.xpath("//span[contains(text(),'12-hour') and @class = 'text']");
	
	// Calendar settings pop-up initialization
	// view type block initialization
	public SelenideElem display12h () {
		return new SelenideElem (opDisplay12h);
	}
	
	public SelenideElem display24h () {
		return new SelenideElem (opDisplay24h);
	}
	

	public SelenideElem interval_15() {
		return new SelenideElem(opInterval_15);
	}
	
	public SelenideElem interval_30 () {
		return new SelenideElem(opInterval_30);
	}
	
	public SelenideElem interval_1h () {
		return new SelenideElem (opInterval_1h);
	}
	

	public SelenideElement header() {
		return $(header);
	}

	public SelenideElement rbMyCalendar() {
		return $(rbMyCalendar);
	}

	public SelenideElement rbUserCalendar() {
		return $(rbUserCalendar);
	}

	public SelenideElement ddlUserCalendar() {
		return $(ddlUserCalendar);
	}

	public SelenideElement fUserName() {
		return $(fUserName);
	}

	// parameters block
	public SelenideElement ddlTimeFormat() {
		return $(ddlTimeFormat);
	}

	public SelenideElement ddlWeekStarts() {
		return $(ddlWeekStarts);
	}

	public SelenideElement ddlSayStarts() {
		return $(ddlDayStarts);
	}

	public SelenideElement ddlTimeInterval() {
		return $(ddlTimeInterval);
	}

	public SelenideElement ddTimeFormatSelection(String timeformat) {
		return $(".//*[contains(text(),'" + timeformat + "')]");
	}

	// save button
	public SelenideElement bCalendarSave() {
		return $(bCalendarSave);
	}

	// assertions block
	public void verifySelectedTimeFormat(MySoftAssert softAssert, String format) {

	}

	public void verifyOtherUserCalendarView(MySoftAssert softAssert) {
		softAssert.assertEquals($$(By.xpath(".//td[contains(@class,'col_dayview_header_right colWidth1Day')]")).size(), 1);
	}

}
