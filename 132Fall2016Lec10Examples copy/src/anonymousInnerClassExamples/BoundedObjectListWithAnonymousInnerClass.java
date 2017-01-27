package anonymousInnerClassExamples;

import java.util.Iterator;

public class BoundedObjectListWithAnonymousInnerClass implements Iterable<Object>{
	
	private Object[] list;
	private int currentSize;

	public BoundedObjectListWithAnonymousInnerClass(int maxSize) {
		list = new Object[maxSize];
		currentSize = 0;
	}
	
	public void add(Object object) {
		list[currentSize++] = object;
	}
	
	public Iterator<Object> iterator() {
		
		return new Iterator<Object>() {
			private int marker = 0;
			
			public boolean hasNext() {
				return marker < currentSize;
			}
			
			public Object next() {
				return list[marker++];
			}
			
			public void remove() {
				marker--;
				for (int i = marker + 1; i < currentSize; i++) {
					list[i - 1] = list[i];
				}
				currentSize--;
			}
		};  // end of return statement (needs semi-colon)
	}
}
