package pages.generalFunctions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.codeborne.selenide.SelenideElement;

import _helpers.MySoftAssert;
import _helpers.TestBase;

public class S_UserCalendar extends TestBase {
	

	public String ucName 		= "Kostiantyn Prokhorov";
	public String fullTime 		= "0:00";
	public String usTime 		= "12:00 AM";
	
	public int size1h			= 24;
	public int size30m			= 48;
	public int size15m			= 96;
	
	
	private String calendarDay = time.getSysdate(" E M/d");
	private String lDate = time.getSysdate("d ");
	private String headerDay = "- " + time.getSysdate("EEEE MMMM d,YYYY");

	//frame and header
	public By	header				= By.xpath(".//*[@class='calendar-main-header-text main-header-text ']");
	public By	frame				= By.xpath(".//iframe[@id='calendar_CONTROL_PANEL_0_Frame']");
	public By	leftFrame			= By.cssSelector("#calendarLeftFrame");

	// main calendar page
	private By lCalendar 			= By.xpath(".//span[@id = 'menuItem-1']");

	// top-left side
	private By	bSynchronize		= By.xpath(".//button[@id = 'calendar-synchronize']");
	private By	bRefresh			= By.xpath(".//button[@id = 'calendar-refresh']");

	// top-right side
	private By	bTodayCalendar		= By.xpath(".//button[contains(text(),\"Today's Calendar\")]");
	private By	bLeftArrow			= By.xpath(".//i[contains(@class, 'icon-black-blue icon-chevron-left')]");
	private By	bRightArrow			= By.xpath(".//i[contains(@class, 'icon-black-blue icon-chevron-right')]");

	// center-right side
	private By	bDay				= By.xpath(".//button[text() = 'Day']");				
	private By	bFiveDay			= By.xpath(".//button[starts-with(text(), 'Five day')]");
	private By	bWeek				= By.xpath(".//button[starts-with(text(), 'Week')]");
	private By	bMonth				= By.xpath(".//button[starts-with(text(), 'Month')]");
	private By	bSettings			= By.xpath(".//i[@id = 'cog_button']/parent::button");		
	
	//calendar elements
	private By 	lFirstTimeValue		= By.xpath(".//span[@class = 'full-hour' and @id = '0_0']");
	private By	lOneDayTitle		= By.xpath(".//td[contains(@class,'col_dayview_header_right colWidth1Day')]");
	private By  timeIntervalLine 	= By.xpath(".//td[@class = 'colWidth1Day']/table[@id = 'calendar-table']/tbody/tr");
	
	//calendar cells
	//private By aAppointment			= By.xpath(".//a[contains(text(), '" + Other.Variables.candFirstName + "')]");
	private By tableCalendar		= By.xpath(".//table[@id = 'monthCalendar']");
	//private By aAppointDate			= By.xpath(".//a[contains(text(), '" + Other.Variables.candFirstName + "')]/parent::td/div/a");
	
	//calendar popup
	private By aCandName			= By.xpath(".//div[@id = 'BISPopupContent']/div/p/a");
	
	
	
	//booking elements
	
	// main calendar page initialization
	//Calendar table
	public SelenideElement tableCalendar () {
		return $(tableCalendar);
	}
	
	public SelenideElement aAppointment (String candFirstName) {
		return $(By.xpath(".//a[contains(text(), '" + candFirstName + "') and contains(@class, 'links03')]"));
	}
	
	public SelenideElement aAppointDate	(String candFirstName) {
		return $(".//a[contains(text(), '" + candFirstName + "')]/parent::td/div/a");
	}
	
	public SelenideElement aCandName () {
		return $(aCandName);
	}
	
	//**************************************************************//
	
	public SelenideElement frame() {
		return $(frame);
	}
	
	public SelenideElement leftFrame () {
		return $(leftFrame);
	}

	public SelenideElement bSynchronize() {
		return $(bSynchronize);
	}

	public SelenideElement bRefresh() {
		return $(bRefresh);
	}

	public SelenideElement bLeftArrow() {
		return $(bLeftArrow);
	}

	public SelenideElement bRightArrow() {
		return $(bRightArrow);
	}

	public SelenideElement bTodayCalendar() {
		return $(bTodayCalendar);
	}

	public SelenideElement bDay() {
		return $(bDay);
	}

	public SelenideElement bFiveDay() {
		return $(bFiveDay);
	}

	public SelenideElement bWeek() {
		return $(bWeek);
	}

