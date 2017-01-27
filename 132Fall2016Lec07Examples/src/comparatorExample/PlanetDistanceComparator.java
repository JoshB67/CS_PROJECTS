package comparatorExample;

import java.util.Comparator;

public class PlanetDistanceComparator implements Comparator<Planet> {

	public int compare(Planet a, Planet b) {
		return (int)(a.getDistance() - b.getDistance());
	}
}
