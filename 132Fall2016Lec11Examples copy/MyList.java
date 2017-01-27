import java.util.Iterator;

public class MyList implements Iterable<Object>{
	private Object[] stuff;

	public MyList() {
		stuff = new Object[0];
	}
	
	/* Imagine more methods here... */
	
	private class MYIterator implements Iterator<Object> {
		int marker = 0;
		
		public boolean hasNext() {
			return marker < stuff.length;
		}
		
		public Object next() {
			return stuff[marker++];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public Iterator<Object> iterator() {
		return new MYIterator();
	}
}
