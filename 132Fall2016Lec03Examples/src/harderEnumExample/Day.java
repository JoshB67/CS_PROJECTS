//CHECKED! CAN RECITE!
package harderEnumExample;

public enum Day {
	
	SUN("Sunday", 0), MON("Monday", 8), 
	TUE("Tuesday", 6), WED("Wednesday", 8), 
	THU("Thursday", 6), FRI("Friday", 8), 
	SAT("Saturday", 0);
	
	private String name;
	private int workHours;
	
	// Note: Constructors must be private!
	private Day(String name, int workHours) {
		this.name = name;
		this.workHours = workHours;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWorkHours() {
		return workHours;
	}
}


