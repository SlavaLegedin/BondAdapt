package dataPreparations;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.TestBase;
import pages.M_LeftHandMenu;
import pages.S_ClientHome;
import pages.S_PeopleHome;
import pages.clientEntity.S_ClientSummary;
import pages.clientEntity.W_CreateACompany;
import pages.contactEntity.W_CreateAContact;

@Report
public class CreateClient extends TestBase{
	
	@Test (priority = 0)
	public void createDataFile ()  throws IOException {
		
		FileInputStream fis;
        Properties property = new Properties();
		
      	fis = new FileInputStream("src/main/resources/config.properties");
       	property.load(fis);
        	
       	String fileName = property.getProperty("clientDataFileName");
        	
		
		//file name only - file will be created in project root directory
		File clientData = new File( fileName + ".txt");
		
        if(clientData.createNewFile()){
            System.out.println("file.txt File Created in Project root directory");
        	}
        else 
        	System.out.println("File file.txt already exists in the project root directory");
        
        
	}
	
	@Test (priority = 1)
	public void createClientWitEntities () throws IOException, InterruptedException {
		
		String clientName  		= "SClient_" + time.getSysdate("YYMMDDHHmmssS");
		String contacName;
		String bProflName;
		String workStName;
		String conJobName;
				
		String zipCode			= "85003";
		String clientAddress	= "Address " + clientName;
		

		FileInputStream fis;
        Properties property = new Properties();
      	fis = new FileInputStream("src/main/resources/config.properties");
       	property.load(fis);
       	String fileName = property.getProperty("clientDataFileName");
		
		
       	M_LeftHandMenu 				lhm			= new M_LeftHandMenu();
       	S_ClientHome 			cgen		= new S_ClientHome();
       	W_CreateACompany			crClient	= new W_CreateACompany();
       	S_ClientSummary				clSum		= new S_ClientSummary();
       	W_CreateAContact			crContact	= new W_CreateAContact();
       	
        //creation of Client
       	lhm.openMyAdapt();
		switchTo().defaultContent();
		lhm.openCompanies();
		lhm.lCompanies_General().shouldBe(visible).click();
		
		switchTo().defaultContent();
		switchTo().frame(cgen.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(cgen.frameRootCompanies().shouldBe(exist));
		switchTo().frame(cgen.frameRoleSearchFrame().shouldBe(exist));
		
		//set Client checkbox
		cgen.chClientRole().shouldBe(visible).setSelected(true);
		cgen.chClientRole().shouldBe(selected);
		
		//run search and open create Client WF
		cgen.bFind().shouldBe(visible).click();
		
		switchTo().defaultContent();
		switchTo().frame(cgen.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(cgen.frameRootCompanies().shouldBe(exist));
		switchTo().frame(cgen.frameSearchResults().shouldBe(exist));
		
		cgen.bCreate().shouldBe(visible).click();
		
		switchTo().defaultContent();
		switchTo().window(crClient.windowTitle);
		
		switchTo().frame(crClient.frameInternal().shouldBe(exist));
		
		crClient.fCompanyName().shouldBe(visible).sendKeys(clientName);
		crClient.fPostalCode().shouldBe(visible).sendKeys(zipCode);
		crClient.fAddress1().shouldBe(visible).sendKeys(clientAddress);
		crClient.bConfirm().shouldBe(visible).click();
		
		switchTo().defaultContent(); //switching to default content and default window
		switchTo().window(0);//I do not have any ideas how avoid that. default title?
		switchTo().defaultContent();
		
		switchTo().frame(cgen.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(cgen.frameRootCompanies());
		
		//Assert with client name have to be here///////////////////////////////////////////////////
		//Creation of Contact started
		
		//clSum.mActivitiesMenu().shouldBe(visible).click();
		switchTo().defaultContent();
		//clSum.lAddNew().shouldBe(visible).click();
		//clSum.lAddContact().shouldBe(visible).click();
		
		switchTo().defaultContent();
		switchTo().window(crContact.windowTitle);
		
		
		
		Thread.sleep(5000);
		
		//Contact created
		//returning to a Client and creation of Worksite
		
		
		
		
       	/*
		 * open Companies tab
		 * select Client checkbox
		 * click on Find
		 * populate data on opened wf
		 * click on confirm
		 * verify opened Client
		 * Create contact
		 * create billing profile
		 * create worksite
		 * activate Company financial
		 * Create Contract Job
		 * Send Client and Contract Job data to external source
		 * */
		
       	/**Temporary setting of variables**/
				contacName = "2";
				bProflName = "3";
				workStName = "4";
				conJobName = "5";

       	FileWriter dataWriter = new FileWriter( fileName + ".txt");
		dataWriter.write("clientName = " + clientName +"\n");
		dataWriter.write("contacName = " + contacName +"\n");
		dataWriter.write("bProflName = " + bProflName +"\n");
		dataWriter.write("workStName = " + workStName +"\n");
		dataWriter.write("conJobName = " + conJobName +"\n");
		
		dataWriter.close();
		
	}
	
	@Test (priority = 2)
	public void createContact () {
		
	}
		
	@Test (priority = 3)
	public void createWorksite () {
		
	}
	
	@Test (priority = 4)
	public void createBillingProfile () {
		
	}
	
	@Test (priority = 5)
	public void createContractJob () {
		
	}

}
