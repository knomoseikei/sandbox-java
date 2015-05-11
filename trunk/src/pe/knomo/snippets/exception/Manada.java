package pe.knomo.snippets.exception;

public class Manada {

	private Filosoforaptor filosoforaptor;
	
	public Manada() {
		super();
		this.filosoforaptor = new Filosoforaptor();
	}

	public int herpderp() throws Exception{
		System.out.println("INICIO herpderp()");
		try{
			
			System.out.println(filosoforaptor.filosofarBien());
			System.out.println(filosoforaptor.filosofarMal());
			
		} catch (NullPointerException e) {
			System.out.println("NullPointerException STFU! "+ e.getMessage());
			throw e;
		} catch (Exception e) {
			System.out.println("GENERIC STFU!"+ e.getMessage());
			throw e;
		} finally {
			System.out.println("pero antes! el finally!");
		}
		return 1;
		
	}

	public Filosoforaptor getFilosoforaptor() {
		return filosoforaptor;
	}

	public void setFilosoforaptor(Filosoforaptor filosoforaptor) {
		this.filosoforaptor = filosoforaptor;
	}
	
	
}
