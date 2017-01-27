
/* Represents a sequence of integers from 1 up to a 
 * pre-determined value.  */

import java.util.Iterator;

public class PrimeNumberList2 implements Iterable<Integer> {

	private int max;
	
	private boolean isPrime(int n) {
		for (int factor = (int)Math.sqrt(n); factor >=2; factor--) {
			if (n % factor == 0)
				return false;
		}
		return true;
	}
	
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int current = 1;
			private int lastPrime = 1;
			
			public boolean hasNext() {
				return current <= max;
			}
			
			public Integer next() {
				current++;
				while(true) {
					if (isPrime(++lastPrime))
						return lastPrime;
				}
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		
	}
	
	PrimeNumberList2(int max) {
		this.max = max;
	}

}
