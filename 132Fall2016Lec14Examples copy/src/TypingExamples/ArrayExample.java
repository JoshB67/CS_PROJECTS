package TypingExamples;

public class ArrayExample {

	// your driver class
	public static void main(String[] args) {

		BaseballPlayer[] a = new BaseballPlayer[10]; // create 10 slots in the array
		Athlete[] b = a;     // BaseballPLayer array IS-A Athlete array
		// What are you allowed to assigned to this? 
		// why ar you allowed to assign this?
		
		Athlete[] c = new BaseballPlayer[10];
		// Cannot put Athletes into the a BasballPlayer[]
		
		
		// BaseballPlayer[] compared to Athlete[] does the IS-A
		// BaseballPlayer[] IS-A Athlete[] ?
		// So BaseballPlayer[] really IS-A Athlete[]
		
		
		// BaseballPlayer[] IS-A Athlete[];
		
		// How does this work?
		// How can you have an Array of a class
		// superclass and subclass
		
		// Athlete is the superclass
		// BaseballPlaye is the subclass
		
		// both references to the same array
		String x = "Hello";
		String z = x;
		
		
		b[0] = new Athlete();
		// Compiles but runtime error
		// Array store exception
		// What just happened?
		// but it doesn't work with ArrayLists?
		
		
	}

}

