package pages;

import pages.generalFunctions.S_Tasks;
import pages.generalFunctions.S_UserCalendar;

public class _PagesList {
	public M_Reminders		reminders	= new M_Reminders();
	public M_Tasks			tasks		= new M_Tasks();
	public S_Tasks			sTasks		= new S_Tasks();
	public M_Calendar		calendar	= new M_Calendar();
	public S_UserCalendar	sCalendar	= new S_UserCalendar();
	public M_configurations	conf		= new M_configurations();
	public M_WorkStack		workStack	= new M_WorkStack();
	public M_TopMenu		topMenu		= new M_TopMenu();

}
