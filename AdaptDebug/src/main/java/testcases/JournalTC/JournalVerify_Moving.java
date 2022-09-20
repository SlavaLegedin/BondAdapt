package testcases.JournalTC;

import org.testng.annotations.Test;

import com.codeborne.selenide.testng.annotations.Report;

import static com.codeborne.selenide.Condition.*;

import java.text.ParseException;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.generalFunctions.S_UserJournal;


@Report
public class JournalVerify_Moving extends TestBase {
	
	@Test (invocationCount = 1,
			enabled = true)
	public void journalChecks () throws InterruptedException, ParseException {
		
		M_LeftHandMenu 			lhm			= new M_LeftHandMenu();
		S_UserJournal			uj			= new S_UserJournal();
		
		int pageOverallCount = 0;
		int pageCurrent	= 0;
		int firstPage = 1;
		int secondPage = 2;
		
		String desiredPageNumber 			= variablesProp.getProperty("desiredPageNumber");//"2"; 
		
		lhm.openMyAdapt();
		lhm.lUserJournal().shouldBe(visible).click();
		
		/*
		 * 1. Go to page:							    - DONE
		 * 1.1 By selecting of number   	        	- DONE
		 * 1.2 By next/previous buttons     		    - DONE
		 * 1.3 By last/first buttons      	    	  	- DONE
		 * */
		switchTo().defaultContent();	
		switchTo().frame(uj.frameLegacyContainer());
		switchTo().frame(uj.frameRootFrame());
		
		// 1. Go to page
		/*
		 * Important Note
		 * Make sure that user has at least four Journal entries before testing.
		 * Probably it would be better to run such test cases after Candidate creation test cases.
		 */
		//1.1
		System.out.println("Start  1.1");
		
		//assert that appropriate pages opened
		pageCurrent = Integer.parseInt(uj.fpageNo().shouldBe(visible).getAttribute("value"));
		uj.verifyPageNo(softAssert, firstPage, pageCurrent);
		
		//next page
		uj.bNextPage().shouldBe(visible).click();
		pageCurrent = Integer.parseInt(uj.fpageNo().shouldBe(visible).getAttribute("value"));
		uj.verifyPageNo(softAssert, secondPage, pageCurrent);
		pageOverallCount = Integer.parseInt(uj.lTotalPages().shouldBe(visible).getText().replaceAll("[^0-9]", ""));
		
		//last page
		uj.bLastPage().shouldBe(visible).click();
		pageCurrent = Integer.parseInt(uj.fpageNo().shouldBe(visible).getAttribute("value"));
		uj.verifyPageNo(softAssert, pageOverallCount, pageCurrent);
		
		//Previous page
		uj.bPrevPage().shouldBe(visible).click();
		uj.verifyPageNo(softAssert, pageOverallCount - 1, pageCurrent);
		
		//First page
		uj.bFirstPage().shouldBe(visible).click();
		uj.verifyPageNo(softAssert, firstPage, pageCurrent);
		
		//1.2 Next/Previous page buttons
		System.out.println("Start  1.2");
		uj.fpageNo().shouldBe(visible).setValue(desiredPageNumber);
		uj.bGo().shouldBe(visible).click();
		uj.verifyPageNo(softAssert, Integer.parseInt(desiredPageNumber), pageCurrent);
		
		//1.3 is implemented in 1.1
		System.out.println("Start  1.3 - implemented in 1.1");		
		
		
		switchTo().defaultContent();		
		softAssert.assertAll();		
		
	}
}
