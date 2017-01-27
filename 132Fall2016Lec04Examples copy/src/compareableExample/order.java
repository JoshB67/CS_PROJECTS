package compareableExample;

public class Dog implements Comparable<Dog> {

	private String name;
	private int size;
	
	public Dog(String name, int size){
		this.name = name;
		this.size = size;
	}
	
	// if the desired ordering is by the dogs size then I would program it like:
	public int compareTo(Dog other){ 
		Dog temp = (Dog)other;
		if(this.size > temp.size){ //first dog gets ordered later
			return 1;
		}else if(this.size < temp.size){ //first dog gets order before
			return -1;
		}else{
			return 0; //therefore they are equal
		}
	}

}
