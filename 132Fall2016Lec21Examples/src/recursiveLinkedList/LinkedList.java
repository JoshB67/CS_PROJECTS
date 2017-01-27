package recursiveLinkedList;

import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> {

	private class Node {
		private T data;
		private Node next;

		private Node(T data) {
			this.data = data;
			next = null;  /* do we really need to do this? */
		}
	}

	/* List head pointer */
	private Node head;

	/* Do we really need this? */
	public LinkedList() { 
		head = null;
	}

	/* Adding at the front of the list */
	public void add(T data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	public boolean contains(T target) {
		return containsHelper(head, target);
	}
	
	private boolean containsHelper(Node localHead, T target) {
		if (localHead == null) {
			return false;
		}
		return localHead.data.equals(target)  || containsHelper(localHead.next, target);
	}

	public String toString() {
		return toStringHelper(head);
	}
	
	private String toStringHelper(Node localHead) {
		if (localHead == null) {
			return "";
		}
		return localHead.data.toString() + toStringHelper(localHead.next);
	}
	
	public int countOccurrences(T target) {
		return countOccurrencesHelper(head, target);
	}

	private int countOccurrencesHelper(Node localHead, T target) {
		if (localHead == null) {
			return 0;
		}
		int theRest = countOccurrencesHelper(localHead.next, target);
		int headCount = (localHead.data.equals(target))?  1 : 0;
		return theRest + headCount;
	}
	
	/* Throws NoSuchElementException when empty */
	public T getLastElement() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return getLastElementHelper(head);
	}
	
	private T getLastElementHelper(Node localHead) {
		if (localHead.next == null) {
			return localHead.data;
		}
		return getLastElementHelper(localHead.next);
	}



}