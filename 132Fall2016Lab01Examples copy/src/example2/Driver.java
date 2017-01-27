package example2;

public class Driver {

	public static void main(String[] args) {
		Roster roster = new Roster("CMSC132", 700);
		
		roster.addStudent("John", 80);
		roster.addStudent("Mary", 95);
		
		System.out.println(roster);
	}
}