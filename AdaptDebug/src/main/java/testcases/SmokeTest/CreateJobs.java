package testcases.SmokeTest;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.IoOperations;
import _helpers.TestBase;
import pages.M_ClientMenu;
import pages.M_LeftHandMenu;
import pages.S_ClientHome;
import pages.S_JobsHome;
import pages.S_PeopleHome;
import pages.W_DirectJob_NewJobOrder;
import pages.contactEntity.S_ContactSummary;
import pages.contactEntity.W_CreateAContact;
import pages.clientEntity.S_ClientSummary;
import pages.clientEntity.W_CreateACompany;
import pages.directJobEntity.S_DirectJob_Summary;
import Other.DatesCalculation;

@Report
public class CreateJobs extends TestBase {
	
	
	@Test(priority = 1, 
			enabled = false
			//dependsOnClass = {"CreateClient"}
	)
	public void CreateContractJob() {}
	
	
	@Test(priority = 1, 
			enabled = false
			//dependsOnClass = {"CreateClient"}
	)
	public void ClientQF () {}
	
	@Test(priority = 2, 
			enabled = false
			//dependsOnClass = {"CreateClient"}
	)
	public void CreateDirectJob() throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
		/*1. Open Client or Contact (count that already opened after previous step)
		 * 2. Open Activity menu
		 * 3. Select Add New
		 * 4. Select Direct Job
		 * 5. Switch to opened WF
		 * 6. Check prepopulated data
		 * 7. Enter new data
		 * 8. Confirm WF
		 * 9. Open created Job and check that data matches prepopulated
		 * Next Step - Submit Candidate to Job and create an Assignment*/
		
		
		IoOperations io = new IoOperations();		
		M_ClientMenu cGen = new M_ClientMenu();
		S_ClientHome cHome = new S_ClientHome();
		W_DirectJob_NewJobOrder crDirectJob = new W_DirectJob_NewJobOrder();
		S_JobsHome jHome = new S_JobsHome();
		S_DirectJob_Summary djSum = new S_DirectJob_Summary();
		
		DatesCalculation dt = new DatesCalculation();
		
		//get data for asserting of client
		Map <String, String> testData = io.readMapFromFile();
		String clientName = testData.get("ClientName");
		String contactFn = testData.get("contactFN");
		String contactLn = testData.get("ContactrLN");
		
		//Variables for Job ////////////////////////////////////////////////
		//category should be moved to data file. Properties?????
		//replace should be changed to something more flexible.
		String directJobName = clientName.replace("SClient_", "SC_DrctJob");
		String directJobCategory = "Distribution Management";
		String directStartDate = dt.getFirstDayOfYear().toString();
		String directNoRequired = "2";
		String directSalaryLow = "10000";
		String directSalaryHigh = "20000";
		
		switchTo().defaultContent();
		switchTo().frame(cHome.frameLegacyContainer().shouldBe(exist));		
//		switchTo().frame(cHome.frameRootCompanies());
		
		cGen.mActivitiesMenu().shouldBe(visible).click();
		
		//switch to menu window and run wfs
		switchTo().window(cGen.menuWindowName);
		
		cGen.lAddNew().shouldBe(visible).click();
		cGen.lAddJobOrder().shouldBe(visible).click();
		cGen.lContractJob().shouldBe(visible).click();
		
		//switching to New Direct Job  WF
		switchTo().window(crDirectJob.windowTitle);
//		switchTo().frame(crDirectJob.frInternal());
		
		//Assertions of prepopulated data
		crDirectJob.verifyClientName(softAssert, clientName);
		String contact_name = contactFn + ' ' + contactLn;
		crDirectJob.verifyContactName(softAssert, contact_name);
		
		//Populating of data and confirming WF
		crDirectJob.fJobTitle().shouldBe(visible).sendKeys(directJobName);
		crDirectJob.fJobCategory().shouldBe(visible).sendKeys(directJobCategory);
		crDirectJob.fNumReq().shouldBe(visible).sendKeys(directNoRequired);
		crDirectJob.fStartDate().shouldBe(visible).sendKeys(directStartDate);
		crDirectJob.fSalaryLow().shouldBe(visible).sendKeys(directSalaryLow);
		crDirectJob.fSalaryHigh().shouldBe(visible).sendKeys(directSalaryHigh);
		
		crDirectJob.bConfirm().click();		
		//Assert data on created Direct Job
		
		switchTo().window(0);//
		
		switchTo().defaultContent();
		switchTo().frame(jHome.frameLegacyContainer().shouldBe(exist));

		//assert job title and presence of roles
		
		
//		switchTo().frame(djSum.frInnerFrame()).switchTo().frame(djSum.frDirectJobGen());
		
		//Assert that all expected data has been populated
		
		
		// put data to json with information
		testData.put("directJobId", directJobId);
		testData.put("directJobTitle", directJobTitle);
		testData.put("DirectJobMinSalary", directJobMinSalary);
		testData.put("DirectJobMaxSalary", directJobMaxSalary);
		io.writeMapFile(testData);

	}
}
