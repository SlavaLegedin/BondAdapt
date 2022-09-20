package testcases.JournalTC;

import org.testng.annotations.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.annotations.Report;

import static com.codeborne.selenide.Condition.*;

import java.text.ParseException;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.W_WorkFlowPicker;
import pages.generalFunctions.S_UserJournal;
import pages.generalFunctions.W_JournalFilters;
import pages.generalFunctions.W_JournalSettings;

@Report
public class JournalVerify_Settings extends TestBase {
	
	@Test (invocationCount = 1, 
			enabled=true)
	public void journalChecks () throws InterruptedException, ParseException {
		
		/*
		 * Important Note
		 * Make sure that user has at least twenty five Journal entries before testing.
		 * Probably it would be better to run such test cases after Candidate creation test cases.
		 */
		
		M_LeftHandMenu 			lhm			= new M_LeftHandMenu();
		S_UserJournal			uj			= new S_UserJournal();
		W_JournalSettings		jset		= new W_JournalSettings();
		W_JournalFilters		jFil		= new W_JournalFilters();
		W_WorkFlowPicker		wPick		= new W_WorkFlowPicker();

		
		int pageCurrent	= 0;
		int firstPage = 1;
		int recordsPerPage;
		
		String otherUserName 				= variablesProp.getProperty("otherUserName");  
		String currUserName 				= lhm.currUserName().getText();
		String notesColumn					= variablesProp.getProperty("notesColumn");//"wf_name";
		String dateTimeColumn				= variablesProp.getProperty("dateTimeColumn");//"date_time";
		String userColumn					= variablesProp.getProperty("userColumn");//"user";		
		String firstJournalNoteText;
		
		lhm.openMyAdapt();
		lhm.lUserJournal().shouldBe(visible).click();
		
		/*
		 * 2. Settings							 	- DONE
		 * 2.1 Other User								- DONE
		 * 2.2 returning to the current User			- DONE
		 * 2.3.1 View Detail DDL						- DONE
		 * 2.3.2 sort by Column							- DONE
		 * 2.3.3 Sort Order								- DONE
		 * 2.3.4 Default Filter							- DONE
		 * 2.4 Record per page							- DONE
		 * 2.5 Expand Notes								- DONE 
		 * 2.6 Show in groups							- DONE
		 * */
	  
    	switchTo().defaultContent();	
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		


		//assert that appropriate pages opened
		pageCurrent = Integer.parseInt(uj.fpageNo().shouldBe(visible).getAttribute("value"));
		uj.verifyPageNo(softAssert, firstPage, pageCurrent);
		
		//2.1 Journal of other user
		System.out.println("Start  2.1");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.rbMyJournal().isSelected();
		jset.rbUserJournal().shouldBe(visible).click();
		jset.ddlUserJournal().shouldBe(visible).click();
		jset.fUserJournal().shouldBe(visible).sendKeys(otherUserName);
		jset.firstUser().shouldBe(visible).click(); 
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyUserNamePresence(otherUserName);
		
		//2.2 Return to initial user
		System.out.println("2.2 return to initial user");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.rbUserJournal().isSelected();
		jset.rbMyJournal().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyUserNamePresence(currUserName);
		
		//2.3.1 View detail
		System.out.println("2.3.1 View details");
		
		//select WF with documents
		uj.bFilters().shouldBe(visible).click();
		switchTo().defaultContent();
		jFil.bWfName().shouldBe(visible).click();
		wPick.fwfname().shouldBe(visible).sendKeys(wPick.boname);
		wPick.bSearchWF().shouldBe(visible).click();
		wPick.chWFcheckbox().shouldNotBe(Condition.checked);
		wPick.chWFcheckbox().shouldBe(visible).click();
		
		Thread.sleep(2000);////////////////////////////////looks like Adapt need time for internal element load.
		
		wPick.chWFcheckbox().shouldBe(Condition.checked);
		
		Thread.sleep(2000);////////////////////////////////looks like Adapt need time for internal element load.
		
		wPick.bSelect().shouldBe(visible).click();
		jFil.bApplyFilter().shouldBe(visible).click();
		
		Thread.sleep(2000);////////////////////////////////looks like Adapt need time for internal element load.
		
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		
		uj.bSettings().shouldBe(visible).click();
		//view All
		System.out.println("Switch to view all");
		switchTo().defaultContent();
		jset.ddlViewDetails().shouldBe(visible).click();
		jset.opViewAll().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		uj.verifyNotesPresented();
		uj.verifyDocumentsPresented(softAssert);
		
		//view SIMPLE
		System.out.println("Switch to SIMPLE view");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlViewDetails().shouldBe(visible).click();
		jset.opViewSimple().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		uj.verifyNotesNotPresented();
		uj.verifyDocumentsNotPresented();
		
		//view Journal Notes
		System.out.println("Switch to Notes only view");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlViewDetails().shouldBe(visible).click();
		jset.opViewJournNotes().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		uj.verifyNotesPresented();
		uj.verifyDocumentsNotPresented();
		
		//view Documents
		System.out.println("Switch to document only view");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlViewDetails().shouldBe(visible).click();
		jset.opViewDocs().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		uj.verifyNotesNotPresented();
		uj.verifyDocumentsPresented(softAssert);
		
		//return to view All
		System.out.println("return to view all");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlViewDetails().shouldBe(visible).click();
		jset.opViewAll().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
		//clear all filters
		System.out.println("Clear all filters");
		uj.bFilters().shouldBe(visible).click();
		switchTo().defaultContent();
		jFil.bClearFilter().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
	
		//2.3.2 sort by column
		System.out.println("2.3.2 started");
		
		//sort by date time
		System.out.println("Sort by DateTime");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlSortByColumn().shouldBe(visible).click();
		jset.opSortDateTime().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		Thread.sleep(1000); //loading of all elements. not necessary.
		//check that time in row 0 less than time in row 1
		uj.verifyEntriesOrder(softAssert, "desc");
		uj.verifyArrowPresented(dateTimeColumn);
		
		//sort by wf name
		System.out.println("Sort by WF name");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlSortByColumn().shouldBe(visible).click();
		jset.opSortWFName().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		Thread.sleep(1000); //loading of all elements. not necessary.
		uj.verifyArrowPresented(notesColumn);
		uj.verifyLexicString(softAssert, "desc");
		System.out.println("Sort order by asc");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlSortOrder().shouldBe(visible).click();
		jset.opOrderAsc().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		uj.verifyLexicString(softAssert, "asc");
		System.out.println("returning to desc");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlSortOrder().shouldBe(visible).click();
		jset.opOrderDesc().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		uj.verifyLexicString(softAssert, "desc");
		
		//sort by User
		System.out.println("Sort by User");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlSortByColumn().shouldBe(visible).click();
		jset.opSortUser().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());	
		//Thread.sleep(1000); //loading of all elements. not necessary.
		//Assert is hard to apply - only same user can be on the page
		uj.verifyArrowPresented(userColumn);
		
