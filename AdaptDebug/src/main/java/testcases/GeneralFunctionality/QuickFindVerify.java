package testcases.GeneralFunctionality;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;

import org.testng.annotations.Test;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.MySoftAssert;
import _helpers.TestBase;
import pages.M_CandidateControls;
import pages.M_LeftHandMenu;
import pages.S_PeopleHome;
import pages.candidateEntity.S_CandidatePersonalInfo;
import pages.candidateEntity.S_CandidateSummary;
import pages.candidateEntity.W_AddConfidentialInfo;
import pages.candidateEntity.W_CreateACandidate;
import pages.generalFunctions.S_UserCalendar;

@Report
public class QuickFindVerify extends TestBase{
	
	/*
	* Ensure appropriate attributes display depending on roles selected (e.g. if selecting all four types of person, the fields will be more limited than if you selected candidate and supplier candidate.
	* Search by multiple attributes
	* Jump to page
	* Next/Previous Page
	* Hover over result (should preview record)
	* Add /Remove Favorites
	* Create new record
	* Reformat view
	* Reset format to default
	* */
	private String  candFirstName;
	private String  candLastName;
	private String  nickName;
	private String  state;
	private String  postalCode;
	private String  candEmail;
	private String	personId;
	private String  jobTitle;
	private String  branch;
	private String  lastContactedBy;
	private String  candPhone;
	private String  ssn;
	private String  address1;
	
	
	
