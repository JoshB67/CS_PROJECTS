package LinkedListExample;

import java.util.NoSuchElementException;

public class LinkedListPartOne<T extends Comparable<T>> {

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
	public LinkedListPartOne() { 
		head = null;
	}

	/* Adding at the front of the list */
	public void add(T data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	/* Illustrates simple traversal */
	public String toString() {
		Node curr = head;
		String answer = "";
		while (curr != null) {
			answer += curr.data + " ";
			curr = curr.next;
		}
		return answer;
	}

	public boolean contains(T target) {
		Node curr = head;
		while (curr != null) {
			if (curr.data.equals(target)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	public T getLastElement() {
		Node curr = head;
		if (head == null) {
			throw new NoSuchElementException();
		}
		while (curr.next != null) {
			curr = curr.next;
		}
		return curr.data;
	}

	/* No insertion will take place if list empty or targetElement not found */
	public void insertElementAfter(T targetElement, T toInsert) {
		Node curr = head;
		while (curr != null) {
			if (curr.data.equals(targetElement)) {
				Node n = new Node(toInsert);
				n.next = curr.next;
				curr.next = n;
				return;
			}
			curr = curr.next;
		}
	}

	/* No insertion will take place if list empty or targetElement not found */
	public void insertElementBefore(T targetElement, T toInsert) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			if (curr.data.equals(targetElement)) {
				if (curr == head) {
					Node n = new Node(toInsert);
					n.next = head;
					head = n;
				} else {
					Node n = new Node(toInsert);
					n.next  = curr;
					prev.next = n;
				}
				return;
			}
			prev = curr;
			curr = curr.next;
		}
	}

	
}