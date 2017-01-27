//POSTED!
package inheritance;

public class Student extends Person{

	private double GPA;
	private int admitYear;
	
	public Student(String name, int ID, double GPA, int admitYear) { //Understood, a constructor
		super(name, ID); //This super keyword, I am very confused by, also why parameters? 
		this.GPA = GPA;
		this.admitYear = admitYear;
	}
	
	public Student() { //Understood, a default constructor
		super("Unknown", 0); //Again, super, just isn't clicking what this is doing here
		this.GPA = 0.0;
		this.admitYear = 0;
	}
	
	public Student(Student copy) { //Understod, a copy constructor
		super(copy); //Yet again with the copy constructor, why is this super here?
		this.GPA = copy.GPA;
		this.admitYear = copy.admitYear;
	}
	
	public String toString() { //Understood, toString method
		return super.toString() + ", GPA: " + GPA + ", admitted: " + admitYear;//here too
	} 
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if ( !(other instanceof Student)) {
			return false;
		}
		Student s = (Student) other;
		return super.equals(s) && s.GPA == GPA && s.admitYear == admitYear; //here as well
	}
}
