package pages.generalFunctions;

import com.codeborne.selenide.SelenideElement;

import _helpers.TestBase;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class W_JournalSaveView extends TestBase {
	
	private By fViewName				= By.xpath(".//input[@id = 'journalFilterNameTxt']");
	private By bSaveView				= By.xpath(".//button[@id = 'confirm-save-button']");
	
	public SelenideElement fViewName () {
		return $(fViewName);
	}
	
	public SelenideElement bSaveView () {
		return $(bSaveView);
	} 
	
}
