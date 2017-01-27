package innerClassExamples;

/* Represents a sequence of integers from 1 up to a 
 * pre-determined value.  */

import java.util.Iterator;

public class PrimeNumberList implements Iterable<Integer> {

	private int numberOfPrimes;
	
	public PrimeNumberList(int numberOfPrimes) {
		this.numberOfPrimes = numberOfPrimes;
	}
	
	private static boolean isPrime(int n) {
		for (int factor = (int)Math.sqrt(n); factor >= 2; factor--) {
			if (n % factor == 0)
				return false;
		}
		return true;
	}
	
	private class PNLIterator implements Iterator<Integer> {
		private int count = 0;
		private int currValue = 1;
		
		public boolean hasNext() {
			return count < numberOfPrimes;
		}
		
		public Integer next() {
			count++;
			while(true) {
				if (isPrime(++currValue)) {
					return currValue;
				}
			}
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	public Iterator<Integer> iterator() {
		return new PNLIterator();
	}
	
}
