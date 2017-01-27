package hurricaneImplementation;

import java.util.Comparator;

public class RainfallComparator implements Comparator<Hurricane> {

	@Override
	public int compare(Hurricane o1, Hurricane o2) {
		return o1.getRainFall() - o2.getRainFall(); //EZ way to sort numerically
	}


}
