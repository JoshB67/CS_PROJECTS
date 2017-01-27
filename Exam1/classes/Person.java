
public class Person implements Comparable<Person>{
	private String name;
	private int age;


	public Person(String n, int a) {
		this.name = n;
		this.age = a;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}

	//how you DEFINE EQUALITY BETWEEN OBJECTS
	public boolean equals(Person other){
		return this.getName() == other.getName()
				&& this.getAge() == other.getAge();
	}

	//how you DEFINE ORDER/SORTING BETWEEN OBJECTS
	public int compareTo(Person temp) {

		Person other = (Person)temp;

		if (this.getAge() > other.getAge()) {
			return 1;
		} else if (this.getAge() < other.getAge()) {
			return -1;
		}else if (this.getName().compareTo(other.getName()) > 0) {
			return 1;
		} else if (this.getName().compareTo(other.getName()) < 0) {
			return -1;
		} else {
			return 0;
		}

	}


	public static void main(String[] args) {
		Person p1 = new Person("Bob", 12);
		Person p2 = new Person("Zach", 12);

		int result = p1.compareTo(p2); //p1 is the man of the hour here

		//If < 0 then p1 is of lesser value than that of p2, therefore sort p1 first
		if (result < 0) {
			System.out.println(p1.getName() + " comes before " + p2.getName());
			//If > 0 then p1 is of greater value than p2, therefore sort p2 first
		} else if(result > 0) {
			System.out.println(p2.getName() + " comes before " + p1.getName());
			//otherwise they are exactly the same
		} else {
			System.out.println("names are the same");
		}

	}

}
