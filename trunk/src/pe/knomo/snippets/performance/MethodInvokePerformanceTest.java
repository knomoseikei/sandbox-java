package pe.knomo.snippets.performance;

public class MethodInvokePerformanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Foo foo = new Foo();
		Pet pet = new Pet();
		pet.setName("NameOfPet");
		foo.setPet(pet);

		@SuppressWarnings("unused")
		String string = "";
		String aux;
		Pet auxPet;

		long time = System.currentTimeMillis();

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			string = foo.getPet().getName();
			string = foo.getPet().getName();
			string = foo.getPet().getName();
			string = foo.getPet().getName();
			string = foo.getPet().getName();
			string = foo.getPet().getName();
			string = foo.getPet().getName();
			string = foo.getPet().getName();
			string = foo.getPet().getName();
			string = foo.getPet().getName();
		}

		System.out.println("A:" + (System.currentTimeMillis() - time));

		string = "";
		time = System.currentTimeMillis();

		auxPet = foo.getPet();

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			string = auxPet.getName();
			string = auxPet.getName();
			string = auxPet.getName();
			string = auxPet.getName();
			string = auxPet.getName();
			string = auxPet.getName();
			string = auxPet.getName();
			string = auxPet.getName();
			string = auxPet.getName();
			string = auxPet.getName();
		}

		System.out.println("B:" + (System.currentTimeMillis() - time));

		string = "";
		time = System.currentTimeMillis();

		aux = foo.getPet().getName();

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			string = aux;
			string = aux;
			string = aux;
			string = aux;
			string = aux;
			string = aux;
			string = aux;
			string = aux;
			string = aux;
			string = aux;
		}

		System.out.println("C:" + (System.currentTimeMillis() - time));
	}

}
