import java.util.Iterator;

public class MyList2 implements Iterable<Object>{
	private Object[] stuff;

	public MyList2() {
		stuff = new Object[0];
	}
	
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {
			int marker = 0;
			
			public boolean hasNext() {
				return marker < stuff.length;
			}
			
			public Object next() {
				marker++;
				return stuff[marker - 1];
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		} ;
	}
}
