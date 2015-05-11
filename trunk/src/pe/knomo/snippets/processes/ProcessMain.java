package pe.knomo.snippets.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Process p = null;
		String line = null;
		
		try {
			p = Runtime.getRuntime().exec(
					System.getenv("windir") + "\\system32\\" + "tasklist.exe");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			
			while ((line = input.readLine()) != null) {
				System.out.println(line); // <-- Parse data here.
			}
			
			input.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(p);
	}

}
