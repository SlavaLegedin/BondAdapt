package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import _helpers.TestBase;

public class W_WorkFlowPicker extends TestBase {
	
	public final String boname = "Direct Assignment Created";
	
	private By fwfname				= By.xpath(".//input[@id = 'WorkFlowInput']");
	private By bSearchWF			= By.xpath(".//button[@id = 'WorkFlowSearchButton']");
	private By chWFcheckbox			= By.xpath(".//input[@id = 'chkSelectedWorkFlow'and @workflowid = '6977201']");
	private By bSelect				= By.xpath(".//button[@id = 'journalWorkflowPickerSelect']");
	
	public SelenideElement fwfname () {
		return $(fwfname);
	}
	
	public SelenideElement bSearchWF () {
		return $(bSearchWF);
	}
	
	public SelenideElement chWFcheckbox () {
		return $(chWFcheckbox);
	} 
	
	public SelenideElement bSelect () {
		return $(bSelect);
	}
	
	
	

}
