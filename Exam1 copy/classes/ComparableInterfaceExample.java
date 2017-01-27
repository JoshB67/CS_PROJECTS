
public class ComparableInterfaceExample implements Comparable<ComparableInterfaceExample> {

	private String name;
	private int grade;
	private double gpa;


	public ComparableInterfaceExample(String n, int gr, double gp) {
		this.name = n;
		this.grade = gr;
		this.gpa = gp;
	}


	public String getName() {
		return name;
	}


	public int getGrade() {
		return grade;
	}


	public double getGpa() {
		return gpa;
	}


	//remember boolean is by default false, so you want to put in a condition that would make it true, if not it's always false!
	public boolean equals(ComparableInterfaceExample other) { //sometimes it's Object other sometimes it's the class name then other? what's the deal?
		return this.getGpa() == other.getGpa(); //then return true! otherwise false!
	}


	@Override
	public int compareTo(ComparableInterfaceExample temp) {
		ComparableInterfaceExample other = (ComparableInterfaceExample)temp;

		if (this.getGpa() > other.getGpa()) {
			return 1;
		} else if(this.getGpa() < other.getGpa()) {
			return -1;
		} else {
			return 0;
		}
	}


	public static void main(String[] args) {
		ComparableInterfaceExample obj1 = new ComparableInterfaceExample("Bob", 12, 3.5);
		ComparableInterfaceExample obj2 = new ComparableInterfaceExample("Sarah", 11, 2.5);
		
		System.out.println("CompareTo returns: " + obj1.compareTo(obj2));
		
		int result = obj1.compareTo(obj2);

		if (result > 0) {
			System.out.println(obj1.getName() + " is greater than " + obj2.getName());
		} else if(result < 0) {
			System.out.println(obj2.getName() + " is greater than " + obj1.getName());
		} else {
			System.out.println(obj1.getName() + " is equal to " + obj2.getName());
		}

	}


}
