package testcases.GeneralFunctionality;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.MySoftAssert;
import _helpers.TestBase;
import pages.M_CandidateControls;
import pages.M_LeftHandMenu;
import pages.S_PeopleHome;
import pages.W_AddTask;
import pages.W_ScheduleInternalInterview;
import pages.candidateEntity.S_CandidateInterviews;
import pages.candidateEntity.S_CandidateSummary;
import pages.candidateEntity.W_CreateACandidate;
import pages.generalFunctions.S_TasksDashboard;
import pages.generalFunctions.S_UserCalendar;
import pages.generalFunctions.W_UserCalendarSettings;


@Report
public class BookingsLinksVerify extends TestBase{
	
	@Test
	public void verifyBookings () throws InterruptedException {
		
		M_LeftHandMenu 			lhm			= new M_LeftHandMenu();
		MySoftAssert 			softAssertL	= new MySoftAssert();
		S_UserCalendar 			uc			= new S_UserCalendar();
		S_CandidateSummary 		cs			= new S_CandidateSummary();
		
		lhm.openMyAdapt();
		
		/* 1.Open User Calendar
		 * 1.2 Click on refresh
		 * 2.Switch to month view
		 * 3.look through cells where Candidate name is placed
		 * 4.if date for this cell match current date  - test passed
		 * (we create an Interview for today) */
		
		/***************************************************************************************************************/
		//Creation Test candidate with an Interview
		W_CreateACandidate 			crCand1	= new W_CreateACandidate(); 
		S_PeopleHome 			pgen	= new S_PeopleHome();
		S_CandidateSummary 			candSum	= new S_CandidateSummary();
		W_ScheduleInternalInterview sii 	= new pages.W_ScheduleInternalInterview();
		S_CandidateInterviews 		sci 	= new pages.candidateEntity.S_CandidateInterviews();
		M_CandidateControls			cc		= new pages.M_CandidateControls();
		
		String 			candFirstName 		= "Selenide" + time.getSysdate("YYYYMMDDHHmmssS");
		String 			candLastName		= time.getSysdate("YYYYMMDDHHmmssS");
		String 			candTitle 			= candFirstName + " " + candLastName;
		String 			candEmail			= time.getSysdate("YYMMDDHHmmss") + crCand1.candEmail;
		String 			candPhone			= time.getSysdate("MMDDHHMS") + candEmail;
		String 			windowTitle			= crCand1.wfTitleExp;
	
		switchTo().defaultContent();
		lhm.tPeople().shouldBe(visible).click();
		lhm.lPeople_General().shouldBe(visible).click();
	
		switchTo().defaultContent();
		switchTo().frame(pgen.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(pgen.frame_S_PEOPLE().shouldBe(exist));
		switchTo().frame(pgen.frame_roleSearchFrame().shouldBe(exist));
		
		//set candidate checkbox
		pgen.chCandidate().shouldBe(visible).setSelected(true);
		pgen.chCandidate().shouldBe(selected);
		
		//click on find and run of create WF
		pgen.bFind().shouldBe(visible).click();
		pgen.swithToLookupResults();
		pgen.bCreateCand().shouldBe(visible).click();
		
		switchTo().defaultContent();
		switchTo().window(windowTitle);
		switchTo().frame(crCand1.frameNames().shouldBe(exist));
		
		//populating of fields
		crCand1.fFName().shouldBe(visible).sendKeys(candFirstName);
		crCand1.fLName().shouldBe(visible).sendKeys(candLastName);
		crCand1.fMobilePhone().shouldBe(visible).sendKeys(crCand1.candMobNumber);
		crCand1.fEmail1().shouldBe(visible).sendKeys(candEmail);
		crCand1.bConfirm().shouldBe(visible).click();
		
		//set variables for further using
		/*Other.Variables.candFirstName = candFirstName;
		Other.Variables.candLastName = candLastName;
		Other.Variables.candEmail = candEmail;
		Other.Variables.candMobile = candPhone;
		Other.Variables.candTitle = candTitle;*/
		
		switchTo().defaultContent(); //switching to default content and default window
		switchTo().window(0);//I do not have any ideas how avoid that. default title?
		switchTo().defaultContent();
		
		//Assertion
		switchTo().frame(candSum.frcandFrame().shouldBe(exist));
		candSum.verifyCandTitle(softAssert, candTitle);
		
		softAssert.assertAll();
		switchTo().defaultContent();
		
		//Creation of interview
		/*Candidate already opened
		 * 1.Select Interviews segment for Candidate
		 * 2.Click on Schedule Interview button
		 * 3.switch to opened WF
		 * 4.enter the today's date
		 * 5.enter time
		 * 6.Click on Confirm
		 * 7.Make sure that interview has been created (first line in LC)????
		 * */
		//1. Open segments menu
		switchTo().frame(cc.frcandFrame());
		switchTo().frame(cc.frIntFrame());
		cc.bListOfSegments().click();
		//2. 
		switchTo().defaultContent();
		cc.menuInterviewaSegment().shouldBe(visible).click();
		switchTo().frame(cc.frcandFrame());
		switchTo().frame(cc.frIntFrame());
		switchTo().frame(sci.frameInner());
		switchTo().frame(sci.frameInterviews());
		sci.bScheduleIntInterview().shouldBe(visible).click();
		//3.
		switchTo().defaultContent();
		switchTo().window(sii.schedInterInterview);
		switchTo().frame(sii.frameFields());
		//4.
		sii.bCurrDate().shouldBe(visible).click();
		//check that date is current date:
		sii.fDate().getText();
		//5.
		sii.bCurrTime().shouldBe(visible).click();
		//check that time appeared
		sii.fTime().getText();
		//6.
		sii.bConfirm().shouldBe(visible).click();
		//7.
		switchTo().defaultContent();
		switchTo().window(0);//I do not have any ideas how avoid that. default title?
		// just to let browser load elements
		Thread.sleep(1000);
		/*****************************************************************************************************************/
		// continue of calendar check
		//1.
		switchTo().defaultContent();
		lhm.openMyAdapt();
		lhm.lCalendar().shouldBe(visible).click();
		switchToFrame(uc.frame, uc.leftFrame);
		//1.2
		//wait to allow elements load
		Thread.sleep(1000);
		uc.bRefresh().shouldBe(visible).click();
		//wait to allow elements load
		Thread.sleep(1000);
		//2.
		uc.bMonth().shouldBe(visible).click();
		//3.
		uc.aAppointment(candFirstName).shouldBe(visible).click();
		switchTo().defaultContent();
		uc.aCandName().shouldBe(visible).click();
		//4
		//Get entity title and compare with existing
		switchTo().frame(uc.frameLegacyContainer());
		cs.verifyCandTitle(softAssertL, candTitle);
		
		softAssertL.assertAll();

	}

}
