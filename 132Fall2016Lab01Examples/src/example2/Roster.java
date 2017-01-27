package example2;

/**
 * Represents a class roster.
 * @author cmsc132
 *
 */

public class Roster {
	public static final String SCHOOL = "UMCP";
	private Student[] allStudents;
	private String courseName;
	private int registered;
	private static int totalRosters = 0;

	/**
	 * 
	 * @param courseName course's name
	 * @param totalSeats maximum capacity for the room
	 */
	public Roster(String courseName, int totalSeats) {
		this.courseName = courseName;

		allStudents = new Student[totalSeats];
		registered = 0;
		totalRosters++;
	}

	/**
	 * 
	 * @param name student's name
	 * @param score value between 0 and a 100
	 */
	public void addStudent(String name, int score) {
		if (registered < allStudents.length) {
			allStudents[registered++] = new Student(name, score);
		}
	}

	/**
	 * 
	 *  Returns a string with the number of students registered,
	 *  and a list of students with their grade.
	 */
	public String toString() {
		String answer = SCHOOL + "\n";
		answer = "Course Name: " + courseName + "\n";

		answer += "Students Registered: " + registered + "\n";
		answer += "Students:\n";
		for (int idx = 0; idx < registered; idx++) {
			answer += allStudents[idx];
			answer += ", grade: " + findGrade(allStudents[idx].getScore()) + "\n";
		}

		return answer;
	}

	/**
	 * 
	 * @return total number of rosters created.
	 */
	public static int getTotalRosters() {
		return totalRosters;
	}
	
	/**
	 * 
	 * @param score
	 * @return letter grade based on cutoffs
	 */
	private static char findGrade(int score) {
		int cutOffs[] = { 90, 80, 70, 60 };
		char letterGrades[] = { 'A', 'B', 'C', 'D', 'F' };

		int idx;
		for (idx = 0; idx < cutOffs.length; idx++) {
			if (score >= cutOffs[idx]) {
				break;
			}
		}

		return letterGrades[idx];
	}
}