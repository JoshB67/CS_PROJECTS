package innerClassExamples;
import java.util.Iterator;

public class BoundedListDriver {

	public static void main(String[] args) {

		BoundedObjectList list = new BoundedObjectList(10);
		
		list.add("cat");
		list.add("antelope");
		list.add(new java.util.Scanner(System.in));
		list.add(17);
		list.add("dog");
		list.add(74);
		list.add(new BoundedObjectList(4));
		
		/* Let's remove anything that's not a String */
		Iterator<Object> it = list.iterator();
		while(it.hasNext()) {
			Object curr = it.next();
			if ( !(curr instanceof String)) {
				it.remove();
			}
		}
		
		/* Now print the list */
		for (Object x : list) {
			System.out.println(x);
		}
	}

}
