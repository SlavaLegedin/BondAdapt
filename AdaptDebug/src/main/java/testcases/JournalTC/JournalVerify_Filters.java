package testcases.JournalTC;

import org.testng.annotations.Test;

import com.codeborne.selenide.testng.annotations.Report;

import static com.codeborne.selenide.Condition.*;

import java.text.ParseException;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.generalFunctions.S_UserJournal;
import pages.generalFunctions.W_JournalFilters;


@Report
public class JournalVerify_Filters extends TestBase {
	
	@Test (invocationCount = 1,
			 enabled = true)
	public void journalChecks () throws InterruptedException, ParseException {		
		
		M_LeftHandMenu 			lhm			= new M_LeftHandMenu();
		S_UserJournal			uj			= new S_UserJournal();
		W_JournalFilters		jFil		= new W_JournalFilters();

		String filterWord					= variablesProp.getProperty("filterWord");//"Test";		
		
		lhm.openMyAdapt();
		lhm.lUserJournal().shouldBe(visible).click();
		
		System.out.print("login");
		
    	switchTo().defaultContent();	
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
				
		//3. Filters
		/*3.1 Date From and Date To
		 *3.2 WF Name						- DONE above
		 *3.3 Groups and Users
		 *3.4 Notes 
		 *4. Sorting of entries by columns		 - IN PROGRESS
		 * */

				
		//3.1 Date from and Date To
		System.out.println("3.1 Date From/To for filters started");
		uj.bFilters().shouldBe(visible).click();
		switchTo().defaultContent();
		jFil.bFromLeft().shouldBe(visible).click();
		jFil.bFromLeft().click();
		jFil.bFromLeft().click();
		jFil.bToLeft().shouldBe(visible).click();
		//startFilterDate = jFil.fDateFrom().shouldBe(visible).getText();
		//endFilterDate = jFil.fDateTo().shouldBe(visible).getText();
		//System.out.println(startFilterDate + " " + endFilterDate);
				
		jFil.bApplyFilter().shouldBe(visible).click();
		
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyDatesInJournal(softAssert);

		uj.bFilters().shouldBe(visible).click();
		switchTo().defaultContent();
		jFil.bClearFilter().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
		//3.2 WF name/
		//Covered in 2.3.1
		
		//3.3 Groups + Users/
		//testing will be just selection that appropriate User and group can be selected.
		//Assertion is hard to do
					
		//3.4 Notes
		uj.bFilters().shouldBe(visible).click();
		switchTo().defaultContent();
		jFil.fNotes().shouldBe(visible).sendKeys(filterWord);//
		jFil.bApplyFilter().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		uj.verifyfilteredByNotes(softAssert, filterWord);
		uj.bFilters().shouldBe(visible).click();
		switchTo().defaultContent();
		jFil.bClearFilter().shouldBe(visible).click();
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		//assert has to be here///////////////////////////////////////////////////////////////////////////////////////
		
		//4. Sorting of entries by columns
		
		//4.1 Notes
		uj.columnNotes().shouldBe(visible).click();
		Thread.sleep(1000); // just to do something///////////////////////////////////////////////////////
		//assert of order ///////////////////////////////////////////////////////////////////////////////////////
		//4.2 date Time (default)
		uj.columnDate().shouldBe(visible).click();
		Thread.sleep(1000); // just to do something///////////////////////////////////////////////////////
		//assert of order ///////////////////////////////////////////////////////////////////////////////////////
		//4.3 user
		uj.columnUser().shouldBe(visible).click();
		Thread.sleep(1000); // just to do something///////////////////////////////////////////////////////		
		
		switchTo().defaultContent();		
		softAssert.assertAll();
	}

}
