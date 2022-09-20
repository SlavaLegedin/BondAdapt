package pages;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import _helpers.MySoftAssert;
import _helpers.TestBase;

public class M_ClientMenu extends TestBase {

		//elements
		private By clientEntityTitle		= By.xpath(".//span[@id = 'WebUI_MainHeaderTitle']");
		
		//links to client roles
		private By lClientSegment		= By.xpath(".//div[@id = 'legacy-heading']//a[@roleid = '116']");
		private By lCompFinancial		= By.xpath(".//div[@id = 'legacy-heading']//a[@roleid = '500000075']");
		
		//activities menu
		private By mActivitiesMenu		= By.xpath(".//span[@id = 'entity-action-button-span']");
		
		//Add new menu
		private By lAddNew				= By.xpath(".//div[@class = 'BISPopupWrapper' and @tier = '1']");
		private By lAddContact			= By.xpath(".//span[@id = 'menuPopupItem-32615157475247671']");
		private By lAddJobOrder			= By.xpath(".//div[@class = 'BISPopupWrapper' and @tier = '2']");
		private By lContractJob			= By.xpath(".//span[@id = 'menuPopupItem-13460413591037893']");
		
		
		//Client Activities menu
		private By lClientActivities	= By.xpath(".//div[@class = 'BISPopupWrapper' and @tier = '1']//span[@id='menuPopupItem-500000040']");
		private By lActivateFinancial	= By.xpath(".//div[@class = 'BISPopupWrapper' and @tier = '2']//span[@id='menuPopupItem-500000743']");
		
		
		public String menuWindowName = "Adapt Control Panel";
		
		//top bar
		
		
		//initialization
		public SelenideElement lContractJob() {
			return $(lContractJob);
		}
		
		public SelenideElement lAddJobOrder () {
			return $(lAddJobOrder);
		}
	
		
		public SelenideElement lActivateFinancial() {
			return $(lActivateFinancial);
		}
		
		public SelenideElement lClientActivities() {
			return $(lClientActivities);
		}		
		
		public SelenideElement lCompFinancial() {
			return $(lCompFinancial);
		}
		
		public SelenideElement clientEntityTitle () {
			return $(clientEntityTitle);
		}		
		
		public SelenideElement lClientSegment () {
			return $(lClientSegment);
		}
		
		public SelenideElement mActivitiesMenu () {
			return $(mActivitiesMenu);
		}
		
		public SelenideElement lAddNew () {
			return $(lAddNew);
		}
		
		public SelenideElement lAddContact () {
			return $(lAddContact);
		}
		
		
		//assertion
		//public void verifyClientName (MySoftAssert softAssert, String title) {
		//	
		//	softAssert.assertEquals(title,  lClientEntityTitle().getText());
		//}
		
}
