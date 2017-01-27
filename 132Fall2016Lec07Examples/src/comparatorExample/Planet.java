package comparatorExample;

import java.util.ArrayList;
import java.util.Collections;

public class Planet implements Comparable<Planet>{

	private String name;
	private double mass;
	private double distanceFromSun;
	
	public Planet(String name, double mass, double distance) {
		this.name = name;
		this.mass = mass;
		this.distanceFromSun = distance;
	}
	
	public double getMass() {
		return mass;
	}
	
	public double getDistance() {
		return distanceFromSun;
	}
	
	public int compareTo(Planet other) { 
		return name.compareTo(other.name);
	}
	
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		ArrayList<Planet> list = new ArrayList<Planet>();
		list.add(new Planet("Earth", 5.9E24, 1.49E11));
		list.add(new Planet("Mercury", 3.3E23, 5.8E10));
		list.add(new Planet("Venus", 4.8E24, 1.1E11));
		list.add(new Planet("Mars", 6.4E23, 2.3E11));
		list.add(new Planet("Jupiter", 1.9E27, 7.8E11));
		list.add(new Planet("Saturn", 5.68E26, 1.4E12));
		list.add(new Planet("Uranus", 8.68E25, 2.86E12));
		list.add(new Planet("Neptune", 1.02E26, 4.5E12));
		list.add(new Planet("Pluto", 1.25E22, 5.9E12));
		
		
		Collections.sort(list);
		System.out.println("Alphabetized:");
		System.out.println(list);
		Collections.sort(list, new PlanetMassComparator());
		System.out.println("\nSorted by Mass:");
		System.out.println(list);
		Collections.sort(list, new PlanetDistanceComparator());
		System.out.println("\nSorted by Distance");
		System.out.println(list);
		
	}
	
}
