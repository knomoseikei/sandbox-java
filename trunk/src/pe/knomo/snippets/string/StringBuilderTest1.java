package pe.knomo.snippets.string;

public class StringBuilderTest1 {

	static String a;

    public static void main( String[] args ) throws Exception {
    	
        long time = System.currentTimeMillis();
        for( int i = 0; i < 10000000; i++ ) {
            StringBuilder sb = new StringBuilder();
            sb.append( "someString" );
            sb.append( "someString2"+i );
            sb.append( "someStrin4g"+i );
            sb.append( "someStr5ing"+i );
            sb.append( "someSt7ring"+i );
            a = sb.toString();
        }
        System.out.println( System.currentTimeMillis()-time );
        
        time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < 10000000; i++ ) {
            sb.delete( 0, sb.length() );
            sb.append( "someString" );
            sb.append( "someString2"+i );
            sb.append( "someStrin4g"+i );
            sb.append( "someStr5ing"+i );
            sb.append( "someSt7ring"+i );
            a = sb.toString();
        }
        System.out.println( System.currentTimeMillis()-time );
    }
}
