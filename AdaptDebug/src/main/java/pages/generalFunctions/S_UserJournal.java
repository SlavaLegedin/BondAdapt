package pages.generalFunctions;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import _helpers.MySoftAssert;
import _helpers.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class S_UserJournal extends TestBase {
	
	private By bNextPage 			= By.xpath(".//a[@class = 'links03' and contains(text(), 'Next page')]");
	private By bPrevPage			= By.xpath(".//a[@class = 'links03' and contains(text(), 'Previous page')]");
	private By bLastPage			= By.xpath(".//a[contains(@class, 'arrowRight nextprevimage')]");
	private By bFirstPage			= By.xpath(".//a[contains(@class, 'arrowLeft nextprevimage')]");
	
	private By ddlShowAll			= By.xpath(".//button[@id = 'journal-viewtype-button']");
	
	private By bGo					= By.xpath(".//input[@value = 'Go!' and @type = 'button']");
	private By fPageNo				= By.xpath(".//input[@id = 'goToPageTop']");
	private By lTotalPages			= By.xpath(".//div[@id = 'jgoto']/span/b[2]");
	
	private By bFilters				= By.xpath(".//button[@id = 'journal-filter-button']");
	private By bSettings			= By.xpath(".//button[@id = 'journal-settings-button']");
	private By bViews				= By.xpath(".//span[@id = 'journal-viewtype-button-span']");
	
	private By frameRootFrame		= By.xpath(".//iframe[@id = 'tabframe-root-_T_MYADAPT']");
	private By frCandFrame 			= By.xpath(".//iframe[@id = 'legacyContainer']");
	
	private By columnNotes			= By.xpath(".//span[@id = 'wf_name']");
	private By columnDate			= By.xpath(".//span[@id = 'date_time']");
	private By columnUser			= By.xpath(".//span[@id = 'user']");
	
	
	private By journalEntry			= By.xpath(".//div[@class = 'journalRow' and contains(@id, 'journalRow_')]");
	private By journalFirstEntryText= By.xpath(".//div[@id = 'journalRow_0']/div/table/tbody/tr/td/div[2]");
	private By journalNoteTooltip	= By.xpath(".//div[@id = 'journalTableBody']//div[@class = 'noteContainer']/i");
	private By journalGroupButton	= By.xpath(".//div[@id = 'journalGroupTitle0']//img[@class = 'expandButton']");
	
	private By bAddJournalNote		= By.xpath(".//div[@id = 'journalTableBody']//span[@class = 'addNoteButton'][1]");
	private By lEntityName			= By.xpath(".//span[contains(@class,'entityLink textBlock')]");
	
	private By bClosePopup			= By.xpath(".//i[@id = 'closeButton']");
	
	private By userNameJournal		= By.xpath(".//div[@id = 'journalTableBody']/div/div[3]/table/tbody/tr/td");
	private By journalBOname		= By.xpath(".//div[@id = 'journalTableBody']/div/div/table/tbody/tr/td/div/span[1]");
	
	private By lDocumentTextbox		= By.xpath(".//span[contains(@class, 'documentLink textBlock')]");
	
	private By lSaveCurrentView		= By.xpath(".//span[@id = 'journal-save-current-view-label' and contains(text(), 'Save Current View')]");
	
	private By bDeleteViewConfirm	= By.xpath(".//button[@id = 'confirm-ok-button']");
	private By bInformOKbutton		= By.xpath(".//button[@id = 'alert-ok-button']");
	
	//initialization of elements
	public SelenideElement bInformOKbutton () {
		return $(bInformOKbutton);
	}
	
	public SelenideElement bDeleteViewConfirm () {
		return $(bDeleteViewConfirm);
	}
	
	public SelenideElement lDeleteView (String enteredViewName) {
		return $(By.xpath((".//div[@id = 'BISPopupContent']//li[contains(@class, 'secondary-action')]/span[contains(text(), '"+enteredViewName
				+"')]/following-sibling::i[1]")));
	}
	
	
	public SelenideElement lSaveCurrentView () {
		return $(lSaveCurrentView);
	}
	
	public SelenideElement journalGroupButton( ) {
		return $(journalGroupButton);
	}
	
	public SelenideElement bClosePopup () {
		return $(bClosePopup);
	}
	
	public SelenideElement lEntityName () {
		return $(lEntityName);
	}
	
	public SelenideElement bViews () {
		return $(bViews);
	}
	
	public SelenideElement bFilters () {
		return $(bFilters);
	}
	
	public SelenideElement bAddJournalNote () {
		return $(bAddJournalNote);
	} 
	
	public SelenideElement journalNoteTooltip () {
		return $(journalNoteTooltip);
	}
	
	public SelenideElement journalFirstEntryText () {
		return $(journalFirstEntryText);
	}
		
	public SelenideElement columnNotes () {
		return $(columnNotes);
	}
	
	public SelenideElement columnDate () {
		return $(columnDate);
	}
	
	public SelenideElement columnUser () {
		return $(columnUser);
	}
	
	public SelenideElement fpageNo () {
		return $(fPageNo);
	}
	
	//public SelenideElement frameLegacyContainer
	public SelenideElement bSettings () {
		return $(bSettings);
	}
	
	public SelenideElement bGo () {
		return $(bGo);
	}
	
	public SelenideElement lTotalPages () {
		return $(lTotalPages);
	}
	
	public SelenideElement bFirstPage () {
		return $(bFirstPage);
	}
	
	public SelenideElement bLastPage () {
		return $(bLastPage);
	}
	
	public SelenideElement frameRootFrame () {
		return $(frameRootFrame);
	}
	
	public SelenideElement bPrevPage () {
		return $(bPrevPage);
	}
	
	public SelenideElement bNextPage () {
		return $(bNextPage);
	}
	
	//assertions
	//verify that arrow in column is presented
	public void verifyArrowPresented (String columnName) {
		$(By.xpath(".//span[@id = '"+columnName+"']/img")).shouldBe(Condition.exist);
	}
	//verify that Notes are visible for different view modes
	public void verifyNotesPresented () {
		$(By.xpath(".//div[@id = 'journalRow_0']//div[@class = 'noteContainer']")).shouldBe(Condition.exist);
		//$(By.xpath(".//div[@id = 'journalRow_1']//div[@class = 'noteContainer']")).shouldBe(Condition.exist);
		//$(By.xpath(".//div[@id = 'journalRow_2']//div[@class = 'noteContainer']")).shouldBe(Condition.exist);
		//$(By.xpath(".//div[@id = 'journalRow_3']//div[@class = 'noteContainer']")).shouldBe(Condition.exist);
		//$(By.xpath(".//div[@id = 'journalRow_4']//div[@class = 'noteContainer']")).shouldBe(Condition.exist);
	}
	//verify that Notes are NOT visible for different view modes
	public void verifyNotesNotPresented () {
		$(By.xpath(".//div[@id = 'journalRow_0']//div[@class = 'noteContainer']")).shouldNotBe(Condition.exist);
	}
	//verify filtered journal
	public void verifyfilteredByNotes (MySoftAssert softAssert, String word) {
		//$(By.xpath(".//div[@id = 'journalRow_0']//div[@class = 'noteContainer']")).shouldHave(Condition.text(word));
		String currWord = $(By.xpath(".//div[@id = 'journalRow_0']//div[@class = 'noteContainer']")).getText();
		softAssert.assertTrue(currWord.contains(word));
		
	}
	//verify options for views dropdown
	public void verifyViewDdlOptions () {
		$(By.xpath(".//span[@id = 'journal-all-label' and contains(text(), 'Show All')]")).shouldBe(Condition.visible);
		$(lSaveCurrentView).shouldBe(Condition.visible);
		$(By.xpath(".//span[@id = 'journal-myViews-label' and contains(text(), 'My Views')]")).shouldBe(Condition.visible);
		$(By.xpath(".//span[@id = 'journal-sharedViews-label' and contains(text(), 'Shared Views')]")).shouldBe(Condition.visible);
		
	}
	//verify that appropriate entity opened after click on link
	public void verifyEntityOpening (MySoftAssert softAssert, String entityTitle) {
		String actTitle = $(By.xpath(".//span[@id = 'WebUI_MainHeaderTitle']")).shouldBe(Condition.visible).getText();
		softAssert.assertTrue(actTitle.contains(entityTitle));
	}
	//verify that popup opened
	public void verifyNotesPopupOpened () {
		$(By.xpath(".//span[@id = 'notesPopupContent']")).shouldBe(Condition.visible);
	}
	//verify that user name is presented in Journal in User column
	public void verifyUserNamePresence (String userName) {
		
		List <SelenideElement> usersInJournal = $$(By.xpath(".//div[@class= 'journalTableBody' and @id = 'journalTableBody']//table[@class = 'elipsisContainer']//td"));
		int count = usersInJournal.size();
		String currentName;		
		for (int i = 0; i <  count; i++) {
			currentName = usersInJournal.get(i).getText();
			if (currentName.equals(userName)) 
			{	
				usersInJournal.get(i).shouldHave(Condition.text(userName));
				break;
			}
			
		}
		
	}
	public void verifypopupContent (MySoftAssert softAssert, String note) {
		String takenNote = $(By.xpath(".//span[@id = 'notesPopupContent']")).shouldBe(Condition.visible).getText();
		softAssert.assertTrue(takenNote.contains(note));
		
	}
	//page number
	public void verifyPageNo (MySoftAssert softAssert, int expNumber, int realNumber) {
		softAssert.assertEquals(expNumber, realNumber);
		
	}
	//Number of Journal records on the page
	public void verifyamountJournals (MySoftAssert softAssert, int entriesCount) {
		int actual = $$(journalEntry).size();
		softAssert.assertEquals(actual, entriesCount);
	}
	//check text of first journal entry
	public void verifyJournalNotesComparing (MySoftAssert softAssert, String initNote, String newNote) {
		softAssert.assertNotEquals(newNote, initNote);
		softAssert.assertTrue(newNote.contains(initNote));
	}
	public void verifyUserPresence (MySoftAssert softAssert, String userName ) {
		String name = "";
		List <SelenideElement> users = new ArrayList <> ();
		for (int i = 1; i <= $$(userNameJournal).size(); i++) {
			users.add($(By.xpath(".//div[@id = 'journalTableBody']/div['"+i+"']/div[3]/table/tbody/tr/td")));
		}
	
		for (SelenideElement userData : users) {
			name = userData.getText();
			if (name == userName) {
				break;
			}
		}
		softAssert.assertEquals(name, userName);
	}
	public void verifyDocumentsPresented (MySoftAssert softAssert) {
		softAssert.assertTrue($(lDocumentTextbox).exists());
		}
	public void verifyDocumentsNotPresented () {
		softAssert.assertFalse($(lDocumentTextbox).exists());
		}
	public void verifyEntriesOrder (MySoftAssert softAssert, String order) throws ParseException {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy hh:mm a", Locale.UK);
		List <SelenideElement> dates = $$(By.xpath(".//div[@id = 'journalTableBody']//td[@class = 'dateNote']"));
		List <String> datesStr = new ArrayList <String> ();
		for (SelenideElement elem : dates) {
			datesStr.add(elem.getText());
		}
		int size = datesStr.size();
		
		Date initDate = formatter.parse(datesStr.get(0));
		Date finDate = formatter.parse(datesStr.get(size-1));
		//LocalDateTime finDate = LocalDateTime.parse(datesStr.get(size - 1), formatter);
		if (order.equals("asc")) {
			softAssert.assertTrue(initDate.before(finDate));
		}
		else {
			softAssert.assertTrue(initDate.after(finDate));
		}
	}
	public void verifyLexicString (MySoftAssert softAssert, String order) {
		List <SelenideElement> wfnames = new ArrayList <> ();
		for (int i = 1; i <= $$(journalBOname).size(); i++) {
			wfnames.add($(By.xpath(".//div[@id = 'journalTableBody']/div['"+i+"']/div/table/tbody/tr/td/div/span[1]")));
		}
		
		String stringTop = wfnames.get(0).getText();
		String stringBottom = wfnames.get(wfnames.size() - 1).getText();
		
		int result = stringTop.compareTo(stringBottom);
		
		if (order.equals("asc")) {
			softAssert.assertTrue(result < 0);
		}
		else //order equal desc etc
		{
			softAssert.assertTrue(result > 0);
		}
	}
	public void verifyCustViewPresence (MySoftAssert softAssert, String enteredViewName) {
		String actual = $(By.xpath(".//div[@id = 'BISPopupContent']//li[contains(@class, 'sharedFilters')]/span[contains(text(), 'New')]")).getText();
		softAssert.assertEquals(actual, enteredViewName);
	}
	public void verifyCustViewInMenu  (MySoftAssert softAssert, String enteredViewName) {
		String actual = $(By.xpath(".//span[@id = 'journal-viewtype-button-span']")).getText();
		softAssert.assertEquals(actual, enteredViewName);
	}
	public void verifyDatesInJournal (MySoftAssert softAssert) throws ParseException {
		//LocalDateTime dfInt = new LocalDateTime("MMM d, yyyy");
		Date date = new Date();
		//dfInt.format(date);
		//date.plusDays(-3);
				
		List <SelenideElement> dates = $$(By.xpath(".//div[@id = 'journalTableBody']//td[@class = 'dateNote']"));
		//commented until it will be understandable how to get dates
		/*List <SelenideElement> dates = $$(By.xpath(".//div[@id = 'journalTableBody']//td[@class = 'dateNote']"));
		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy hh:mm a");
		SimpleDateFormat dfInt = new SimpleDateFormat("MMM d, yyyy");
		Date dStartDate = dfInt.parse(startDate);
		Date dEndDate = dfInt.parse(endDate); 
		for (SelenideElement elem : dates) {
			Date date = df.parse(elem.getText());
			if (date.before(dStartDate) || date.after(dEndDate)) {
				softAssert.assertTrue(false, "Dates in Journal are beyond interval");
				break;
			}
			
		}*/
	}
}
