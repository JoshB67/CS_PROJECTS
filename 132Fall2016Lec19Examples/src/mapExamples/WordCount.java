package mapExamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import setExamples.RandomWord;

public class WordCount {
	
	
	public static void main(String[] args) throws IOException {
		readFileAndDisplayCounts(new HashMap<String, Integer>());
		readFileAndDisplayCounts(new LinkedHashMap<String, Integer>());
		readFileAndDisplayCounts(new TreeMap<String, Integer>());
	}

// make is an ADT/API/INTERFACE therefore it's POLYMORPHIC

	private static void readFileAndDisplayCounts( Map<String, Integer> map) throws IOException {
		readFromFile(map);
		showPartOfMap(map);
	}
	
	private static void readFromFile( Map<String, Integer> map ) throws IOException {
		
		Path path = Paths.get("shakespeare.txt");
		Scanner s = new Scanner(path);
		
		while (s.hasNext()) {
			String word = s.next();
			word = forceUppercaseAndRemoveWeirdSymbols(word);
			if (word != "") {
				Integer currentCount = map.get(word);  // may be null
				if (currentCount == null) {
					currentCount = 0;
				}
				map.put(word, currentCount + 1);
			}
		}
		
		s.close();
	
	}
	
	private static void showPartOfMap( Map<String, Integer> map ) {
		int count = 0;
		
		for (String key : map.keySet()) {
			System.out.print(key + ": " + map.get(key) + "  ");
			if (count++ == 100) {
				break;
			}
		}
		
		System.out.println("\n\n");
	}
	
	private static String forceUppercaseAndRemoveWeirdSymbols(String word) {
		
		word = word.toUpperCase();
		String newWord ="";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				newWord += c;
			}
		}
		
		return newWord;
	
	}
	
}
