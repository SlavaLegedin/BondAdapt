package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class M_CandidateControls {

	private By bListOfSegments 			= By.xpath(".//button[@id = 'entity-segment-popup-trigger']");
	
	private By menuSummarySegment 		= By.xpath(".//span[@id = 'menuPopupItem-6955925']");
	private By menuInterviewsSegment 	= By.xpath(".//span[@id = 'menuPopupItem-6955946']");
	private By menuPersonalInfoSegment	= By.xpath(".//span[@id = 'menuPopupItem-6957643']");
	
	private By frIntFrame				= By.xpath(".//iframe[@id = 'tabframe-root-_S_PEOPLE']");
	private By frCandFrame 				= By.xpath(".//iframe[@id = 'legacyContainer']");

	
	public SelenideElement frIntFrame() {
		return $(frIntFrame);
	}
	
	public SelenideElement frcandFrame() {
		return $(frCandFrame);
	}

	public SelenideElement menuInterviewaSegment() {
		return $(menuInterviewsSegment);
	}

	public SelenideElement bListOfSegments() {
		return $(bListOfSegments);
	}
	
	public SelenideElement menuPersonalInfoSegment () {
		return $(menuPersonalInfoSegment);
	}

}
