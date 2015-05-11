package pe.knomo.snippets.exception;

public class MemeMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("INICIO");
		Granja granja = new Granja();
		int i = 1000;
		
		try{
			i = granja.ordenarManada();
		} catch (Exception e) {
			System.out.println("---"+e.getMessage());
			System.out.println("---"+e);
			//System.out.println(e.getLocalizedMessage());
			//e.printStackTrace();
		}
			System.out.println("resultado: "+i);
		System.out.println("FIN");
	}

}
