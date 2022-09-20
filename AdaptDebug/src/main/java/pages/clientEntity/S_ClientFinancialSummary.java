package pages.clientEntity;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import _helpers.MySoftAssert;

import _helpers.TestBase;

public class S_ClientFinancialSummary extends TestBase {
	//constants
	private String defaultFinStatus = "Active";
	
	//elems
	private By lCreditStatus   			= By.id("lCreditStatus");	
	private By fFinStatus				= By.xpath(".//input[@id='entitydcbStatus$B_E_FinClientSummary$B_E_Financials']"); 
	
	
	//iframes
	private By frClientFinGeneral		= By.xpath(".//iframe[@id='blank']");
	private By frClientFinInner			= By.id("vmInnerFrame");
	
		
	
	//init elements
	public SelenideElement frClientFinInner() {
		return $(frClientFinInner);
	}
	
	public SelenideElement frClientFinGeneral() {
		return $(frClientFinGeneral);
	}
	
	
	public SelenideElement fFinStatus () {
		return $(fFinStatus);
	}
	
	public SelenideElement lCreditStatus () {
		return $(lCreditStatus);
	}
	
	
	//asserts	
	public void verifyFinStatus (MySoftAssert softAssert) {	
		//Assert that Status equal to expected. Assumes that element exists and has appropriate value
		String finStatus = fFinStatus().getText();
		softAssert.assertEquals(finStatus,  defaultFinStatus);
		
	}

}
