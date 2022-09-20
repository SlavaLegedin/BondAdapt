package testcases.EntityScreensAndWF;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.TestBase;

@Report
public class EntityScreensVerify extends TestBase {
	
	
	@Test(dependsOnMethods = {"dataPreparations.createCandidate.createAdaptCandidate"})
	public void entityChecks () throws InterruptedException {
		
		
		int candCounter = 22; //should be moved to confg? //////////////////////////////////////////////////////////////
		/*
		 * 1. Check of buttons which runs wf
		 * 2. test hyperlinks
		 * run segment in edit mode
		 * - edit xref
		 * - edit date field
		 * - edit time field
		 * - edit plain text field
		 * - edit numeric field
		 * - edit checkbox
		 * - edit CG
		 * - edit RTE control
		 * - auto-populated fields populated correctly
		 * - save changes
		 * - cancel changes
		 * 
		 * link candidates to job from batch
		 * - linkiing
		 * - sorting be column
		 * - pagination
		 * - displaying of flyout
		 * - select one or more items and run appropriate WF
		 * 
		 * User defined field segment
		 * - add multiple documents
		 * - change sorting of columns
		 * - delete document
		 * - sorting columns from gearbox menu
		 * 	- sort by all parameters
		 * 	- change view
		 * 	- open document
		 * 	- make document default
		 * 	- rename document
		 * 	- document properties
		 */
		
		/*Data preparation:
		 * Create Client
		 * Create Contact
		 * Create Default Worksite
		 * Activate Company financial
		 * Create Billing Profile
		 * Create Contract Job
		 * Create 20+ candidates in loop
		 * Save all data to properties(?)
		 * */
		String candNames [] = new String [candCounter];
		
		/*for (int i = 0; i < candCounter; i++) {
			
			createCand(i) ; //run create Candidate from dataPreparation
		}*/
		
		//run creation of CLient wit all linked entities
		
		
	
	}

}
