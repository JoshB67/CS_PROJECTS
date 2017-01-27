//CHECKED! CAN RECITE!
package equalsExample;

public class Dog {

	private String name;
	private int size;
	
	public Dog(String name, int size){
		this.name = name;
		this.size = size;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if ( !(other instanceof Dog) ) {
			return false;
		}
		Dog dog = (Dog)other;
		return (dog.name.equals(name) && dog.size == size);
	}

}
