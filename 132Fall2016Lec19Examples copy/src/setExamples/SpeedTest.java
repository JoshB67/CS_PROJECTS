package setExamples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SpeedTest {

	final static int COLLECTION_SIZE = 10000000;  		 // 10 million
	final static int NUMBER_OF_SEARCHES = 10000000;      // 10 million
	
	private static List<Integer> list;
	static {
		System.out.println("Initializing list of values...\n");
		list = new ArrayList<Integer>();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			list.add(i);    // lots of autoboxing
		}
		Collections.shuffle(list);
	}

	public static void main(String[] args) {
		System.out.print("HashSet:  ");
		doManySearches(new HashSet<Integer>());      // search is O(1)
		System.out.print("TreeSet:  ");
		doManySearches(new TreeSet<Integer>());      // search is O(log n)
		System.out.print("ArrayList:  ");
		doManySearches(new ArrayList<Integer>());    // search is O(n)
	}
	
	public static void doManySearches(Collection<Integer> collection) {
		System.out.println("Creating collection of size " + COLLECTION_SIZE + "...");
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			collection.add(list.get(i));
		}
		Collections.shuffle(list);
		System.out.print("Performing " + NUMBER_OF_SEARCHES + " searches...  ");
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_SEARCHES; i++) {
			if (collection.contains(list.get(i % COLLECTION_SIZE))) {
				// do nothing
			}
		}
		long endTime = System.nanoTime();
		System.out.println("It took: " +  (endTime - startTime) / 1000000000.0 + " seconds\n");

	}

	

}
