package pe.knomo.snippets.string;

public class StringBuilderTest2 {

	static String a;

    public static void main( String[] args ) throws Exception {
    	
        long time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < 10000000; i++ ) {
            sb.delete( 0, sb.length() );
            sb.append( "someString" );
            sb.append( "someString2" );
            sb.append( "someStrin4g" );
            sb.append( "someStr5ing" );
            sb.append( "someSt7ring" );
            a = sb.toString();
        }
        System.out.println( System.currentTimeMillis()-time );
        
        time = System.currentTimeMillis();
        for( int i = 0; i < 10000000; i++ ) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append( "someString" );
            sb2.append( "someString2" );
            sb2.append( "someStrin4g" );
            sb2.append( "someStr5ing" );
            sb2.append( "someSt7ring" );
            a = sb2.toString();
        }
        System.out.println( System.currentTimeMillis()-time );
    }

}
