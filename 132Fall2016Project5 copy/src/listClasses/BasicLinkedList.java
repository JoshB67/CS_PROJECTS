package listClasses;

import java.util.*;


public class BasicLinkedList<T> implements Iterable<T> {


	protected class Node { 
		protected T data; 
		protected Node next;


		public Node(T data) { 
			this.data = data; 
		}

		public T getData() {
			return this.data;
		}

		public Node getNext() {
			return this.next;
		}

	}

	protected Node head; 
	protected Node tail; 
	protected int listSize; 


	public BasicLinkedList() { 
		head = null;
		tail = null;
		listSize = 0;
	}


	/**
	 * Returns a BasicLinkedList<T> with an added Node to the end.
	 * First a temporary Node object is created and passed in generic 
	 * data to its constructor. Then this method handles the edge case
	 * of size 0 by the head == null conditional statement. It then 
	 * follows that head will be assigned to the temporary variable
	 * and tail will be assigned to head when there is not any Node
	 * present. Otherwise case this method jumps along to the next node
	 * in the list. Then after that jump it then assigns the variable after
	 * tail which originally would have been null to that of the 
	 * temporary Node.
	 */
	public BasicLinkedList<T> addToEnd(T data) {
		Node endNodeTemp = new Node(data);////////

		if (head == null) { //handles edge case of size 0
			head = endNodeTemp;
			tail = endNodeTemp;
			head.next = tail;
		} else {
			tail.next = endNodeTemp;
			tail = endNodeTemp;
		}
		listSize++;
		return this;
	}


	/**
	 * A helper method for determining if the list is empty
	 * this method is only used in the Unit testing of this
	 * code.
	 */
	public boolean isEmpty() {
		return getSize() == 0;
	}



	/**
	 * Method returns a BasicLinkedList<T> after adding a temporary Node
	 * to the front of the list. Similar to the addToEnd method this 
	 * method also creates a temporary Node and persists that though the
	 * code with a series of checkpoints. First it checks if head or tail
	 * are null. If so it sets head and tail to the temporary node. Otherwise
	 * the other case would be bumping the next node in line and assigning that
	 * to the head Node.
	 */
	public BasicLinkedList<T> addToFront(T data) {
		Node frontNodeTemp = new Node(data); //Creates a new Node named 'n' and passes in that generic <T> type data
		if (head == null || tail == null) { 
			head = frontNodeTemp; 
			tail = frontNodeTemp;
		} else {
			frontNodeTemp.next = head;
			head = frontNodeTemp;
		}
		listSize++;
		return this;
	}


	/**
	 * Method serves to get the first Node in the list and return that
	 * T type. It does this by first checking that case that head is null
	 * in which case setting the entire method to null. Otherwise returns
	 * the data of head.
	 */
	//Returns but does not remove the first element from the list.
	public T getFirst() {
		if (head == null) {
			return null;
		}
		return head.data;
	}



	/**
	 * The same as the previous method except this gets the last Node of the
	 * list and checks the tail case.
	 */
	public T getLast() {
		if (tail == null) {
			return null;
		}
		return tail.data;
	}



	/**
	 * This method does not traverse a list. It simply returns the listSize
	 * from the listSize instance variable of the BasicLinkedList class
	 */
	public int getSize() {
		return listSize;
	}


	/**
	 * This method uses the Iterable<T> interface implemented in the start of this class.
	 * it returns an Iterator<T>. It follows that it would first return the iterator<T> and begin
	 * its method prototypes for implementation. A dummy variable is created to check against for
	 * null and to allow methods such as hasNext to operate it's check by seeing if head is not equal
	 * to null. remove will not be fully implemented here, that is honors 132. So here it simply throws
	 * an UnsupportedOperationException. The prototype method next returns a type T by first checking is
	 * the dummy variable is currently null, then throwing its exception if that's the case. Then a T type
	 * variable T is created to get the data of the dummy variable through the get method of the inner 
	 * Node class. The dummy variable is then bumped along as the next method prescribes.
	 */
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			Node curr = head;

			public boolean hasNext() {
				return curr != null;
			}


			public void remove() {
				throw new UnsupportedOperationException();
			}


			public T next() {
				if (curr == null) {
					throw new NoSuchElementException();
				}
				T temp = curr.getData();
				curr = curr.getNext();
				return temp;
			}

		};

	}


	/**
	 * Method returns a BasicLinkdList<T> creates a dummy variable and passes
	 * in null data. Also assigns node variable to dummy. Than the standard while loop
	 * pattern for linked lists is carried out, so long as it is not null node will jump
	 * from one node to the next. And if the data matches up with the targetData then
	 * we must check the corner case against tail and if so, set tail to node. Eventually
	 * we break out of this loop. Setting head to the next node of the dummy variable, then
	 * returning the BasicLinkedList<T>
	 */
	public BasicLinkedList<T> removeAllInstances(T targetData) {
		Node dummy = new Node(null), node = dummy;
		while (node.next != null) {
			if (node.next.data.equals(targetData)) {
				if (node.next == tail) 
					tail = node;
				node.next = node.next.next;
				break;
			}
		}

		head = dummy.next;
		return this;
	}




	/**
	 * This method returns a T type by way of retrieving the first node in the list. First we check for the corner
	 * case of an empty list, if so set the entire thing to null. Otherwise we create our T type set it to null
	 * and allow it to pick up different properties as it goes through its check points. Then we check if head is null
	 * if so we also return null. Otherwise we take our result and capture the data of head then decrement and assigned
	 * head to the next Node in line and return it.
	 * 
	 */
	public T retrieveFirstElement() {

		if (listSize == 0) { 
			return null; 
		}


		T result = null; 

		if (head == null) { 
			return null;
		} else { 
			result = head.data; 
			listSize = Math.max(0, listSize --); 
			head = head.next; 

		}
		return result;
	}



	/**
	 * This method returns a type T by retrieving the last element in the list and removing it.
	 * It fist checks for the corner case if the list of Nodes if empty/0. Then if so, it simply
	 * points to a null reference. Then two dummy variables are created towards head and tail
	 * to be persisted through the method. Then a corner case of size 1 is checked. If
	 * it is of size 1 head and tail are t be set to null. It's then decremented and returns the
	 * the dummy variables data. After such, the looping pattern for linked lists is created to
	 * find every node until tail. This operation lets us jump from one node to the other until
	 * we reach the terminating point which then it stations us at tail. Once at tail we assign
	 * the next node of the dummy variable of head to null, therefore garbage collecting the 
	 * mid Node. After that we take the pointer that references the very last node and assign 
	 * it to the first Node in the list is now pointing to null, therefore
	 * leaving us with one single Node (that last Node) to return.
	 */
	public T retrieveLastElement() {

		if (listSize == 0) {
			return null; 
		}

		Node curr = head;
		Node last = tail;

		if (listSize == 1) {
			head = null; 
			tail = null; 
			listSize = Math.max(0, listSize --); 
			return curr.data;
		}

		while (curr.next != tail) {
			curr = curr.next;

		}

		curr.next = null;
		tail = curr; 
		listSize = Math.max(0, listSize --);

		return last.data;
	}


}

