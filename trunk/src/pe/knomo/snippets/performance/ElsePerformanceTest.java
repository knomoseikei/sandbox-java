package pe.knomo.snippets.performance;

public class ElsePerformanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String string = new String("Hola!");
		@SuppressWarnings("unused")
		String aux;

		long time = System.currentTimeMillis();

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if(string == null){
				aux = "";
			}else{
				
			}
		}

		System.out.println("A:" + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if(string == null){
				aux = "";
			}
		}

		System.out.println("B:" + (System.currentTimeMillis() - time));
	}

}
