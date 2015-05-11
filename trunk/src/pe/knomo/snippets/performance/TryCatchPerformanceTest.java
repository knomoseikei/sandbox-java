package pe.knomo.snippets.performance;

public class TryCatchPerformanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DummieNegocio dn = new DummieNegocio();
		DummieNegocioTry dnt = new DummieNegocioTry();
//-------------A 
		long time = System.currentTimeMillis();

		for (int i = 0; i < 10000000; i++) {
			try {
				dn.haceNada();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("A:" + (System.currentTimeMillis() - time));
		
//-------------B 
		time = System.currentTimeMillis();
		
		try {
			for (int i = 0; i < 10000000; i++) {
				dn.haceNada();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("B:" + (System.currentTimeMillis() - time));

//-------------C 
		time = System.currentTimeMillis();

		for (int i = 0; i < 10000000; i++) {
			dnt.haceNada();
		}

		System.out.println("C:" + (System.currentTimeMillis() - time));
	}

}
