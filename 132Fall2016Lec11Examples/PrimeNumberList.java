
/* Represents a sequence of integers from 1 up to a 
 * pre-determined value.  */

import java.util.Iterator;

public class PrimeNumberList implements Iterable<Integer> {

	private int numberOfPrimes;
	
	public PrimeNumberList(int max) {
		this.numberOfPrimes = max;
	}
	
	private boolean isPrime(int n) {
		for (int factor = (int)Math.sqrt(n); factor >= 2; factor--) {
			if (n % factor == 0)
				return false;
		}
		return true;
	}
	
	private class PNLIterator implements Iterator<Integer> {
		private int current = 1;
		private int lastPrime = 1;
		
		public boolean hasNext() {
			return current <= numberOfPrimes;
		}
		
		public Integer next() {
			current++;
			while(true) {
				if (isPrime(++lastPrime)) {
					return lastPrime;
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
