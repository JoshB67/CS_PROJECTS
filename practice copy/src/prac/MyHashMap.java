package prac;

//import java.util.HashMap;
import java.util.*;

public class MyHashMap {

	public static void main(String[] args) {
		System.out.println("HashMap example program: ");
		
		Map<String, Integer> hMap = new HashMap<>(); //random order of how Map is added (or put), no order
		hMap.put("Homer", 39); //key first, then value
		hMap.put("Marge", 38); //key first, then value
		hMap.put("Lisa", 8); //key first, then value
		hMap.put("Bart", 10); //key first, then value
		hMap.put("Maggie", 1); //key first, then value
		
		hMap.remove("Homer"); //without the key no value will be printed!, they are shared (a pair)
		hMap.remove("Lisa");
		
		for ( Map.Entry<String, Integer> var : hMap.entrySet()) {
			String key = var.getKey();
			int value = var.getValue();
			
			//System.out.println(hMap.remove("Homer"));
			System.out.println(key + " : " + value);
			
		}
		
	}

}
