package pages.candidateEntity;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import _helpers.TestBase;

public class S_CandidatePersonalInfo extends TestBase {
	
	private By bAddConfInfo				= By.xpath(".//button[@id = 'entityButton2$E_ContractCand_AboutMe$E_ContractCandidate_Payroll']");
	
	private By frCandPersonalInfo		= By.xpath(".//iframe[@id = 'E_ContractCand_AboutMe$E_ContractCandidate_Payroll']");
	
	
	public SelenideElement frCandPersonalInfo () {
		return $(frCandPersonalInfo);
	}
	
	public SelenideElement bAddConfInfo () {
		return $(bAddConfInfo);
	}

}
