package threadSafeIntegerExample;

public class ThreadSafeInteger {

	private int value;
	
	public ThreadSafeInteger(int v) {
		value = v;
	}
	
	public void increment() {
		synchronized(this) {
			value++;
		}
	}
	
	public void decrement() {
		synchronized(this) {
			value--;
		}
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
