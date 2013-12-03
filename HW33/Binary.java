/*
  Shein Htike
  Period 8
  HW#29
  2012-11-21
*/
public class Binary implements Comparable{

    private int _decNum;
    private String _binNum;

    /*=====================================
      default constructor
      precondition:  
      postcondition: 
      =====================================*/
    public Binary() { 
	_decNum = 0;
	_binNum = "0";
    }


    /*=====================================
      overloaded constructor
      precondition:  n >= 0
      postcondition: 
      =====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = decToBin(n);
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      precondition:  
      postcondition: 
      =====================================*/
    public String toString() { 
	return _binNum;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      precondition:  n >= 0
      postcondition: return String of bits
      eg  decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	String x = "";
	while(n != 0){
	    x = n % 2 + x;
	    n /= 2;
	}
	return x;
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      precondition:  n >= 0
      postcondition: returns String of bits
      eg  decToBin(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) { 
	if (n == 0)
	    return "0";
	else if (n == 1)
	    return "1";
	else
	    return n % 2 + decToBin(n / 2);
    }
    public boolean equals(Object x){
	return ((Binary) x)._decNum == _decNum;
    }
    public int compareTo(Object x){
	int y = ((Binary) x)._decNum;
	if ( _decNum < y )
	    return -1;
	else if ( _decNum > y )
	    return 1;
	else
	    return 0;
    }

    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

    	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	System.out.println(b1);
	System.out.println(b2);
	System.out.println(b3);       //false b/c b1, b2 not aliases
	System.out.println(b1 == b2); //true b/c b1, b3 are aliases
	System.out.println(b1 == b3); //false, but should be true
	System.out.println(b1.equals(b2));
    }//end main()

} //end class
