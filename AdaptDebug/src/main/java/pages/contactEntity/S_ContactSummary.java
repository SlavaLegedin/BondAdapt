package pages.contactEntity;

import _helpers.TestBase;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import _helpers.MySoftAssert;

public class S_ContactSummary extends TestBase {
	
	private By contactId 				= By.xpath(".//input[@id='entityAttribute17$E_Contact_AboutMe$E_Contact_ManagementInformation']");
	private By address1 				= By.id("entityAttribute10$E_Contact_AboutMe$E_Contact_ManagementInformation"); //value
	private By city 					= By.id("entityCITY$E_Contact_AboutMe$E_Contact_ManagementInformation");
	private By state 					= By.id("entitySTATE$E_Contact_AboutMe$E_Contact_ManagementInformation"); //text
	private By postCode 				= By.id("entityZIPCODE$E_Contact_AboutMe$E_Contact_ManagementInformation"); //value
	private By country 					= By.id("entityCOUNTRY$E_Contact_AboutMe$E_Contact_ManagementInformation"); //text
	private By contactLn 				= By.id("entityLASTNAME$E_Contact_AboutMe$E_Contact_ManagementInformation"); //value
	private By contactFN 				= By.id("entityFIRSTNAME$E_Contact_AboutMe$E_Contact_ManagementInformation"); //value
	
	
	//iframes
	private By frContactGeneral 			= By.xpath(".//iframe[@id='E_Contact_AboutMe$E_Contact_ManagementInformation']");
	private By frContactInner				= By.xpath(".//iframe[@id='vmInnerFrame']");
	
	//init
	public SelenideElement fContactFN() {
		return $(contactFN);
	}
	
	public SelenideElement fContactLn() {
		return $(contactLn);
	}
	
	public SelenideElement fCountry() {
		return $(country);
	}
	
	public SelenideElement fPostCode() {
		return $(postCode);
	}
	
	public SelenideElement fState() {
		return $(state);
	}
	
	public SelenideElement fCity () {
		return $(city);
	}
	
	public SelenideElement frContactInner () {
		return $(frContactInner);
	}
	
	public SelenideElement frContactGeneral() {
		return $(frContactGeneral);
	}
	
	public SelenideElement fAddress1() {
		return $(address1);
	}
	
	public SelenideElement fContactId() {
		return $(contactId);
	}
	
	
	
	//assertion
	public void verifyPostCode(MySoftAssert softAssert, String postCode) {
		softAssert.assertEquals(postCode, fPostCode().getValue());
	}
	
	public void verifyCountry(MySoftAssert softAssert, String country) {
		softAssert.assertEquals(country,  fCountry().getText());
	}
	
	
	public void verifyState (MySoftAssert softAssert, String state) {
		softAssert.assertEquals(state, fState().getText());
	}
	
	
	public void verifyCity (MySoftAssert softAssert, String city) {
		softAssert.assertEquals(city, fCity().getValue());
	}
	
	public void verifyContactAddress1 (MySoftAssert softAssert, String address1) {
		softAssert.assertEquals(address1, fAddress1().getValue());
	}
	
	
	public void verifyContactId (MySoftAssert softAssert, String personId) {
		softAssert.assertEquals(personId, fContactId().getValue());
	}
	
	public void verifyContactFN (MySoftAssert softAssert, String fisrstName) {
			
		softAssert.assertEquals(fisrstName,  fContactFN().getValue());
	}		
		
	public void verifyCpntactLn(MySoftAssert softAssert, String lastName) {
		softAssert.assertEquals(lastName,  fContactLn().getValue());
	}
		
		
	

}
