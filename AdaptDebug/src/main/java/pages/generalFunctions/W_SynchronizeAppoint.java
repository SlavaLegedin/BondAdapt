package pages.generalFunctions;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.codeborne.selenide.SelenideElement;

import _helpers.TestBase;

public class W_SynchronizeAppoint extends TestBase{
	
	public String wfSyncAppointHeader 	= "Synchronize Appointments"; 
	public String qSyncOpt0Rang = "-- Date range --";
	public String qSyncOpt1Today = "Today";
	public String qSynqcOpt2Today = "Today"; //not an error
	public String qSyncOpt3NxMonth = "The next month";
	public String qSyncOpt4Nx3Month = "The next 3 months";
	public String qSyncOpt5Nx6Month = "The next 6 months";
	public String qSyncOpt6PtMonth = "The past month";
	public String qSyncOpt7Pt3Month = "The past 3 months";
	public String qSyncOpt8Pt6Month = "The past 6 months";
	public String qSyncOpt9TYear = "This year";
	
	//title
	public By wHeader 					= By.xpath(".//span[@id = 'modalHeading']");
	
	//date picker from
	public By fFrom  					= By.xpath(".//input[@id = 'sync-from-date']");

	//date picker to
	public By fTo						= By.xpath(".//input[@id = 'sync-to-date']");
	
	//quick-sync options
	public By	ddlQuickSync			= By.xpath(".//select[@id = 'sync-quick-option']");
	public By bDdldownArrow				= By.xpath(".//td[@class='dropdown-arrow']");

	public By bStartSync 				= By.xpath(".//button[@id = 'sync-start']");
	public By bCancelSync				= By.xpath(".//button[@id = 'sync-cancel']");
	
	public By ddlRangeMenu				= By.xpath(".//div[contains(@class, 'contentWrap scrollElement scroll-40877')]");
	
	
	//initialization
	public SelenideElement ddlRangeMenu () {
		return $(ddlRangeMenu);
	}
	
	
	public SelenideElement bDdlDownArrow () {
		return $(bDdldownArrow);
	}
	
			
	public SelenideElement wHeader () {
		return $(wHeader);
	}
	
	
	public SelenideElement ddlQuickSync () 
	{
		return $(ddlQuickSync);
	}
	
	public SelenideElement bStartsync () {
		return $(bStartSync);
	}
	
	public SelenideElement bCancelSync () {
		return $(bCancelSync);
	}
	
	public SelenideElement fTo () {
		return $(fTo);
	}
	
	public SelenideElement fFrom () {
		return $(fFrom);
	}
	
	public SelenideElement optDateRange (String dateRange) {
		return $(By.xpath(".//span[@class = 'text' and contains(text(), '"+dateRange+"')]"));
	}
	
	//assertion
	public void verifySyncheader (SoftAssert softAssert, String header, SelenideElement wHeader) {
		softAssert.assertEquals(wHeader.getText(), header);
	}
	
	public void verifyDataPopulation (SoftAssert softAssert, String qSyncOpt) {

		int lastDay = time.getLastDayOfCurMonth();
		
		long timeStFrom = Long.parseLong(fFrom().getAttribute("value"));
		String dateFrom = time.getDateFromTimestamp(timeStFrom);
		
		long timeStTo = Long.parseLong(fTo().getAttribute("value"));
		String dateTo = time.getDateFromTimestamp(timeStTo);
		
		String expDateFrom  = "";
		String expDateTo = "";

		switch (qSyncOpt) {
			case "Today" : 				expDateFrom =  time.getSysdate("MMM d,yyyy"); 
						   				expDateTo =	   time.getSysdate("MMM d,yyyy");
				break;
			case "The next month": 		expDateFrom =  time.getSysdate("MMM d,yyyy"); ;
								   		expDateTo =    time.getSysdatePlusMM(1, "MMM d,yyyy");
				break;
			case "The next 3 months": 	expDateFrom =  time.getSysdate("MMM d,yyyy"); ;
									  	expDateTo =    time.getSysdatePlusMM(3, "MMM d,yyyy");
				break;
			case "The next 6 months": 	expDateFrom =  time.getSysdate("MMM d,yyyy"); ;
									  	expDateTo =    time.getSysdatePlusMM(6, "MMM d,yyyy");
				break;
			case "The past month": 		expDateFrom =  time.getSysdatePlusMM(-1, "MMM d,yyyy");
								   		expDateTo =    time.getSysdate("MMM d,yyyy"); ;
				break;
			case "The past 3 months": 	expDateFrom =  time.getSysdatePlusMM(-3, "MMM d,yyyy");
									  	expDateTo =    time.getSysdate("MMM d,yyyy"); ;
				break;
			case "The past 6 months": 	expDateFrom =  time.getSysdatePlusMM(-6, "MMM d,yyyy");
									  	expDateTo =    time.getSysdate("MMM d,yyyy"); ;
				break;
			case "This year": 			expDateFrom =  "Jan 1," + time.getSysdate("yyyy");
							  			expDateTo =    "Dec 31," + time.getSysdate("yyyy");
				break;
			default: 					expDateFrom = time.getSysdate("MMM ") + 1 + time.getSysdate(",yyyy"); //this month
					 					expDateTo = time.getSysdate("MMM ") + lastDay + time.getSysdate(",yyyy");
				break;
			
		}
		
		softAssert.assertEquals(dateFrom, expDateFrom);
		softAssert.assertEquals(dateTo, expDateTo);
	}
	


}
