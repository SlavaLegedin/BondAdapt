package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

public class M_LeftHandMenu {

	// tab names
	public 	By	tMyAdapt		= 		By.cssSelector("#menuItem-500000010");
	/** Use css where it is possible it works faster **/
	public 	By	tAdaptStudio	= 		By.cssSelector("#menuItem-100000135");

	
	public 	By	tPeople			= 		By.cssSelector("#menuItem-100000134");
	private By	lPeople_General	= 		By.xpath(".//a[@id = 'menuItem-100000134']/..//*[@id='menuItem-8']");
	
	public 	By	tCompanies		= 		By.cssSelector("#menuItem-100000132");
	private By  lCompanies_General = 	By.xpath(".//a[@id = 'menuItem-100000132']/..//*[@id='menuItem-8']");
	
	
	private	By	tJobOrders		= 		By.cssSelector("#menuItem-100000133");
	private By	lJobs_General	=		By.xpath(".//a[@id='menuItem-100000133']/..//*[@id='menuItem-8']");
	
	public 	By	tAssignments	= 		By.cssSelector("#menuItem-100000130");
	public 	By	tSearching		= 		By.cssSelector("#menuItem-100000128");
	public 	By	treporting		= 		By.cssSelector("#menuItem-8084936042538922");
	public 	By	tFinancials		= 		By.cssSelector("#menuItem-500000001");
	public 	By	tAdministration	= 		By.cssSelector("#menuItem-34445399229527686");
	public 	By	tHelp			= 		By.cssSelector("#menuItem-100000140");
	
	public 	By	lmyAdapt_Home	= 		By.cssSelector("#menuItem-34451671848167236");
	
	public 	By 	lTaskSashboard	= 		By.cssSelector("#menuItem-12");

	public SelenideElement myAdapt_Home() {
		return $(lmyAdapt_Home);
	}

	// content of tabs
	// My Adapt tab
	private By lCalendar 			= By.xpath(".//span[@id = 'menuItem-1']");
	private By lUserJournal			= By.xpath(".//span[@id	= 'menuItem-2']");
	private By currUserName			= By.xpath(".//span[@id = 'username']");
	private By lTaskDashBoard		= By.xpath(".//span[@id	= 'menuItem-12']");

	
	
	
	/** initialization of menu items **/
	public SelenideElement currUserName () {
		return $(currUserName);
	}

	// My Adapt tab and related links
	public SelenideElement lTaskDashBoard () {
		return $(lTaskDashBoard);
	}
	
	public SelenideElement lUserJournal () {
		return $(lUserJournal);
	}


	public SelenideElement tMyAdapt() {
		return $(tMyAdapt);
	}

	public SelenideElement lCalendar() {
		return $(lCalendar);
	}

	// Adapt Studio and related links

	// People and related links
	public SelenideElement tPeople() {
		return $(tPeople);
	}
	
	public SelenideElement lPeople_General() {
		return $(lPeople_General);
	}

	// companies and related links
	public SelenideElement lCompanies_General () {
		return $(lCompanies_General);
	}
	
	public SelenideElement tCompanies () {
		return $(tCompanies);
	}

	// Job Orders and related links
	public SelenideElement tJobs() {
		return $(tJobOrders);
	}
	
	public SelenideElement lJobs_General() {
		return $(lJobs_General);
	}

	// Assignments and related links

	// Searching and related links

	// Reporting and related links

	// Financials and related links

	// Administrations and related links

	// Administration and related links

	// Help and relate links

	// functions
	/** click on My adapt only if it collapsed. **/
	public void openJobs() {
		if (!lJobs_General().is(visible)) {
			tJobs().click();
			lJobs_General().shouldBe(visible);
		}
	}
	
	public void openCompanies() {
		if (!lCompanies_General().is(visible)) {
			tCompanies().click();
			lCompanies_General().shouldBe(visible);
		}
	}
	
	
	public void openPeople() {
		if (!lPeople_General().is(visible)) {
			tPeople().click();
			lPeople_General().shouldBe(visible);
		}
	}

	public void openMyAdapt() {
		if (!lCalendar().is(visible)) {
			tMyAdapt().click();
		}
	}

	// assertions

}
