package testcases.SmokeTest;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.annotations.Report;

import _helpers.IoOperations;
import _helpers.TestBase;
import pages.M_ClientMenu;
import pages.M_LeftHandMenu;
import pages.S_ClientHome;
import pages.S_PeopleHome;
import pages.clientEntity.S_ClientFinancialSummary;
import pages.clientEntity.S_ClientSummary;
import pages.clientEntity.W_CreateACompany;
import pages.contactEntity.S_ContactSummary;
import pages.contactEntity.W_CreateAContact;

@Report
public class CreateClient extends TestBase {

	@Test(priority = 1, 
			enabled = true
	// dependsOnMethods = {"createDataFile"}
	)
	public void CreateClientFromWF() throws IOException, InterruptedException, ParseException {
		/*
		 * Steps: 1. Open Companies Tab 
		 * 2. Select Client checkbox 
		 * 3. Set template for
		 * Company search name 
		 * 4. Run Search 
		 * 5. Click on Create Client button 
		 * 6. Switch to Create Client WF 
		 * 7. Populate fields 
		 * 8. Confirm WF 
		 * 9. Verify that just  created Client is opened 
		 * 10. Check that data on segment matches data entered during client creation
		 */

		String clientName = "SClient_" + time.getSysdate("YYMMDDHHmmssS");
		String zipCode = "85003";
		String clientAddress = "Address " + clientName;

		M_LeftHandMenu lhm = new M_LeftHandMenu();
		S_ClientHome cHome = new S_ClientHome();
		W_CreateACompany crClient = new W_CreateACompany();
		S_ClientSummary clSum = new S_ClientSummary();	
				
		IoOperations io = new IoOperations();
		
		Map<String, String> testData = io.readMapFromFile();
		testData.put("ClientName", clientName);
		testData.put("ClientAddress1", clientAddress);
		testData.put("ClientZip", zipCode);		
		
		/**creation of Client**/
		lhm.openMyAdapt();
		switchTo().defaultContent();
		lhm.openCompanies();
		lhm.lCompanies_General().shouldBe(visible).click();

		switchTo().defaultContent();
		switchTo().frame(cHome.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(cHome.frameRootCompanies().shouldBe(exist));
		switchTo().frame(cHome.frameRoleSearchFrame().shouldBe(exist));

		// set Client checkbox
		cHome.chClientRole().shouldBe(visible).setSelected(true);
		cHome.chClientRole().shouldBe(selected);

		// run search and open create Client WF
		cHome.bFind().shouldBe(visible).click();

		switchTo().defaultContent();
		switchTo().frame(cHome.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(cHome.frameRootCompanies().shouldBe(exist));
		switchTo().frame(cHome.frameSearchResults().shouldBe(exist));

		cHome.bCreate().shouldBe(visible).click();

		switchTo().defaultContent();
		switchTo().window(crClient.windowTitle);

		switchTo().frame(crClient.frameInternal().shouldBe(exist));

		crClient.fCompanyName().shouldBe(visible).sendKeys(clientName);
		crClient.fPostalCode().shouldBe(visible).sendKeys(zipCode);
		crClient.fAddress1().shouldBe(visible).sendKeys(clientAddress);
		crClient.bConfirm().shouldBe(visible).click();
		
		Thread.sleep(1000);
		
		switchTo().window(0);// I do not have any ideas how avoid that. default title?
		
		Thread.sleep(1000);
		
		switchTo().defaultContent();
		switchTo().frame(cHome.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(cHome.frameRootCompanies().shouldBe(exist));
		switchTo().frame(clSum.frClientInner().shouldBe(exist));
		switchTo().frame(clSum.frClientGeneral().shouldBe(exist));

		
		//record client ID
		String clientID = clSum.fClientId().getValue();
		String clientState = clSum.fClientState().getText();
		String clientCity = clSum.fClientCity().getValue();
		String clientCountry = clSum.fClientCountry().getText();
		testData.put("CompanyID", clientID);
		testData.put("CompanyCity", clientCity);
		testData.put("CompanyState", clientState);		
		testData.put("CompanyCountry", clientCountry);
				
		// Assert with client name have to be same as entered
		clSum.verifyClientName(softAssert, clientName);
		
		//write data to file
		io.writeMapFile(testData);
		
		Selenide.switchTo().defaultContent();
		softAssert.assertAll();
	}

	@Test(dependsOnMethods = { "CreateClientFromWF" },
			priority = 2,
			enabled = true)
	public void EnableClientFinancial() throws InterruptedException {
		/*
		 * 1. Open Client from previous step (already opened) 
		 * 2. Click on Activate Financial 
		 * 3. Make sure that Company Financial has been opened and contains data
		 * 4. Return to Client summary
		 */
		
		M_ClientMenu cGen = new M_ClientMenu();
		S_ClientHome cHome = new S_ClientHome();
		S_ClientSummary clSum = new S_ClientSummary();
		S_ClientFinancialSummary clfSum = new S_ClientFinancialSummary();
		
		//PropsReader pr = new PropsReader();
		
		switchTo().defaultContent();
		switchTo().frame(cHome.frameLegacyContainer().shouldBe(exist));
		
		//Assert that financial has not been activated yet
		cGen.lCompFinancial().shouldNotBe(visible);
		
		switchTo().frame(cHome.frameRootCompanies());

		cGen.mActivitiesMenu().shouldBe(visible).click();
		
		//switch to menu window and run wfs
		switchTo().window(cGen.menuWindowName);
		
		cGen.lClientActivities().shouldBe(visible).click();
		cGen.lActivateFinancial().shouldBe(visible).click();
		
		switchTo().window(0);// I do not have any ideas how avoid that. default title?
		
		//financial activated and opened
		Thread.sleep(1000);		
		
		switchTo().defaultContent();
		switchTo().frame(cHome.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(cHome.frameRootCompanies().shouldBe(exist));
		switchTo().frame(clfSum.frClientFinInner().shouldBe(exist));
		switchTo().frame(clfSum.frClientFinGeneral().shouldBe(exist));
		
		//Assert that Financial activated
		clfSum.verifyFinStatus(softAssert);
		
		//return to summary segment
		switchTo().defaultContent();
		switchTo().frame(cHome.frameLegacyContainer().shouldBe(exist));
		cGen.lClientSegment().shouldBe(visible).click();
		
		//Assert that client returned to Summary segment by checking that Client ID is visible
		switchTo().defaultContent();
		switchTo().frame(cHome.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(cHome.frameRootCompanies().shouldBe(exist));
		switchTo().frame(clSum.frClientInner().shouldBe(exist));
		switchTo().frame(clSum.frClientGeneral().shouldBe(exist));

		clSum.fClientId().shouldBe(visible);
		
		switchTo().defaultContent();
		softAssert.assertAll();
	}
	
	@Test(dependsOnMethods = { "CreateClientFromWF" },
			priority = 3,
			enabled = true)	
	public void AddContact() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		/*1. Open Client (already opened from previous test)
		 * 2. Open Activities menu
		 * 3. Select Add New
		 * 4. Select Contact
		 * 5. Switch to WF
		 * 6. Enter all
		 * */
		//Constants generation
		String contactFN = "SContFN_" + time.getSysdate("YYMMDDHHmmssS");
		String contactLN = "Selenide";
		//String contactEmail = config.getContactEmail();
		String contactEmail = time.getSysdate("YYMMDDHHmmssS") + "@testmail.cc.com"; 
				
		IoOperations io = new IoOperations();		
		M_ClientMenu cGen = new M_ClientMenu();
		S_ClientHome cHome = new S_ClientHome();
		W_CreateAContact crContact = new W_CreateAContact();
		S_ContactSummary contSum = new S_ContactSummary();
		S_PeopleHome pgen = new S_PeopleHome();
		
		//get data for asserting of client
		Map <String, String> testData = io.readMapFromFile();
		String clientName = testData.get("ClientName");	
		String clientAddress1 = testData.get("streetAddress");
		String clientCity = testData.get("city");
		String clientState = testData.get("state");
		String clientCountry = testData.get("country");
		String clientPostCode = testData.get("postalCode");
		
		switchTo().defaultContent();
		switchTo().frame(cHome.frameLegacyContainer().shouldBe(exist));		
		switchTo().frame(cHome.frameRootCompanies());
		
		cGen.mActivitiesMenu().shouldBe(visible).click();
		
		//switch to menu window and run wfs
		switchTo().window(cGen.menuWindowName);
		
		cGen.lAddNew().shouldBe(visible).click();
		cGen.lAddContact().shouldBe(visible).click();
		
		
		//switching to add contact WF
		switchTo().window(crContact.windowTitle);
		switchTo().frame(crContact.frameInternal());
		
		//Assert that compamy mame is prepopulated on WF
		crContact.verifyClientName(softAssert, clientName);
		
		//Assert address is prepopulated on WF
		crContact.verifyClientAddress(softAssert, clientAddress1);
		crContact.verifyClientCity(softAssert, clientCity);
		crContact.verifyClientState(softAssert, clientState);
		crContact.verifyClientCountry(softAssert, clientCountry);
		crContact.verifyClientZip(softAssert, clientPostCode);
		
		//Populate fields
		crContact.fContFN().shouldBe(visible).sendKeys(contactFN);
		crContact.fContLN().shouldBe(visible).sendKeys(contactLN);
		crContact.fEmail1().shouldBe(visible).sendKeys(contactEmail);
		
		//Click on Confirm button
		crContact.bConfirm().shouldBe(visible).click();
		
		Thread.sleep(1000);
		
		switchTo().window(0);// I do not have any ideas how avoid that. default title?
		
		Thread.sleep(1000);
		
		switchTo().defaultContent();
		switchTo().frame(pgen.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(pgen.frame_S_PEOPLE().shouldBe(exist));
		switchTo().frame(contSum.frContactInner().shouldBe(exist));
		switchTo().frame(contSum.frContactGeneral().shouldBe(exist));
		
		
		//Verify that contact was created and contains entered data		
		contSum.verifyContactAddress1(softAssert, clientAddress1);
		contSum.verifyCity(softAssert, clientCity);
		contSum.verifyState(softAssert, clientState);
		contSum.verifyPostCode(softAssert, clientPostCode);
		contSum.verifyCountry(softAssert, clientCountry);
		contSum.verifyContactFN(softAssert, contactFN);
		contSum.verifyCpntactLn(softAssert, contactLN);
		
		
		String contactID = contSum.fContactId().shouldBe(visible).getValue();
		
		testData.put("contctID", contactID);
		testData.put("contactFN", contactFN);
		testData.put("ContactrLN", contactLN);
		testData.put("ContactEmail", contactEmail);
		testData.put("ContactAddress1", clientAddress1);
		testData.put("ContactCity",  clientCity);
		testData.put("ContactState",  clientState);
		testData.put("ContactPostCode", clientPostCode);
		testData.put("ContactCountry", clientCountry);
		
		io.writeMapFile(testData);
		switchTo().defaultContent();
		softAssert.assertAll();
		
	}

}
