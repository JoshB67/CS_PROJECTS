
public class Pair<T> {

	private T left;
	private T right;
	
	public Pair(T left, T right) { // things passed in HAVE to be of the SAME type T
		this.left = left;
		this.right = right;
	}
	
	public T getLeft() {
		return left;
	}
	
	public T getRight() {
		return right;
	}
	
	public String toString() {
		return "(" + left + ", " + right + ")";
	}
}
