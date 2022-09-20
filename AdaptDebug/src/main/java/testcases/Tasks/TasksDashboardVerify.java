package testcases.Tasks;

import static com.codeborne.selenide.Condition.visible;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.codeborne.selenide.testng.annotations.Report;

import _helpers.TestBase;
import pages.M_LeftHandMenu;

@Report
public class TasksDashboardVerify extends TestBase{
	
	@Test
	public void VerifyTasksDashboard () throws InterruptedException {
		
		M_LeftHandMenu lhm 		= new M_LeftHandMenu();
		SoftAssert softAssertL 	= new SoftAssert();
		
		lhm.openMyAdapt();
		lhm.lTaskDashBoard().shouldBe(visible).click();
		
		/* Options to be tested:
		 * - synchronize
		 * - Filter by User/Group
		 * - Reschedule a task
		 * - Mark as completed
		 * - Add a new task
		 * - Reformat
		 * Sort view by columns
		 * - Refresh view
		 * - Preview task information in panel
		 * 		- expand and collapse
		 * 		- run activities from panel
		 * 		- check displaying and appearing of warnings
		 * - hover over "notes" and confirm they are visible
		 * - hover over "links" and it is possible to open linked records
		 * - hover over "activity" and activity running is possible
		 * - Filters:
		 * 		- date
		 * 		- text
		 * 		- Status
		 * 		- proprty
		 * - view / edit individual task:
		 * 		- dates
		 * 		- add/change category
		 * 		- primary link
		 * 		- status
		 * 		- update percent completed
		 * 		- change priority level
		 * 		- add/change alarm
		 * 		- edit notes
		 * 		- verify links to records
		 * 		- verify task appears in records which have “Show Task On” listed
		 * 		- Add a record for “Show Task On”
		 * 		- verify links to associated records
		 * 		- add a record for “Associated Records”
		 * 		- Run one or two next workflows to ensure that guessing works correctly
		 * */
	}

}
