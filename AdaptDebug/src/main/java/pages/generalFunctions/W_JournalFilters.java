package pages.generalFunctions;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.SelenideElement;

import _helpers.TestBase;

public class W_JournalFilters extends TestBase{
	
	private By fDateFrom				= By.xpath(".//div[@id = 'journalFilterPanel']/div[2]/div[2]/input[@type = 'text']");
	private By fDateTo					= By.xpath(".//div[@id = 'journalFilterPanel']/div[2]/div[4]/input[@type = 'text']");
	
	private By bFromLeft				= By.xpath(".//div[@id = 'journalFilterPanel']//div[@class = 'input-append date-control'][1]//i[contains(@class, 'date-control-previous-day')]");
	private By bFromRight				= By.xpath(".//div[@id = 'journalFilterPanel']//div[@class = 'input-append date-control'][1]//i[contains(@class, 'date-control-next-day')]");
	private By bFromCurr				= By.xpath(".//div[@id = 'journalFilterPanel']//div[@class = 'input-append date-control'][1]//i[contains(@class, 'date-control-current-day')]");
	private By bToLeft					= By.xpath(".//div[@id = 'journalFilterPanel']//div[@class = 'input-append date-control'][2]//i[contains(@class, 'date-control-previous-day')]");
	private By bToRight					= By.xpath(".//div[@id = 'journalFilterPanel']//div[@class = 'input-append date-control'][2]//i[contains(@class, 'date-control-next-day')]");
	private By bToCurr					= By.xpath(".//div[@id = 'journalFilterPanel']//div[@class = 'input-append date-control'][2]//i[contains(@class, 'date-control-current-day')]");
	
	private By bWfName					= By.xpath(".//input[@id = 'journalWorkflowPicker']");
	private By lWfName					= By.xpath(".//div[@id = 'selectedWorkflows']/div/div/span/span");
	
	private By ddlGroups				= By.xpath(".//select[@id = 'journalFormUserGroups']/parent::div/button");
	private By ddlUsers					= By.xpath(".//select[@id = 'usersInGroup']/parent::div/button");
	
	private By fNotes					= By.xpath(".//input[@id = 'txtNotes']");
	
	private By bClearFilter				= By.xpath(".//input[@id = 'journalFilterClearButton']");
	private By bApplyFilter				= By.xpath(".//input[@id = 'journalFilterApplyButton']");
	private By bCancel					= By.xpath(".//input[@id = 'journalFilterCancelButton']");
	
	private By fUserByGroup				= By.xpath(".//input[@class = 'form-control']");
	
	//initialization of elements
	public SelenideElement opUserDdl(String filtUserName) {
		return $(By.xpath(".//div[contains(@class, 'filter_input_combobox dropup open') ]//a/span[contains(text(), '"+ filtUserName +"')]"));
	}
	
	public SelenideElement opGroupDdl(String groupName) {
		return $(By.xpath(".//div[contains(@class, 'filter_input_combobox dropup open') ]//a/span[contains(text(), '"+ groupName +"')]"));
	}
	
	public SelenideElement bCancel () {
		return $(bCancel);
	}
	
	public SelenideElement ddlUsers () {
		return $(ddlUsers);
	}
	
	public SelenideElement ddlGroups () {
		return $(ddlGroups);
	}
	
	
	public SelenideElement fDateTo () {
		return $(fDateTo);
	}
	
	public SelenideElement fDateFrom () {
		return $(fDateFrom);
	}
	
	public SelenideElement lWfName () {
		return $(lWfName);
	}
	
	public SelenideElement bWfName () {
		return $(bWfName);
	}
	
	
	public SelenideElement bToLeft () {
		return $(bToLeft);
	}
	
	public SelenideElement bFromLeft () {
		return $(bFromLeft);
	}
	
	
	public SelenideElement bToRight () {
		return $(bToRight);
	}
	
	public SelenideElement bToCurr () {
		return $(bToCurr);
	}
	
	public SelenideElement bFromRight () {
		return $(bFromRight);
	}
	
	public SelenideElement bFromCurr () {
		return $(bFromCurr);
	}
	
	public SelenideElement fNotes () {
		return $(fNotes);
	}
		
	public SelenideElement bClearFilter () {
		return $(bClearFilter);
	}
	
	public SelenideElement bApplyFilter () {
		return $(bApplyFilter);
	}
	

}
