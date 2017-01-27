//POSTED!
package compareableExample;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		Random random = new Random(); //Creating an obj of type random, understood
		ArrayList<Dog> dogs = new ArrayList<Dog>(); //Creating an AL, understood
		for (int i = 0; i < 50; i++) { //Creating a for loop to go from 0 - 50
			int size = random.nextInt(100) + 5; //lost, random.nextInt(100) + 5 ????
			String name = "DOG"; //Why has this been written here?
			dogs.add(new Dog(name, size)); //Adding a new Dog with name "DOG" and size
		//how are we allowed to put "new" inside a parameter of the add method?
		}

		
		Collections.sort(dogs); //understood, sorts in ascending/natural order
		
		System.out.println(dogs); //then prints what was just sorted
	}

}
