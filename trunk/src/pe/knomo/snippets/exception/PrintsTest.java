package pe.knomo.snippets.exception;

public class PrintsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			@SuppressWarnings("unused")
			int num = 9/0;
		} catch(ArithmeticException e) {
			System.out.println("e.printStackTrace():");
			e.printStackTrace();
			
			System.out.println("System.out.println(e.getMessage()):");
//			System.out.println(e.getStackTrace().length);
//			System.out.println(e.getStackTrace()[0].getClassName());
//			System.out.println(e.getStackTrace()[0].getFileName());
//			System.out.println(e.getStackTrace()[0].getLineNumber());
//			System.out.println(e.getStackTrace()[0].getMethodName());
			System.out.println(e.getMessage());
		}
		System.out.println("FIN");
	}

}
