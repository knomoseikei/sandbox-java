package pe.knomo.snippets.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date today = new java.util.Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd'_'HH:mm:ss");
		System.out.println(sdf.format(today));

		SimpleDateFormat sdf_es = new SimpleDateFormat("yyyy.MMMM.dd'_'HH:mm:ss", new Locale("es"));
		System.out.println(sdf_es.format(today));
	}

}
