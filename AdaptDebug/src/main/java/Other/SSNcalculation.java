package Other;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;

import org.testng.annotations.Test;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.MySoftAssert;
import _helpers.PropsReader;
import _helpers.TestBase;
import pages.M_CandidateControls;
import pages.M_LeftHandMenu;
import pages.S_PeopleHome;
import pages.candidateEntity.S_CandidatePersonalInfo;
import pages.candidateEntity.S_CandidateSummary;
import pages.candidateEntity.W_AddConfidentialInfo;
import pages.candidateEntity.W_CreateACandidate;
import pages.generalFunctions.S_UserCalendar;

public class SSNcalculation extends TestBase {
	
	@Test
	public void ssnCalc () {
	//W_AddConfidentialInfo			confInfo		= new pages.W_AddConfidentialInfo();
	String propSsn = 	variablesProp.getProperty("ssn");
	
	String tempSsnP1 = propSsn.substring(0,3);
	String tempSsnP0 = propSsn.substring(3);
	String tempSsnP2 = Integer.toString((Integer.valueOf(tempSsnP0) + 1));
	
	System.out.println(tempSsnP2);
	
	if (tempSsnP2.length() != 6) {
		String zero = "000000";
		tempSsnP2 = zero.substring(0, 6 - tempSsnP2.length()) + tempSsnP2;
	}
	
	System.out.println(tempSsnP2);
	String ssn = tempSsnP1 + tempSsnP2;
		
		System.out.println(ssn);
	}
	

}
