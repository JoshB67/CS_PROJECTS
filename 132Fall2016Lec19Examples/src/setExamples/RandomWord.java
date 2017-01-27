package setExamples;

import java.util.Random;

public class RandomWord implements Comparable<RandomWord>{

	private String word;
	private static Random r = new Random();
	
	public RandomWord(int length) {
		word = "";
		for (int i = 0; i < length; i++) {
			word += (char)(r.nextInt(26) + 'A');
		}
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		
		if ( !(other instanceof RandomWord)) {
			return false;
		}
		
		RandomWord rw = (RandomWord) other;
		return this.word.equals(rw.word);
	}
	
	@Override
	public int hashCode() { // your hashing function here
		return this.word.hashCode();  // how is this computed?
	}
	
	@Override
	public String toString() {
		return this.word;
	}

	@Override
	public int compareTo(RandomWord other) {
		return this.word.compareTo(other.word);
	}
}
