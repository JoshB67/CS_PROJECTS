//CHECKED! CAN RECITE!
package harderEnumExample;

public class WorkHours {
	
	public static void main(String[] args) {
		for (Day d : Day.values()) {
			System.out.println(d.getName() + ": " + d.getWorkHours());
		}
		
	}

}
