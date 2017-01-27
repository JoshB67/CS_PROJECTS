//POSTED!
package inheritance;

public class Person {

	private String name;
	private int ID;

	public Person(String name, int ID){
		this.name = name;
		this.ID = ID;
	}
	
	public Person(Person other) {
		name = other.name;
		ID = other.ID;
	}
	
	public String getName() {
		return name;
	} 
	
	public int getID() {
		return ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String toString() {
		return "Name: " + name + ", ID: " + ID;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if ( !(other instanceof Person)) {
			return false;
		}
		Person person = (Person)other;
		return person.name.equals(name) && person.ID == ID;
	}
}

