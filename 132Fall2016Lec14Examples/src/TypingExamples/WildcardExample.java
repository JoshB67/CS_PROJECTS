package TypingExamples;

import java.util.ArrayList;

public class WildcardExample {

	private static void foo(ArrayList< ? extends Athlete > a) {
		// You can pass in any type of AL as long as that type in the brackets is an ArrayList extends from Athlete
		// ? is used for variables, not instantiating
		
		for (Athlete athlete : a) {
			athlete.run();
		//	a.add(new Athlete()); // won't compile
		}
	
	}
	
	public static void main(String[] args) {
		ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
		
		
		for (int i = 0; i < 10; i++) {
			athleteList.add(new Athlete());
		}
		
		
		ArrayList<BaseballPlayer> BBPlayerList = new ArrayList<BaseballPlayer>();
		for (int i = 0; i < 10; i++) {
			BBPlayerList.add(new BaseballPlayer());
		}

		
		foo(athleteList);
		foo(BBPlayerList);
		
	}

}
