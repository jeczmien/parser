package pl.parser.nbp;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {

	private Utils() {
		//
	}

	public static int getYear(Date date) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
}
