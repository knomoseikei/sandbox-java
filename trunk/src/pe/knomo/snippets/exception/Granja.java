package pe.knomo.snippets.exception;

public class Granja {

	private Manada manada;

	public Granja() {
		super();
		this.manada = new Manada();
	}

	public int ordenarManada() throws Exception {
		System.out.println("INICIO ordenarManada()");
		return manada.herpderp();
	}

	public Manada getManada() {
		return manada;
	}

	public void setManada(Manada manada) {
		this.manada = manada;
	}
}
