package pages.contactEntity;

import _helpers.MySoftAssert;
import _helpers.TestBase;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class W_CreateAContact extends TestBase {
	
	//variables
	public String windowTitle		= "Contact";
	
	
	//elements
	
	private By	frameInternal		= By.xpath(".//iframe[@id = 'blank']");
	
	private By	fContFN				= By.xpath(".//input[@id = 'FIRSTNAME$W_US_AddContact$W_US_AddContact']");
	private By	fContLN				= By.xpath(".//input[@id = 'LASTNAME$W_US_AddContact$W_US_AddContact']");
	private By	fCompany			= By.xpath(".//input[@id = 'COMPANY$W_US_AddContact$W_US_AddContact']");
	private By	fAddress1			= By.xpath(".//input[@id = 'STREET1$W_US_AddContact$W_US_AddContact']");
	private By	fCity				= By.xpath(".//input[@id = 'CITY$W_US_AddContact$W_US_AddContact']");
	private By	fState				= By.xpath(".//input[@id = 'STATE$W_US_AddContact$W_US_AddContact']");
	private By	fCountry			= By.xpath(".//input[@id = 'COUNTRY$W_US_AddContact$W_US_AddContact']");
	private By	fPostalCode			= By.xpath(".//input[@id = 'ZIPCODE$W_US_AddContact$W_US_AddContact']");
	private By	fEmail1				= By.xpath(".//input[@id = 'EMAIL1$W_US_AddContact$W_US_AddContact']");
	
	private By	bConfirm			= By.xpath(".//button[@id = 'Button1$W_US_AddContact$W_US_AddContact']/span");
	
	//initialization
	public SelenideElement frameInternal () {
		return $(frameInternal);
	}
	
	public SelenideElement bConfirm() {
		return $(bConfirm);
	}
	
	public SelenideElement fEmail1() {
		return $(fEmail1);
	}
	
	public SelenideElement fPostalCode() {
		return $(fPostalCode);
	}
	
	public SelenideElement fCountry () {
		return $(fCountry);
	}
	
	public SelenideElement fState() {
		return $(fState);
	}
	
	public SelenideElement fCity() {
		return $(fCity);
	}
	
	public SelenideElement fAddress1() {
		return $(fAddress1);
	}
	
	public SelenideElement fCompany() {
		return $(fCompany);
	}
	
	public SelenideElement fContLN() {
		return $(fContLN);
	}
	
	public SelenideElement fContFN() {
		return $(fContFN);
	}
	
	//assertion
	public void verifyClientName (MySoftAssert softAssert, String title) {
		
		softAssert.assertEquals(title,  fCompany().getText());
	}
	
	public void verifyClientAddress(MySoftAssert softAssert, String address1) {
		softAssert.assertEquals(address1,  fAddress1().getText());
	}
	
	public void verifyClientCity(MySoftAssert softAssert, String city) {
		softAssert.assertEquals(city,  fCity().getText());
	}
	
	public void verifyClientState(MySoftAssert softAssert, String state) {
		softAssert.assertEquals(state,  fState().getText());
	}
	
	public void verifyClientCountry(MySoftAssert softAssert, String country) {
		softAssert.assertEquals(country,  fCountry().getText());
	}
	
	public void verifyClientZip(MySoftAssert softAssert, String postCode) {
		softAssert.assertEquals(postCode,  fPostalCode().getText());
	}
	
	

}
