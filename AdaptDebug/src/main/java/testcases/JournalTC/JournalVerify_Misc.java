package testcases.JournalTC;

import org.testng.annotations.Test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.annotations.Report;

import static com.codeborne.selenide.Condition.*;

import java.text.ParseException;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.generalFunctions.S_UserJournal;
import pages.generalFunctions.W_JournalFilters;
import pages.generalFunctions.W_JournalNotes;
import pages.generalFunctions.W_JournalSaveView;
import pages.generalFunctions.W_JournalSettings;

@Report
public class JournalVerify_Misc extends TestBase {
	
	@Test (invocationCount = 1,
			 enabled = false)
	public void journalChecks () throws InterruptedException, ParseException {
		
		M_LeftHandMenu 			lhm			= new M_LeftHandMenu();
		S_UserJournal			uj			= new S_UserJournal();
		W_JournalSettings		jset		= new W_JournalSettings();
		W_JournalNotes			jNot		= new W_JournalNotes();
		W_JournalFilters		jFil		= new W_JournalFilters();
		W_JournalSaveView		wView		= new W_JournalSaveView();

		String filterWord					= variablesProp.getProperty("filterWord");//"Test";

		String notePhrase = "Test Adding of Notes" + time.getSysdate("G yyyy MMMM ww dd EEEE HH:mm:ss S");
		String viewName = variablesProp.getProperty("journalViewName") + time.getSysdate("yyddHH:mm:ss");
		
		lhm.openMyAdapt();
		lhm.lUserJournal().shouldBe(visible).click();
		
		/*
		 * 5. Add Journal Note button			 - IN PROGRESS
		 * 9 See tooltip by clicking on it		 	- DONE
		 * 7. View dropdown						 	- DONE
		 * 8. Opening of entity by click on link - IN PROGRESS
		 * 6. Open linked document 				 - CANNOT BE CHECKED VIA SELENIUM
		 * */
    	switchTo().defaultContent();	
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
				
		
		//5. Add Journal Note button
		uj.bAddJournalNote().shouldBe(visible).click();
		switchTo().defaultContent();
		switchTo().frame(jNot.frameTextArea());
		jNot.fNotesArea().shouldBe(visible).sendKeys(notePhrase);
		switchTo().defaultContent();
		jNot.bOkButton().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
		//Assertion /////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//9 See tooltip by clicking on it
		uj.journalNoteTooltip().shouldBe(visible).click();
		switchTo().defaultContent();
		uj.verifyNotesPopupOpened();
		uj.verifypopupContent(softAssert, notePhrase);
		uj.bClosePopup().shouldBe(visible).click();
				
		//7. View dropdown
		System.out.println("7. verify view dropdown");
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.bViews().shouldBe(visible).click();
		switchTo().defaultContent();
		uj.verifyViewDdlOptions();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.bViews().shouldBe(visible).click();
		
		switchTo().defaultContent();
		//verify saving of view
		System.out.println("2.3.4 testing. verify saved view.");
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.bViews().shouldBe(visible).click();
		switchTo().defaultContent();
		uj.lSaveCurrentView().shouldBe(visible).click();
		wView.fViewName().shouldBe(visible).sendKeys(viewName);
		wView.bSaveView().shouldBe(visible).click();
		
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.bViews().shouldBe(visible).click();
		switchTo().defaultContent();
		uj.verifyCustViewPresence(softAssert, viewName);//check that new view is presented in menu//////////////////
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.bViews().shouldBe(visible).click();
		
		uj.bSettings().shouldBe(visible).click();
		switchTo().defaultContent();
		jset.ddlDefaultFilter().shouldBe(visible).click();
		jset.opFilterName(viewName).shouldBe(visible).click();
		jset.bSave().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyCustViewInMenu(softAssert, viewName);//select that view is in dropdown
		
		System.out.println("reset of custom view filter");
		uj.bFilters().shouldBe(visible).click();
		switchTo().defaultContent();
		jFil.bClearFilter().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
		//delete view
		uj.bViews().shouldBe(visible).click();
		switchTo().defaultContent();
		Thread.sleep(750); /////////////////////////////////////to allow script loading
		uj.lDeleteView(viewName).shouldBe(visible).click();
		uj.bDeleteViewConfirm().shouldBe(visible).click();
		uj.bInformOKbutton().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
		//8. Opening of entity by click on link
		String entityName = uj.lEntityName().shouldBe(visible).getText();
		uj.lEntityName().click();
		switchTo().defaultContent();
		switchTo().frame(uj.frameLegacyContainer());
		uj.verifyEntityOpening(softAssert, entityName);
		Thread.sleep(2000); // for debugging purpose///////////////////////////////////////////////////////
		Selenide.back();
		Thread.sleep(2000); // for debugging purpose///////////////////////////////////////////////////////
		
		switchTo().defaultContent();			
		softAssert.assertAll();
		
	}

}
