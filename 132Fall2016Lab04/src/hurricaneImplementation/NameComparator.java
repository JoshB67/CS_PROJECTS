package hurricaneImplementation;

import java.util.Comparator;

public class NameComparator implements Comparator<Hurricane>{

	@Override
	public int compare(Hurricane obj1, Hurricane obj2) {
		return obj1.getName().compareTo(obj2.getName()); //EZ way to sort two strings alphabetically
	}


}
