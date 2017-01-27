package innerClassExamples;

import java.util.Iterator;

public class BoundedObjectList implements Iterable<Object>{
	
	private Object[] list;
	private int currentSize;

	public BoundedObjectList(int maxSize) {
		list = new Object[maxSize];
		currentSize = 0;
	}
	
	public void add(Object object) {
		list[currentSize++] = object;
	}
	
	private class MYIterator implements Iterator<Object> {
		
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
	}
	
	public Iterator<Object> iterator() {
		return new MYIterator();
	}
}
