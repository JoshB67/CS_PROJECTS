package example2;

public class Student {
	private String name;
	private int score;
	
	/**
	 * 
	 * @param name
	 * @param score value between 0 and 100
	 */
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/**
	 * 
	 * @return student's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		return "name: " + name + ", score: " + score;
	}
	
	/**
	 * Two students are considered equal if they have the
	 * same name.
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Student student = (Student) obj;
		
		return name.equals(student.name);
	}
}
