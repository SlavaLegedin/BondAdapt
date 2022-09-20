package pages.generalFunctions;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import _helpers.TestBase;

public class W_JournalNotes extends TestBase{
	
	private By fNotesArea			= By.xpath(".//body[contains(@class, 'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]");
	
	private By bOkButton			= By.xpath(".//button[@id = 'addJournalNotesOK']");
	private By bCancel				= By.xpath(".//button[@id = 'addJournalNotesCancel']");
	
	private By frameTextArea		= By.xpath(".//div[contains(@id,'cke_')]/iframe[@class = 'cke_wysiwyg_frame cke_reset']");
	
	
	public SelenideElement fNotesArea() {
		return $(fNotesArea);
	}
	
	public SelenideElement bOkButton () {
		return $(bOkButton);
	}
	
	public SelenideElement bCancel () {
		return $(bCancel);
	}
	
	public SelenideElement frameTextArea () {
		return $(frameTextArea);
	}
	
	
}
