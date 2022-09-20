package pages.generalFunctions;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import _helpers.TestBase;

public class S_RecruitmentStudio extends TestBase {

	private By	frame_legacyContainer	= By.cssSelector("#legacyContainer");
	private By	frame_studioCaption		= By.cssSelector("#studioCaptionFrame");
	private By	header					= By.cssSelector("[class='main-header-text studioCaption']");

	public SelenideElement frame_legacyContainer() {
		return $(frame_legacyContainer);
	}

	public SelenideElement frame_studioCaption() {
		return $(frame_studioCaption);
	}

	public SelenideElement header() {
		return $(header);
	}

	public void verifyHeader() {
		Selenide.switchTo().frame(frame_legacyContainer());
		Selenide.switchTo().frame(frame_studioCaption());
		header().shouldBe(visible).shouldHave(attribute("value", "Recruitment Studio"));
	}

}
