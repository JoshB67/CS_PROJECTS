import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample2 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Mary");
		list.add("had");
		list.add("a");
		list.add("little");
		list.add("lamb");
		
		Iterator<String> iter = list.iterator();
		
		iter.next();
		iter.next();
		iter.next();
		iter.remove();
		
		System.out.println(list.get(2));
	}

}
