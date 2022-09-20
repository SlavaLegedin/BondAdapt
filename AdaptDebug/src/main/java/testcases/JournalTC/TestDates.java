package testcases.JournalTC;

import static com.codeborne.selenide.Condition.visible;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import pages.generalFunctions.W_JournalFilters;

public class TestDates {
	public static void main (String [] args) throws ParseException {
		
		W_JournalFilters		jFil		= new W_JournalFilters();
		String startFilterDate = jFil.fDateFrom().shouldBe(visible).getText();
		String endFilterDate = jFil.fDateTo().shouldBe(visible).getText();
		
		System.out.println(startFilterDate + " " + endFilterDate);
	}

}
