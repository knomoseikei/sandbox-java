package pe.knomo.snippets.logic;

public final class LogicMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean p, q;
		
		p = true; q = true;
		System.out.println(func1(p, q)+" "+func2(p, q));

		p = true; q = false;
		System.out.println(func1(p, q)+" "+func2(p, q));

		p = false; q = true;
		System.out.println(func1(p, q)+" "+func2(p, q));

		p = false; q = false;
		System.out.println(func1(p, q)+" "+func2(p, q));
	}
	
	private static boolean func1(boolean p, boolean q){
		return !(!p && !q);
	}

	private static boolean func2(boolean p, boolean q){
		return p || q;
	}
}
