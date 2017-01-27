package prac;

import java.util.*;

public class prac<T> implements Iterable<T>{

	private List<T> myList = new ArrayList<>();

	public void add(T val) {
		myList.add(val);
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomIterator<T>(myList);
	}

	public class CustomIterator<E> implements Iterator<E> {

		int indexPosition = 0;
		List<E> internalList;

		public CustomIterator(List<E> internalList) {
			this.internalList = internalList;
		}

		@Override
		public boolean hasNext() {
			if(internalList.size() >= indexPosition + 1) {
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			E val = internalList.get(indexPosition);
			indexPosition++;
			return val;
		}

	}

	public static void main(String[] args){

		prac<String> myCustomArray = new prac<>();

		myCustomArray.add("How");
		myCustomArray.add("Now");
		myCustomArray.add("Brown");
		myCustomArray.add("Cow");

		for(String str : myCustomArray) {
			System.out.println(str);
		}

	}

}
