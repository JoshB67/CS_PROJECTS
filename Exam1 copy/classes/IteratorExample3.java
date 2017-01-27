import java.util.*;

public class IteratorExample3 {

	public static void main(String[] args){
		ArrayList<String> myList = new ArrayList<String>();
			myList.add("cat");
			myList.add("dog");
			myList.add("monkey");
			myList.add("giraffe");
			myList.add("elephant");
			myList.add("cow");


			Iterator<String> iter = myList.iterator();
			
			while (iter.hasNext()) {
				String currentString = iter.next();
				if (currentString.length() < 4) {
					iter.remove();
				}
			}

			System.out.println(myList);
		}
	}

