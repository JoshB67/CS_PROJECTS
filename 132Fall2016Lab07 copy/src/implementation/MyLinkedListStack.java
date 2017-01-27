package implementation;
import java.util.NoSuchElementException;

public class MyLinkedListStack<T> implements MyStack<T> {

	
	public class Node {

		public T data; //a piece of data in the node
		public Node next; //reference to the next ==> node and that node has the same stuff and so on

		
		public Node(T d) {
			data = d;
			next = null;
		}

		
	}


	public Node head = null;


	@Override
	public void push(T element) {
		Node nodeToTheTop = new Node(element);
		nodeToTheTop.next = head;
		head = nodeToTheTop;
	}


	@Override
	public T pop() {
		if(head == null){
			return null;
		}else{
			T type = head.data;
			head = head.next;
			return type;
		}

	}

}
