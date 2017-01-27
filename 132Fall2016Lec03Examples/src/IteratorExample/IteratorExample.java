//CHECKED! CAN RECITE!
package IteratorExample;

import java.util.*;

public class IteratorExample {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("cow");
		list.add("dog");
		list.add("monkey");
		list.add("chicken");
		list.add("pig");
		list.add("ostrich");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String curr = it.next();
			if (curr.length() < 4) {
				it.remove();
			}
		}
		System.out.println(list);
	}

}
