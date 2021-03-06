/* 
   Shein Htike
   Period 8
   HW#30
   2012-11-21
*/
public class Hexadecimal implements Comparable {
    private int _decNum;
    private String _hexNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";

    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of hex digits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = dexToHex(n);
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _hexNum;
    }


    /*=====================================
      String hexToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of hex digits
      eg  hexToBin(0) -> "0"
          hexToBin(1) -> "1"
	  hexToBin(2) -> "2"
	  hexToBin(3) -> "3"
	  hexToBin(10) -> "A"
	  hexToBin(16) -> "10"
	  hexToBin(20) -> "14"
	  hexToBin(32) -> "20"
	  hexToBin(42) -> "2A"
      =====================================*/
    public static String dexToHex( int n ) {
	String digits = "0123456789ABCDEF";
	String x = "";
	while (n != 0){
	    int digit = n % 16;
	    x = digits.substring(digit,digit + 1) + x;
	    n /= 16;
	}
	return x;
    }


    /*=====================================
      String hexToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of hex digits
      eg  hexToBin(0) -> "0"
          hexToBin(1) -> "1"
	  hexToBin(2) -> "2"
	  hexToBin(3) -> "3"
	  hexToBin(10) -> "A"
	  hexToBin(16) -> "10"
	  hexToBin(20) -> "14"
	  hexToBin(32) -> "20"
	  hexToBin(42) -> "2A"
      =====================================*/
    public static String dexToHexR( int n ) { 
	String digits = "0123456789ABCDEF";
	if (n < 16)
	    return digits.substring(n,n + 1);
	else 
	    return dexToHexR(n % 16) + dexToHexR(n / 16);
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
            Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	return ((Hexadecimal) other)._decNum == _decNum;

    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
            negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	int x = ((Hexadecimal) other)._decNum;
	if (_decNum > x)
	    return 1;
	else if (_decNum < x)
	    return -1;
	else
	    return 0;

    }


    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal h1 = new Hexadecimal(10);
	Hexadecimal h2 = new Hexadecimal(10);
	Hexadecimal h3 = h1;
	Hexadecimal h4 = new Hexadecimal(20);

	System.out.println( h1 );
	System.out.println( h2 );
	System.out.println( h3 );       
	System.out.println( h4 );       

	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be neg
	System.out.println( h4.compareTo(h1) ); //should be pos
    }//end main()

} //end class