		//return to initial state
		System.out.println("Return by initial state");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlSortByColumn().shouldBe(visible).click();
		jset.opSortDateTime().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
		//2.3.3 sort order/
		//covered in sorting be WF name
		
		//2.3.4 test view
		/*Set first valuable option in filter and reset.
		 * Assertion in the filter is hard to imagine without filter presets*/
		//Covered in view Section

			
		//2.4 Records per page
		System.out.println("Record per page start");
		//10
		recordsPerPage = 10;
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.rbTenRecords().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyamountJournals(softAssert, recordsPerPage);
		
		//15
		recordsPerPage = 15;
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.rbTenRecords().shouldBe(selected);
		jset.rbFifteenRecords().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyamountJournals(softAssert, recordsPerPage);
				
		//20
		recordsPerPage = 20;
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.rbFifteenRecords().shouldBe(selected);
		jset.rbTwentyRecords().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyamountJournals(softAssert, recordsPerPage);
				
		//25
		recordsPerPage = 25;
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.rbTwentyRecords().shouldBe(selected);
		jset.rbTwentyFiveRecords().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyamountJournals(softAssert, recordsPerPage);
				
		//30
		recordsPerPage = 30;
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.rbTwentyFiveRecords().shouldBe(selected);
		jset.rbThirtyRecords().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyamountJournals(softAssert, recordsPerPage);
				
		//5
		recordsPerPage = 5;
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.rbThirtyRecords().shouldBe(selected);
		jset.rbFiveRecords().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyamountJournals(softAssert, recordsPerPage);
		
		//2.5 Expand Notes
		System.out.println("2.5 Started");
		//take data from first note
		firstJournalNoteText = uj.journalFirstEntryText().getText();
		//expand notes
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.chExpandNotes().shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		Thread.sleep(500);//
		//take data from first note again
		//compare the strings
		uj.verifyJournalNotesComparing(softAssert, firstJournalNoteText, uj.journalFirstEntryText().getText());
		//return to initial state
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.chExpandNotes().is(selected);
		jset.chExpandNotes().click();
		jset.bSave().click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
		//2.6 Show in groups
		System.out.println("2.6 Started");
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.chShowInGroups().shouldBe(visible).click();
		jset.bSave().click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.journalGroupButton().shouldBe(visible);
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.chShowInGroups().shouldBe(selected).click();
		jset.bSave().click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
    	switchTo().defaultContent();	

		softAssert.assertAll();
	}
}
