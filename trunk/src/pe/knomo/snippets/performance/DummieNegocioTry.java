package pe.knomo.snippets.performance;

public class DummieNegocioTry {
	
	private DummieDaoTry dummie = new DummieDaoTry();
	
	public void haceNada(){
		try{
			dummie.hacerNada();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
