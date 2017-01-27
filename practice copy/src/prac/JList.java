package prac;

public class JList<T> { // T just represents the arbitrary thing being passed in, can have any number of arbitrary things
	// we use <> in the class when we are making our own data structures for other classes to use!
	
	
	private T left;
	private T right;
	private int size;
	
	
	public JList(T right, T left) { // object constructor
		this.right = right; // so it says, the right (instance variable) for this object becomes what you passed in
		this.left = left;
		size++;
	}
	
	
	public T getLeft() {
		return this.left;
	}
	
	
	public T getRight() {
		return this.right;
	}
	
	
	public void adder(T data) {
		
	}
	
	
	public void deleter(T data) {
		
	}
	
	
	public int getSize(){
		return this.size;
	}
	
	
	// Why did this need a toString?
	public String toString() {
		return "(" + left + ", " + right + ")";
	}
	
	
	public boolean isEmpty() {
		return size == 0;
		}
	
}
