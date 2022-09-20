package dataPreparations;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;

import org.testng.annotations.Test;

import _helpers.MySoftAssert;
import pages.M_LeftHandMenu;
import pages.S_PeopleHome;
import pages.candidateEntity.S_CandidateSummary;
import pages.candidateEntity.W_CreateACandidate;
import pages.generalFunctions.S_UserCalendar;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.TestBase;

@Report
public class CreateCandidate extends TestBase{
	

	@Test(invocationCount = 22)
	public void createAdaptCandidate () {
		
		/*
		 * create Candidate
		 * verify that candidate is created
		 * add candidate name to already existing file
		 * */
		
		M_LeftHandMenu 			lhm			= new M_LeftHandMenu();
		MySoftAssert 			softAssertL	= new MySoftAssert();
		S_UserCalendar 			uc			= new S_UserCalendar();
		S_CandidateSummary 		cs			= new S_CandidateSummary();
		W_CreateACandidate 			crCand1	= new W_CreateACandidate(); 
		S_PeopleHome 			pgen	= new S_PeopleHome();
		S_CandidateSummary 			candSum	= new S_CandidateSummary();
		
		String 			candFirstName 		= "Selenide" + time.getSysdate("YYYYMMDDHHmmssS");
		String 			candLastName		= time.getSysdate("YYYYMMDDHHmmssS");
		String 			candTitle 			= candFirstName + " " + candLastName;
		String 			candEmail			= time.getSysdate("YYMMDDHHmmss") + crCand1.candEmail;
		String 			candPhone			= time.getSysdate("MMDDHHMMSS");
		String 			windowTitle			= crCand1.wfTitleExp;
	
		// Candidate creation
		lhm.openMyAdapt();
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
		//crCand1.fMobilePhone().shouldBe(visible).sendKeys(crCand1.candMobNumber);
		crCand1.fMobilePhone().shouldBe(visible).sendKeys(candPhone);
		crCand1.fEmail1().shouldBe(visible).sendKeys(candEmail);
		crCand1.bConfirm().shouldBe(visible).click();
		
		switchTo().defaultContent(); //switching to default content and default window
		switchTo().window(0);//I do not have any ideas how avoid that. default title?
		switchTo().defaultContent();
		
		//Assertion
		switchTo().frame(candSum.frcandFrame().shouldBe(exist));
		candSum.verifyCandTitle(softAssert, candTitle);
		
		softAssert.assertAll();
		switchTo().defaultContent();
		
		//add data to file
		
		
	}

}
