//POSTED!

package compareableExample;

public class Dog implements Comparable<Dog> {

	private String name;
	private int size;
	
	public Dog(String name, int size){
		this.name = name;
		this.size = size;
	}
	
	public int compareTo(Dog other){ //EZ way to do compareTo() numerically     
		return this.size - other.size; //numerical contract, +1,-1,0
		}
	//put names in alphabetical order
	//length of the strings
	
	public String toString() {
		return name + ": " + size + " pounds";
	}

}
