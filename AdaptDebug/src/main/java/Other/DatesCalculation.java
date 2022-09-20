package Other;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

public class DatesCalculation {

    static LocalDate now = LocalDate.now(); // 2015-11-23
    private static LocalDate firstDay = null;
    Locale locale = Locale.US;
    static String input = "02-Mar-2015";
    @Test

        public String getFirstDayOfYear() throws ParseException {
        //Date date = new Date();

        LocalDate now = LocalDate.now(); // 2015-11-23
        LocalDate firstDay = now.with(firstDayOfYear());
        System.out.println(firstDay);
        String sDate = firstDay.toString();
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
        SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yy");
        String stringDate= DateFor.format(date1);
        System.out.println(stringDate);
        return stringDate;
    }
}
