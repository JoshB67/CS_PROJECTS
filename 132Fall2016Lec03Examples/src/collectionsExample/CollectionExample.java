///UNCHECKED....
package collectionsExample;
import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionExample {

	public static Collection<Integer> defineElements(boolean arrayFlag,
			int numberOfValues, int maxValue) {
		Collection<Integer> elements;
		
		if (arrayFlag) {
			elements = new ArrayList<Integer>();
		} else {
			elements = new LinkedList<Integer>();
		}

		for (int j = 0; j < numberOfValues; j++) {
			elements.add((int) (Math.random() * maxValue + 1));
		}

		return elements;
	}

	public static void displayValues(Collection<Integer> data) {
		if (data.isEmpty()) {
			System.out.println("Empty Collection");
		} else {
			for (Integer value : data)
				System.out.print(value + " ");
		}
	}

	public static void main(String[] args) {
		Collection<Integer> firstCollection = defineElements(true, 5, 10);
		System.out.println("First Collection:");
		displayValues(firstCollection);

		System.out.println("\nSecond Collection:");
		Collection<Integer> secondCollection = defineElements(false, 5, 10);
		displayValues(secondCollection);

		/* Example of methods defined by the Collection interface */
		Collection<Integer> union = new ArrayList<Integer>();

		/* Combining elements */
		union.addAll(firstCollection);
		union.addAll(secondCollection);
		System.out.println("\nUnion");
		displayValues(union);

		/* Checking if elements from one collection are present in antoher */
		if (union.containsAll(firstCollection))
			System.out.println("\nIncludes all elements of first collection");

		/* Removing elements in union present in second collection */
		union.removeAll(secondCollection);
		System.out.println("After removing");
		displayValues(union);

		/* Clearing the collection */
		union.clear();
		System.out.println();
		displayValues(union);
	}
}