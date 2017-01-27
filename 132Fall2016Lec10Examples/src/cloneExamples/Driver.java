package cloneExamples;

public class Driver {

	public static void main(String[] args) {

		Address a = new Address("123 Main St.", "College Park", "MD");
		Student s = new Student(8382882, "Fred", a);
		
		Address b = a.clone();
		Student t = s.clone();
		
		System.out.println(a.equals(b));
		System.out.println(a == b);
		
		System.out.println(s.equals(t));
		System.out.println(s == t);
		
		System.out.println(t.getAddress().equals(a));
		System.out.println(t.getAddress() == a);
		
	}

}
