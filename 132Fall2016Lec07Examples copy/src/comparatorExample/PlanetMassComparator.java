package comparatorExample;

import java.util.Comparator;

public class PlanetMassComparator implements Comparator<Planet> {

	public int compare(Planet a, Planet b) {
		return (int)(a.getMass() - b.getMass());
	}
	
}
