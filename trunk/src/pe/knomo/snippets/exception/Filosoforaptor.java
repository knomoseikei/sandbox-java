package pe.knomo.snippets.exception;

public class Filosoforaptor {

	public int filosofarBien(){
		System.out.println("INICIO filosofarBien()");
		int i;
		i = 1/1;
		return i;
	}
	
	public int filosofarMal(){
		System.out.println("INICIO filosofarMal()");
		int i;
		i = 1/0;
		return i;
	}
}
