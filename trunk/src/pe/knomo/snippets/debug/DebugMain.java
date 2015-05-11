package pe.knomo.snippets.debug;

public class DebugMain {

	public static void main(String[] args) {
		Contador contador = new Contador();
		contador.contar();
		System.out.println("Hemos contado hasta " + contador.getResultado());
	}

}
