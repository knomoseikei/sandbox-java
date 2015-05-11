package pe.knomo.snippets.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class DateFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateFormat dfin = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		DateFormat dfout = new SimpleDateFormat("MMMM/dd hh:mm");
		try {
			Date date = dfin.parse("2011-09-14 17:42:03.635");
			System.out.println(dfout.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
