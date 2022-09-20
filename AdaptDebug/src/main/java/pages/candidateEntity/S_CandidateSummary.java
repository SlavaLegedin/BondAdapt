package pages.candidateEntity;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import _helpers.MySoftAssert;
import _helpers.TestBase;

public class S_CandidateSummary extends TestBase{
	
	
	private By lEntityTitle		= By.xpath(".//span[@id = 'WebUI_MainHeaderTitle']");
	
	private By frCandFrame 		= By.xpath(".//iframe[@id = 'legacyContainer']");
	private By frInnerFrame		= By.xpath(".//iframe[@id = 'vmInnerFrame']");
	private By frCandSummary	= By.xpath(".//iframe[@id = 'E_ContractCand_AboutMe$E_ContractCandidate_Summry']");
	
	private By fPersonId		= By.xpath(".//input[@id = 'entityAttribute20$E_ContractCand_AboutMe$E_ContractCandidate_Summry']");
	private By fBranch			= By.xpath(".//input[@id = 'entityBranch$E_ContractCand_AboutMe$E_ContractCandidate_Summry']");
	private By fNickName		= By.xpath(".//input[@id = 'entityNICKNAME$E_ContractCand_AboutMe$E_ContractCandidate_Summry']");
	
	private By fState			= By.xpath(".//input[@id = 'entitySTATE$E_ContractCand_AboutMe$E_ContractCandidate_Summry']");
	
	private By bEdit			= By.xpath(".//input[@id = 'EDIT']");
	private By bSave			= By.xpath(".//input[@id = 'SAVE']");
	
	
	public SelenideElement fState () {
		return $(fState);
	}
	
	public SelenideElement fBranch () {
		return $(fBranch);
	}
	
	public SelenideElement fNickName () {
		return $(fNickName);
	}
	
	public SelenideElement frcandFrame () {
		return $(frCandFrame);
	}
	
	public SelenideElement frCandSummary () {
		return $(frCandSummary);
	}
	
	public SelenideElement frInnerFrame () {
		return $(frInnerFrame);
	}
	
	public SelenideElement lEntityTitle () {
		return $(lEntityTitle);
	}
	
	public SelenideElement bEdit () {
		return $(bEdit);
	}
	
	public SelenideElement bSave () {
		return $(bSave);
	}
	
	public SelenideElement fPersonId () {
		return $(fPersonId);
	}
	
	
	
	public void verifyCandTitle (MySoftAssert softAssert, String title) {
		
		softAssert.assertEquals(title,  lEntityTitle().getText());
	}

}
