package pe.knomo.snippets;

import java.net.MalformedURLException;

/**
 * Contains various unorganized static utility methods used across Cayenne.
 * 
 * @author Andrei Adamchik
 */
public class JNIMathClient {

	public native int addTwoNumbers(int one, int two);

	public native int multiplyTwoNumbers(int one, int two);

	static {
		System.loadLibrary("MathLibrary");
	}

	public static void main(String[] args) throws MalformedURLException {
		JNIMathClient client = new JNIMathClient();

		int num1, num2;

		num1 = 5;
		num2 = 100;

		System.out.println(num1 + " + " + num2 + " = " + client.addTwoNumbers(num1, num2));
		System.out.println(num1 + " + " + num2 + " = " + client.multiplyTwoNumbers(num1, num2));
	}

}
