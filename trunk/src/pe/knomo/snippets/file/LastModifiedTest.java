package pe.knomo.snippets.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastModifiedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("rsc/"); 

		//File lstFile[] = file.listFiles();
		String str[] = file.list();

		
		for(String s : str){
			System.out.println(s);
		}
				
		Long lastModified = file.lastModified(); 
		System.out.println(lastModified);
		Date date = new Date(lastModified);
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy.MM.dd_hh.mm");
		String postfix = sfd.format(date);
		System.out.println(postfix);
		System.out.println(date); 

	}
}