	@Test (priority = 0)
	public void candidateCreation () {
	M_LeftHandMenu 					lhm				= new M_LeftHandMenu();
	MySoftAssert 					softAssertL		= new MySoftAssert();
	W_CreateACandidate 				crCand1			= new W_CreateACandidate(); 
	S_PeopleHome		 			pgen			= new S_PeopleHome();
	S_CandidateSummary 				candSum			= new S_CandidateSummary();
	S_CandidatePersonalInfo			candPers		= new S_CandidatePersonalInfo();
	M_CandidateControls				candControl		= new M_CandidateControls();
	W_AddConfidentialInfo			confInfo		= new W_AddConfidentialInfo();
	
	String propertyPath = variablesProp.getProperty("propertyPath");
	
	candFirstName 		= "Selenide" + time.getSysdate("YYYYMMDDHHmmssS");
	candLastName		= time.getSysdate("YYYYMMDDHHmmssS");
	candEmail			= time.getSysdate("YYMMDDHHmmss") + crCand1.candEmail;
	candPhone			= time.getSysdate("MMDDHHMMSS");
	address1			= "Address" +  candLastName;
	postalCode			= crCand1.postalCode;
	jobTitle			= crCand1.jobTitle + candLastName.substring(4);
	
	String	windowTitle			= crCand1.wfTitleExp;
	String	candTitle 			= candFirstName + " " + candLastName;
	String	addPersInfoWF		=	confInfo.wFTitle;
	
	//creating of new SSN increasing existing one
	String propSsn = 	variablesProp.getProperty("ssn");
	String tempSsnP1 = propSsn.substring(0,3);
	String tempSsnP0 = propSsn.substring(3);
	String tempSsnP2 = Integer.toString((Integer.valueOf(tempSsnP0) + 1));
	
	if (tempSsnP2.length() != 6) {
		String zero = "000000";
		tempSsnP2 = zero.substring(0, 6 - tempSsnP2.length()) + tempSsnP2;
	}
	String ssn = tempSsnP1 + tempSsnP2;
	System.out.println("new ssn is: " + ssn);
	variablesProp.setProperty(propertyPath, "ssn", ssn, "");

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
	
	//click on clear
	pgen.bClear().shouldBe(visible).click();
	
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
	crCand1.fMobilePhone().shouldBe(visible).sendKeys(candPhone);
	crCand1.fEmail1().shouldBe(visible).sendKeys(candEmail);
	crCand1.fAddress1().shouldBe(visible).sendKeys(address1);
	crCand1.fPostalCode().shouldBe(visible).sendKeys(postalCode);
	crCand1.fJobTitle().shouldBe(visible).sendKeys(jobTitle);
	
	crCand1.bConfirm().shouldBe(visible).click();
	
	switchTo().defaultContent(); //switching to default content and default window
	switchTo().window(0);//I do not have any ideas how avoid that. default title?
	switchTo().defaultContent();
	
	//Assertion
	switchTo().frame(candSum.frcandFrame().shouldBe(exist));
	candSum.verifyCandTitle(softAssert, candTitle);
		
	
	switchTo().defaultContent();
	switchTo().frame(pgen.frameLegacyContainer().shouldBe(exist));
	switchTo().frame(pgen.frame_S_PEOPLE().shouldBe(exist));
	switchTo().frame(candSum.frInnerFrame().shouldBe(exist));
	
	//Edit Summary segment for Candidate
	//switchTo().frame(candSum.frcandFrame())
	//candSum.bEdit().shouldBe(visible).click();
	switchTo().frame(candSum.frCandSummary().shouldBe(exist));
	//get data from summary segment
	personId = candSum.fPersonId().shouldBe(visible).getAttribute("value");
	branch = candSum.fBranch().shouldBe(visible).getText();
	nickName = candSum.fNickName().shouldBe(visible).getAttribute("value");
	state = candSum.fState().shouldBe(visible).getText();
	
	switchTo().defaultContent();
	switchTo().frame(pgen.frameLegacyContainer().shouldBe(exist));
	switchTo().frame(pgen.frame_S_PEOPLE().shouldBe(exist));
	
	candControl.bListOfSegments().shouldBe(exist).click();
	
	//open of personal info segment
	switchTo().defaultContent();
	candControl.menuPersonalInfoSegment().shouldBe(exist).click();
	
	switchTo().frame(pgen.frameLegacyContainer().shouldBe(exist));
	switchTo().frame(pgen.frame_S_PEOPLE().shouldBe(exist));
	switchTo().frame(candSum.frInnerFrame().shouldBe(exist));
	switchTo().frame(candPers.frCandPersonalInfo().shouldBe(exist));
	
	//open add personal info WF
	candPers.bAddConfInfo().shouldBe(visible).click();
	
	switchTo().defaultContent();
	switchTo().window(addPersInfoWF).manage().window().maximize();
		
	switchTo().frame(confInfo.frAddConfInfoFrame().shouldBe(exist));
	
	confInfo.fSSN().shouldBe(visible).sendKeys(ssn);
	confInfo.bConfirm().shouldBe(visible).click();
	
	//Run and Confirm log a phone call WF /////////////////////////////////////////////////////////
	
	switchTo().defaultContent();
	System.out.println("Creation and preparing of Candidate are completed");
	
	switchTo().window(0);//I do not have any ideas how avoid that. default title?
	switchTo().defaultContent();
	
	//lhm.tPeople().shouldBe(visible).click();
	lhm.lPeople_General().shouldBe(visible).click();
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	/* 2. Open QuickFind and try to open Candidate*/
	
	switchTo().defaultContent();
	switchTo().frame(pgen.frameLegacyContainer().shouldBe(exist));
	switchTo().frame(pgen.frame_S_PEOPLE().shouldBe(exist));
	switchTo().frame(pgen.frame_roleSearchFrame().shouldBe(exist));
		
	//set candidate checkbox
	pgen.chCandidate().shouldBe(visible).setSelected(true);
	pgen.chCandidate().shouldBe(selected);
		
	//populate data for quick find
	pgen.bClear().shouldBe(visible).click();
	pgen.fFirstName().shouldBe(visible).sendKeys(candFirstName);
	pgen.fLastName().shouldBe(visible).sendKeys(candLastName);
	pgen.fNickName().shouldBe(visible).sendKeys(nickName);
	pgen.fState().shouldBe(visible).sendKeys(state);
	pgen.fPostalCode().shouldBe(visible).sendKeys(postalCode);
	pgen.fEmail().shouldBe(visible).sendKeys(candEmail);
	pgen.fPersonId().shouldBe(visible).sendKeys(personId);
	pgen.fJobTitle().shouldBe(visible).sendKeys(jobTitle);
	pgen.fBranch().shouldBe(visible).sendKeys(branch);
	pgen.fPhoneNumber().shouldBe(visible).sendKeys(candPhone);
	pgen.fSsnLastDigits().shouldBe(visible).sendKeys(ssn.substring(5));
		
	pgen.bFind().shouldBe(visible).click();
	
	switchTo().defaultContent();
	switchTo().frame(pgen.frameLegacyContainer().shouldBe(exist));
	switchTo().frame(pgen.frame_S_PEOPLE().shouldBe(exist));
	switchTo().frame(pgen.frame_roleSearchFrame().shouldBe(exist));
	
	pgen.lFirstSearchResult().shouldBe(visible).click();
	
	
		
	/* 3. Verify opened Candidate*/
		
		softAssert.assertAll();
	}
	

}
