package pe.knomo.snippets.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd'_'HH.mm.ss");
		Date todayDate = Calendar.getInstance().getTime();
		System.out.println(sdf.format(todayDate));
		
	}

}
