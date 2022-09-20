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
import pages.M_LeftHandMenu;
import pages.S_JobsHome;


@Report
public class JobsQF extends TestBase {

	@Test (priority = 0,
			enabled = true)
	public void JobsQuickFind () throws InterruptedException, FileNotFoundException, IOException, ParseException {
		/**
		 * Function use login and then quick find to search Job according to number in JSON
		 * For direct Job Order search name of parameter should be changes.
		 * For further enhancement*/
		
		IoOperations io = new IoOperations();
		Map <String, String> testData = io.readMapFromFile();
		
		String jobId = testData.get("ContractJobId");//"40318";

		M_LeftHandMenu lhm = new M_LeftHandMenu();
		S_JobsHome jobHome = new S_JobsHome();
		
		lhm.openMyAdapt();
		switchTo().defaultContent();
		lhm.openJobs();
		lhm.lJobs_General().shouldBe(visible).click();		
/*
		switchTo().defaultContent();
		switchTo().frame(jobHome.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(jobHome.frJobOrders().shouldBe(exist));
		switchTo().frame(jobHome.frJobSearchParams().shouldBe(exist));

		// set Client checkbox
		jobHome.chkDirectJob().shouldBe(visible).setSelected(true);
		jobHome.chkDirectJob().shouldBe(selected);
		
		jobHome.bClear().shouldBe(visible).click();
		
		//set job id
		jobHome.fJobID().shouldBe(visible).sendKeys(jobId);

		// run search and open create Client WF
		jobHome.bFind().shouldBe(visible).click();
		
		
		Thread.sleep(2000); /////////////////////////////////////////////////////////////////
		
		switchTo().defaultContent();
		switchTo().frame(jobHome.frameLegacyContainer().shouldBe(exist));
		switchTo().frame(jobHome.frJobOrders().shouldBe(exist));
		switchTo().frame(jobHome.frJobSearchResults().shouldBe(exist));
		
		jobHome.lkFirstJob(jobId).shouldBe(visible).click();


 */
	}

}
