package setExamples;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class Driver {


// set is NOT a class it's an interface therefore it's a POLYMORPHIC variable!
// therefore we can call it with any of the kinds of set!
	
// takes in any kind of SET which has the RandowWord class inside it
// Remember since SET is an API you cannot instantiate only use it's derivatives
	
	public static void makeSetOfRandomWords( Set<RandomWord> set ) {
		
		for (int wordLength = 2; wordLength < 12; wordLength++) {
			for (int i = 0; i < 100000; i++) {
				set.add(new RandomWord(wordLength));
			}
		}
		
		System.out.println("Size of collection: " + set.size());
		System.out.println("Here is part of it: ");
		
		int count = 0;
		for (RandomWord rw : set) {
			System.out.print(rw + "  ");
			if (count++ == 100) {
				break;
			}
		}
		
		System.out.println("\n\n");
	
	}
	
	
	public static void main(String[] args) {
		makeSetOfRandomWords(new HashSet<RandomWord>());
		makeSetOfRandomWords(new LinkedHashSet<RandomWord>());
		makeSetOfRandomWords(new TreeSet<RandomWord>());
	}

}
