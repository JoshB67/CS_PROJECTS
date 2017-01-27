package prac;

public class Basic {
	private String name; // difference between assignment and no assignment here?
	private int age;
	private static String nickName;
	
	
	public Basic(String n, int a, String nn) {
		this.name = n;
		this.age = a;
		this.nickName = nn; // what would this do?
		
		Basic.nickName = nn; // what would this do?
	}

	
	// why isn't any of this allowed?
	name = "Sarah" // Error
	age = 12; // Error

	getName(); // Error
	setName("Rex"); // Error
	getAge(); // Error
	setAge(14); // Error


	int age = getAge(); // Error
	age = 12; // Error

	int a = age; // Error
	a = 19;

	String name = name; // Error
	name = "Jimbo"; // Error


	String s = getName(); // Error
	s = "Sam";
	
	int d = this.reassign(7); // Error


	// however when I make a method all of that is a-ok
	// when changing the variables inside a method is that actually changing the instance variables up top?
	public int changeAge() {

		name = "Sarah";
		age = 12;

		getName();
		setName("Rex");
		
		getAge();
		setAge(14);

		// differenec b/w int a = getAge; and int g = age;?
		
		int age = this.getAge(); // why doesn't Eclipse complain about the same age variable?
		age = 13;


		String name = this.name;
		name = "Jimbo";


		int x = age; // which age is this referring to? the instance variable or the other?
		String y = name;


		String s = this.getName();
		int ah = this.getAge();

		int d = this.reassign(7);

		String bar = "hi";
		age = 99;
		this.getName();


	}


	public int reassign(int u) {
		this.name = "Sally";
		this.age = 16;

		setAge(15);


		this.getName();
		this.getAge();

		return this.age;

	}


	public Basic(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return this.age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public static void main(String[] args) {
		Basic b = new Basic("James", 28);


		name = "jim"; // does not work! no reassignment here
		age = 17; // does not work! or here


		int i = b.age; // merely storing that information in a variable
		String s = b.getName(); // storing that information for later use

		int x = b.hashCode(); // storing information for later use


		b.name = "Jimmy";
		b.age = 17;


		b.getAge();
		b.setAge(12);


		b.getName();
		b.setName("Timmy");


	}

}
