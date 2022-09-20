package pages.clientEntity;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import _helpers.TestBase;

public class W_CreateACompany extends TestBase {
	//variables
	String clientName;
	String clientRole;
	String address1;
	String zipcode;
	
	public String windowTitle = "Create a Company";
	
	//xpaths vlock
	private By frameInternal		= By.xpath(".//iframe[@id = 'blank']");
	
	private By fCompanyName 		= By.xpath(".//input[@id = 'COMPANYNAME$W_US_AddCompany$W_US_AddCompany']");
	private By cgCompanyRole		= By.xpath(".//input[@id = 'ROLE$W_US_AddCompany$W_US_AddCompany']");
	private By fAddress1			= By.xpath(".//input[@id = 'ADDRESS1$W_US_AddCompany$W_US_AddCompany']");
	private By fPostalCode			= By.xpath(".//input[@id = 'ZIPCODE$W_US_AddCompany$W_US_AddCompany']");
	
	private By bConfirm				= By.xpath(".//button[@id = 'Button1$W_US_AddCompany$W_US_AddCompany']");
	
	
	//initialization of elements
	public SelenideElement frameInternal () {
		return $(frameInternal);
	}
	
	public SelenideElement fCompanyName () {
		return $(fCompanyName);
	}
	
	public SelenideElement cgCompanyRole () {
		return $(cgCompanyRole);
	}
	
	public SelenideElement fAddress1 () {
		return $(fAddress1);
	}
	
	public SelenideElement fPostalCode () {
		return $(fPostalCode);
	}
	
	public SelenideElement bConfirm () {
		return $(bConfirm);
	}
	
	
	//assertions
	
}
