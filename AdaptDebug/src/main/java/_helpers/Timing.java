package _helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Timing {
public Locale locale = new Locale("en","US");
	
	public String getSysdate(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format, locale);
		Date referenceDate = new Date();
		String rightdate = dateFormat.format(referenceDate);
		return rightdate;
	} 


	public String getSysdatePlusdd(int days, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format, locale);
		Date referenceDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(referenceDate);
		c.add(Calendar.DAY_OF_MONTH, +days);
		String rightdate = dateFormat.format(c.getTime());
		return rightdate;
	}


	
	public String getSysdatePlusMM(int months, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format, locale);
		Date referenceDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(referenceDate);
		c.add(Calendar.MONTH, +months);
		String rightdate = dateFormat.format(c.getTime());
		return rightdate;
	}
	
	
	public String getSysdateMinusdd(int days, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format, locale);
		Date referenceDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(referenceDate);
		c.add(Calendar.DAY_OF_MONTH, -days);
		String rightdate = dateFormat.format(c.getTime());
		return rightdate;
	}
	
	//Items below were added by KP
	public String getDateFromTimestamp (long timeSt) {
		Date d = new Date(timeSt);
		DateFormat dfr = new SimpleDateFormat ("MMM d,yyyy", locale);
		String formattedDate = dfr.format(d);
		return formattedDate;
	}
	
	
	public int getLastDayOfCurMonth ( ) {
		int lastDay = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
		return lastDay;
	}


}