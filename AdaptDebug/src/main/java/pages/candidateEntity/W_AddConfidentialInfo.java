package pages.candidateEntity;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;


import _helpers.TestBase;

public class W_AddConfidentialInfo extends TestBase {
	
	public String wFTitle			=	"Add Confidential Information";
	public String ssn				=	variablesProp.getProperty("ssn");
	
	private By fSSN 				= 	By.xpath(".//input[@id = 'SSN$W_US_AddConfidentInform$W_US_AddConfidentInform']");
	
	private By frAddConfInfoFrame	=	By.xpath(".//iframe[@id = 'W_US_AddConfidentInform$W_US_AddConfidentInform']");
	
	private By bConfirm				=	By.xpath(".//button[@id = 'Button1$W_US_AddConfidentInform$W_US_AddConfidentInform']");
	
	public SelenideElement fSSN () {
		return $(fSSN);
	}
	
	public SelenideElement frAddConfInfoFrame () {
		return $(frAddConfInfoFrame);
	}
	
	public SelenideElement bConfirm () {
		return $(bConfirm);
	}
	

}
