import java.util.ArrayList;

public class MixedPairDriver {


	public static void main(String[] args) {

		// you get tools to build complex structures! with generics!
		
		ArrayList< MixedPair<Integer, String> > list = new ArrayList< MixedPair<Integer, String> >();
		// making an empty Arraylist, nothing in there, but it's not null
		
		final int SIZE = 1024; // why is final needed?
		
		
		for (int i = 0; i <= SIZE; i++) {
			
			String binary = Integer.toBinaryString(i); // converts number into its binary representation as a string
			
			// then you store BOTH the original Integer i and the Sting binary representation
			MixedPair<Integer, String> pair = new MixedPair<Integer, String>(i, binary);
			
			// then add that pair to the list defined outside the for loop
			list.add(pair);
		
		}
		
		// then the elegant for each loop, where you have your TYPE extracted from the list,
		// along with your chosen variable name
		// then the actual list you stored all those pairs in.
		// then print each and every one of the
		
		for ( MixedPair< Integer, String > p : list ) {
			System.out.println(p);
		}
		
		
	}

}
