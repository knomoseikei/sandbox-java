package pe.knomo.snippets.ifcontinue;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++){
			System.out.println(i);
			if(i<5){
				if(i == 3){
					System.out.println("go 3");
				}else if(i == 4){
					System.out.println("go 4 and continue");
					continue;
				}
				System.out.println("go less than 5");
			}else{
				System.out.println("more than 5");
				if(i == 9){
					System.out.println("go 9 and continue");
					continue;
				}
			}
			System.out.println("last line");
		}
	}

}
