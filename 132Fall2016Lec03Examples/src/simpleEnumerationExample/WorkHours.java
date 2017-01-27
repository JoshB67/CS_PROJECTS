//DIDN'T UNDERSTAND AND POSTED!
package simpleEnumerationExample;

public class WorkHours {

	public static int getWorkHours(Day day) {
		if (day == Day.MON || day == Day.WED || day == Day.FRI) {
			return 8;
		} else if (day == Day.TUE || day == Day.THU) {
			return 6;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		for (Day d : Day.values()) {
			System.out.println(d + ": " + getWorkHours(d));
		}
		
		if (Day.WED.compareTo(Day.SUN) < 0) {
			System.out.println("Wednesday comes before Sunday");
		} else {
			System.out.println("Wednesday comes after Sunday");
		}
	}

}

