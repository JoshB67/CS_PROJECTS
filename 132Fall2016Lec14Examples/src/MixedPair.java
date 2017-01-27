
public class MixedPair<L,R> {
	// you can define type safety for what your class DS so it can take in and define those as your instance variables
	
	
	private L left; // this represents a separate anyTHING altogether, a holder. Distinctness.
	private R right; // this represents a separate anyTHING altogether. a holder. Distinctness.
	
	
	public MixedPair(L left, R right) { // now the object can have TWO different types of things rather than one
		this.left = left;
		this.right = right;
	}
	
	
	public L getLeft() {
		return left;
	}
	
	
	public R getRight() {
		return right;
	}
	
	// Why is this toString needed?
	public String toString() {
		return "(" + left + ", " + right + ")";
	}

}
