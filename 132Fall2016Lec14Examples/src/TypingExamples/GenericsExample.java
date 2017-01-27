package TypingExamples;

import java.util.ArrayList;

public class GenericsExample {

	ArrayList<BaseballPlayer> a = new ArrayList<BaseballPlayer>();
	ArrayList<Athlete> b = a;   // won't compile
	// same thing but with ArrayList instead of array.
}
