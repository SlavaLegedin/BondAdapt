package pages.candidateEntity;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import _helpers.MySoftAssert;
import _helpers.TestBase;

import static com.codeborne.selenide.Selenide.$;

public class W_CreateACandidate extends TestBase {
	
	//it would be better to move all public strings to the properties file
	public String candMobNumber		 = "5555555555";
	public String candEmail 		= "@test.cc.com";
	public String wfTitleExp		= "Create a Candidate";
	public String postalCode		= "85050"; //Arizona postal code
	public String jobTitle			= "TestTitle";
	
	public By wfTitle				= By.xpath(".//title");
	public By wfheader				= By.xpath(".//span[@id = 'segmentTitle']");
	
	private By fFName 				= By.xpath(".//input[@id = 'FIRSTNAME$W_US_CreateACandidate$W_US_CreateACandidate']");
	private By fLName 				= By.xpath(".//input[@id = 'LASTNAME$W_US_CreateACandidate$W_US_CreateACandidate']");
	
	private By fAddress1			= By.xpath(".//input[@id = 'ADDRESSLINE1$W_US_CreateACandidate$W_US_CreateACandidate']");
	private By fAddress2			= By.xpath(".//input[@id = 'ADDRESSLINE2$W_US_CreateACandidate$W_US_CreateACandidate']");
	private By fCity				= By.xpath(".//input[@id = 'CITY$W_US_CreateACandidate$W_US_CreateACandidate']");
	private By fState				= By.xpath(".//input[@id = 'STATE$W_US_CreateACandidate$W_US_CreateACandidate']");
	private By fPostalCode			= By.xpath(".//input[@id = 'ZIPCODE$W_US_CreateACandidate$W_US_CreateACandidate']");
	private By fJobTitle			= By.xpath(".//input[@id = 'JOBTITLE$W_US_CreateACandidate$W_US_CreateACandidate']");
	
	private By fMobilePhone			= By.xpath(".//input[@id = 'MOBILE$W_US_CreateACandidate$W_US_CreateACandidate']");
	private By fEmail1				= By.xpath(".//input[@id = 'EMAIL$W_US_CreateACandidate$W_US_CreateACandidate']");
	private By bConfirm				= By.xpath(".//button[@id = 'Button1$W_US_CreateACandidate$W_US_CreateACandidate']");
	
	
	private By frameNames		= By.xpath(".//iframe[@id = 'blank']");
	
	public SelenideElement fJobTitle () {
		return $(fJobTitle);
	}
	
	public SelenideElement fPostalCode () {
		return $(fPostalCode);
	}
	
	public SelenideElement fCity () {
		return $(fCity);
	}
	
	public SelenideElement fState () {
		return $(fState);
	}
	
	public SelenideElement fAddress2 () {
		return $(fAddress2);
	}
	
	public SelenideElement fAddress1 () {
		return $(fAddress1);
	}
	
	public SelenideElement frameNames () {
		return $(frameNames);
	}
	
	public SelenideElement fFName () {
		return $(fFName);
	}
	
	public SelenideElement fLName () {
		return $(fLName);
	}
	
	public SelenideElement fMobilePhone () {
		return $(fMobilePhone);
	}
	
	public SelenideElement fEmail1 () {
		return $(fEmail1);
	}
	
	public SelenideElement bConfirm () {
		return $(bConfirm);
	}
	
	public SelenideElement wfTitle () {
		return $(wfTitle);
	}
	

}
