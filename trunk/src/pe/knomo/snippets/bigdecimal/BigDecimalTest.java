package pe.knomo.snippets.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalTest {

	
	public static void main(String[] args) {
		
		BigDecimal bdIn;
		BigDecimal bdOut;
		//---------------------------
//		bdIn = new BigDecimal(1);
//		bdOut = new BigDecimal(5);
//		bdOut = (bdIn != null ?	bdIn : new BigDecimal(0));
//		
//		System.out.println("bdIn="+bdIn);
//		System.out.println("bdOut="+bdOut);
//		//----------------------------
//		bdIn = new BigDecimal(2);
//		bdOut = new BigDecimal(0);
//		bdOut = (bdIn != null ?	bdIn : new BigDecimal(0));
//		
//		System.out.println("bdIn="+bdIn);
//		System.out.println("bdOut="+bdOut);
//		//-----------------------------
//		
//		bdIn = null;
//		bdOut = null;
//		bdOut = (bdIn != null ?	bdIn : new BigDecimal(0));
//		
//		System.out.println("bdIn="+bdIn);
//		System.out.println("bdOut="+bdOut);
		
		//------------------------------
		bdIn = new BigDecimal(100);
		bdOut = new BigDecimal(35);
		System.out.println(bdIn);
		System.out.println(bdOut);
		bdIn.add(bdOut);
		System.out.println(bdIn);
		System.out.println(bdOut);
		bdIn = bdIn.add(bdOut);
		System.out.println(bdIn);
		System.out.println(bdOut);
		bdIn = bdIn.add(null);
		
	}

}
