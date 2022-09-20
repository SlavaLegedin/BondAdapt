package pages.generalFunctions;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import _helpers.MySoftAssert;
import _helpers.TestBase;

public class W_JournalSettings extends TestBase {
	
	private By rbMyJournal 					= By.xpath(".//input[@id = 'myJournal']");
	private By rbUserJournal				= By.xpath(".//input[@id = 'userJournal']");
	private By ddlUserJournal				= By.xpath(".//button[@data-id = 'ViewUserID']");
	private By fUserJournal					= By.xpath(".//input[@type = 'text' and @class = 'form-control']");
	
	private By ddlViewDetails				= By.xpath(".//div[contains(@class, 'btn-group bootstrap-select normal-line-height journal-settings-view')]/button");
	private By ddlSortByColumn				= By.xpath(".//div[contains(@class, 'btn-group bootstrap-select normal-line-height journal-settings-sortOrder')]/button");
	private By ddlSortOrder					= By.xpath("//div[contains(@class, 'btn-group bootstrap-select normal-line-height journal-settings-sortBy')]/button");
	private By ddlDefaultFilter				= By.xpath("//div[contains(@class, 'btn-group bootstrap-select normal-line-height journal-settings-filter')]/button");
	
	private By rbFiveRecords				= By.xpath(".//input[@id = 'journal-settings-r5']");
	private By rbTenRecords					= By.xpath(".//input[@id = 'journal-settings-r10']");
	private By rbFifteenRecords				= By.xpath(".//input[@id = 'journal-settings-r15']");
	private By rbTwentyRecords				= By.xpath(".//input[@id = 'journal-settings-r20']");
	private By rbTwentyFiveRecords			= By.xpath(".//input[@id = 'journal-settings-r25']");
	private By rbThirtyRecords				= By.xpath(".//input[@id = 'journal-settings-r30']");
	
	private By chExpandNotes				= By.xpath(".//input[@id = 'journalExpandNotes']");
	private By chShowInGroups				= By.xpath(".//input[@id = 'journalGroupBySortColumnAllowed']");
	
	private By bSave						= By.xpath(".//div[@id = 'save-button-div']/button");
	
	//options in ddl
	//view details
	private By opViewAll					= By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), 'ALL')]");
	private By opViewSimple					= By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), 'SIMPLE')]");
	private By opViewJournNotes				= By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), 'Journal Notes')]");
	private By opViewDocs					= By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), 'DOCUMENTS')]");
	//sort By column
	private By opSortDateTime				= By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), 'Date Time')]");
	private By opSortWFName					= By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), 'Workflow Name')]");
	private By opSortUser					= By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), 'User')]");
	//sort Order
	private By opOrderAsc					= By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), 'Asc')]");
	private By opOrderDesc					= By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), 'Desc')]");
	//Default Filter
	//first valuable line
	//see assertion. Need to assemble xpath based on entered name
	//empty line
	private By oppEmptyLine					= By.xpath(".//li[@rel = '0']//span[@class = 'text journal-settings-drop-down' and contains(text(), '          ')]");
	//user filter
	private By firstUser					= By.xpath(".//div[contains(@class, 'journal-settings-userJournal open')]/div/ul/li[2]/a");
	
	//initialization
	public SelenideElement ddlDefaultFilter () {
		return $(ddlDefaultFilter);
	}
	
	
	public SelenideElement opFilterName (String filtername ) {
		return $(By.xpath(".//span[@class = 'text journal-settings-drop-down' and contains(text(), '"+filtername+"')]"));
	}
	
	
	public SelenideElement opOrderDesc () {
		return $(opOrderDesc);
	}
	
	public SelenideElement ddlSortOrder () {
		return $(ddlSortOrder);
	}
	
	public SelenideElement opOrderAsc () {
		return $(opOrderAsc);
	}
	
	
	public SelenideElement firstUser () {
		return $(firstUser);
	}
	
	
	public SelenideElement chShowInGroups () {
		return $(chShowInGroups);
	}
		
	public SelenideElement chExpandNotes () {
		return $(chExpandNotes);
	}
	
	public SelenideElement rbThirtyRecords () {
		return $(rbThirtyRecords);
	}
	
	public SelenideElement rbTwentyFiveRecords () {
		return $(rbTwentyFiveRecords);
	}
	
	public SelenideElement rbTwentyRecords () {
		return $(rbTwentyRecords);
	}
	
	public SelenideElement rbFifteenRecords () {
		return $(rbFifteenRecords);
	}
	
	public SelenideElement rbTenRecords () {
		return $(rbTenRecords);
	}
	
	public SelenideElement rbFiveRecords () {
		return $(rbFiveRecords);
	}
	
	
	public SelenideElement opSortUser () {
		return $(opSortUser);
	}
	
	public SelenideElement opSortWFName () {
		return $(opSortWFName);
	}
	
	public SelenideElement opSortDateTime () {
		return $(opSortDateTime);
	}
	
	public SelenideElement ddlSortByColumn () {
		return $(ddlSortByColumn);
	}
	
	public SelenideElement opViewDocs () {
		return $(opViewDocs);
	}
	
	public SelenideElement opViewJournNotes () {
		return $(opViewJournNotes);
	}
	
	public SelenideElement opViewSimple () {
		return $(opViewSimple);
	} 
	
	public SelenideElement opViewAll () {
		return $(opViewAll);
	}
	
	public SelenideElement ddlViewDetails () {
		return $(ddlViewDetails);
	}
	
	public SelenideElement bSave () {
		return $(bSave);
	}
	
	public SelenideElement ddlUserJournal () {
		return $(ddlUserJournal);
	}
	
	public SelenideElement fUserJournal () {
		return $(fUserJournal);
	}
	
	public SelenideElement rbUserJournal () {
		return $(rbUserJournal);
	}
	
	public SelenideElement rbMyJournal () {
		return $(rbMyJournal);
	}
	
}
