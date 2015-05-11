package pe.knomo.snippets.timestamp;

import java.sql.Timestamp;
import java.util.Date;

public class TimeStampTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date today = new java.util.Date();
	    System.out.println(new Timestamp(today.getTime()));
	}

}