	public SelenideElement bMonth() {
		return $(bMonth);
	}

	public SelenideElement bSettings() {
		return $(bSettings);
	}

	// particular date
	public SelenideElement lDate() {
		return $(By.xpath(getDateXpath(lDate)));
	}
	
	//return xpath with date
	public String getDateXpath (String ldate) {
		ldate = ".//a[text() =" +  "'" + ldate + "']";
		return ldate;
	}
	
	public SelenideElement lFirstTimeValue () {
		return $(lFirstTimeValue);
	}
	
	public SelenideElement lOneDayTitle () {
		return $(lOneDayTitle);
	}
	

	// assertions
	// Day view assertions
	public void dayAssert(MySoftAssert softAssert) {
		softAssert.assertEquals($$(By.xpath(".//td[contains(@class,'col_dayview_header_right colWidth1Day')]")).size(), 1);
		softAssert.assertEquals($(By.xpath(".//button[text() = 'Day']")), $(By.xpath(".//button[contains(@class, 'active')]"))); //check that button is active
	}

	// Five days view assertions
	public void fiveDayAssert(MySoftAssert softAssert) {
		softAssert.assertEquals($$(By.xpath(".//td[contains(@class,  'col_dayview_header_right colWidth5Day')]")).size(), 5);
	}

	// Week view assertions

	public void weekAssert(MySoftAssert softAssert) {
		softAssert.assertEquals($$(By.xpath(".//td[contains(@class,  'col_dayview_header_right colWidth7Day')]")).size(), 7);
	}

	// Month view assertions
	public void verifyMonthView(MySoftAssert softAssert) {
		softAssert.assertEquals($$(By.xpath(".//td[contains(@class,'monthHeading')]")).size(), 7);
		softAssert.assertEquals($$(By.xpath(".//table[@id = 'monthCalendar']/tbody/tr")), 7);
		softAssert.assertEquals($$(By.xpath(".//table[@id = 'monthCalendar']/tbody/tr[2]/td")), 7);
		softAssert.assertEquals($(By.xpath(".//table[@id = 'monthCalendar']/tbody/tr[1]")).getText(), "SUN");

	}
	
	//Today view Assertions
	public void verifyTodayView (MySoftAssert softAssert) {
		softAssert.assertEquals($(By.xpath(".//td[contains(@class, '  col_dayview_header_right colWidth1Day ')]")), calendarDay); //header
		softAssert.assertEquals($(By.xpath(".//div[@id = 'calendarSubHeading']/span")), headerDay);
	}
	
	//date after clicking of left arrow
	public void verifyLeftArrow (MySoftAssert softAssert) {
		
		String dayOfWeek 	= time.getSysdateMinusdd(2, " E ");
		String dayOfMonth 	= time.getSysdateMinusdd(2, "M//d");
		String fullDate 	= dayOfWeek + dayOfMonth;
			
		softAssert.assertEquals(lOneDayTitle().getText(),  fullDate);
		
	}
	
	//date after clicking of right arrow
	public void verifyRightArrow (MySoftAssert softAssert) {
		
		String dayOfWeek 	= time.getSysdatePlusdd(2, " E ");
		String dayOfMonth 	= time.getSysdatePlusdd(2, "M//d");
		String fullDate 	= dayOfWeek + dayOfMonth;
			
		softAssert.assertEquals(lOneDayTitle().getText(),  fullDate);
	}
	
	//verify date after clicking on particular date
	public void verifySelectedDate (SoftAssert softAssert) {
		
		String fullDate = time.getSysdate(" E M/d");
		softAssert.assertEquals(lOneDayTitle().getText(),  fullDate);
	}
	
	//time frequency verify
	public void verifyTimeInterval (SoftAssert softAssert, int expNumber) {
		int intervalSize = $$(timeIntervalLine).size();
		softAssert.assertEquals(intervalSize, expNumber);
	}
	
	//time format verify
	public void verifyTimeFormat (MySoftAssert softAssert, SelenideElement calendar, String expTime) {
		softAssert.assertEquals(calendar.getText(), expTime);
	}
	
	//check candidate name in appointment
	public void verifyCandidateName (MySoftAssert softAssert, SelenideElement aAppointDate, SelenideElement aAppointment, String date) {
		softAssert.assertEquals(aAppointDate, date);
		softAssert.assertTrue(aAppointment != null);
		softAssert.assertTrue(!aAppointment.exists());
	}
	
}
