package pages.clientEntity;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import _helpers.MySoftAssert;
import _helpers.TestBase;

public class S_ClientSummary extends TestBase {
	//variables
	
	//elements
	
	private By fClientName			= By.xpath(".//input[@id = 'entityNAME$E_ClientEntity_General$E_General_General']");
	private By fClientId 			= By.id("entityAttribute29$E_ClientEntity_General$E_General_General");
	private By fClientAddress1		= By.xpath(".//input[@id = 'entitySTREET1$E_ClientEntity_General$E_General_General']");
	private By fClientCity			= By.xpath(".//input[@id = 'entityCITY$E_ClientEntity_General$E_General_General']");
	private By fClientState			= By.xpath(".//input[@id='entitySTATE$E_ClientEntity_General$E_General_General']");
	private By fClientZip			= By.xpath(".//input[@id='entityZIPCODE$E_ClientEntity_General$E_General_General']");
	private By fClientCountry		= By.xpath(".//input[@id='entityCOUNTRY$E_ClientEntity_General$E_General_General']");
	
	//iframes
	private By frClientGeneral 		= By.xpath(".//iframe[@id = 'E_ClientEntity_General$E_General_General']");
	private By frClientInner		= By.xpath(".//iframe[@id='vmInnerFrame']");
	
	
	
	//initialization
	public SelenideElement fClientCountry() {
		return $(fClientCountry);
	}
	
	public SelenideElement fClientZip() {
		return $(fClientZip);
	}
	
	public SelenideElement fClientState () {
		return $(fClientState);
	}
	
	public SelenideElement fClientCity() {
		return $(fClientCity);
	}
	
	public SelenideElement fClientAddress1() {
		return $(fClientAddress1);
	}
	
	
	public SelenideElement frClientInner() {
		return $(frClientInner);
	}
	
	public SelenideElement frClientGeneral() {
		return $(frClientGeneral);
	}
	
	public SelenideElement fClientId() {
		return $(fClientId);
	}
	
	public SelenideElement lClientName() {
		return $(fClientName);
	}
	
	//assertion
	public void verifyClientName (MySoftAssert softAssert, String title) {
		
		softAssert.assertEquals(title,  lClientName().getText());
	}
	
	

	

	

}
