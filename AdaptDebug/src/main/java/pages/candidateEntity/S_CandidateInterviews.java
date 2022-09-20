package pages.candidateEntity;

import _helpers.TestBase;
import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import _helpers.MySoftAssert;


public class S_CandidateInterviews extends TestBase{
	
	private By bScheduleIntInterview		= By.xpath(".//button[@id = 'entityButton5$E_ContractCand_AboutMe$E_ContractCandidate_Interviews']");
	private By lcInternalInterviews			= By.xpath("");
	private By frameInterviews				= By.xpath(".//iframe[@id = 'E_ContractCand_AboutMe$E_ContractCandidate_Interviews']");
	private By frameInner					= By.xpath(".//iframe[@id = 'vmInnerFrame']");
	
	public SelenideElement frameInner () {
		return $(frameInner);
	}
	
	public SelenideElement frameInterviews () {
		return $(frameInterviews);
	}
	
	public SelenideElement bScheduleIntInterview () {
		return $(bScheduleIntInterview);
	}
	
	public SelenideElement lcInternalInterviews () {
		return $(lcInternalInterviews);
	}
	
	

}
